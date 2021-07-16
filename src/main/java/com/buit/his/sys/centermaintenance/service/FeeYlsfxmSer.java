package com.buit.his.sys.centermaintenance.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseManagerImp;
import com.buit.commons.PageQuery;
import com.buit.his.param.dao.SysXtcsDao;
import com.buit.his.sys.centermaintenance.dao.CmoSsxmgxDao;
import com.buit.his.sys.centermaintenance.dao.DicSfxmlbDao;
import com.buit.his.sys.centermaintenance.dao.FeeYlsfxmDao;
import com.buit.his.sys.centermaintenance.dto.SsbmDto;
import com.buit.his.sys.centermaintenance.model.FeeYlsfxm;
import com.buit.his.sys.centermaintenance.request.FeeYlsfxmReq;
import com.buit.his.sys.centermaintenance.request.FeeYlsfxmYlReq;
import com.buit.his.sys.centermaintenance.response.SsFeeYlsfxmResp;
import com.buit.system.response.FeeYlsfxmOutResp;
import com.buit.system.response.SysXtcs;
import com.buit.system.utill.ObjectToTypes;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.hutool.core.bean.BeanUtil;

/**
 * 公用_医疗收费<br>
 * @author 老花生
 */
@Service
public class FeeYlsfxmSer extends BaseManagerImp<FeeYlsfxm,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(FeeYlsfxmSer.class);
    
    @Autowired
    private FeeYlsfxmDao feeYlsfxmDao;
    @Autowired
    private CmoSsxmgxDao cmoSsxmgxDao;
    @Autowired
    private DicSfxmlbDao dicSfxmlbDao;

    @Override
    public FeeYlsfxmDao getEntityMapper(){        
        return feeYlsfxmDao;
    }
    
    @Autowired
    private SysXtcsDao sysXtcsDao;
    
    /**
     * @name: allInfoNoUser
     * @description: 查询全部手术信息刨除用户选择
     * @param req
     * @return: com.github.pagehelper.PageInfo<com.buit.his.sys.centermaintenance.response.FeeYlsfxmResp>
     * @date: 2020/8/13 19:51
     * @auther: 老花生
     *
     */
    public PageInfo<FeeYlsfxm> allInfoNoUser(FeeYlsfxmReq req) {
        PageInfo<FeeYlsfxm> pageInfo = PageHelper.startPage(
                req.getPageNum(), req.getPageSize()).doSelectPageInfo(
                () -> feeYlsfxmDao.allInfoNoUser(req.getPydm())
        );
        return pageInfo;
    }

    public PageInfo<FeeYlsfxm> queryFeeYlsfxmDetail(FeeYlsfxmYlReq feeYlsfxmYlReq, PageQuery page) {
        FeeYlsfxm feeYlsfxm = BeanUtil.toBean(feeYlsfxmYlReq, FeeYlsfxm.class);
        PageInfo<FeeYlsfxm> pageInfo = PageHelper.startPage(page.getPageNum(), page.getPageSize())
                .doSelectPageInfo(() -> feeYlsfxmDao.findByEntity(feeYlsfxm));
        List<Integer> fyxhList = pageInfo.getList().stream().map(f->f.getFyxh()).collect(Collectors.toList());
        List<SsbmDto> ssbmDtoList = new ArrayList<>();
        if(fyxhList!=null&&fyxhList.size()>0){
            ssbmDtoList = cmoSsxmgxDao.querySsbmAndSsmcByFyxh(fyxhList);
        }
        Map<Integer ,SsbmDto> ssbmMap = ssbmDtoList.stream().collect(Collectors.toMap(SsbmDto::getFyxh,s->s));

        List<FeeYlsfxm> resp = pageInfo.getList().stream().map(f->{
            if(ssbmMap.containsKey(f.getFyxh())){
                SsFeeYlsfxmResp s = BeanUtil.toBean(f,SsFeeYlsfxmResp.class);
                s.setSsbm(ssbmMap.get(f.getFyxh()).getSsbm());
                s.setSsmc(ssbmMap.get(f.getFyxh()).getSsmc());
                return s;
            }else{
                return f;
            }

        }).collect(Collectors.toList());
        pageInfo.setList(resp);
        return pageInfo;
    }

    public String xmbm(String sfxmlb){
        String nextSfxmlsh = dicSfxmlbDao.nextSfxmbm(sfxmlb);
        return zeroPrefix(sfxmlb, 2) + zeroPrefix(nextSfxmlsh, 6);
    }

    private String zeroPrefix(String source, int tagetLength){
        StringBuilder sb = new StringBuilder(source);
        while (sb.length() < tagetLength){
            sb.insert(0,"0");
        }
        return sb.toString();
    }
    
    
}
