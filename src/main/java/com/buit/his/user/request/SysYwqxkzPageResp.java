//   
//package com.buit.his.drugstock.response;
//
//import java.sql.Timestamp;
//
//import com.buit.commons.PageQuery;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//
//
///**
// * 类名称：SysYwqxkz<br> 
// * 类描述：公用_公用权限控制分页信息<br>
// * @author "MLeo"
// */
//@ApiModel(value="公用_公用权限控制分页信息")
//public class SysYwqxkzPageResp{
//    @ApiModelProperty(value="员工代码")
//    private Integer ygdm;
//    @ApiModelProperty(value="药库类别 | edit liyl 1.药房业务 2.门诊医生 3.门诊业务;    药库，药房，病区，医技，供应，物资，门诊")
//    private String ywlb;
//    @ApiModelProperty(value="科室代码 | 业务类别为药库表示药库类别 业务类别为药房表示药房类别 业务类别为病区，医技表示科室代码 业务类别为供应表示供应库房类别 业务类别为物资表示物资库房类别 业务类别为门诊表示门诊类别")
//    private Integer ksdm;
//    @ApiModelProperty(value="机构代码")
//    private Integer jgid;
//    @ApiModelProperty(value="默认标志 | 1.默认科室   0.非默认科室")
//    private Integer mrbz;
//    /**
//     * 设置:员工代码
//     */
//    public void setYgdm(Integer value) {
//        this.ygdm = value;
//    }
//    /**
//     * 获取:员工代码
//     */
//    public Integer getYgdm() {
//        return ygdm;
//    }
//    /**
//     * 设置:药库类别 | edit liyl 1.药房业务 2.门诊医生 3.门诊业务;    药库，药房，病区，医技，供应，物资，门诊
//     */
//    public void setYwlb(String value) {
//        this.ywlb = value;
//    }
//    /**
//     * 获取:药库类别 | edit liyl 1.药房业务 2.门诊医生 3.门诊业务;    药库，药房，病区，医技，供应，物资，门诊
//     */
//    public String getYwlb() {
//        return ywlb;
//    }
//    /**
//     * 设置:科室代码 | 业务类别为药库表示药库类别 业务类别为药房表示药房类别 业务类别为病区，医技表示科室代码 业务类别为供应表示供应库房类别 业务类别为物资表示物资库房类别 业务类别为门诊表示门诊类别
//     */
//    public void setKsdm(Long value) {
//        this.ksdm = value;
//    }
//    /**
//     * 获取:科室代码 | 业务类别为药库表示药库类别 业务类别为药房表示药房类别 业务类别为病区，医技表示科室代码 业务类别为供应表示供应库房类别 业务类别为物资表示物资库房类别 业务类别为门诊表示门诊类别
//     */
//    public Long getKsdm() {
//        return ksdm;
//    }
//    /**
//     * 设置:机构代码
//     */
//    public void setJgid(Integer value) {
//        this.jgid = value;
//    }
//    /**
//     * 获取:机构代码
//     */
//    public Integer getJgid() {
//        return jgid;
//    }
//    /**
//     * 设置:默认标志 | 1.默认科室   0.非默认科室
//     */
//    public void setMrbz(Integer value) {
//        this.mrbz = value;
//    }
//    /**
//     * 获取:默认标志 | 1.默认科室   0.非默认科室
//     */
//    public Integer getMrbz() {
//        return mrbz;
//    }
//}
