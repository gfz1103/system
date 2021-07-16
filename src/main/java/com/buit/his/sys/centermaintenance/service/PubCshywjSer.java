package com.buit.his.sys.centermaintenance.service;


import com.buit.commons.BaseException;
import com.buit.commons.SysUser;
import com.buit.his.param.service.SysXtcsCacheSerImp;
import com.buit.his.sys.centermaintenance.dao.PubCshywjDao;
import com.buit.his.sys.centermaintenance.request.PubCshReq;
import com.buit.his.sys.centermaintenance.response.PubCshResp;
import com.buit.his.sys.centermaintenance.response.PubCshywjResp;
import com.buit.his.user.api.HrPersonnelServiceImpl;
import com.buit.system.utill.ObjectToTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * 公用_功能集<br>
 * @author 老花生
 */
@Service
public class PubCshywjSer  {
    
    static final Logger logger = LoggerFactory.getLogger(PubCshywjSer.class);

    @Autowired
    private PubCshywjDao gyGnjDao;
    
    @Autowired
    private HrPersonnelServiceImpl hrPersonnelService;

    @Autowired
	private SysXtcsCacheSerImp sysXtcsCacheSer;
    /**
     * 系统初始化列表
     * @param user
     * @return
     */
    public List<PubCshywjResp> queryList(SysUser user) {
        List<PubCshywjResp> gnj_list = gyGnjDao.queryList();
        //List<Map<String, Object>> meds = BUHISUtil.ListObjToMap(gnj_list);
        gnj_list.forEach(item -> {
            Integer groupid = item.getGroupid();
            if(groupid ==2){
                List<PubCshResp> PUB_CSH = gyGnjDao.queryYkCshList(groupid);
                item.setChildrenList(PUB_CSH);
            }
            if(groupid ==3){
                List<PubCshResp> PUB_CSH = gyGnjDao.queryYfCshList(groupid);
                item.setChildrenList(PUB_CSH);
            }
        });
        return gnj_list;
    }

    /**
     * 初始化
     * @param req
     */
    @Transactional(rollbackFor = Exception.class)
    public void doInit(PubCshReq req,SysUser user) throws Exception {
        String userid = req.getUserid();
        Integer jgid = user.getHospitalId();
        String sadmin = sysXtcsCacheSer.getByJGIdAndCsmc(jgid, "SADMIN").getCsz();
        if(!sadmin.equals(userid)){
            throw BaseException.create("ERROR_USER_0022");
        }
        boolean check=  hrPersonnelService.checkPassWd(Integer.valueOf(req.getUserid()), req.getPassword());
        if(!check){
            throw BaseException.create("ERROR_USER_0004");
        }
        List<Map<String, Object>> meds = ObjectToTypes.ListObjToMap(req.getChildrenList());
        for(int i=0;i<meds.size();i++) {
            String groupid = meds.get(i).get("groupid") + "";
            String officeid = meds.get(i).get("officeid") + "";
            if ("1".equals(groupid)) {
                long count = gyGnjDao.count(groupid, officeid, jgid);
                if (!(count > 0)) {
                    gyGnjDao.delOpThmxByJgid(jgid);
                    gyGnjDao.delOpYyghByJgid(jgid);
                    gyGnjDao.delOpGhFkxxByJgid(jgid);
                    gyGnjDao.delOpGhmxByJgid(jgid);

                    gyGnjDao.delOpGrmx(jgid);  // 个人日报明细
                    gyGnjDao.delOpGhrbfkmx(jgid);
                    gyGnjDao.delOpGhrb(jgid);  //挂号日报
                    gyGnjDao.delOpRbmx(jgid);   //日报明细
                    gyGnjDao.delOpXzmx(jgid);    //日报性质
                    gyGnjDao.delOpSfrbfkmx(jgid);
                    gyGnjDao.delOpHzrb(jgid);   //汇总日报

                    gyGnjDao.delOpYjcf02ByJgid(jgid);
                    gyGnjDao.delOpYjcf01ByJgid(jgid);

                    gyGnjDao.delOpCf02ByJgid(jgid);
                    gyGnjDao.delOpCf01ByJgid(jgid);
                    gyGnjDao.delOpSfmxByJgid(jgid);
                    gyGnjDao.delOpZffpByJgid(jgid);
                    gyGnjDao.delOpMzxxByJgid(jgid);
                    gyGnjDao.delOpFkxxByJgid(jgid);
                    // gyGnjDao.MS_MZMX(jgid);
                    // gyGnjDao.MS_MZHS(jgid);
                    //gyGnjDao.MS_YJMX(jgid);
                    //gyGnjDao.MS_YJHS(jgid);
                    gyGnjDao.delOpKspbByJgid(jgid);
                    gyGnjDao.delOpYspbByJgid(jgid);
                    gyGnjDao.delMpi_card(jgid);
                    gyGnjDao.delMpi_brda(jgid);

                    gyGnjDao.delOpzydj(jgid);
                    gyGnjDao.updateOpGhksByJgid(jgid);

                    gyGnjDao.insertPubCsh(groupid, officeid, jgid);
                }
            } else if ("2".equals(groupid)) {
                long count = gyGnjDao.count(groupid, officeid, jgid);
                if (!(count > 0)) {
                    gyGnjDao.delDrugsSwyjByXtsb(jgid, officeid);
                    gyGnjDao.delDrugsYjjgByXtsb(jgid, officeid);
                    gyGnjDao.delDrugsJzjlByXtsb(jgid, officeid);
                    gyGnjDao.delDrugsRk02ByXtsb(jgid, officeid);
                    gyGnjDao.delDrugsRk01ByXtsb(jgid, officeid);
                    gyGnjDao.delDrugsCk02ByXtsb(jgid, officeid);
                    gyGnjDao.delDrugsCk01ByXtsb(jgid, officeid);
                    gyGnjDao.delDrugsTjjlByXtsb(jgid, officeid);
                    gyGnjDao.delDrugsTj02ByXtsb(jgid, officeid);
                    gyGnjDao.delDrugsTj01ByXtsb(jgid, officeid);
                    gyGnjDao.delDrugsPd02ByXtsb(jgid, officeid);
                    gyGnjDao.delDrugsPd01ByXtsb(jgid, officeid);
                    gyGnjDao.delDrugsPz02ByXtsb(jgid, officeid);
                    gyGnjDao.delDrugsPz01ByXtsb(jgid, officeid);
                    gyGnjDao.delDrugsKcflByXtsb(jgid, officeid);
                    gyGnjDao.delDrugsKcmxByXtsb(jgid, officeid);
                    gyGnjDao.delDrugsKcmxlsByXtsb(jgid, officeid);
                    gyGnjDao.delDrugsYpxxByXtsb(jgid, officeid);
                    gyGnjDao.updateDrugsCdxxByXtsb(jgid, officeid);
                    Calendar startc = Calendar.getInstance();
                    int year = startc.get(Calendar.YEAR);
                    int ll_djhm = year % 100 * 10000 + 1;
                    gyGnjDao.updateDrugsRkfsByXtsb(jgid, ll_djhm, officeid);
                    gyGnjDao.updateDrugsCkfsByXtsb(jgid, ll_djhm, officeid);
                    gyGnjDao.updateDrugsYklbByXtsb(jgid, officeid);

                    gyGnjDao.insertPubCsh(groupid, officeid, jgid);
                }
            } else if ("3".equals(groupid)) {
                long count = gyGnjDao.count(groupid, officeid, jgid);
                if (!(count > 0)) {
                    gyGnjDao.delPharRk02ByYfsb(jgid, officeid);
                    gyGnjDao.delPharRk01ByYfsb(jgid, officeid);
                    gyGnjDao.delPharCk02ByYfsb(jgid, officeid);
                    gyGnjDao.delPharCk01ByYfsb(jgid, officeid);
                    gyGnjDao.delPharTjjlByYfsb(jgid, officeid);
                    gyGnjDao.delPharMzfymxByYfsb(jgid, officeid);
                    gyGnjDao.delPharKcmxByYfsb(jgid, officeid);
                    gyGnjDao.delPharKcmxlsByYfsb(jgid, officeid);
                    gyGnjDao.delPharRbmxByYfsb(jgid, officeid);
                    gyGnjDao.delPharYfrbByYfsb(jgid, officeid);
                    gyGnjDao.delPharYjjgByYfsb(jgid, officeid);
                    gyGnjDao.delPharJzjlByYfsb(jgid, officeid);
                    gyGnjDao.delPharZyfymxByYfsb(jgid, officeid);
                    gyGnjDao.delPharFyjlByYfsb(jgid, officeid);
                    gyGnjDao.delPharDb02ByYfsb(jgid, officeid);
                    gyGnjDao.delPharDb01ByYfsb(jgid, officeid);
                    //gyGnjDao.YF_MZ_SFJL(jgid,officeid);
                    gyGnjDao.delPharYk02grlrByYfsb(jgid, officeid);
                    gyGnjDao.delPharYk02ByYfsb(jgid, officeid);
                    gyGnjDao.delPharYk01ByYfsb(jgid, officeid);
                    gyGnjDao.delPharKcdjByYfsb(jgid, officeid);
                    gyGnjDao.delPharypxx(jgid, officeid);
                    Calendar startc = Calendar.getInstance();
                    int year = startc.get(Calendar.YEAR);
                    int ll_djhm = year % 100 * 10000 + 1;
                    gyGnjDao.updatePharRkfsByXtsb(jgid, ll_djhm, officeid);
                    gyGnjDao.updatePharCkfsByXtsb(jgid, ll_djhm, officeid);

                    gyGnjDao.insertPubCsh(groupid, officeid, jgid);

                    long countbq = gyGnjDao.countBq(officeid, jgid);
                    if (countbq > 0) {
                        gyGnjDao.delNisTj02ByYfsb(jgid, officeid);
                        gyGnjDao.delNisTj01ByYfsb(jgid, officeid);
                    }
                }
            } else if ("4".equals(groupid)) {
                //gyGnjDao.ys_mz_psjl(jgid);
                long count = gyGnjDao.count(groupid, officeid, jgid);
                if(!(count>0)){
                    gyGnjDao.delZlJlxjzjByJgid(jgid);
                    gyGnjDao.delZlLbByJgid(jgid);
                    gyGnjDao.delZlSqdmxByJgid(jgid);
                    gyGnjDao.delZlSqdxmzlnrByJgid(jgid);
                    gyGnjDao.delZlSqdyyzxByJgid(jgid);
                    gyGnjDao.delZlSqdzbByJgid(jgid);
                    gyGnjDao.delZlSqdzdByJgid(jgid);
                    gyGnjDao.delZlXmByJgid(jgid);
                    gyGnjDao.delZlXmldsfxmByJgid(jgid);
                    gyGnjDao.delZlXmzljhByJgid(jgid);
                    gyGnjDao.insertPubCsh(groupid, officeid, jgid);
                }
            } else if ("5".equals(groupid)) {
                long count = gyGnjDao.count(groupid, officeid, jgid);
                if(!(count>0)) {
                    gyGnjDao.delCisHzyzByJgid(jgid);
                    gyGnjDao.delNisTymxByJgid(jgid);
                    gyGnjDao.delCiszyhzsqByJgid(jgid);
                    gyGnjDao.delCiszyhzyjByJgid(jgid);
                    gyGnjDao.delCiszyhzyqdxByJgid(jgid);
                    gyGnjDao.delCisBxsqdzdByJgid(jgid);
                    gyGnjDao.delCisBxsqdByJgid(jgid);

                    gyGnjDao.insertPubCsh(groupid, officeid, jgid);
                }
            } else if ("6".equals(groupid)) {
                long count = gyGnjDao.count(groupid, officeid, jgid);
                if(!(count>0)) {
                    gyGnjDao.delImSrhzByJgid(jgid);
                    gyGnjDao.delImFeefyhzByJgid(jgid);
                    gyGnjDao.delImJzhzByJgid(jgid);
                    gyGnjDao.delImZfpjByJgid(jgid);
                    gyGnjDao.delImJzxxByJgid(jgid);
                    gyGnjDao.delImJszfByJgid(jgid);
                    gyGnjDao.delImJsmxByJgid(jgid);
                    gyGnjDao.delImFkxxByJgid(jgid);
                    gyGnjDao.delImZyjsByJgid(jgid);
                    gyGnjDao.delImFeefymxByJgid(jgid);
                    gyGnjDao.delImFeefymxjsByJgid(jgid);
                    gyGnjDao.delCisHzyzByJgid(jgid);
                    gyGnjDao.delImJkzfByJgid(jgid);
                    gyGnjDao.delImTbkkByJgid(jgid);
                    gyGnjDao.delImHcmxByJgid(jgid);
                    gyGnjDao.delImRyzdByJgid(jgid);
                    //gyGnjDao.ZY_YPGM(jgid);
                    gyGnjDao.delImHzryByJgid(jgid);
                    gyGnjDao.delImCwtjByJgid(jgid);
                    //gyGnjDao.ZY_YGPJ_JK(jgid);
                    gyGnjDao.delImRcjlByJgid(jgid);

                    // gyGnjDao.delImcwsz(jgid);
                    // gyGnjDao.updateImCwszByJgid(jgid);

                    gyGnjDao.insertPubCsh(groupid, officeid, jgid);
                }
            }
        }

        }





}
