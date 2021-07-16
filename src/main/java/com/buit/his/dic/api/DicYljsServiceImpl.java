package com.buit.his.dic.api;

import com.buit.his.dic.model.DicYljs;
import com.buit.his.dic.service.DicYljsSer;
import com.buit.system.model.DicYljsModel;
import com.buit.system.service.DicYljsService;
import com.buit.utill.BeanUtil;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名：DicYljsServiceImpl
 * 描述：医疗角色
 *
 * @author : liushijie
 * 2021/3/23
 **/
@DubboService(timeout = 10000)
public class DicYljsServiceImpl implements DicYljsService {

    @Autowired
    private DicYljsSer dicYljsSer;

    /**
     * 查询医疗角色
     *
     * @param jsxh
     * @return
     */
    @Override
    public DicYljsModel queryYljs(Integer jsxh) {
        DicYljs yljs = dicYljsSer.getYljs(jsxh);
        DicYljsModel model = BeanUtil.toBean(yljs, DicYljsModel.class);
        return model;
    }

    @Override
    public List<DicYljsModel> queryALL() {
        List<DicYljsModel> retList = new ArrayList<>();
        List<DicYljs> list = dicYljsSer.findByEntity(null);
        for (DicYljs yljs : list) {
            DicYljsModel model = BeanUtil.toBean(yljs, DicYljsModel.class);
            retList.add(model);
        }
        return retList;
    }

}
