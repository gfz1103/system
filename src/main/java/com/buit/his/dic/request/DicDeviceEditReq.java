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
public class DicDeviceEditReq {
    @NotNull
    @ApiModelProperty(value = "设备主键")
    private Integer deviceId;
    @ApiModelProperty(value = "ip地址")
    private String ip;
    @ApiModelProperty(value = "驱动地址 | 本地服务或tomcat启动exe/bat文件所在目录的绝对路径(包含文件名)")
    private String diverLocation;
    @ApiModelProperty(value = "依赖地址 | 动态库dll文件所在目录的绝对路径(包含文件名)")
    private String dllLocation;
    @ApiModelProperty(value = "HTTP端口")
    private String httpPort;
    @ApiModelProperty(value = "HTTPS端口")
    private String httpsPort;

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
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

}
