   
package com.buit.his.sys.centermaintenance.request;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：OpSssd<br> 
 * 类描述：所属时段<br>
 * @author GONGFANGZHOU
 */
@ApiModel(value="所属时段")
public class OpSssdReq {
    @ApiModelProperty(value="所属时段ID")
    private Integer sssdid;
    @ApiModelProperty(value="时段值")
    private String value;
    @ApiModelProperty(value="sfxs")
    private Integer sfxs;
    /**
     * 设置:所属时段ID
     */
    public void setSssdid(Integer value) {
        this.sssdid = value;
    }
    /**
     * 获取:所属时段ID
     */
    public Integer getSssdid() {
        return sssdid;
    }
    /**
     * 设置:时段值
     */
    public void setValue(String value) {
        this.value = value;
    }
    /**
     * 获取:时段值
     */
    public String getValue() {
        return value;
    }
    /**
     * 设置:sfxs
     */
    public void setSfxs(Integer value) {
        this.sfxs = value;
    }
    /**
     * 获取:sfxs
     */
    public Integer getSfxs() {
        return sfxs;
    }
}
