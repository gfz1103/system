package com.buit.his.dic.model;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Auther jiangwei
 * @CreateDate 2021.3.11
 * @Table dic_device_interface
 */
@ApiModel(value = "设备调用接口")
public class DicDeviceInterface extends PageQuery {
    @ApiModelProperty(value = "接口标识")
    private Integer interfaceId;
    @ApiModelProperty(value = "接口名称")
    private String interfaceName;
    @ApiModelProperty(value = "设备类型 | 关联dic_device_type.type_id")
    private Integer typeId;
    @ApiModelProperty(value = "接口调用地址")
    private String url;
    @ApiModelProperty(value = "功能描述")
    private String description;
    @ApiModelProperty(value = "接口返回示例")
    private String resultExample;

    public Integer getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(Integer interfaceId) {
        this.interfaceId = interfaceId;
    }

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
