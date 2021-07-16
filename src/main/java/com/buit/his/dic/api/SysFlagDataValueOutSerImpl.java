package com.buit.his.dic.api;

import java.util.List;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import com.buit.his.dic.dao.SysFlagDataValueDao;
import com.buit.system.response.DictDto;
import com.buit.system.service.SysFlagDataValueOutSer;

/**
 * 标准数据值域 - dubbo服务实现
 * @author liushijie
 **/
@DubboService(timeout = 10000)
public class SysFlagDataValueOutSerImpl implements SysFlagDataValueOutSer {

    @Autowired
    SysFlagDataValueDao flagDataValueDao;

    @Override
    public List<DictDto> queryFlagValueByDataId(String dataId){
        return flagDataValueDao.queryFlagValueByDataId(dataId);
    }

    @Override
    public DictDto findFlagValueByDataIdAndValueCode(String dataId,String code){
        return flagDataValueDao.findFlagValueByDataIdAndValueCode(dataId,code);
    }

}
