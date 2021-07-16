package com.buit.his.dic.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Auther jiangwei
 * @CreateDate 2021.3.11
 */
@ApiModel(value = "设备终端查询条件封装")
public class DicDeviceQueryReq extends PageQuery {
    @ApiModelProperty(value = "设备类型ID | 关联dic_device_type.type_id")
    private Integer typeId;
    @ApiModelProperty(value = "厂商名称")
    private String manufacturerName;
    @ApiModelProperty(value = "医疗机构代码", hidden = true)
    private Integer jgid;
    @ApiModelProperty(value = "设备状态 | 0：启用， 1：停用")
    private Integer status;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
