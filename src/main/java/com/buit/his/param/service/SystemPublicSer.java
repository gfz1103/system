package com.buit.his.param.service;

import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.buit.his.param.enums.MnemonicTypeEnum;
import com.buit.his.param.request.MnemonicReq;

import cn.hutool.json.JSONUtil;

/**
 * @Description
 * @Author yueyu
 * @Date 2020/5/11 18:59
 */
@Service
public class SystemPublicSer  {
	static final Logger log = LoggerFactory.getLogger(SystemPublicSer.class);


//	@Autowired
//	EmrYsxgGrcsDao emrYsxgGrcsDao;
	
	public Map<String, String> getMnemonic(MnemonicReq mnemonicReq) {
		log.info("生成助记码[{}]", JSONUtil.toJsonStr(mnemonicReq));
		return mnemonicReq.getTypeList().stream()
				.collect(Collectors.toMap(MnemonicTypeEnum::name, m -> m.getGenerate().apply(mnemonicReq.getValue())));
	}

	

//	@Locked(value = {"lock_#[a.b]_#[a.*c.*g]_#[a.*f]"},block = 30,expire = -20)
//	public void testLock(Map<String, Object> a) {
//
//	}
}
