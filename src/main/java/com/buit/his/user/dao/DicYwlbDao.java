package com.buit.his.user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.his.user.model.DicYwlb;
import com.buit.his.user.response.BusinessAuth;
/**
 * 业务类别表<br>
 * @author WENGL
 */
@Mapper
public interface DicYwlbDao extends EntityDao<DicYwlb,Integer>{
	public List<BusinessAuth> queryBusinessAuth(Map<String, Object> part);
	public List<Integer> findbtIdByUserId(Integer userId);
	
	public List<BusinessAuth> getOffice(Map<String, Object> part);
	public List<BusinessAuth> getyk(Map<String, Object> part);
	public List<BusinessAuth> getqxkz(Map<String, Object> part);
	public List<BusinessAuth> getyf(Map<String, Object> part);
//	public List<BusinessAuth> getkf(Map<String, Object> part);
	public List<BusinessAuth> getzs(Map<String, Object> part);
	
}
