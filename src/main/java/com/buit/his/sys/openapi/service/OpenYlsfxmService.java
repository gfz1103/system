package com.buit.his.sys.openapi.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.buit.his.dic.dao.SysDictConfigDao;
import com.buit.his.dic.dao.SysFlagDataValueDao;
import com.buit.his.dic.model.SysDictConfig;
import com.buit.his.dic.response.Sondic;
import com.buit.his.sys.centermaintenance.dao.DicSfxmlbDao;
import com.buit.his.sys.centermaintenance.dao.FeeYlsfxmDao;
import com.buit.his.sys.centermaintenance.model.FeeYlsfxm;
import com.buit.his.sys.centermaintenance.request.FeeYlsfxmYlSaveReq;
import com.buit.his.sys.centermaintenance.response.PubBrxzResp;
import com.buit.his.sys.centermaintenance.service.DicSfxmlbSer;
import com.buit.his.sys.centermaintenance.service.FeeYlsfxmSer;
import com.buit.his.sys.openapi.request.SaveSfxmmxRequest;
import com.buit.his.sys.openapi.response.*;
import com.buit.system.model.DicSfxmlb;
import com.buit.system.response.DictDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author sunjx
 * @Date 2020-12-15 09:39
 * @Description
 **/
@Service
public class OpenYlsfxmService {

    @Autowired
    private FeeYlsfxmSer feeYlsfxmSer;
    @Autowired
    private DicSfxmlbSer dicSfxmlbSer;
    @Autowired
    private DicSfxmlbDao dicSfxmlbDao;
    @Autowired
    private FeeYlsfxmDao feeYlsfxmDao;
    @Autowired
    private SysDictConfigDao sysDictConfigDao;
    @Autowired
    private SysFlagDataValueDao sysFlagDataValueDao;

    public QuerySfxmmxDetailResponse detail(Integer fyxh) {
        FeeYlsfxm feeylsfxm = feeYlsfxmDao.getById(fyxh);
        if (null == feeylsfxm) {
            return null;
        }

        return toQuerySfxmmxDetailResponse(feeylsfxm);
    }

    public List<QueryDictResponse> dict(Integer dictId, Integer hospitalId) {
        SysDictConfig dict = sysDictConfigDao.getById(dictId);
        if (null == dict) {
            return null;
        }
        String sql = dict.getQuerySql();
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("hospitalId", hospitalId);
        parameter.put("sql", sql);
        List<Sondic> sondics = sysDictConfigDao.runSondic(parameter);

        if (CollUtil.isEmpty(sondics)) {
            return null;
        }

        return sondics.stream()
                .map(s -> {
                    QueryDictResponse queryDictResponse = new QueryDictResponse();
                    queryDictResponse.setDv(s.getDv());
                    queryDictResponse.setDn(s.getDn());
                    queryDictResponse.setStop(s.getStop());
                    queryDictResponse.setShowOrder(s.getShowOrder());
                    queryDictResponse.setPy(s.getPy());
                    queryDictResponse.setWb(s.getWb());
                    return queryDictResponse;
                }).collect(Collectors.toList());
    }

    public List<QueryFlagDataResponse> flagData(String dataCode, Integer hospitalId) {
        List<DictDto> dictDtos = sysFlagDataValueDao.queryFlagValueByDataCode(dataCode);
        if(CollUtil.isEmpty(dictDtos)){
            return null;
        }

        return dictDtos.stream()
                .map(d -> {
                    QueryFlagDataResponse response = new QueryFlagDataResponse();
                    response.setCode(d.getCode());
                    response.setName(d.getName());
                    return response;
                }).collect(Collectors.toList());
    }

    public QueryNextSfxmbmResponse nextSfxmbm(String sfxmlb) {
        QueryNextSfxmbmResponse response = new QueryNextSfxmbmResponse();
        response.setNextSfxmbm(feeYlsfxmSer.xmbm(sfxmlb));
        return response;
    }


    @Transactional(rollbackFor = Exception.class)
    public SaveSfxmmxResponse save(SaveSfxmmxRequest data) {
        FeeYlsfxmYlSaveReq.FeeYlsfxmBody feeYlsfxmBody = toFeeYlsfxmBody(data);
        FeeYlsfxmYlSaveReq feeYlsfxmYlSaveReq = new FeeYlsfxmYlSaveReq();
        feeYlsfxmYlSaveReq.setFeeYlsfxmBody(feeYlsfxmBody);

        //费用性质
        List<PubBrxzResp> pubBrxzResps = dicSfxmlbSer.queryCostLimit(feeYlsfxmBody.getFyxh());
        if (CollUtil.isNotEmpty(pubBrxzResps)) {
            List<FeeYlsfxmYlSaveReq.PubFyxzBody> pubFyxzBodyList = new ArrayList();

            for (PubBrxzResp pubBrxzResp : pubBrxzResps) {
                FeeYlsfxmYlSaveReq.PubFyxzBody pubFyxzBody = new FeeYlsfxmYlSaveReq.PubFyxzBody();
                pubFyxzBody.setBrxz(pubBrxzResp.getBrxz());
                pubFyxzBody.setCxbl(pubBrxzResp.getCxbl());
                pubFyxzBody.setFyxe(pubBrxzResp.getFyxe());
                pubFyxzBody.setFyxh(pubBrxzResp.getFyxh());
                pubFyxzBody.setXzmc(pubBrxzResp.getXzmc());
                pubFyxzBody.setZfbl(pubBrxzResp.getZfbl());
                pubFyxzBodyList.add(pubFyxzBody);
            }

            feeYlsfxmYlSaveReq.setPubFyxzBodyList(pubFyxzBodyList);
        }

        //如果是新增,更新收费项目类别的项目编码
        if(feeYlsfxmBody.getFyxh() == null){
            dicSfxmlbDao.updateNowSfxmbm(feeYlsfxmBody.getFygb() , Integer.valueOf(feeYlsfxmBody.getXmbm().substring(2)));
        }

        FeeYlsfxmYlSaveReq.FeeYlsfxmBody feeYlsfxmBody1 = dicSfxmlbSer.doSaveCostDetail(feeYlsfxmYlSaveReq);
        if( null == feeYlsfxmBody1){
            return null;
        }

        SaveSfxmmxResponse response = new SaveSfxmmxResponse();
        response.setFyxh(feeYlsfxmBody1.getFyxh());
        return response;
    }

    public List<DicSfxmlb> sfxmlbList(Integer fyfl, String pydm) {
        DicSfxmlb dicSfxmlb = new DicSfxmlb();
        dicSfxmlb.setFyfl(fyfl);
        if (StrUtil.isNotBlank(pydm)) {
            dicSfxmlb.setPydm(pydm);
        }
        return dicSfxmlbSer.findByEntity(dicSfxmlb);
    }

    private FeeYlsfxmYlSaveReq.FeeYlsfxmBody toFeeYlsfxmBody(SaveSfxmmxRequest data) {
        FeeYlsfxmYlSaveReq.FeeYlsfxmBody feeYlsfxmBody = new FeeYlsfxmYlSaveReq.FeeYlsfxmBody();
        feeYlsfxmBody.setSsbm(data.getSsbm());
        feeYlsfxmBody.setBasygb(data.getBasygb());
        feeYlsfxmBody.setBbgb(data.getBbgb());
        feeYlsfxmBody.setBhdm(data.getBhdm());
        feeYlsfxmBody.setBzjg(data.getBzjg());
        feeYlsfxmBody.setClbz(data.getClbz());
        feeYlsfxmBody.setCldym(data.getCldym());
        feeYlsfxmBody.setFydw(data.getFydw());
        feeYlsfxmBody.setFygb(data.getFygb());
        feeYlsfxmBody.setFymc(data.getFymc());
        feeYlsfxmBody.setFyxh(data.getFyxh());
        feeYlsfxmBody.setHmbm(data.getHmbm());
        feeYlsfxmBody.setJxdm(data.getJxdm());
        feeYlsfxmBody.setMxbz(data.getMxbz());
        feeYlsfxmBody.setMzsy(data.getMzsy());
        feeYlsfxmBody.setPydm(data.getPydm());
        feeYlsfxmBody.setQtdm(data.getQtdm());
        feeYlsfxmBody.setTjfy(data.getTjfy());
        feeYlsfxmBody.setTxzl(data.getTxzl());
        feeYlsfxmBody.setWbdm(data.getWbdm());
        feeYlsfxmBody.setXmbm(data.getXmbm());
        feeYlsfxmBody.setXmlx(data.getXmlx());
        feeYlsfxmBody.setYbbm(data.getYbbm());
        feeYlsfxmBody.setYbdw(data.getYbdw());
        feeYlsfxmBody.setYbmc(data.getYbmc());
        feeYlsfxmBody.setYjsy(data.getYjsy());
        feeYlsfxmBody.setYyclgg(data.getYyclgg());
        feeYlsfxmBody.setYypp(data.getYypp());
        feeYlsfxmBody.setZczh(data.getZczh());
        feeYlsfxmBody.setZfpb(data.getZfpb());
        feeYlsfxmBody.setZjxe(data.getZjxe());
        feeYlsfxmBody.setZxks(data.getZxks());
        feeYlsfxmBody.setZysy(data.getZysy());
        return feeYlsfxmBody;
    }

    private QuerySfxmmxDetailResponse toQuerySfxmmxDetailResponse(FeeYlsfxm feeylsfxm) {
        QuerySfxmmxDetailResponse response = new QuerySfxmmxDetailResponse();
        response.setBasygb(feeylsfxm.getBasygb());
        response.setBasyxm(feeylsfxm.getBasyxm());
        response.setBbgb(feeylsfxm.getBbgb());
        response.setBbgb1(feeylsfxm.getBbgb1());
        response.setBhdm(feeylsfxm.getBhdm());
        response.setBlbz(feeylsfxm.getBlbz());
        response.setBzjg(feeylsfxm.getBzjg());
        response.setCftxbz(feeylsfxm.getCftxbz());
        response.setClbz(feeylsfxm.getClbz());
        response.setCldym(feeylsfxm.getCldym());
        response.setDz(feeylsfxm.getDz());
        response.setDzbh(feeylsfxm.getDzbh());
        response.setFlzzf(feeylsfxm.getFlzzf());
        response.setFydj(feeylsfxm.getFydj());
        response.setFydw(feeylsfxm.getFydw());
        response.setFyetjmbz(feeylsfxm.getFyetjmbz());
        response.setFygb(feeylsfxm.getFygb());
        response.setFyjmbm(feeylsfxm.getFyjmbm());
        response.setFyks(feeylsfxm.getFyks());
        response.setFylb(feeylsfxm.getFylb());
        response.setFymc(feeylsfxm.getFymc());
        response.setFyms(feeylsfxm.getFyms());
        response.setFyxh(feeylsfxm.getFyxh());
        response.setGnxh(feeylsfxm.getGnxh());
        response.setHlxmlb(feeylsfxm.getHlxmlb());
        response.setHlzx(feeylsfxm.getHlzx());
        response.setHmbm(feeylsfxm.getHmbm());
        response.setJcsq(feeylsfxm.getJcsq());
        response.setJczqtys(feeylsfxm.getJczqtys());
        response.setJxcs(feeylsfxm.getJxcs());
        response.setJxdm(feeylsfxm.getJxdm());
        response.setJxxmlb(feeylsfxm.getJxxmlb());
        response.setLislx(feeylsfxm.getLislx());
        response.setMgh(feeylsfxm.getMgh());
        response.setMxbz(feeylsfxm.getMxbz());
        response.setMzsq(feeylsfxm.getMzsq());
        response.setMzsy(feeylsfxm.getMzsy());
        response.setPydm(feeylsfxm.getPydm());
        response.setQtdm(feeylsfxm.getQtdm());
        response.setRislx(feeylsfxm.getRislx());
        response.setSfjxfx(feeylsfxm.getSfjxfx());
        response.setSsstj(feeylsfxm.getSsstj());
        response.setTjfy(feeylsfxm.getTjfy());
        response.setTsfy(feeylsfxm.getTsfy());
        response.setTsts(feeylsfxm.getTsts());
        response.setTsxmlx(feeylsfxm.getTsxmlx());
        response.setTxzl(feeylsfxm.getTxzl());
        response.setWbdm(feeylsfxm.getWbdm());
        response.setXmbm(feeylsfxm.getXmbm());
        response.setXmfl(feeylsfxm.getXmfl());
        response.setXmks(feeylsfxm.getXmks());
        response.setXmlx(feeylsfxm.getXmlx());
        response.setYbbm(feeylsfxm.getYbbm());
        response.setYbdw(feeylsfxm.getYbdw());
        response.setYbmc(feeylsfxm.getYbmc());
        response.setYbxmjfbz(feeylsfxm.getYbxmjfbz());
        response.setYjck(feeylsfxm.getYjck());
        response.setYjjk(feeylsfxm.getYjjk());
        response.setYjlx(feeylsfxm.getYjlx());
        response.setYjsy(feeylsfxm.getYjsy());
        response.setYlxz(feeylsfxm.getYlxz());
        response.setYyclgg(feeylsfxm.getYyclgg());
        response.setYypp(feeylsfxm.getYypp());
        response.setZczh(feeylsfxm.getZczh());
        response.setZfpb(feeylsfxm.getZfpb());
        response.setZjxe(feeylsfxm.getZjxe());
        response.setZxks(feeylsfxm.getZxks());
        response.setZysx(feeylsfxm.getZysx());
        response.setZysy(feeylsfxm.getZysy());
        response.setZyxmbz(feeylsfxm.getZyxmbz());
        return response;
    }
}
