//   
//package com.buit.his.drugstock.request;
//
//import java.sql.Timestamp;
//
//import com.buit.commons.PageQuery;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
//import java.math.BigDecimal;
//
//
///**
// * 类名称：SysYwqxkz<br> 
// * 类描述：公用_公用权限控制添加<br>
// * @author "MLeo"
// */
//@ApiModel(value="公用_公用权限控制添加")
//public class SysYwqxkzAddReq{
//    @NotBlank(message = "员工代码不能为空")
//    @ApiModelProperty(value="员工代码",required = true)
//    private Integer ygdm;
//    @NotBlank(message = "药库类别 | edit liyl 1.药房业务 2.门诊医生 3.门诊业务;    药库，药房，病区，医技，供应，物资，门诊不能为空")
//    @ApiModelProperty(value="药库类别 | edit liyl 1.药房业务 2.门诊医生 3.门诊业务;    药库，药房，病区，医技，供应，物资，门诊",required = true)
//    private String ywlb;
//    @NotNull(message = "科室代码 | 业务类别为药库表示药库类别 业务类别为药房表示药房类别 业务类别为病区，医技表示科室代码 业务类别为供应表示供应库房类别 业务类别为物资表示物资库房类别 业务类别为门诊表示门诊类别不能为空")
//    @ApiModelProperty(value="科室代码 | 业务类别为药库表示药库类别 业务类别为药房表示药房类别 业务类别为病区，医技表示科室代码 业务类别为供应表示供应库房类别 业务类别为物资表示物资库房类别 业务类别为门诊表示门诊类别",required = true)
//    private Integer ksdm;
//    @NotBlank(message = "机构代码不能为空")
//    @ApiModelProperty(value="机构代码",required = true)
//    private Integer jgid;
//    @NotNull(message = "默认标志 | 1.默认科室   0.非默认科室不能为空")
//    @ApiModelProperty(value="默认标志 | 1.默认科室   0.非默认科室",required = true)
//    private Integer mrbz;

//}
