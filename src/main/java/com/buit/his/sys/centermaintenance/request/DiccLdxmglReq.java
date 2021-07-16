
package com.buit.his.sys.centermaintenance.request;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
* 类名称：DiccLdxmgl<br>
* 类描述：项目关联<br>
* @author GONGFANGZHOU
*/
@ApiModel(value="项目关联")
public class DiccLdxmglReq {
   @ApiModelProperty(value="记录序号")
   private Integer jlxh;
   @ApiModelProperty(value="项目序号")
   private Integer xmxh;
   @ApiModelProperty(value="机构ID")
   private Integer jgid;
   @ApiModelProperty(value="使用类别 | 1.门诊 2。住院")
   private Integer sylb;
   @ApiModelProperty(value="关联序号")
   private Integer glxh;
   @ApiModelProperty(value="科室代码")
   private Integer ksdm;
   @ApiModelProperty(value="费用数量")
   private BigDecimal fysl;

   /**
    * 设置:记录序号
    */
   public void setJlxh(Integer value) {
       this.jlxh = value;
   }
   /**
    * 获取:记录序号
    */
   public Integer getJlxh() {
       return jlxh;
   }
   /**
    * 设置:项目序号
    */
   public void setXmxh(Integer value) {
       this.xmxh = value;
   }
   /**
    * 获取:项目序号
    */
   public Integer getXmxh() {
       return xmxh;
   }
   /**
    * 设置:机构ID
    */
   public void setJgid(Integer value) {
       this.jgid = value;
   }
   /**
    * 获取:机构ID
    */
   public Integer getJgid() {
       return jgid;
   }
   /**
    * 设置:使用类别 | 1.门诊 2。住院
    */
   public void setSylb(Integer value) {
       this.sylb = value;
   }
   /**
    * 获取:使用类别 | 1.门诊 2。住院
    */
   public Integer getSylb() {
       return sylb;
   }
   /**
    * 设置:关联序号
    */
   public void setGlxh(Integer value) {
       this.glxh = value;
   }
   /**
    * 获取:关联序号
    */
   public Integer getGlxh() {
       return glxh;
   }
   /**
    * 设置:科室代码
    */
   public void setKsdm(Integer value) {
       this.ksdm = value;
   }
   /**
    * 获取:科室代码
    */
   public Integer getKsdm() {
       return ksdm;
   }
   /**
    * 设置:费用数量
    */
   public void setFysl(BigDecimal value) {
       this.fysl = value;
   }
   /**
    * 获取:费用数量
    */
   public BigDecimal getFysl() {
       return fysl;
   }
}
