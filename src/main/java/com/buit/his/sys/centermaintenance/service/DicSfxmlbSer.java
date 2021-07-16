package com.buit.his.sys.centermaintenance.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.buit.his.sys.centermaintenance.dao.*;
import org.apache.commons.collections.CollectionUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.commons.SysUser;
import com.buit.constans.OperationTypeEnum;
import com.buit.constans.TableName;
import com.buit.drug.service.DrugsTypkOutSer;
import com.buit.drug.service.PharYpxxOutSer;
import com.buit.his.dic.api.SysDictConfigSerImpl;
import com.buit.his.sys.centermaintenance.model.FeeYlsfxm;
import com.buit.his.sys.centermaintenance.model.PubFybm;
import com.buit.his.sys.centermaintenance.model.PubFyxz;
import com.buit.his.sys.centermaintenance.request.DicSfxmlbReq;
import com.buit.his.sys.centermaintenance.request.DicSfxmlbYlReq;
import com.buit.his.sys.centermaintenance.request.FeeYlsfxmYlSaveReq;
import com.buit.his.sys.centermaintenance.request.FeeYlsfxmYlSaveReq.FeeYlsfxmBody;
import com.buit.his.sys.centermaintenance.request.FeeYlsfxmYlSaveReq.PubFybmBody;
import com.buit.his.sys.centermaintenance.request.FeeYlsfxmYlSaveReq.PubFyxzBody;
import com.buit.his.sys.centermaintenance.response.PubBrxzResp;
import com.buit.system.model.DicSfxmlb;
import com.buit.system.response.FeeSfdlzfbl;
import com.buit.system.service.SysDictConfigSer;
import com.buit.system.utill.ObjectToTypes;
import com.buit.utill.RedisFactory;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;

/**
 * 公用_收费项目<br>
 * 
 * @author GONGFANGZHOU
 */
@Service
public class DicSfxmlbSer extends BaseManagerImp<DicSfxmlb, Integer> {

	static final Logger logger = LoggerFactory.getLogger(DicSfxmlbSer.class);

	@Autowired
	private FeeYlsfxmSer feeYlsfxmSer;

	@Autowired
	private DicSfxmlbDao dicSfxmlbDao;

	@Override
	public DicSfxmlbDao getEntityMapper() {
		return dicSfxmlbDao;
	}

	@Autowired
	private RedisFactory redisFactory;

	@Autowired
	private FeeYlsfxmDao feeYlsfxmDao;

	@Autowired
	private PubFybmDao pubFybmDao;

	@Autowired
	private FeeSfdlzfblDao feeSfdlzfblDao;

	@Autowired
	private PubFyxzDao pubFyxzDao;

	@DubboReference
	private PharYpxxOutSer pharYpxxOutSer;

	@Autowired
	private PubBrxzDao pubBrxzDao;

	@Autowired
	private SysDictConfigSerImpl sysDictConfigSer;
	@DubboReference
	private DrugsTypkOutSer drugsTypkOutSer;
	@Autowired
	CmoSsxmgxDao cmoSsxmgxDao;

	/**
	 * 医疗项目新增修改前校验 @Title: chargingProjectsVerification @Description:
	 * TODO(这里用一句话描述这个方法的作用) @param @param dicSfxmlbYlReq 设定文件 @return void
	 * 返回类型 @author 龚方舟 @throws
	 */
	public void chargingProjectsVerification(DicSfxmlbYlReq dicSfxmlbYlReq) {
		String op = dicSfxmlbYlReq.getOpStatus();
		DicSfxmlb dicSfxmlb = new DicSfxmlb();
		if (OperationTypeEnum.create.getCode().equals(op)) {
			dicSfxmlb.setSfmc(dicSfxmlbYlReq.getSfmc());
			long l = dicSfxmlbDao.findByEntityCount(dicSfxmlb);
			if (l > 0) {
				throw BaseException.create("ERROR_CENTERMAINTENANCE_GYSFXM_0001");
			}
			if (StrUtil.isNotBlank(dicSfxmlbYlReq.getPlsx())) {
				dicSfxmlb = new DicSfxmlb();
				dicSfxmlb.setPlsx(dicSfxmlbYlReq.getPlsx());
				long plCount = dicSfxmlbDao.findByEntityCount(dicSfxmlb);
				if (plCount > 0) {
					throw BaseException.create("ERROR_CENTERMAINTENANCE_GYSFXM_0002");
				}
			}
			if (StrUtil.isNotBlank(dicSfxmlbYlReq.getZypl())) {
				dicSfxmlb = new DicSfxmlb();
				dicSfxmlb.setZypl(dicSfxmlbYlReq.getZypl());
				long zyCount = dicSfxmlbDao.findByEntityCount(dicSfxmlb);
				if (zyCount > 0) {
					throw BaseException.create("ERROR_CENTERMAINTENANCE_GYSFXM_0003");
				}
			}
			if (StrUtil.isNotBlank(dicSfxmlbYlReq.getMzpl())) {
				dicSfxmlb = new DicSfxmlb();
				dicSfxmlb.setMzpl(dicSfxmlbYlReq.getMzpl());
				long mzCount = dicSfxmlbDao.findByEntityCount(dicSfxmlb);
				if (mzCount > 0) {
					throw BaseException.create("ERROR_CENTERMAINTENANCE_GYSFXM_0004");
				}
			}
		} else {
			dicSfxmlb.setSfmc(dicSfxmlbYlReq.getSfmc());
			dicSfxmlb.setSfxm(dicSfxmlbYlReq.getSfxm());
			long l = dicSfxmlbDao.findCountNotEqualSfxm(dicSfxmlb);
			if (l > 0) {
				throw BaseException.create("ERROR_CENTERMAINTENANCE_GYSFXM_0001");
			}
			if (StrUtil.isNotBlank(dicSfxmlbYlReq.getZblb()) && "0".equals(dicSfxmlbYlReq.getZblb())) {
				long pkCount = drugsTypkOutSer.zblbCount(dicSfxmlbYlReq.getSfxm());
				if (pkCount > 0) {
					throw BaseException.create("ERROR_CENTERMAINTENANCE_GYSFXM_0005");
				}
			}
			if (StrUtil.isNotBlank(dicSfxmlbYlReq.getPlsx())) {
				dicSfxmlb = new DicSfxmlb();
				dicSfxmlb.setPlsx(dicSfxmlbYlReq.getPlsx());
				dicSfxmlb.setSfxm(dicSfxmlbYlReq.getSfxm());
				long plCount = dicSfxmlbDao.findCountNotEqualSfxm(dicSfxmlb);
				if (plCount > 0) {
					throw BaseException.create("ERROR_CENTERMAINTENANCE_GYSFXM_0002");
				}
			}
			if (StrUtil.isNotBlank(dicSfxmlbYlReq.getZypl())) {
				dicSfxmlb = new DicSfxmlb();
				dicSfxmlb.setZypl(dicSfxmlbYlReq.getZypl());
				dicSfxmlb.setSfxm(dicSfxmlbYlReq.getSfxm());
				long zyCount = dicSfxmlbDao.findCountNotEqualSfxm(dicSfxmlb);
				if (zyCount > 0) {
					throw BaseException.create("ERROR_CENTERMAINTENANCE_GYSFXM_0003");
				}
			}
			if (StrUtil.isNotBlank(dicSfxmlbYlReq.getMzpl())) {
				dicSfxmlb = new DicSfxmlb();
				dicSfxmlb.setMzpl(dicSfxmlbYlReq.getMzpl());
				dicSfxmlb.setSfxm(dicSfxmlbYlReq.getSfxm());
				long mzCount = dicSfxmlbDao.findCountNotEqualSfxm(dicSfxmlb);
				if (mzCount > 0) {
					throw BaseException.create("ERROR_CENTERMAINTENANCE_GYSFXM_0004");
				}
			}
		}
	}

	/**
	 * 医疗项目新增或修改保存 @Title: doSaveChargingProjects @Description:
	 * TODO(这里用一句话描述这个方法的作用) @param @param dicSfxmlbReq 设定文件 @return void
	 * 返回类型 @author 龚方舟 @throws
	 */
	@Transactional(rollbackFor = Exception.class)
	public void doSaveChargingProjects(DicSfxmlbReq dicSfxmlbReq) {
		String op = dicSfxmlbReq.getOpStatus();
		if (OperationTypeEnum.create.getCode().equals(op)) {
//			Integer sfxm = redisFactory.getTableKey(TableName.DB_NAME, TableName.DIC_SFXMLB);
			Integer sfxm = dicSfxmlbDao.queryPkNextNum();
			dicSfxmlbReq.setSfxm(sfxm);
			dicSfxmlbReq.setFylb(sfxm);
			dicSfxmlbReq.setMzgb(sfxm);
			dicSfxmlbReq.setZygb(sfxm);
			dicSfxmlbReq.setDqsfxmlsh(0);
			dicSfxmlbDao.insert(dicSfxmlbReq);
			sysDictConfigSer.upDateVersion(TableName.DIC_SFXMLB);

//			String ylsfHql = "select SFXM as FYGB,SFMC as FYMC,'笔' as FYDW,PYDM as PYDM,MZSY as MZSY,ZYSY as ZYSY,'1' as YJSY,'0' as TJFY,'0' as TXZL,'0' as ZFPB,0 as BZJG from DIC_SFXMLB where SFXM=:SFXM";
//			Map<String, Object> ylsfMap = dao.doLoad(ylsfHql, ylsfParameters);
//    		String wbm = CharacterEncodingController.getCode(
//					(String) ylsfMap.get("FYMC"), PHISExpSymbols.WB, ctx);
//			String jxm = CharacterEncodingController.getCode(
//					(String) ylsfMap.get("FYMC"), PHISExpSymbols.JX, ctx);
//			ylsfMap.put("WBDM", wbm);
//			ylsfMap.put("JXDM", jxm);
			Map<String, Object> feeYlsfxmMap = dicSfxmlbDao.queryDicSfxmlbInfo(sfxm);
			FeeYlsfxm feeYlsfxm = BeanUtil.fillBeanWithMapIgnoreCase(feeYlsfxmMap, new FeeYlsfxm(), true);
//			Integer fyxh = redisFactory.getTableKey(TableName.DB_NAME, TableName.FEE_YLSFXM);
//			feeYlsfxm.setFyxh(fyxh);
			if(StrUtil.isNotBlank(feeYlsfxm.getXmbm())){
				feeYlsfxm.setXmbm(feeYlsfxmSer.xmbm(String.valueOf(feeYlsfxm.getFygb())));
				dicSfxmlbDao.updateNowSfxmbm(feeYlsfxm.getFygb() ,Integer.valueOf(feeYlsfxm.getXmbm().substring(2)));
			}
			feeYlsfxmDao.insert(feeYlsfxm);

			PubFybm pubFybm = new PubFybm();
			pubFybm.setFyxh(feeYlsfxm.getFyxh());
			pubFybm.setFymc(ObjectToTypes.parseString(feeYlsfxmMap.get("FYMC")));
			pubFybm.setPydm(ObjectToTypes.parseString(feeYlsfxmMap.get("PYDM")));
			pubFybm.setBmfl(1);
//			pubFybm.setBmxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.PUB_FYBM));
			pubFybmDao.insert(pubFybm);
			List<FeeSfdlzfbl> list = feeSfdlzfblDao.getBrxzInfo();
			// 然后每个病人性质插入一条该收费项目
			for (FeeSfdlzfbl feeSfdlzfbl : list) {
				feeSfdlzfbl.setSfxm(sfxm);
				feeSfdlzfbl.setZfbl(ObjectToTypes.parseBigDecimal(1));
				feeSfdlzfblDao.insert(feeSfdlzfbl);
			}
		} else {
			DicSfxmlb dicSfxmlb = dicSfxmlbDao.getById(dicSfxmlbReq.getSfxm());
			BeanUtil.copyProperties(dicSfxmlbReq, dicSfxmlb,
					CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
			dicSfxmlbDao.update(dicSfxmlb);
			sysDictConfigSer.upDateVersion(TableName.DIC_SFXMLB);
		}

	}

	/**
	 * 医疗项目明细新增修改保存 @Title: doSaveCostDetail @Description:
	 * TODO(这里用一句话描述这个方法的作用) @param @param feeYlsfxmYlSaveReq 设定文件 @return void
	 * 返回类型 @author 龚方舟 @throws
	 */
	@Transactional(rollbackFor = Exception.class)
	public FeeYlsfxmBody doSaveCostDetail(FeeYlsfxmYlSaveReq feeYlsfxmYlSaveReq) {
		// 费用属性
		FeeYlsfxmBody feeYlsfxmBody = feeYlsfxmYlSaveReq.getFeeYlsfxmBody();
		if (feeYlsfxmBody == null) {
			return null;
		}
		Integer fyxh = null;
		if (StrUtil.isNotBlank(ObjectToTypes.parseString(feeYlsfxmBody.getFyxh()))) {
			fyxh = feeYlsfxmBody.getFyxh();
			FeeYlsfxm feeYlsfxm = BeanUtil.toBean(feeYlsfxmBody, FeeYlsfxm.class);
//			FeeYlsfxm feeYlsfxm = feeYlsfxmDao.getById(feeYlsfxmBody.getFyxh());
//			BeanUtil.copyProperties(feeYlsfxmBody, feeYlsfxm,
//					CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
			feeYlsfxmDao.update(feeYlsfxm);
		} else {
//			fyxh = redisFactory.getTableKey(TableName.DB_NAME, TableName.FEE_YLSFXM);
//			feeYlsfxmBody.setFyxh(fyxh);
			FeeYlsfxm feeYlsfxm = BeanUtil.toBean(feeYlsfxmBody, FeeYlsfxm.class);
			if(StrUtil.isNotBlank(feeYlsfxm.getXmbm())){
				feeYlsfxm.setXmbm(feeYlsfxmSer.xmbm(String.valueOf(feeYlsfxm.getFygb())));
				dicSfxmlbDao.updateNowSfxmbm(feeYlsfxm.getFygb() ,Integer.valueOf(feeYlsfxm.getXmbm().substring(2)));
			}
			feeYlsfxmDao.insert(feeYlsfxm);
			fyxh = feeYlsfxm.getFyxh();
		}
		if(feeYlsfxmBody.getXmlx()==6){
			if(feeYlsfxmBody.getSsbm()==null||feeYlsfxmBody.getSsbm()==0){
				throw BaseException.create("ERROR_CENTERMAINTENANCE_GYSFXM_0006");
			}
			cmoSsxmgxDao.replace(feeYlsfxmBody.getSsbm(),fyxh);
		}
		// 费用别名
		List<PubFybmBody> pubFybmBodyList = feeYlsfxmYlSaveReq.getPubFybmBodyList();
		if (CollectionUtils.isNotEmpty(pubFybmBodyList)) {
			PubFybm pubFybm = new PubFybm();
			pubFybm.setFyxh(fyxh);
			pubFybmDao.removeByEntity(pubFybm);
			for (PubFybmBody pubFybmBody : pubFybmBodyList) {
				pubFybmBody.setFyxh(fyxh);
				PubFybm pubFybmSave = BeanUtil.toBean(pubFybmBody, PubFybm.class);
				pubFybmSave.setBmxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.PUB_FYBM));
				pubFybmDao.insert(pubFybmSave);
			}
		}
		// 费用性质
		List<PubFyxzBody> pubFyxzBodyList = feeYlsfxmYlSaveReq.getPubFyxzBodyList();
		if (CollectionUtils.isNotEmpty(pubFyxzBodyList)) {
			PubFyxz pubFyxz = new PubFyxz();
			pubFyxz.setFyxh(fyxh);
			pubFyxzDao.removeByEntity(pubFyxz);
			for (PubFyxzBody pubFyxzBody : pubFyxzBodyList) {
				pubFyxzBody.setFyxh(fyxh);
				boolean flag = !("0".equals(pubFyxzBody.getZfbl() + "") && "0".equals(pubFyxzBody.getCxbl() + "")
						&& "0".equals(pubFyxzBody.getFyxe() + ""));
				if (flag) {
					BigDecimal zfbl = pubFyxzBody.getZfbl().divide(new BigDecimal(100));
					pubFyxzBody.setZfbl(zfbl);
					BigDecimal cxbl = pubFyxzBody.getCxbl().divide(new BigDecimal(100));
					pubFyxzBody.setCxbl(cxbl);
					PubFyxz pubFyxzSave = BeanUtil.toBean(pubFyxzBody, PubFyxz.class);
					pubFyxzDao.insert(pubFyxzSave);
				}
			}
		}

		return feeYlsfxmBody;
	}

	/**
	 * 项目作废或取消作废 @Title: logoutMedicalItems @Description:
	 * TODO(这里用一句话描述这个方法的作用) @param @param fyxh @param @param zfpb @param @param
	 * user 设定文件 @return void 返回类型 @author 龚方舟 @throws
	 */
	public void logoutMedicalItems(Integer fyxh, Integer zfpb, SysUser user) {
		feeYlsfxmDao.updateZfpbByFyxh(zfpb, fyxh);
		pharYpxxOutSer.updateXgsjByYpxh(DateUtil.date().toTimestamp(), fyxh, user.getHospitalId());
	}

	/**
	 * 项目费用限制列表 @Title: queryCostLimit @Description:
	 * TODO(这里用一句话描述这个方法的作用) @param @param fyxh @param @return 设定文件 @return
	 * List<PubBrxz> 返回类型 @author 龚方舟 @throws
	 */
	public List<PubBrxzResp> queryCostLimit(Integer fyxh) {
		return pubBrxzDao.queryCostLimit(fyxh);
	}
}
