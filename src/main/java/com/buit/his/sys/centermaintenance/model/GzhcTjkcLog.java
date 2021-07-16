package com.buit.his.sys.centermaintenance.model;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author jiangwei
 * @Description 高值耗材调价库存日志表
 * @Date 2021-07-08
 */
@ApiModel(value = "高值耗材调价库存日志表")
public class GzhcTjkcLog extends PageQuery {
    @ApiModelProperty(value = "记录序号")
    private Integer jlxh;
    @ApiModelProperty(value = "机构id")
    private Integer jgid;
    @ApiModelProperty(value = "调价单号 | 关联 fee_xmfytj01.TJDH")
    private Integer tjdh;
    @ApiModelProperty(value = "识别序号 | 关联 fee_xmfytj02.SBXH")
    private Integer sbxh;
    @ApiModelProperty(value = "费用序号 | 关联 fee_ylsfxm.FYXH")
    private Integer fyxh;
    @ApiModelProperty(value = "病区ID | 关联 dic_kszd.ID")
    private String ksdm;
    @ApiModelProperty(value = "规格")
    private String gg;
    @ApiModelProperty(value = "型号")
    private String xx;
    @ApiModelProperty(value = "单位")
    private String dw;
    @ApiModelProperty(value = "医保编码")
    private String ybbm;
    @ApiModelProperty(value = "生产厂家")
    private String sccj;
    @ApiModelProperty(value = "进货价格")
    private BigDecimal jhjg;
    @ApiModelProperty(value = "库存数量")
    private BigDecimal kcsl;
    @ApiModelProperty(value = "生效日期")
    private Timestamp sxrq;

    public Integer getJlxh() {
        return jlxh;
    }

    public void setJlxh(Integer jlxh) {
        this.jlxh = jlxh;
    }

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }

    public Integer getTjdh() {
        return tjdh;
    }

    public void setTjdh(Integer tjdh) {
        this.tjdh = tjdh;
    }

    public Integer getSbxh() {
        return sbxh;
    }

    public void setSbxh(Integer sbxh) {
        this.sbxh = sbxh;
    }

    public Integer getFyxh() {
        return fyxh;
    }

    public void setFyxh(Integer fyxh) {
        this.fyxh = fyxh;
    }

    public String getKsdm() {
        return ksdm;
    }

    public void setKsdm(String ksdm) {
        this.ksdm = ksdm;
    }

    public String getGg() {
        return gg;
    }

    public void setGg(String gg) {
        this.gg = gg;
    }

    public String getXx() {
        return xx;
    }

    public void setXx(String xx) {
        this.xx = xx;
    }

    public String getDw() {
        return dw;
    }

    public void setDw(String dw) {
        this.dw = dw;
    }

    public String getYbbm() {
        return ybbm;
    }

    public void setYbbm(String ybbm) {
        this.ybbm = ybbm;
    }

    public String getSccj() {
        return sccj;
    }

    public void setSccj(String sccj) {
        this.sccj = sccj;
    }

    public BigDecimal getJhjg() {
        return jhjg;
    }

    public void setJhjg(BigDecimal jhjg) {
        this.jhjg = jhjg;
    }

    public BigDecimal getKcsl() {
        return kcsl;
    }

    public void setKcsl(BigDecimal kcsl) {
        this.kcsl = kcsl;
    }

    public Timestamp getSxrq() {
        return sxrq;
    }

    public void setSxrq(Timestamp sxrq) {
        this.sxrq = sxrq;
    }
}