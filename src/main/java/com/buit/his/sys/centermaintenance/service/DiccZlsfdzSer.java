package com.buit.his.sys.centermaintenance.service;

import java.util.ArrayList;
import java.util.List;

import com.buit.system.model.DiccZlsfdz;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.constans.TableName;
import com.buit.his.sys.centermaintenance.dao.DiccZlsfdzDao;
import com.buit.his.sys.centermaintenance.request.DiccZlsfdzAddReq;
import com.buit.system.response.LoadSqdDetailInfoResp;
import com.buit.utill.BeanUtil;
import com.buit.utill.RedisFactory;

/**
 * 诊疗收费对照<br>
 * 
 * @author 老花生
 */
@Service
public class DiccZlsfdzSer extends BaseManagerImp<DiccZlsfdz, Integer> {

	static final Logger logger = LoggerFactory.getLogger(DiccZlsfdzSer.class);

	@Autowired
	private DiccZlsfdzDao diccZlsfdzDao;

	@Override
	public DiccZlsfdzDao getEntityMapper() {
		return diccZlsfdzDao;
	}

	@Autowired
	private RedisFactory redisFactory;

	/**
	 * 新增
	 * 
	 * @param req
	 */
	public void add(DiccZlsfdzAddReq req) {
		// 数据查重
		DiccZlsfdz condition = new DiccZlsfdz();
		condition.setZlxmid(req.getZlxmid());
		condition.setFyxh(req.getFyxh());
		List<DiccZlsfdz> existList = diccZlsfdzDao.findByEntity(condition);
		if (existList.size() > 0) {
			throw BaseException.create("ERROR_CENTERMAINTENANCE_DICCZLSFDZ_0001");
		}
		DiccZlsfdz obj = BeanUtil.toBean(req, DiccZlsfdz.class);
//		int xh = redisFactory.getTableKey(TableName.DB_NAME, TableName.DICC_ZLSFDZ);
//		obj.setJlxh(xh);
		diccZlsfdzDao.insert(obj);
	}

	/**
	 * 删除
	 * 
	 * @param jlxh
	 */
	public void delete(int jlxh) {
		diccZlsfdzDao.deleteById(jlxh);
	}

	/**
	 * 根据诊疗项目ID删除
	 * 
	 * @param zlxmId
	 */
	public void deleteByZlxmId(int zlxmId) {
		diccZlsfdzDao.deleteByZlxmId(zlxmId);
	}
	public List<LoadSqdDetailInfoResp> loadSqdDetailInfo(Integer type, Integer jcxh) {
		if (!"3".equals(type)) {
			return diccZlsfdzDao.loadSqdDetailInfo(jcxh);
		}
		return new ArrayList<>();
	}

}
