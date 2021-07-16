package com.buit.his.sys.centermaintenance.model;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * 类名称：FeeXmfytj01<br> 
 * 类描述：
 * @author GONGFANGZHOU 
 * 
 */
@ApiModel(value="公用_费用调价")
public class FeeXmfytj01  extends  PageQuery{
	@ApiModelProperty(value="调价单号")
    /** tjdh */
    private Integer tjdh;
    @ApiModelProperty(value = "机构ID")
    /** jgid */
    private Integer jgid;
    @ApiModelProperty(value = "调价方式")
    /** tjfs */
    private Integer tjfs;
    @ApiModelProperty(value = "调价文号")
    /** tjwh */
    private String tjwh;
    @ApiModelProperty(value = "确认工号")
    /** zxgh */
    private String zxgh;
    @ApiModelProperty(value = "确认日期")
    /** zxrq */
    private Timestamp zxrq;
    @ApiModelProperty(value = "确认判别 | 0：未确认 1：已确认")
    /** zxpb */
    private Integer zxpb;
    @ApiModelProperty(value = "录入工号")
    /** rrgh */
    private String rrgh;
    @ApiModelProperty(value = "录入日期")
    /** rrrq */
    private Timestamp rrrq;
    @ApiModelProperty(value = "定时日期")
    /** dsrq */
    private Date dsrq;
    @ApiModelProperty(value = "生效/作废工号")
    /** sxgh */
    private String sxgh;
    @ApiModelProperty(value = "生效/作废日期")
    /** sxrq */
    private Timestamp sxrq;
    @ApiModelProperty(value = "生效判别 | 0：未生效 1：已生效 2：作废")
    /** sxpb */
    private Integer sxpb;

    /**
     * 设置:tjdh
     */
    public void setTjdh(Integer value) {
        this.tjdh = value;
    }

    /**
     * 获取:tjdh
     */
    public Integer getTjdh() {
        return tjdh;
    }

    /** 设置:jgid  */
    public void setJgid(Integer value) {
        this.jgid = value;
    }
    /** 获取:jgid */
    public Integer getJgid() {
        return jgid;
    }

    /** 设置:tjfs  */
    public void setTjfs(Integer value) {
        this.tjfs = value;
    }
    /** 获取:tjfs */
    public Integer getTjfs() {
        return tjfs;
    }

    /** 设置:tjwh  */
    public void setTjwh(String value) {
        this.tjwh = value;
    }
    /** 获取:tjwh */
    public String getTjwh() {
        return tjwh;
    }

    /** 设置:zxgh  */
    public void setZxgh(String value) {
        this.zxgh = value;
    }
    /** 获取:zxgh */
    public String getZxgh() {
        return zxgh;
    }

    /** 设置:zxrq  */
    public void setZxrq(Timestamp value) {
        this.zxrq = value;
    }
    /** 获取:zxrq */
    public Timestamp getZxrq() {
        return zxrq;
    }

    /** 设置:zxpb  */
    public void setZxpb(Integer value) {
        this.zxpb = value;
    }
    /** 获取:zxpb */
    public Integer getZxpb() {
        return zxpb;
    }

    /** 设置:rrgh  */
    public void setRrgh(String value) {
        this.rrgh = value;
    }
    /** 获取:rrgh */
    public String getRrgh() {
        return rrgh;
    }

    /** 设置:rrrq  */
    public void setRrrq(Timestamp value) {
        this.rrrq = value;
    }
    /** 获取:rrrq */
    public Timestamp getRrrq() {
        return rrrq;
    }

    /** 设置:dsrq  */
    public void setDsrq(Date value) {
        this.dsrq = value;
    }
    /** 获取:dsrq */
    public Date getDsrq() {
        return dsrq;
    }

    /** 设置:sxgh  */
    public void setSxgh(String value) {
        this.sxgh = value;
    }
    /** 获取:sxgh */
    public String getSxgh() {
        return sxgh;
    }

    /** 设置:sxrq  */
    public void setSxrq(Timestamp value) {
        this.sxrq = value;
    }
    /** 获取:sxrq */
    public Timestamp getSxrq() {
        return sxrq;
    }

    /** 设置:sxpb  */
    public void setSxpb(Integer value) {
        this.sxpb = value;
    }
    /** 获取:sxpb */
    public Integer getSxpb() {
        return sxpb;
    }


}
