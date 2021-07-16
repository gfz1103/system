package com.buit.his.dic.service;

import com.buit.commons.BaseManagerImp;
import com.buit.his.dic.dao.DicYljsDao;
import com.buit.his.dic.model.DicYljs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <br>
 * @author N47FN489F
 */
@Service
public class DicYljsSer extends BaseManagerImp<DicYljs,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(DicYljsSer.class);
    
    @Autowired
    private DicYljsDao dicYljsDao;
    
    @Override
    public DicYljsDao getEntityMapper(){        
        return dicYljsDao;
    }

    /**
     * 查询医疗角色
     * @param jsxh
     * @return
     */
    public DicYljs getYljs(Integer jsxh) {
        return dicYljsDao.getById(jsxh);
    }

    /**
     * 查询医疗角色集合
     * @return
     */
    public List<DicYljs> queryYljsList() {
        return dicYljsDao.findByEntity(null);
    }
    
}
