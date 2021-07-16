package com.buit.his.sys.centermaintenance.service;


import java.util.Date;
import java.util.List;

import com.buit.apply.model.OpSbhy;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.constans.TableName;
import com.buit.his.sys.centermaintenance.dao.OpSbbhDao;
import com.buit.his.sys.centermaintenance.dao.OpSbhyDao;
import com.buit.his.sys.centermaintenance.dao.OpSssdDao;
import com.buit.his.sys.centermaintenance.model.OpSbbh;
import com.buit.his.sys.centermaintenance.model.OpSssd;
import com.buit.utill.RedisFactory;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
/**
 * 设备编号表<br>
 * @author GONGFANGZHOU
 */
@Service
public class OpSbbhSer extends BaseManagerImp<OpSbbh,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(OpSbbhSer.class);
    
    @Autowired
    private OpSbbhDao opSbbhDao;
    
    @Override
    public OpSbbhDao getEntityMapper(){        
        return opSbbhDao;
    }
    
    @Autowired
    private OpSbhyDao opSbhyDao;
    
    @Autowired
    private OpSssdDao opSssdDao;
    
    @Autowired
    private RedisFactory redisFactory;
    
    /**
     * 删除检查检验设备维护
     * @Title: ddeleteById
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param bhId    设定文件
     * @return void    返回类型
     * @author 龚方舟
     * @throws
     */
    public void deleteById(Integer bhId) {
    	OpSbhy opSbhy = new OpSbhy();
    	opSbhy.setBhid(bhId);
    	List<OpSbhy> opSbhyList = opSbhyDao.findByEntity(opSbhy);
    	if(CollectionUtils.isNotEmpty(opSbhyList)) {
    		throw BaseException.create("ERROR_CENTERMAINTENANCE_MSSBBH_0001");
    	}
    	opSbbhDao.deleteById(bhId);	
    }
    
    /**
     * 生成未来30天浩源
     * @Title: doGenerateSbhy
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param bhId    设定文件
     * @return void    返回类型
     * @author 龚方舟
     * @throws
     */
    @Transactional(rollbackFor = Exception.class)
    public void doGenerateSbhy(Integer bhId) {	
    	logger.info("设备号源开始" + DateUtil.date().toTimestamp());
		int dateGenerate = 30; 
		Date dateTemp = new Date();
		Date beginSw = new Date();
		Date endSw = new Date();
		Date beginXw = new Date();
		Date endXw = new Date();
		long d = 0;
		//获取当天的凌晨
		Date date = DateUtil.beginOfDay(new Date());
		OpSbbh opSbbh = new OpSbbh();
		//bhId为空时生成全部
		if(bhId != null) {
			opSbbh.setBhid(bhId);
		}
		List<OpSbbh> opSbbhList = opSbbhDao.findByEntity(opSbbh);
		
		// 所属时段集合
		List<OpSssd> opSssdList = opSssdDao.findByEntity(null);
		OpSbhy opSbhy = new OpSbhy();
		try {
			for(OpSbbh m : opSbbhList){
				String swkssj = m.getSwkssj();
				String swjssj = m.getSwjssj();
				String swjgfz = m.getSwjgfz();
				String xwkssj = m.getXwkssj();
				String xwjssj = m.getXwjssj();
				String xwjgfz = m.getXwjgfz();
				
				for(int j = 0; j < dateGenerate; j++){
					d = date.getTime() + 24*60*60*1000L*(j+1);
					dateTemp = new Date(d);
					String swkssjTemp = DateUtil.formatDate(dateTemp) + " " + swkssj;
					String swjssjTemp = DateUtil.formatDate(dateTemp) + " " + swjssj;
					String xwkssjTemp = DateUtil.formatDate(dateTemp) + " " + xwkssj;
					String xwjssjTemp = DateUtil.formatDate(dateTemp) + " " + xwjssj;
					beginSw = DateUtil.parse(swkssjTemp, DatePattern.NORM_DATETIME_MINUTE_PATTERN);
					endSw = DateUtil.parse(swjssjTemp, DatePattern.NORM_DATETIME_MINUTE_PATTERN);
					beginXw = DateUtil.parse(xwkssjTemp, DatePattern.NORM_DATETIME_MINUTE_PATTERN);
					endXw = DateUtil.parse(xwjssjTemp, DatePattern.NORM_DATETIME_MINUTE_PATTERN);				
					while(beginSw.before(endSw)){
						opSbhy.setBhid(m.getBhid());
						opSbhy.setHyrq(DateUtil.beginOfDay(dateTemp).toTimestamp());
						opSbhy.setHysj(DateUtil.format(beginSw, "HH:mm"));
						opSbhy.setSdid(getSssd(opSssdList, DateUtil.format(beginSw, "HH:mm")));
						opSbhy.setSfyy(0);
						opSbhy.setSfdj(0);
//						opSbhy.setHyid(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_SBHY));	
						opSbhyDao.insert(opSbhy);
						beginSw = new Date(beginSw.getTime() + Long.parseLong(swjgfz)*60*1000);
					}
					while(beginXw.before(endXw)){
						opSbhy.setBhid(m.getBhid());
						opSbhy.setHyrq(DateUtil.beginOfDay(dateTemp).toTimestamp());
						opSbhy.setHysj(DateUtil.format(beginXw, "HH:mm"));
						opSbhy.setSdid(getSssd(opSssdList, DateUtil.format(beginXw, "HH:mm")));
						opSbhy.setSfyy(0);
						opSbhy.setSfdj(0);
//						opSbhy.setHyid(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_SBHY));	
						opSbhyDao.insert(opSbhy);
						beginXw = new Date(beginXw.getTime() + Long.parseLong(xwjgfz)*60*1000);
					}
				}
			}
		} catch (DuplicateKeyException e) {
			throw BaseException.create("ERROR_CENTERMAINTENANCE_MSSBBH_0002");
		}
		logger.info("设备号源结束" + DateUtil.date().toTimestamp());
    
	}
    
    /**
     * 通过时间匹配所属时段
     * @Title: getSssd
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param opSssdList
     * @param @param hysj
     * @param @return    设定文件
     * @return Integer    返回类型
     * @author 龚方舟
     * @throws
     */
	public static Integer getSssd(List<OpSssd> opSssdList, String hysj) {
		for (OpSssd m : opSssdList) {		
			String[] value = m.getValue().split("-");
			Date start = DateUtil.parse(value[0], "HH:mm");
			Date end = DateUtil.parse(value[1], "HH:mm");
			Date hysjDate = DateUtil.parse(hysj, "HH:mm");
			if ((start.getTime() - hysjDate.getTime() <= 0) && (end.getTime() - hysjDate.getTime() > 0)) {
				return m.getSssdid();
			}
		}
		return 0;
	}
	
}
