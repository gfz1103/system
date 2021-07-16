package com.buit.his.param.service;


import java.util.List;
import java.util.Map;

import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseManagerImp;
import com.buit.his.param.dao.SysXtcsDao;
import com.buit.system.request.SysXtcsReq;
import com.buit.system.response.SysXtcs;
import com.buit.system.response.SysXtcsResp;
import com.buit.system.service.SysXtcsSer;

/**
 * 公用_系统参数<br>
 * @author 老花生
 */
@DubboService(timeout = 10000)
public class SysXtcsSerImp extends BaseManagerImp<SysXtcs,String> implements SysXtcsSer {
    
    static final Logger logger = LoggerFactory.getLogger(SysXtcsSerImp.class);
    
    @Autowired
    private SysXtcsDao sysXtcsDao;
    
    @Override
    public SysXtcsDao getEntityMapper(){        
        return sysXtcsDao;
    }

    /**
     * 加载信息药房设置信息
     * @param pkey  科室可以
     * @param user  用户信息
     * @return
     */
    public SysXtcsResp load(String pkey, Integer hospitalId,Integer ztlb) {
        SysXtcs query = new SysXtcs();
        query.setJgid(hospitalId);
        query.setCsmc("YS_MZ_FYYF_" + pkey);
        List<SysXtcs> ret = sysXtcsDao.load(query);

        SysXtcsResp resp = new SysXtcsResp();
        if(ztlb != null) {
        	resp.setZtlb(ztlb);
        }
        for(SysXtcs xtcs : ret){
            if(xtcs.getCsmc().indexOf("_CY") > 0){
                resp.setCy(xtcs.getCsz());
            }else if(xtcs.getCsmc().indexOf("_XY") > 0){
                resp.setXy(xtcs.getCsz());
            }else if(xtcs.getCsmc().indexOf("_ZY") > 0){
                resp.setZy(xtcs.getCsz());
            }
        }
        return resp;
    }

    /**
     * 保存设置
     * @param req   请求参数
     * @param user  用户信息
     */
    public void save(SysXtcsReq req, Integer hospitalId) {
        //保存cy
        SysXtcs data = new SysXtcs();
        data.setJgid(hospitalId);
        data.setCsmc("YS_MZ_FYYF_" + req.getPkey() + "_CY");
        List<SysXtcs> retCy = sysXtcsDao.findByEntity(data);
        if(retCy.isEmpty()){
            data.setCsz(req.getCy());
            sysXtcsDao.insert(data);
        }else{
            SysXtcs cy = retCy.get(0);
            cy.setCsz(req.getCy());
            sysXtcsDao.updateCsz(cy);
        }

        //保存xy
        data.setCsmc("YS_MZ_FYYF_" + req.getPkey() + "_XY");
        List<SysXtcs> retXy = sysXtcsDao.findByEntity(data);
        if(retXy.isEmpty()){
            data.setCsz(req.getXy());
            sysXtcsDao.insert(data);
        }else{
            SysXtcs xy = retXy.get(0);
            xy.setCsz(req.getXy());
            sysXtcsDao.updateCsz(xy);
        }

        //保存zy
        data.setCsmc("YS_MZ_FYYF_" + req.getPkey() + "_ZY");
        List<SysXtcs> retZy = sysXtcsDao.findByEntity(data);
        if(retZy.isEmpty()){
            data.setCsz(req.getZy());
            sysXtcsDao.insert(data);
        }else{
            SysXtcs zy = retZy.get(0);
            zy.setCsz(req.getZy());
            sysXtcsDao.updateCsz(zy);
        }


    }

    /**
     * 修改住院相关参数 住院号、病案号做加一操作
     * @param sysXtcs
     */
    public void updateZyParam(SysXtcs sysXtcs){
        sysXtcsDao.updateZyParam(sysXtcs);
    }
    public void updateCsz(SysXtcs sysXtcs){
    	 sysXtcsDao.updateCsz(sysXtcs);
    }
    public void insert(SysXtcs sysXtcs){
    	sysXtcsDao.insert(sysXtcs);
    }
    public List<Map<String, Object>>  getXtcsByCsmc(Map<String, Object> par){
    	 return sysXtcsDao.getXtcsByCsmc(par);
    }
}
