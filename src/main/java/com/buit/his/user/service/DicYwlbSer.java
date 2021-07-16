package com.buit.his.user.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.his.user.dao.DicYwlbDao;
import com.buit.his.user.dao.SysGroupDao;
import com.buit.his.user.model.DicYwlb;
import com.buit.his.user.model.SysGroup;
import com.buit.his.user.response.BusinessAuth;
import com.buit.his.user.response.DicYwlbTabelResp;
import com.buit.his.user.response.DicYwlbWherlResp;

import cn.hutool.core.date.DateUtil;
/**
 * 业务类别表<br>
 * @author WENGL
 */
@Service
public class DicYwlbSer extends BaseManagerImp<DicYwlb,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(DicYwlbSer.class);
    
    @Autowired
    private DicYwlbDao dicYwlbDao;
    @Autowired
    private SysGroupDao sysGroupDao;
//    @Autowired
//	private RedisFactory redisFactory;
    private List<DicYwlbTabelResp> tableList;
    
    @Override
    public DicYwlbDao getEntityMapper(){        
        return dicYwlbDao;
    }
    public DicYwlb add(DicYwlb dicYwlb){
    	//redisFactory.getTableKey(TableName.DB_NAME, TableName.DIC_YWLB);
    	dicYwlb.setBtId(Integer.valueOf(dicYwlb.getBtCode()));
    	if(dicYwlbDao.getById(dicYwlb.getBtId())!=null) {
    		throw BaseException.create("ERROR_SYS_AUTH_0001");
    	}
    	
    	dicYwlb.setBtSql(getSql(dicYwlb.getBtTableName(),dicYwlb.getBtWhere()));
    	dicYwlb.setGmtCreate(DateUtil.date().toTimestamp());
    	dicYwlb.setGmtModify(DateUtil.date().toTimestamp());
    	dicYwlbDao.insert(dicYwlb);
        return dicYwlb;
    }
    public DicYwlb edit(DicYwlb dicYwlb){      
    	dicYwlb.setBtSql(getSql(dicYwlb.getBtTableName(),dicYwlb.getBtWhere()));
    	dicYwlb.setGmtModify(DateUtil.date().toTimestamp());
    	dicYwlbDao.update(dicYwlb);
        return dicYwlb;
    }
    
    /**
     * 取业SQL语句
     */
    private String getSql(String table,int where){
    	String tb="DRUGS_YKLB";
    	if(table.equals(tb)) {
    		//药库表
    		return "SELECT YKSB AS queryid, YKMC showname FROM DRUGS_YKLB  WHERE JGID=#{ hospitalId }"; 
    	}
    	if(table.equals("OP_FWTXX")) {
    		//服务台表
    		return "SELECT RID AS queryid,ZSMC showname FROM op_fwtxx t WHERE t.LX=1"; 
    	}
    	switch (where) {
			case 1:
				//门诊科室"
				return "SELECT KSDM AS queryid , KSMC AS showname  FROM OP_GHKS  WHERE JGID=#{hospitalId} order by PYDM"; 
			case 2:
				//医技科室
				return "SELECT id AS queryid,officename AS showname FROM DIC_KSZD WHERE  medicalLab='1' and ORGANIZCODE!=PARENTID and OFFICECODE!=PARENTID AND logoff='0' AND ORGANIZCODE=#{ hospitalId }"; 
			case 3:
				//住院科室
				return "SELECT id AS queryid,officename AS showname FROM DIC_KSZD WHERE hospitaldept='1' and ORGANIZCODE!=PARENTID and OFFICECODE!=PARENTID AND logoff='0' AND ORGANIZCODE=#{ hospitalId }"; 
			case 4:
				//住院病区
				return "SELECT id AS queryid,officename AS showname FROM DIC_KSZD WHERE hospitalArea='1' and ORGANIZCODE!=PARENTID and OFFICECODE!=PARENTID AND logoff='0' AND ORGANIZCODE=#{ hospitalId }"; 
			case 5:
				//输液科室
				return "SELECT id AS queryid,officename AS showname FROM DIC_KSZD WHERE SYKS='1' and ORGANIZCODE!=PARENTID and OFFICECODE!=PARENTID AND logoff='0' AND ORGANIZCODE=#{ hospitalId }";
			case 6:
				//治疗科室
				return "SELECT id AS queryid,officename AS showname FROM DIC_KSZD WHERE ZLKS='1' and ORGANIZCODE!=PARENTID and OFFICECODE!=PARENTID AND logoff='0' AND ORGANIZCODE=#{ hospitalId }";
			case 7:
				//注射科室
				return "SELECT id AS queryid,officename AS showname FROM DIC_KSZD WHERE ZSKS='1' AND ORGANIZCODE!=PARENTID AND OFFICECODE!=PARENTID AND logoff='0' AND ORGANIZCODE=#{ hospitalId }";
			case 25:
				//手术科室
				return "SELECT id AS queryid,officename AS showname FROM DIC_KSZD WHERE SURGICAL='1' AND ORGANIZCODE!=PARENTID AND OFFICECODE!=PARENTID AND logoff='0' AND ORGANIZCODE=#{ hospitalId }";
			case 8:
				//门诊
				return "SELECT YFSB AS queryid , YFMC AS showname FROM PHAR_YFLB WHERE BZLB=1 AND JGID=#{ hospitalId }"; 
			case 9:
				//住院
				return "SELECT YFSB AS queryid , YFMC AS showname FROM PHAR_YFLB WHERE BZLB=2 AND JGID=#{ hospitalId }"; 
				
			case 26:
				//留观科室
				return "SELECT id AS queryid,officename AS showname FROM DIC_KSZD WHERE LGKS='1' and ORGANIZCODE!=PARENTID and OFFICECODE!=PARENTID AND logoff='0' AND ORGANIZCODE=#{ hospitalId } ";
			case 27:
				//留观病区
				return "SELECT id AS queryid,officename AS showname FROM DIC_KSZD WHERE LGBQ='1' and ORGANIZCODE!=PARENTID and OFFICECODE!=PARENTID AND logoff='0' AND ORGANIZCODE=#{ hospitalId } ";
//			case 16:
//				//二级库房
//				return "SELECT KFXH AS queryid, KFMC AS showname FROM WL_KFXX WHERE KFLB=3 AND JGID=#{ hospitalId }";
				
				
				
				
			default:
				break;
			}
    	return null;
    }
    /**
     * 取业务表信息
     */
    public List<DicYwlbTabelResp> getTableinfo(){
    	if(tableList==null) {
    		tableList=new ArrayList<>();
    		//科室表
    		DicYwlbTabelResp tableoffice=new DicYwlbTabelResp();
    		tableoffice.setBtTableName("DIC_KSZD");
    		tableoffice.setBtTableNameCn("科室表");
    		List<DicYwlbWherlResp> officewhereList= new ArrayList<>();
    		officewhereList.add(new DicYwlbWherlResp(1,"门诊科室"));
    		officewhereList.add(new DicYwlbWherlResp(2,"医技科室"));
    		officewhereList.add(new DicYwlbWherlResp(3,"住院科室"));
    		officewhereList.add(new DicYwlbWherlResp(4,"住院病区"));
    		officewhereList.add(new DicYwlbWherlResp(5,"输液科室"));
			officewhereList.add(new DicYwlbWherlResp(6,"治疗科室"));
			officewhereList.add(new DicYwlbWherlResp(7,"注射科室"));
			officewhereList.add(new DicYwlbWherlResp(25,"手术科室"));
			officewhereList.add(new DicYwlbWherlResp(26,"留观科室"));
			officewhereList.add(new DicYwlbWherlResp(27,"留观病区"));
    		tableoffice.setBtWhereList(officewhereList);
    		tableList.add(tableoffice);
    		//药库表
    		DicYwlbTabelResp tableywlb = new DicYwlbTabelResp();
    		tableywlb.setBtTableName("HSP_YWLB");
    		tableywlb.setBtTableNameCn("业务类别表");    
    		List<DicYwlbWherlResp> ywlbList= new ArrayList<>();
    		ywlbList.add(new DicYwlbWherlResp(12,"住院业务"));
    		ywlbList.add(new DicYwlbWherlResp(13,"留观业务"));
    		tableList.add(tableywlb);
    		
    		//药库表
    		DicYwlbTabelResp tabledrugsyklb=new DicYwlbTabelResp();
    		tabledrugsyklb.setBtTableName("DRUGS_YKLB");
    		tabledrugsyklb.setBtTableNameCn("药库表");    		
    		tableList.add(tabledrugsyklb);
    		//药房表
    		DicYwlbTabelResp tablepharyflb=new DicYwlbTabelResp();
    		tablepharyflb.setBtTableName("PHAR_YFLB");
    		tablepharyflb.setBtTableNameCn("药房表");
    		List<DicYwlbWherlResp> pharyflbwhereList= new ArrayList<>();
    		pharyflbwhereList.add(new DicYwlbWherlResp(8,"门诊"));
    		pharyflbwhereList.add(new DicYwlbWherlResp(9,"住院"));
    		tablepharyflb.setBtWhereList(pharyflbwhereList);
    		tableList.add(tablepharyflb);
    		//库房表
    		DicYwlbTabelResp tablewlkfxx=new DicYwlbTabelResp();
    		tablewlkfxx.setBtTableName("wl_kfxx");
    		tablewlkfxx.setBtTableNameCn("库房表");
    		List<DicYwlbWherlResp> wlkfxxwhereList= new ArrayList<>();
    		wlkfxxwhereList.add(new DicYwlbWherlResp(14,"普通库房"));
    		wlkfxxwhereList.add(new DicYwlbWherlResp(15,"供应室库房"));
    		wlkfxxwhereList.add(new DicYwlbWherlResp(16,"二级库房"));
    		tablewlkfxx.setBtWhereList(wlkfxxwhereList);
    		tableList.add(tablewlkfxx);
    		
    		//服务台表
    		DicYwlbTabelResp tableopFwtxx=new DicYwlbTabelResp();
    		tableopFwtxx.setBtTableName("OP_FWTXX");
    		tableopFwtxx.setBtTableNameCn("服务台表"); 		
    		tableList.add(tableopFwtxx);
    	}
        return tableList;
    }
    /**
     * 取业务表信息
     */
    public  List<BusinessAuth> getAuthority(Integer userId,Integer btId){
    	Map<String, Object> parameter = new HashMap<>();
        parameter.put("userId",userId);
    	SysGroup sysGroup=sysGroupDao.getById(btId);
    	if(sysGroup.getBtId()!=null) {
    		DicYwlb dicYwlb =dicYwlbDao.getById(sysGroup.getBtId());
    		if(dicYwlb!=null) {
    			parameter.put("btId",dicYwlb.getBtId());
    			if("OP_FWTXX".equals(dicYwlb.getBtTableName())) {
    				return dicYwlbDao.getzs(parameter);    
    			}
    			if("DRUGS_YKLB".equals(dicYwlb.getBtTableName())) {
    				return dicYwlbDao.getyk(parameter);    	
    			}
    			if(dicYwlb.getBtWhere()==1) {
    				return dicYwlbDao.getqxkz(parameter);    				
    			}
    			if(dicYwlb.getBtWhere()<8||dicYwlb.getBtWhere()>24) {
    				return dicYwlbDao.getOffice(parameter);    				
    			}
    			if(dicYwlb.getBtWhere()<14) {
    				return dicYwlbDao.getyf(parameter);
    			}
//    			if(dicYwlb.getBtWhere()<17) {
//    				return dicYwlbDao.getkf(parameter);
//    			}
    			
    		}
    	}
        return null;
    }
    
    
    
    
}
