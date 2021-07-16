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
// * 类名称：PubBrxz<br> 
// * 类描述：公用_病人性质 | 包括自费、公费、记帐等添加<br>
// * @author "MLeo"
// */
//@ApiModel(value="公用_病人性质 | 包括自费、公费、记帐等添加")
//public class PubBrxzAddReq{
//    @NotNull(message = "性质代码不能为空")
//    @ApiModelProperty(value="性质代码",required = true)
//    private Integer brxz;
//    @NotBlank(message = "性质名称不能为空")
//    @ApiModelProperty(value="性质名称",required = true)
//    private String xzmc;
//    @NotNull(message = "上级性质 | 指明该类证号是否存在上级性质,及其上级代码不能为空")
//    @ApiModelProperty(value="上级性质 | 指明该类证号是否存在上级性质,及其上级代码",required = true)
//    private Integer sjxz;
//    @NotNull(message = "归属性质 | 归属于某最高级病人性质不能为空")
//    @ApiModelProperty(value="归属性质 | 归属于某最高级病人性质",required = true)
//    private Integer gsxz;
//    @NotBlank(message = "拼音码不能为空")
//    @ApiModelProperty(value="拼音码",required = true)
//    private String pydm;
//    @NotBlank(message = "证号判别 | 0.不需要 1.需要不能为空")
//    @ApiModelProperty(value="证号判别 | 0.不需要 1.需要",required = true)
//    private String zhpb;
//    @NotNull(message = "保险判别 | 0.非保险 1.大病保险 2.医疗保险 9.其他保险不能为空")
//    @ApiModelProperty(value="保险判别 | 0.非保险 1.大病保险 2.医疗保险 9.其他保险",required = true)
//    private Integer dbpb;
//    @NotNull(message = "门诊使用不能为空")
//    @ApiModelProperty(value="门诊使用",required = true)
//    private Integer mzsy;
//    @NotNull(message = "住院使用不能为空")
//    @ApiModelProperty(value="住院使用",required = true)
//    private Integer zysy;
//    @NotNull(message = "实收比例不能为空")
//    @ApiModelProperty(value="实收比例",required = true)
//    private BigDecimal ssbl;
//    @NotNull(message = "床费限价 | 某些病人床位限制在某金额才为公费，自动累加床位费时将超过的金额写入自负床位费不能为空")
//    @ApiModelProperty(value="床费限价 | 某些病人床位限制在某金额才为公费，自动累加床位费时将超过的金额写入自负床位费",required = true)
//    private BigDecimal cfxj;
//    @NotNull(message = "处方限额不能为空")
//    @ApiModelProperty(value="处方限额",required = true)
//    private BigDecimal cfxe;
//    @NotBlank(message = "排列顺序不能为空")
//    @ApiModelProperty(value="排列顺序",required = true)
//    private String plsx;
//    @NotBlank(message = "性质控制大类不能为空")
//    @ApiModelProperty(value="性质控制大类",required = true)
//    private String xzdl;
//    @NotNull(message = "退费分步交易不能为空")
//    @ApiModelProperty(value="退费分步交易",required = true)
//    private Integer tffbjy;
//    @NotNull(message = "妇幼儿童标志不能为空")
//    @ApiModelProperty(value="妇幼儿童标志",required = true)
//    private Integer fyetbz;
//    @NotBlank(message = "vipcwfy不能为空")
//    @ApiModelProperty(value="vipcwfy",required = true)
//    private String vipcwfy;

//}
