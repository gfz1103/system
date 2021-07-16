package com.buit.his.sys.centermaintenance.response;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
* 类名称：DicZyjbfl
* 类描述：中医疾病分类
* @author liushijie
*/
@ApiModel(value="中医疾病分类")
public class DicZyjbflResp {
   @ApiModelProperty(value="疾病分类")
   private Integer zyfl;
   @ApiModelProperty(value="分类编码")
   private String flbm;
   @ApiModelProperty(value="分类代码")
   private String fldm;
   @ApiModelProperty(value="上级ID")
   private Integer sjid;
   @ApiModelProperty(value="疾病名称")
   private String flmc;
   @ApiModelProperty(value="拼音码")
   private String pydm;
   @ApiModelProperty(value="五笔码")
   private String wbdm;
   @ApiModelProperty(value="其它码")
   private String qtdm;
   @ApiModelProperty(value="注销标志")
   private Boolean zxbz;
   @ApiModelProperty(value="允许治愈")
   private String bzxx;

    private List<DicZyjbflResp> childrenList;

   /**
    * 设置:疾病分类
    */
   public void setZyfl(Integer value) {
       this.zyfl = value;
   }
   /**
    * 获取:疾病分类
    */
   public Integer getZyfl() {
       return zyfl;
   }
   /**
    * 设置:分类编码
    */
   public void setFlbm(String value) {
       this.flbm = value;
   }
   /**
    * 获取:分类编码
    */
   public String getFlbm() {
       return flbm;
   }
   /**
    * 设置:分类代码
    */
   public void setFldm(String value) {
       this.fldm = value;
   }
   /**
    * 获取:分类代码
    */
   public String getFldm() {
       return fldm;
   }
   /**
    * 设置:上级ID
    */
   public void setSjid(Integer value) {
       this.sjid = value;
   }
   /**
    * 获取:上级ID
    */
   public Integer getSjid() {
       return sjid;
   }
   /**
    * 设置:疾病名称
    */
   public void setFlmc(String value) {
       this.flmc = value;
   }
   /**
    * 获取:疾病名称
    */
   public String getFlmc() {
       return flmc;
   }
   /**
    * 设置:拼音码
    */
   public void setPydm(String value) {
       this.pydm = value;
   }
   /**
    * 获取:拼音码
    */
   public String getPydm() {
       return pydm;
   }
   /**
    * 设置:五笔码
    */
   public void setWbdm(String value) {
       this.wbdm = value;
   }
   /**
    * 获取:五笔码
    */
   public String getWbdm() {
       return wbdm;
   }
   /**
    * 设置:其它码
    */
   public void setQtdm(String value) {
       this.qtdm = value;
   }
   /**
    * 获取:其它码
    */
   public String getQtdm() {
       return qtdm;
   }
   /**
    * 设置:注销标志
    */
   public void setZxbz(Boolean value) {
       this.zxbz = value;
   }
   /**
    * 获取:注销标志
    */
   public Boolean getZxbz() {
       return zxbz;
   }
   /**
    * 设置:允许治愈
    */
   public void setBzxx(String value) {
       this.bzxx = value;
   }
   /**
    * 获取:允许治愈
    */
   public String getBzxx() {
       return bzxx;
   }

    public List<DicZyjbflResp> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<DicZyjbflResp> childrenList) {
        this.childrenList = childrenList;
    }
}