
package com.buit.his.sys.centermaintenance.request;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：DicSypc<br>
 * 类描述：给药频次维护-新增<br>
 *
 * @author GONGFANGZHOU
 */
@ApiModel(value = "给药频次维护-新增")
public class DicSypcAddReq {
    @NotNull(message = "频次名称不能为空")
    @ApiModelProperty(value = "频次名称", required = true)
    private String pcmc;
    @NotNull(message = "每日次数不能为空")
    @ApiModelProperty(value = "每日次数", required = true)
    private Integer mrcs;
    @NotNull(message = "最小周期不能为空")
    @ApiModelProperty(value = "最小周期", required = true)
    private Integer zxzq;
    @NotNull(message = "日历周标志不能为空")
    @ApiModelProperty(value = "日历周标志", required = true)
    private Integer rlz;
    @NotNull(message = "执行时间不能为空")
    @ApiModelProperty(value = "执行时间", required = true)
    private String zxsj;
    @NotNull(message = "日执行周期不能为空")
    @ApiModelProperty(value = "日执行周期", required = true)
    private String rzxzq;
    @ApiModelProperty(value = "备注信息")
    private String bzxx;


    /**
     * 设置:频次名称
     */
    public void setPcmc(String value) {
        this.pcmc = value;
    }

    /**
     * 获取:频次名称
     */
    public String getPcmc() {
        return pcmc;
    }

    /**
     * 设置:每日次数
     */
    public void setMrcs(Integer value) {
        this.mrcs = value;
    }

    /**
     * 获取:每日次数
     */
    public Integer getMrcs() {
        return mrcs;
    }

    /**
     * 设置:最小周期
     */
    public void setZxzq(Integer value) {
        this.zxzq = value;
    }

    /**
     * 获取:最小周期
     */
    public Integer getZxzq() {
        return zxzq;
    }

    /**
     * 设置:日历周标志
     */
    public void setRlz(Integer value) {
        this.rlz = value;
    }

    /**
     * 获取:日历周标志
     */
    public Integer getRlz() {
        return rlz;
    }

    /**
     * 设置:执行时间
     */
    public void setZxsj(String value) {
        this.zxsj = value;
    }

    /**
     * 获取:执行时间
     */
    public String getZxsj() {
        return zxsj;
    }

    /**
     * 设置:日执行周期
     */
    public void setRzxzq(String value) {
        this.rzxzq = value;
    }

    /**
     * 获取:日执行周期
     */
    public String getRzxzq() {
        return rzxzq;
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

}
