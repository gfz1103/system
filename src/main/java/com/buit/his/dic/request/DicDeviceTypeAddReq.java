package com.buit.his.dic.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @Auther jiangwei
 * @CreateDate 2021.3.12
 * @Table dic_device_type
 */
@ApiModel(value = "设备类型新增入参封装")
public class DicDeviceTypeAddReq {
    @NotNull
    @ApiModelProperty(value = "设备名称")
    private String typeName;
    @NotNull
    @ApiModelProperty(value = "设备型号")
    private String model;
    @ApiModelProperty(value = "厂商名称")
    private String manufacturerName;
    @ApiModelProperty(value = "厂商电话")
    private String manufacturerTel;
    @ApiModelProperty(value = "厂商地址")
    private String manufacturerAddress;
    @ApiModelProperty(value = "默认驱动安装地址")
    private String driverLocation;
    @ApiModelProperty(value = "默认HTTP端口")
    private String httpPort;
    @ApiModelProperty(value = "默认HTTPS端口")
    private String httpsPort;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getManufacturerTel() {
        return manufacturerTel;
    }

    public void setManufacturerTel(String manufacturerTel) {
        this.manufacturerTel = manufacturerTel;
    }

    public String getManufacturerAddress() {
        return manufacturerAddress;
    }

    public void setManufacturerAddress(String manufacturerAddress) {
        this.manufacturerAddress = manufacturerAddress;
    }

    public String getDriverLocation() {
        return driverLocation;
    }

    public void setDriverLocation(String driverLocation) {
        this.driverLocation = driverLocation;
    }

    public String getHttpPort() {
        return httpPort;
    }

    public void setHttpPort(String httpPort) {
        this.httpPort = httpPort;
    }

    public String getHttpsPort() {
        return httpsPort;
    }

    public void setHttpsPort(String httpsPort) {
        this.httpsPort = httpsPort;
    }
}
