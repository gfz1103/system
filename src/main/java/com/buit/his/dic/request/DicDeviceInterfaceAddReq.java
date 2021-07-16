package com.buit.his.dic.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @Auther jiangwei
 * @CreateDate 2021.3.12
 * @Table dic_device_interface
 */
@ApiModel(value = "设备调用接口")
public class DicDeviceInterfaceAddReq {
    @NotNull
    @ApiModelProperty(value = "接口名称")
    private String interfaceName;
    @NotNull
    @ApiModelProperty(value = "设备类型 | 关联dic_device_type.type_id")
    private Integer typeId;
    @NotNull
    @ApiModelProperty(value = "接口调用地址")
    private String url;
    @NotNull
    @ApiModelProperty(value = "功能描述")
    private String description;
    @ApiModelProperty(value = "接口返回示例")
    private String resultExample;

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResultExample() {
        return resultExample;
    }

    public void setResultExample(String resultExample) {
        this.resultExample = resultExample;
    }
}
