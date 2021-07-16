package com.buit.his.sys.centermaintenance.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseManagerImp;
import com.buit.constans.TableName;
import com.buit.his.sys.centermaintenance.dao.DiccLdxmglDao;
import com.buit.his.sys.centermaintenance.model.DiccLdxmgl;
import com.buit.his.sys.centermaintenance.request.DiccLdxmglAddReq;
import com.buit.utill.BeanUtil;
import com.buit.utill.RedisFactory;
/**
 * 项目关联<br>
 * @author GONGFANGZHOU
 */
@Service
public class DiccLdxmglSer extends BaseManagerImp<DiccLdxmgl,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(DiccLdxmglSer.class);
    
    @Autowired
    private DiccLdxmglDao diccLdxmglDao;

    @Autowired
    private RedisFactory redisFactory;
    
    @Override
    public DiccLdxmglDao getEntityMapper(){        
        return diccLdxmglDao;
    }

    /**
     * 附加项目-新增
     *
     * @param req
     */
    public void add(DiccLdxmglAddReq req, int jgid) {
        DiccLdxmgl diccLdxmgl = BeanUtil.toBean(req, DiccLdxmgl.class);
        diccLdxmgl.setJgid(jgid);
//        int jlxh = redisFactory.getTableKey(TableName.DB_NAME, TableName.DICC_LDXMGL);
//        diccLdxmgl.setJlxh(jlxh);
        diccLdxmglDao.insert(diccLdxmgl);
    }

    /**
     * 删除
     * @param jlxh 记录序号
     */
    public void delete(int jlxh) {
        diccLdxmglDao.deleteById(jlxh);
    }
}
