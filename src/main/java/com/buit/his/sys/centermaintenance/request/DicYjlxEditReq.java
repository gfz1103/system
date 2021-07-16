package com.buit.his.sys.centermaintenance.request;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：DicYjlx<br>
 * 类描述：医技类型维护<br>
 *
 * @author liushijie
 */
@ApiModel(value = "医技类型维护-编辑")
public class DicYjlxEditReq {
    @NotNull(message = "ID不能为空")
    @ApiModelProperty(value = "ID",required = true)
    private Integer id;
    @ApiModelProperty(value = "医技类型名称")
    private String name;
    @ApiModelProperty(value = "父ID")
    private Integer pid;
    @ApiModelProperty(value = "排序")
    private Integer sort;
    @ApiModelProperty(value = "注销标志(0=正常，1=注销)")
    private String zxbz;
    @ApiModelProperty(value = "检查类型")
    private String jclx;

    /**
     * 设置:ID
     */
    public void setId(Integer value) {
        this.id = value;
    }

    /**
     * 获取:ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置:医技类型名称
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * 获取:医技类型名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置:父ID
     */
    public void setPid(Integer value) {
        this.pid = value;
    }

    /**
     * 获取:父ID
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * 设置:排序
     */
    public void setSort(Integer value) {
        this.sort = value;
    }

    /**
     * 获取:排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置:注销标志(0=正常，1=注销)
     */
    public void setZxbz(String value) {
        this.zxbz = value;
    }

    /**
     * 获取:注销标志(0=正常，1=注销)
     */
    public String getZxbz() {
        return zxbz;
    }

    /**
     * 设置:检查类型
     */
    public void setJclx(String value) {
        this.jclx = value;
    }

    /**
     * 获取:检查类型
     */
    public String getJclx() {
        return jclx;
    }
}
