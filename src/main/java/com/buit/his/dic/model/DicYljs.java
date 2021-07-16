package com.buit.his.dic.model;

import com.buit.commons.PageQuery;

/**
 * 类名称：DicYljs<br>
 * 类描述：
 *
 * @author N47FN489F
 * @ApiModel(value="")
 */
public class DicYljs extends PageQuery {
    //@ApiModelProperty(value="角色序号")
    /**
     * 角色序号
     */
    private Integer jsxh;
    //@ApiModelProperty(value="角色名称")
    /**
     * 角色名称
     */
    private String jsmc;
    //@ApiModelProperty(value="角色类型：(0公用 1医生 2护士 9其它)")
    /**
     * 角色类型：(0公用 1医生 2护士 9其它)
     */
    private Integer jslx;
    //@ApiModelProperty(value="医疗角色说明")
    /**
     * 医疗角色说明
     */
    private String jssm;
    //@ApiModelProperty(value="用来区分角色的上下级关系")
    /**
     * 用来区分角色的上下级关系
     */
    private Integer jsjb;

    /**
     * 设置:角色序号
     */
    public void setJsxh(Integer value) {
        this.jsxh = value;
    }

    /**
     * 获取:角色序号
     */
    public Integer getJsxh() {
        return jsxh;
    }

    /**
     * 设置:角色名称
     */
    public void setJsmc(String value) {
        this.jsmc = value;
    }

    /**
     * 获取:角色名称
     */
    public String getJsmc() {
        return jsmc;
    }

    /**
     * 设置:角色类型：(0公用 1医生 2护士 9其它)
     */
    public void setJslx(Integer value) {
        this.jslx = value;
    }

    /**
     * 获取:角色类型：(0公用 1医生 2护士 9其它)
     */
    public Integer getJslx() {
        return jslx;
    }

    /**
     * 设置:医疗角色说明
     */
    public void setJssm(String value) {
        this.jssm = value;
    }

    /**
     * 获取:医疗角色说明
     */
    public String getJssm() {
        return jssm;
    }

    /**
     * 设置:用来区分角色的上下级关系
     */
    public void setJsjb(Integer value) {
        this.jsjb = value;
    }

    /**
     * 获取:用来区分角色的上下级关系
     */
    public Integer getJsjb() {
        return jsjb;
    }


}