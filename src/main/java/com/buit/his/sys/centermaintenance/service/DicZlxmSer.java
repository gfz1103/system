package com.buit.his.sys.centermaintenance.service;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.buit.his.sys.centermaintenance.request.*;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buit.commons.BaseManagerImp;
import com.buit.commons.SysUser;
import com.buit.constans.TableName;
import com.buit.his.sys.centermaintenance.dao.DicZlxmDao;
import com.buit.his.sys.centermaintenance.dao.FeeSfdlzfblDao;
import com.buit.his.sys.centermaintenance.dao.FeeYlsfxmDao;
import com.buit.his.sys.centermaintenance.dao.FeeYpxzDao;
import com.buit.his.sys.centermaintenance.dao.OpSbbhDao;
import com.buit.his.sys.centermaintenance.dao.OpSssdDao;
import com.buit.his.sys.centermaintenance.dao.PubFyxzDao;
import com.buit.his.sys.centermaintenance.model.DicZlxm;
import com.buit.his.sys.centermaintenance.model.FeeYpxz;
import com.buit.his.sys.centermaintenance.model.OpSbbh;
import com.buit.his.sys.centermaintenance.model.OpSssd;
import com.buit.his.sys.centermaintenance.model.PubFyxz;
import com.buit.his.sys.centermaintenance.response.DicZlxmQueryResp;
import com.buit.system.response.FeeSfdlzfbl;
import com.buit.system.service.SysXtcsCacheSer;
import com.buit.system.utill.ObjectToTypes;
import com.buit.utill.ParamUtil;
import com.buit.utill.RedisFactory;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.map.CaseInsensitiveMap;
import cn.hutool.core.util.StrUtil;

/**
 * 诊疗项目<br>
 * @author 老花生
 */
@Service
public class DicZlxmSer extends BaseManagerImp<DicZlxm,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(DicZlxmSer.class);
    public static final String BRXZ_SYBX = "6024";
    
    @Autowired
    private DicZlxmDao dicZlxmDao;
    @Autowired
    private RedisFactory redisFactory;
    @Autowired
    private DiccZlsfdzSer diccZlsfdzSer;
    
    @DubboReference
    private SysXtcsCacheSer sysXtcsCacheSer;

    @Override
    public DicZlxmDao getEntityMapper(){        
        return dicZlxmDao;
    }
    
    @Autowired
    private FeeYlsfxmDao feeYlsfxmDao;
    
    @Autowired
    private PubFyxzDao pubFyxzDao;
    
    @Autowired
    private FeeYpxzDao feeYpxzDao;
    
    @Autowired
    private FeeSfdlzfblDao feeSfdlzfblDao;
    
    @Autowired
    private OpSbbhDao opSbbhDao;
    
    @Autowired
    private OpSssdDao opSssdDao;


    /**
     * 中心维护-诊疗项目维护-查询医技类型列表
     * @param yjlx
     * @return
     */
    public List<DicZlxm> queryList(int yjlx) {
        DicZlxm condition = new DicZlxm();
        condition.setYjlx(yjlx);
        condition.setZfbz("0");
        return dicZlxmDao.findByEntity(condition);
    }

    /**
     * 中心维护-诊疗项目维护-新增
     *
     * @param req
     */
    @Transactional(rollbackFor = Exception.class)
    public void add(DicZlxmAddReq req, SysUser user) {
        DicZlxm zlxm = BeanUtil.toBean(req, DicZlxm.class);
//        int id = redisFactory.getTableKey(TableName.DB_NAME, TableName.DIC_ZLXM);
//        zlxm.setZlxmid(id);
        zlxm.setJgid(user.getHospitalId());
        zlxm.setZfbz("0");
        dicZlxmDao.insert(zlxm);
        if (null != req.getDiccZlsfdzAddReqList() && req.getDiccZlsfdzAddReqList().size() > 0) {
            for (DiccZlsfdzAddReq zlsfdzAddReq : req.getDiccZlsfdzAddReqList()) {
                zlsfdzAddReq.setZlxmid(zlxm.getZlxmid());
                diccZlsfdzSer.add(zlsfdzAddReq);
            }
        }
    }

    /**
     * 中心维护-诊疗项目维护-修改
     *
     * @param req
     */
    @Transactional(rollbackFor = Exception.class)
    public void edit(DicZlxmEditReq req) {
        DicZlxm zlxm = BeanUtil.toBean(req, DicZlxm.class);
        dicZlxmDao.update(zlxm);
        if (null != req.getDiccZlsfdzEditReqList() && req.getDiccZlsfdzEditReqList().size() > 0) {
            for (DiccZlsfdzReq diccZlsfdzReq : req.getDiccZlsfdzEditReqList()) {
            	if(StrUtil.isBlankIfStr(diccZlsfdzReq.getJlxh())) {
            		DiccZlsfdzAddReq diccZlsfdzAddReq = BeanUtil.toBean(diccZlsfdzReq, DiccZlsfdzAddReq.class);
            		diccZlsfdzSer.add(diccZlsfdzAddReq);
            	}else {
            		diccZlsfdzSer.update(diccZlsfdzReq);
            	}
            }
        }
    }

    /**
     * 中心维护-诊疗项目维护-作废
     * @param zlxmId
     */
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer zlxmId) {
        dicZlxmDao.deleteById(zlxmId);
        diccZlsfdzSer.deleteByZlxmId(zlxmId);
    }
    
    /**
     * 查询诊疗项目列表
     * @param req
     * @param user
     * @return
     */
    public List<DicZlxmQueryResp> queryZlxmList(DicZlxmQueryReq req, SysUser user) {
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        List<Map<String, Object>> resultZfbl = new ArrayList<Map<String, Object>>();
        // 获取传过来的ZLXMID参数
        StringBuffer hql = new StringBuffer();
        String brxz = req.getBrxz();
        Integer jgid = user.getHospitalId();
        //获取VIP
        String vipbrxz = sysXtcsCacheSer.getByJGIdAndCsmc(jgid, "VIPBRXZ").getCsz();
        String[] vipbrxzs =  vipbrxz.split(",");
        boolean isVip = false;//是否是VIP病人
        for (int i=0;i<vipbrxzs.length;i++) {
            if(vipbrxzs[i].toString().equals(req.getBrxz())){
                isVip=true;
            }
        }
        Map<String, Object> parameters = new HashMap<>(16);
        parameters.put("yjlx", req.getYjlx());

        if(brxz != null && "6024".equals(brxz)){
            //如果病人性质是商业保险（6024）,费用单价使用商保价格
            parameters.put("bxlx", "1");
        }
        else{
            parameters.put("bxlx", "2");
        }
        result = dicZlxmDao.getFyzh(parameters);

        if(isVip  && brxz != null && !"6024".equals(brxz)){//商保病人费用取商保价格
            resultZfbl = feeYlsfxmDao.getFygbFyxhFydj(parameters);
            List<Map<String, Object>> fyxhZlxmid = dicZlxmDao.getFyxhZlxmidFysl(parameters);

            for (Map<String, Object> map : resultZfbl) {
                //=======获取支付比例======
                Map<String, Object> zfbl = new HashMap<>(16);
                zfbl.put("TYPE", 0);//检查项目
                zfbl.put("FYXH", map.get("FYXH"));
                zfbl.put("FYGB",map.get("FYGB"));
                zfbl.put("BRXZ", req.getBrxz());
                //组套对应的价格可以获取到，获取之后
                Map<String, Object> zfblMap = getPayProportion(zfbl);
                //计算费用单价
                double fydj = Double.parseDouble(zfblMap.get("ZFBL")+"")*Double.parseDouble(map.get("FYDJ")+"");
                for (Map<String, Object> map2 : fyxhZlxmid) {
                    if(map.get("FYXH").toString().equals(map2.get("FYXH").toString())){
                        map2.put("FYDJ", fydj *Double.parseDouble(map2.get("FYSL")+""));
                    }
                }
            }
            for (Map<String, Object> map : result) {
                double sum = 0.00;
                for(int i =0;i<fyxhZlxmid.size();i++){
                    if(map.get("ZLXMID").toString().equals(fyxhZlxmid.get(i).get("ZLXMID").toString())){
                        sum+=Double.parseDouble(fyxhZlxmid.get(i).get("FYDJ")+"");
                    }
                }
                map.put("FYDJ", sum);
            }
        }

        List<DicZlxmQueryResp> ret = new ArrayList<DicZlxmQueryResp>();
		for (Map<String, Object> map : result) {
			DicZlxmQueryResp resp = BeanUtil.fillBeanWithMapIgnoreCase(map, new DicZlxmQueryResp(), true);
			ret.add(resp);
		}
        return ret;
    }
    
    
    /**
	 * 获取费用自负比例
	 *
	 * @param body
	 * @return
	 */
	public Map<String, Object> getPayProportion(Map<String, Object> body) {
		Integer al_yplx = Integer.parseInt(body.get("TYPE") + "");// 药品传药品类型1,2,3,费用传0
		Object al_brxz = body.get("BRXZ");// 病人性质
		Object al_fyxh = body.get("FYXH");// 费用序号
		Object al_fygb = body.get("FYGB");// 费用归并
		Map<String, Object> params = new HashMap<String, Object>(16);
		params.put("BRXZ", al_brxz);
		params.put("FYXH", al_fyxh);
		Map<String, Object> map = new HashMap<String, Object>(16);
		if (al_yplx == 0) {
			PubFyxz pubFyxz = new PubFyxz();
			pubFyxz.setBrxz(Integer.valueOf(params.get("BRXZ").toString()));
			pubFyxz.setFyxh(Integer.valueOf(params.get("FYXH").toString()));
			// 查询费用禁用信息
			map = pubFyxzDao.getFyjyInfo(pubFyxz);
		} else {
			FeeYpxz feeYpxz = new FeeYpxz();
			feeYpxz.setBrxz(Integer.valueOf(params.get("BRXZ").toString()));
			feeYpxz.setYpxh(Integer.valueOf(params.get("FYXH").toString()));
			// 查询药品禁用信息
			map = feeYpxzDao.getYpjyInfo(feeYpxz);
		}
		if (map != null) {
			if (map.get("FYXE") == null || map.get("FYXE") == "") {
				map.put("FYXE", 0.0);
			}
			if (map.get("CXBL") == null || map.get("CXBL") == "") {
				map.put("CXBL", 0.0);
			}
			map.put("CXBL", ObjectToTypes.parseBigDecimal(map.get("CXBL")).divide(new BigDecimal(100), 2,
					BigDecimal.ROUND_HALF_UP));
			return map;
		}
		params.clear();
		params.put("BRXZ", al_brxz);
		params.put("FYGB", al_fygb);

		FeeSfdlzfbl feeSfdlzfbl = new FeeSfdlzfbl();
		feeSfdlzfbl.setBrxz(Integer.valueOf(params.get("BRXZ").toString()));
		feeSfdlzfbl.setSfxm(Integer.valueOf(params.get("FYGB").toString()));
		Map<String, Object> zfbl_map = feeSfdlzfblDao.getZfblInfo(feeSfdlzfbl);
		if (zfbl_map == null) {
			zfbl_map = new HashMap<String, Object>(16);
			zfbl_map.put("ZFBL", 1);
		}
		return zfbl_map;
	}
	
	
	/**
     * 查询诊间医技预病html组装
     */
    public Map<String, Object> queryYjyy4Html() {
        //QueryYjyy4HtmlResp resp = null;
        Map<String, Object> res = new HashMap<>();
        List<OpSbbh> sbObjList =
                opSbbhDao.findByEntity(ParamUtil.instance().put("sortColumns", " JKLX,sbmc"));
        List<Map<String, Object>> sbList = new ArrayList<>();
		for (OpSbbh obj : sbObjList) {
			Map<String, Object> map = BeanUtil.beanToMap(obj);
			Map<String, Object> result = new CaseInsensitiveMap<String, Object>(map);
			sbList.add(result);
		}

        List<Map<String, Object>> sblxList = opSbbhDao.getJklx();


        List<Map<String, Object>>	headerList = new ArrayList();
        List<Map<String, Object>>	headerChildList =  new ArrayList();
        Map<String, Object> headerBlank = new LinkedHashMap<String, Object>();
        headerBlank.put("value", "");
        headerBlank.put("rowspan", 2);
        headerBlank.put("width", 100);
        headerList.add(headerBlank);
        for(Map<String, Object> sblxmap:sblxList){
            Map<String, Object> headerMap = new LinkedHashMap<String, Object>();
            String jklx_text= ObjectToTypes.parseString(sblxmap.get("jklx_text"));
            String jklx= ObjectToTypes.parseString(sblxmap.get("jklx"));
            headerMap.put("id", jklx);
            headerMap.put("value", jklx_text);
            headerMap.put("colspan", sblxmap.get("count"));
            headerMap.put("jklx",jklx);//隐藏列私用
            headerList.add(headerMap);
        }
        for(Map<String, Object> sbmap:sbList){
            Map<String, Object> headerChildMap = new LinkedHashMap<String, Object>();
            String jklx= ObjectToTypes.parseString(sbmap.get("jklx"));
            String sbmc= ObjectToTypes.parseString(sbmap.get("sbmc"));
            String bhid= ObjectToTypes.parseString(sbmap.get("bhid"));
            headerChildMap.put("id", jklx+"_"+bhid);
            headerChildMap.put("value", sbmc);
            headerChildMap.put("jklx",jklx);//隐藏列私用
            headerChildList.add(headerChildMap);
        }
        Map<String, Object> headeritem = new LinkedHashMap<String, Object>();
        headeritem.put("type", "header");
        headeritem.put("items", headerList);

        Map<String, Object> headerChilditem = new LinkedHashMap<String, Object>();
        headerChilditem.put("type", "header");
        headerChilditem.put("items", headerChildList);


        res.put("Header", headeritem);
        res.put("HeaderChild", headerChilditem);


        //具体项目和时间画出表格
        List<OpSssd> sssdObjList = opSssdDao.findByEntity(ParamUtil.instance().put("sfxs", 1).put("sortColumns", " " +
                "SSSDID "));
        List<Map<String, Object>> sssdList = new ArrayList<>();
		for (OpSssd obj : sssdObjList) {
			Map<String, Object> map = BeanUtil.beanToMap(obj);
			Map<String, Object> result = new CaseInsensitiveMap<String, Object>(map);
			sssdList.add(result);
		}

        List<Map<String, Object>>	dataList=  new ArrayList<Map<String, Object>>();
        for(int i=0;i<sssdList.size()+2;i++){
            Map<String, Object>	dataMap = new LinkedHashMap<String, Object>();

            List<Map<String, Object>>	dataItemList = new ArrayList();
            Map<String, Object> dataTimeMap = new LinkedHashMap<String, Object>();
            if(i==0){
                dataTimeMap.put("type", "header");
                dataTimeMap.put("id", "t_kyyrc_"+i);
                dataTimeMap.put("value", "可预约人次");
                dataItemList.add(dataTimeMap);
            }
            if(i==1){
                dataTimeMap.put("type", "header");
                dataTimeMap.put("id", "t_yyyrc_"+i);
                dataTimeMap.put("value", "已预约人次");
                dataItemList.add(dataTimeMap);
            }
            if(i>1){
                Map<String, Object> sssdMap =  sssdList.get(i-2);
                String SSSDID= ObjectToTypes.parseString(sssdMap.get("sssdid"));
                String VALUE= ObjectToTypes.parseString(sssdMap.get("value"));
                dataTimeMap.put("type", "header");
                dataTimeMap.put("id", "t_"+SSSDID);
                dataTimeMap.put("value", VALUE);
                dataItemList.add(dataTimeMap);
            }
            for(int j=0;j<sbList.size();j++){
                Map<String, Object> sbMap =  sbList.get(j);
                String JKLX= ObjectToTypes.parseString(sbMap.get("jklx"));
                String BHID= ObjectToTypes.parseString(sbMap.get("bhid"));

                Map<String, Object> dataSbMap = new LinkedHashMap<String, Object>();

                if (i==0){
                    dataSbMap.put("id", "t_kyyrc_"+JKLX+"_"+BHID);
                }
                if(i==1){
                    dataSbMap.put("id", "t_yyyrc_"+JKLX+"_"+BHID);
                }

                if(i>1){
                    Map<String, Object> sssdMap =  sssdList.get(i-2);
                    String SSSDID= ObjectToTypes.parseString(sssdMap.get("sssdid"));
                    dataSbMap.put("id", "t_"+SSSDID+"_"+JKLX+"_"+BHID);
                    dataSbMap.put("click", true);
                    dataSbMap.put("info", ObjectToTypes.parseString(sbMap.get("sbmc")));
                }
                dataSbMap.put("value", 0);
                dataSbMap.put("type", "data");
                dataSbMap.put("jklx",JKLX);//隐藏列私用
                dataItemList.add(dataSbMap);
            }
            dataMap.put("items", dataItemList);
            dataList.add(dataMap);
        }
        res.put("dataList", dataList);

        return res;
    }
  
}
