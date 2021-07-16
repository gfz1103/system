
package com.buit.his.sys.centermaintenance.request;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：DicZyjb<br>
 *
 * @author 老花生
 */
@ApiModel(value = "中医疾病编码")
public class DicZyjbEditReq {
    @NotNull(message = "疾病标识不能为空")
    @ApiModelProperty(value = "疾病标识")
    private Integer jbbs;
    @ApiModelProperty(value = "中医分类")
    private Integer zyfl;
    @ApiModelProperty(value = "疾病代码")
    private String jbdm;
    @ApiModelProperty(value = "疾病名称")
    private String jbmc;
    @ApiModelProperty(value = "拼音码")
    private String pydm;
    @ApiModelProperty(value = "五笔码")
    private String wbdm;
    @ApiModelProperty(value = "其它码")
    private String qtdm;
    @ApiModelProperty(value = "性别限制")
    private Integer xbxz;
    @ApiModelProperty(value = "允许治愈")
    private Integer yxzy;
    @ApiModelProperty(value = "允许好转")
    private Integer yxhz;
    @ApiModelProperty(value = "允许未愈")
    private Integer yxwy;
    @ApiModelProperty(value = "允许死亡")
    private Integer yxsw;
    @ApiModelProperty(value = "允许其它")
    private Integer yxqt;
    @ApiModelProperty(value = "控制方式")
    private Integer kzfs;
    @ApiModelProperty(value = "注销标志")
    private Integer zxbz;
    @ApiModelProperty(value = "备注信息")
    private String bzxx;

    public Integer getJbbs() {
        return jbbs;
    }

    public void setJbbs(Integer jbbs) {
        this.jbbs = jbbs;
    }

    public Integer getZyfl() {
        return zyfl;
    }

    public void setZyfl(Integer zyfl) {
        this.zyfl = zyfl;
    }

    public String getJbdm() {
        return jbdm;
    }

    public void setJbdm(String jbdm) {
        this.jbdm = jbdm;
    }

    public String getJbmc() {
        return jbmc;
    }

    public void setJbmc(String jbmc) {
        this.jbmc = jbmc;
    }

    public String getPydm() {
        return pydm;
    }

    public void setPydm(String pydm) {
        this.pydm = pydm;
    }

    public String getWbdm() {
        return wbdm;
    }

    public void setWbdm(String wbdm) {
        this.wbdm = wbdm;
    }

    public String getQtdm() {
        return qtdm;
    }

    public void setQtdm(String qtdm) {
        this.qtdm = qtdm;
    }

    public Integer getXbxz() {
        return xbxz;
    }

    public void setXbxz(Integer xbxz) {
        this.xbxz = xbxz;
    }

    public Integer getYxzy() {
        return yxzy;
    }

    public void setYxzy(Integer yxzy) {
        this.yxzy = yxzy;
    }

    public Integer getYxhz() {
        return yxhz;
    }

    public void setYxhz(Integer yxhz) {
        this.yxhz = yxhz;
    }

    public Integer getYxwy() {
        return yxwy;
    }

    public void setYxwy(Integer yxwy) {
        this.yxwy = yxwy;
    }

    public Integer getYxsw() {
        return yxsw;
    }

    public void setYxsw(Integer yxsw) {
        this.yxsw = yxsw;
    }

    public Integer getYxqt() {
        return yxqt;
    }

    public void setYxqt(Integer yxqt) {
        this.yxqt = yxqt;
    }

    public Integer getKzfs() {
        return kzfs;
    }

    public void setKzfs(Integer kzfs) {
        this.kzfs = kzfs;
    }

    public Integer getZxbz() {
        return zxbz;
    }

    public void setZxbz(Integer zxbz) {
        this.zxbz = zxbz;
    }

    public String getBzxx() {
        return bzxx;
    }

    public void setBzxx(String bzxx) {
        this.bzxx = bzxx;
    }
}
