package com.buit.his.dic.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @Auther jiangwei
 * @CreateDate 2021.3.12
 * @Table dic_device
 */
@ApiModel(value = "设备终端")
public class DicDeviceAddReq {
    @NotNull
    @ApiModelProperty(value = "设备序列号")
    private String serialNumber;
    @NotNull
    @ApiModelProperty(value = "设备类型 | 关联dic_device_type.type_id")
    private Integer typeId;
    @ApiModelProperty(value = "医疗机构代码", hidden = true)
    private Integer jgid;
    @NotNull
    @ApiModelProperty(value = "ip地址")
    private String ip;
    @NotNull
    @ApiModelProperty(value = "调用方式 | 1：厂家提供可安装的本地服务 2：发布java程序调用动态库")
    private Integer invokingWay;
    @NotNull
    @ApiModelProperty(value = "驱动地址 | 本地服务或tomcat启动exe/bat文件所在目录的绝对路径(包含文件名)")
    private String diverLocation;
    @ApiModelProperty(value = "依赖地址 | 动态库dll文件所在目录的绝对路径(包含文件名)")
    private String dllLocation;
    @ApiModelProperty(value = "HTTP端口")
    private String httpPort;
    @ApiModelProperty(value = "HTTPS端口")
    private String httpsPort;
    @ApiModelProperty(value = "设备状态 | 0：启用， 1：停用", hidden = true)
    private Integer status;

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getInvokingWay() {
        return invokingWay;
    }

    public void setInvokingWay(Integer invokingWay) {
        this.invokingWay = invokingWay;
    }

    public String getDiverLocation() {
        return diverLocation;
    }

    public void setDiverLocation(String diverLocation) {
        this.diverLocation = diverLocation;
    }

    public String getDllLocation() {
        return dllLocation;
    }

    public void setDllLocation(String dllLocation) {
        this.dllLocation = dllLocation;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
