package com.buit.his.sys.centermaintenance.api;

import com.buit.his.sys.centermaintenance.dao.DicZyjbDao;
import com.buit.his.sys.centermaintenance.model.DicJbbm;
import com.buit.his.sys.centermaintenance.request.DicZyjbReq;
import com.buit.his.sys.centermaintenance.response.DicZyjbResp;
import com.buit.his.sys.centermaintenance.service.DicJbbmSer;
import com.buit.system.request.DicZyjbCopyReq;
import com.buit.system.response.DicJbbmModel;
import com.buit.system.response.DicZyjbCopyResp;
import com.buit.system.service.DicJbbmService;
import com.buit.utill.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * 类名：DicJbbmServiceImpl
 * 描述：疾病编码字典接口实现
 *
 * @author : liushijie
 * 2020/9/15
 **/
@DubboService(timeout = 10000)
public class DicJbbmServiceImpl implements DicJbbmService {

    @Autowired
    private DicJbbmSer dicJbbmSer;

    @Autowired
    private DicZyjbDao dicZyjbDao;

    /**
     * 查询疾病编码
     * @param jbxh  疾病序号
     * @return
     */
    @Override
    public DicJbbmModel queryJbbm(Integer jbxh) {
        DicJbbm dicJbbm = dicJbbmSer.getById(jbxh);
        DicJbbmModel retModel = new DicJbbmModel();
        if (null != dicJbbm) {
            retModel = BeanUtil.toBean(dicJbbm, DicJbbmModel.class);
        }
        return retModel;
    }


	/**
	 * 查询疾病编码
	 * @Title: getJbbmInfo
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param jbxh
	 * @param @return    设定文件
	 * @author 龚方舟
	 * @throws
	 */
	@Override
	public List<Map<String, Object>> getJbbmInfo(String jbxh) {
		return dicJbbmSer.getEntityMapper().getJbbmInfo(jbxh);
	}

    @Override
    public List<DicJbbmModel> queryList(DicJbbmModel dicJbbmParam) {

        return BeanUtil.toBeans(dicJbbmSer.findByEntity(dicJbbmParam),DicJbbmModel.class) ;
    }

    /**
     * 查询疾病信息（西医）
     * @param dicJbbmParam
     * @return
     */
    @Override
    public PageInfo<DicJbbmModel> findByEntity(DicJbbmModel dicJbbmParam) {
        DicJbbm queryparam=new DicJbbm();
        BeanUtils.copyProperties(dicJbbmParam,queryparam);

        PageInfo<DicJbbm> pageInfo = PageHelper.startPage(
                dicJbbmParam.getPageNum(), dicJbbmParam.getPageSize()).doSelectPageInfo(
                () -> dicJbbmSer.findByEntity(queryparam)
        );
        return BeanUtil.toPage(pageInfo, DicJbbmModel.class);
    }

    /**
     * 查询疾病信息（中医）
     * @param req
     * @return
     */
    @Override
    public PageInfo<DicZyjbCopyResp> findZyjb(DicZyjbCopyReq req) {
        DicZyjbReq zyjbReq = BeanUtil.toBean(req, DicZyjbReq.class);

        PageInfo<DicZyjbResp> pageInfo = PageHelper.startPage(
                req.getPageNum(), req.getPageSize()).doSelectPageInfo(
                () -> dicZyjbDao.findZyjb(zyjbReq));
        return BeanUtil.toPage(pageInfo,DicZyjbCopyResp.class);
    }


    public List<Map<String, Object>> getZd(String zdxh) {
		return dicJbbmSer.getEntityMapper().getZd(zdxh);
	}


	public List<Map<String, Object>> getBrzd(String zyh) {
		return dicJbbmSer.getEntityMapper().getBrzd(zyh);
	}
}
