package com.buit.his.dic.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseManagerImp;
import com.buit.constans.RedisKeyHead;
import com.buit.his.dic.dao.SysDataCodeDao;
import com.buit.his.dic.model.SysDataCode;
import com.buit.his.enums.SysDataCodeEnum;
import com.buit.utill.RedisFactory;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;

/**
 * 系统数据代码表<br>
 * 
 * @author
 */
@Service
public class SysDataCodeSer extends BaseManagerImp<SysDataCode, Integer> {

	static final Logger logger = LoggerFactory.getLogger(SysDataCodeSer.class);
	/** 支持25位 */
	String zero = "0000000000000000000000000";

	@Autowired
	private SysDataCodeDao sysDataCodeDao;
	@Autowired
	private RedisFactory redisFactory;
	@Autowired
	private StringRedisTemplate redisTemplate;

	@Override
	public SysDataCodeDao getEntityMapper() {
		return sysDataCodeDao;
	}

	public String getSysDataCode(Integer codeId) {
		SysDataCode sysDataCode = sysDataCodeDao.findByCodeType(codeId);
		if (sysDataCode == null) {
			logger.error("规则Id--", codeId, "SYS_DATA_CODE表未找到");
			return "规则配置在SYS_DATA_CODE表未找到";
		}
		// 头固定值
		StringBuilder headsb = new StringBuilder();
		if (sysDataCode.getDatacodeHead() != null) {
			headsb.append(sysDataCode.getDatacodeHead());
		}
		// 如果设置了 日期
		if (SysDataCodeEnum.YEAR.getCode().equals(sysDataCode.getDatacodeYear())) {
			headsb.append((new SimpleDateFormat(sysDataCode.getDatacodeYearFormat())).format(new Date()));
		}
		String redisKeyHead = RedisKeyHead.data_code.getHeadKey()+"_" + sysDataCode.getDatacodeId();
		//滚动方式,1:年,2:月,3:日,null:不滚动
		if(sysDataCode.getDatacodeScroll()!=null) {
			if(sysDataCode.getDatacodeScroll().equals(1)) 
				redisKeyHead=redisKeyHead+"_"+String.valueOf(DateUtil.date().getField(DateField.YEAR));
			if(sysDataCode.getDatacodeScroll().equals(2)) 
				redisKeyHead=redisKeyHead+"_"+DateUtil.date().toString("yyyyMM");
			if(sysDataCode.getDatacodeScroll().equals(3)) 
				redisKeyHead=redisKeyHead+"_"+DateUtil.date().toString("yyyyMMdd");
		}
		if (!redisFactory.hasKey(redisKeyHead)) {
			if (sysDataCode.getDatacodeNo() != null) {
				redisFactory.setKey(redisKeyHead, sysDataCode.getDatacodeNo());
				setExpire( sysDataCode, redisKeyHead);
			}
		}
		// 头固定值
		StringBuilder num = new StringBuilder(zero);
		Long setp=redisFactory.increment(redisKeyHead, 1);
		num.append(setp);
		if(setp.equals(1L)) {
			setExpire( sysDataCode, redisKeyHead);
		}
		headsb.append(num.substring(num.length() - sysDataCode.getDatacodeLen() + headsb.length()));
		return headsb.toString();
	}
	
	private void setExpire(SysDataCode sysDataCode,String redisKeyHead) {
		if(sysDataCode.getDatacodeScroll()!=null) {//滚动方式,1:年,2:月,3:日,null:不滚动
			if(sysDataCode.getDatacodeScroll().equals(1)) 
				redisTemplate.expire(redisKeyHead, 369, TimeUnit.DAYS);
			if(sysDataCode.getDatacodeScroll().equals(2)) 
				redisTemplate.expire(redisKeyHead, 31, TimeUnit.DAYS);
			if(sysDataCode.getDatacodeScroll().equals(3)) 
				redisTemplate.expire(redisKeyHead, 1, TimeUnit.DAYS);
		}
	}

}
