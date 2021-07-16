package com.buit.his.sys.centermaintenance.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.his.sys.centermaintenance.response.PubCshResp;
import com.buit.his.sys.centermaintenance.response.PubCshywjResp;

/**
 * 功能集<br>
 * @author beijunhua
 */
@Mapper
public interface PubCshywjDao extends EntityDao<PubCshywjResp,Integer>{

    /**
     * 查询功能集
     *
     * */
    List<PubCshywjResp> queryList();

    /**
     * 查询初始化
     *
     * */
    List<PubCshResp> queryYkCshList(Integer groupid);
    List<PubCshResp> queryYfCshList(Integer groupid);

    /**
     * 查询是否有初始化数据
     * @param groupid
     * @param officeid
     * @param jgid
     * @return
     */
    long count(String groupid,String officeid,Integer jgid);
    long countBq(String officeid,Integer jgid);

    void delOpThmxByJgid(Integer jgid);
    void delOpYyghByJgid(Integer jgid);
    void delOpGhFkxxByJgid(Integer jgid);
    void delOpGhmxByJgid(Integer jgid);
    void delOpYjcf02ByJgid(Integer jgid);
    void delOpYjcf01ByJgid(Integer jgid);
    void delOpCf02ByJgid(Integer jgid);
    void delOpCf01ByJgid(Integer jgid);
    void delOpSfmxByJgid(Integer jgid);
    void delOpZffpByJgid(Integer jgid);
    void delOpMzxxByJgid(Integer jgid);
    void delOpFkxxByJgid(Integer jgid);
    void delOpKspbByJgid(Integer jgid);
    void delOpYspbByJgid(Integer jgid);
    void delMpi_card(Integer jgid);
    void delMpi_brda(Integer jgid);
    void delOpzydj(Integer jgid);
    void delOpGrmx(Integer jgid);   // 个人日报明细
    void delOpGhrbfkmx(Integer jgid); //挂号日报付款明细
    void delOpGhrb(Integer jgid);  //挂号日报
    void delOpRbmx(Integer jgid);   //日报明细
    void delOpXzmx(Integer jgid) ; //日报性质
    void delOpSfrbfkmx(Integer jgid); //收费日报付款明细
    void delOpHzrb(Integer jgid);   //汇总日报
    void updateOpGhksByJgid(Integer jgid);
    void insertPubCsh(String groupid, String officeid, Integer jgid);

    void delDrugsSwyjByXtsb(Integer jgid,String xtsb);
    void delDrugsYjjgByXtsb(Integer jgid,String xtsb);
    void delDrugsJzjlByXtsb(Integer jgid,String xtsb);
    void delDrugsRk02ByXtsb(Integer jgid,String xtsb);
    void delDrugsRk01ByXtsb(Integer jgid,String xtsb);
    void delDrugsCk02ByXtsb(Integer jgid,String xtsb);
    void delDrugsCk01ByXtsb(Integer jgid,String xtsb);
    void delDrugsTjjlByXtsb(Integer jgid,String xtsb);
    void delDrugsTj02ByXtsb(Integer jgid,String xtsb);
    void delDrugsTj01ByXtsb(Integer jgid,String xtsb);
    void delDrugsPd02ByXtsb(Integer jgid,String xtsb);
    void delDrugsPd01ByXtsb(Integer jgid,String xtsb);
    void delDrugsPz02ByXtsb(Integer jgid,String xtsb);
    void delDrugsPz01ByXtsb(Integer jgid,String xtsb);
    void delDrugsKcflByXtsb(Integer jgid,String xtsb);
    void delDrugsKcmxByXtsb(Integer jgid,String xtsb);
    void delDrugsKcmxlsByXtsb(Integer jgid,String xtsb);
    void delDrugsYpxxByXtsb(Integer jgid,String xtsb);
    void updateDrugsCdxxByXtsb(Integer jgid,String xtsb);
    void updateDrugsRkfsByXtsb(Integer jgid,int djhm,String xtsb);
    void updateDrugsCkfsByXtsb(Integer jgid,int djhm,String xtsb);
    void updateDrugsYklbByXtsb(Integer jgid,String xtsb);

    void delPharRk02ByYfsb(Integer jgid,String yfsb);
    void delPharRk01ByYfsb(Integer jgid,String yfsb);
    void delPharCk02ByYfsb(Integer jgid,String yfsb);
    void delPharCk01ByYfsb(Integer jgid,String yfsb);
    void delPharTjjlByYfsb(Integer jgid,String yfsb);
    void delPharMzfymxByYfsb(Integer jgid,String yfsb);
    void delPharKcmxByYfsb(Integer jgid,String yfsb);
    void delPharKcmxlsByYfsb(Integer jgid,String yfsb);
    void delPharRbmxByYfsb(Integer jgid,String yfsb);
    void delPharYfrbByYfsb(Integer jgid,String yfsb);
    void delPharYjjgByYfsb(Integer jgid,String yfsb);
    void delPharJzjlByYfsb(Integer jgid,String yfsb);
    void delPharZyfymxByYfsb(Integer jgid,String yfsb);
    void delPharFyjlByYfsb(Integer jgid,String yfsb);
    void delPharDb02ByYfsb(Integer jgid,String yfsb);
    void delPharDb01ByYfsb(Integer jgid,String yfsb);
    void delPharYk02grlrByYfsb(Integer jgid,String yfsb);
    void delPharYk02ByYfsb(Integer jgid,String yfsb);
    void delPharYk01ByYfsb(Integer jgid,String yfsb);
    void delPharKcdjByYfsb(Integer jgid,String yfsb);
    void updatePharRkfsByXtsb(Integer jgid,int djhm,String yfsb);
    void updatePharCkfsByXtsb(Integer jgid,int djhm,String yfsb);
    void delNisTj02ByYfsb(Integer jgid,String yfsb);
    void delNisTj01ByYfsb(Integer jgid,String yfsb);
    void delPharypxx(Integer jgid,String yfsb);

    void delZlJlxjzjByJgid(Integer jgid);
    void delZlLbByJgid(Integer jgid);
    void delZlSqdmxByJgid(Integer jgid);
    void delZlSqdxmzlnrByJgid(Integer jgid);
    void delZlSqdyyzxByJgid(Integer jgid);
    void delZlSqdzbByJgid(Integer jgid);
    void delZlSqdzdByJgid(Integer jgid);
    void delZlXmByJgid(Integer jgid);
    void delZlXmldsfxmByJgid(Integer jgid);
    void delZlXmzljhByJgid(Integer jgid);

    void delCisHzyzByJgid(Integer jgid);
    void delNisTymxByJgid(Integer jgid);
    void delCiszyhzsqByJgid(Integer jgid);
    void delCiszyhzyjByJgid(Integer jgid);
    void delCiszyhzyqdxByJgid(Integer jgid);
    void delCisBxsqdzdByJgid(Integer jgid);
    void delCisBxsqdByJgid(Integer jgid);

    void delImSrhzByJgid(Integer jgid);
    void delImFeefyhzByJgid(Integer jgid);
    void delImJzhzByJgid(Integer jgid);
    void delImZfpjByJgid(Integer jgid);
    void delImJzxxByJgid(Integer jgid);
    void delImJszfByJgid(Integer jgid);
    void delImJsmxByJgid(Integer jgid);
    void delImFkxxByJgid(Integer jgid);
    void delImZyjsByJgid(Integer jgid);
    void delImFeefymxByJgid(Integer jgid);
    void delImFeefymxjsByJgid(Integer jgid);
    void delImJkzfByJgid(Integer jgid);
    void delImTbkkByJgid(Integer jgid);
    void delImHcmxByJgid(Integer jgid);
    void delImRyzdByJgid(Integer jgid);
    void delImHzryByJgid(Integer jgid);
    void delImCwtjByJgid(Integer jgid);
    void delImRcjlByJgid(Integer jgid);
    void delImcwsz(Integer jgid);
    void updateImCwszByJgid(Integer jgid);
}
