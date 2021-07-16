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
@ApiModel(value = "医技类型维护-新增")
public class DicYjlxAddReq {
    @NotNull(message = "医技类型名称不能为空")
    @ApiModelProperty(value = "医技类型名称", required = true)
    private String name;
    @NotNull(message = "父ID不能为空")
    @ApiModelProperty(value = "父ID", required = true)
    private Integer pid;
    @NotNull(message = "排序不能为空")
    @ApiModelProperty(value = "排序", required = true)
    private Integer sort;
    @NotNull(message = "检查类型不能为空")
    @ApiModelProperty(value = "检查类型", required = true)
    private String jclx;


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
