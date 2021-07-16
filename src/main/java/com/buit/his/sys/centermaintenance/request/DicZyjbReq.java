
package com.buit.his.sys.centermaintenance.request;

import java.util.List;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：DicZyjb<br>
 * 类描述：<br>
 * @author 老花生
 */
@ApiModel(value="中医疾病")
public class DicZyjbReq  extends PageQuery {
	private static final long serialVersionUID = -35717591076966322L;
	@ApiModelProperty(value="疾病标识", hidden = true)
    private Integer jbbs;
    @ApiModelProperty(value="中医分类", hidden = true)
    private Integer zyfl;
    @ApiModelProperty(value="疾病代码", hidden = true)
    private String jbdm;
    @ApiModelProperty(value="疾病名称", hidden = true)
    private String jbmc;
    @ApiModelProperty(value="拼音码")
    private String pydm;
    @ApiModelProperty(value="排除 zdxh 集合")
    private List<Integer> notIn;
    @ApiModelProperty(value="五笔码", hidden = true)
    private String wbdm;
    @ApiModelProperty(value="其它码", hidden = true)
    private String qtdm;
    @ApiModelProperty(value="性别限制", hidden = true)
    private Integer xbxz;
    @ApiModelProperty(value="允许治愈", hidden = true)
    private Integer yxzy;
    @ApiModelProperty(value="允许好转", hidden = true)
    private Integer yxhz;
    @ApiModelProperty(value="允许未愈", hidden = true)
    private Integer yxwy;
    @ApiModelProperty(value="允许死亡", hidden = true)
    private Integer yxsw;
    @ApiModelProperty(value="允许其它", hidden = true)
    private Integer yxqt;
    @ApiModelProperty(value="控制方式", hidden = true)
    private Integer kzfs;
    @ApiModelProperty(value="注销标志", hidden = true)
    private Integer zxbz;
    @ApiModelProperty(value="备注信息", hidden = true)
    private String bzxx;
    /**
     * 设置:jbbs
     */
    public void setJbbs(Integer value) {
        this.jbbs = value;
    }
    /**
     * 获取:jbbs
     */
    public Integer getJbbs() {
        return jbbs;
    }
    /**
     * 设置:zyfl
     */
    public void setZyfl(Integer value) {
        this.zyfl = value;
    }
    /**
     * 获取:zyfl
     */
    public Integer getZyfl() {
        return zyfl;
    }
    /**
     * 设置:jbdm
     */
    public void setJbdm(String value) {
        this.jbdm = value;
    }
    /**
     * 获取:jbdm
     */
    public String getJbdm() {
        return jbdm;
    }
    /**
     * 设置:jbmc
     */
    public void setJbmc(String value) {
        this.jbmc = value;
    }
    /**
     * 获取:jbmc
     */
    public String getJbmc() {
        return jbmc;
    }
    /**
     * 设置:pydm
     */
    public void setPydm(String value) {
        this.pydm = value;
    }
    /**
     * 获取:pydm
     */
    public String getPydm() {
        return pydm;
    }
    /**
     * 设置:wbdm
     */
    public void setWbdm(String value) {
        this.wbdm = value;
    }
    /**
     * 获取:wbdm
     */
    public String getWbdm() {
        return wbdm;
    }
    /**
     * 设置:qtdm
     */
    public void setQtdm(String value) {
        this.qtdm = value;
    }
    /**
     * 获取:qtdm
     */
    public String getQtdm() {
        return qtdm;
    }
    /**
     * 设置:xbxz
     */
    public void setXbxz(Integer value) {
        this.xbxz = value;
    }
    /**
     * 获取:xbxz
     */
    public Integer getXbxz() {
        return xbxz;
    }
    /**
     * 设置:yxzy
     */
    public void setYxzy(Integer value) {
        this.yxzy = value;
    }
    /**
     * 获取:yxzy
     */
    public Integer getYxzy() {
        return yxzy;
    }
    /**
     * 设置:yxhz
     */
    public void setYxhz(Integer value) {
        this.yxhz = value;
    }
    /**
     * 获取:yxhz
     */
    public Integer getYxhz() {
        return yxhz;
    }
    /**
     * 设置:yxwy
     */
    public void setYxwy(Integer value) {
        this.yxwy = value;
    }
    /**
     * 获取:yxwy
     */
    public Integer getYxwy() {
        return yxwy;
    }
    /**
     * 设置:yxsw
     */
    public void setYxsw(Integer value) {
        this.yxsw = value;
    }
    /**
     * 获取:yxsw
     */
    public Integer getYxsw() {
        return yxsw;
    }
    /**
     * 设置:yxqt
     */
    public void setYxqt(Integer value) {
        this.yxqt = value;
    }
    /**
     * 获取:yxqt
     */
    public Integer getYxqt() {
        return yxqt;
    }
    /**
     * 设置:kzfs
     */
    public void setKzfs(Integer value) {
        this.kzfs = value;
    }
    /**
     * 获取:kzfs
     */
    public Integer getKzfs() {
        return kzfs;
    }
    /**
     * 设置:zxbz
     */
    public void setZxbz(Integer value) {
        this.zxbz = value;
    }
    /**
     * 获取:zxbz
     */
    public Integer getZxbz() {
        return zxbz;
    }
    /**
     * 设置:bzxx
     */
    public void setBzxx(String value) {
        this.bzxx = value;
    }
    /**
     * 获取:bzxx
     */
    public String getBzxx() {
        return bzxx;
    }

    public List<Integer> getNotIn() {
        return notIn;
    }

    public void setNotIn(List<Integer> notIn) {
        this.notIn = notIn;
    }
}
