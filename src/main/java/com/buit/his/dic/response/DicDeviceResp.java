package com.buit.his.dic.response;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Auther jiangwei
 * @CreateDate 2021.3.11
 */
@ApiModel(value = "设备终端业务展示类")
public class DicDeviceResp extends PageQuery {
    @ApiModelProperty(value = "设备主键")
    private Integer deviceId;
    @ApiModelProperty(value = "设备序列号")
    private String serialNumber;
    @ApiModelProperty(value = "设备类型ID")
    private Integer typeId;
    @ApiModelProperty(value = "设备名称")
    private String typeName;
    @ApiModelProperty(value = "设备型号")
    private String model;
    @ApiModelProperty(value = "厂商名称")
    private String manufacturerName;
    @ApiModelProperty(value = "医疗机构代码")
    private Integer jgid;
    @ApiModelProperty(value = "ip地址")
    private String ip;
    @ApiModelProperty(value = "调用方式 | 1：厂家提供可安装的本地服务 2：发布java程序调用动态库")
    private Integer invokingWay;
    @ApiModelProperty(value = "驱动地址 | 本地服务或tomcat启动exe/bat文件所在目录的绝对路径(包含文件名)")
    private String diverLocation;
    @ApiModelProperty(value = "依赖地址 | 动态库dll文件所在目录的绝对路径(包含文件名)")
    private String dllLocation;
    @ApiModelProperty(value = "HTTP端口")
    private String httpPort;
    @ApiModelProperty(value = "HTTPS端口")
    private String httpsPort;
    @ApiModelProperty(value = "设备状态 | 0：启用， 1：停用")
    private Integer status;

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

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
