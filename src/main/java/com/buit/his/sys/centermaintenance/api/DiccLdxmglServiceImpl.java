package com.buit.his.sys.centermaintenance.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import com.buit.his.sys.centermaintenance.dao.DiccLdxmglDao;
import com.buit.his.sys.centermaintenance.response.DiccLdxmglResp;
import com.buit.system.response.DiccLdxmglApiResp;
import com.buit.system.service.DiccLdxmglService;
import com.buit.utill.BeanUtil;


/**
 * 项目关联外部接口实现
 * @ClassName: DiccLdxmglServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 龚方舟
 * @date 2020年10月13日 下午5:24:31
 *
 */
@DubboService(timeout = 10000)
public class DiccLdxmglServiceImpl implements DiccLdxmglService{
	
	@Autowired
	private DiccLdxmglDao diccLdxmglDao;

	@Override
	public List<DiccLdxmglApiResp> queryProjectAssociationInfo(Map<String, Object> parameters) {
		List<DiccLdxmglResp> list = diccLdxmglDao.queryProjectAssociationInfo(parameters);
		List<DiccLdxmglApiResp> resList = new ArrayList<DiccLdxmglApiResp>();
		for(DiccLdxmglResp diccLdxmglResp : list) {
			DiccLdxmglApiResp apiResp = BeanUtil.toBean(diccLdxmglResp, DiccLdxmglApiResp.class);
			resList.add(apiResp);
		}
		return resList;
	}

}
