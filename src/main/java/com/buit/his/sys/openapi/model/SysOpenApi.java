package com.buit.his.sys.openapi.model;

import java.sql.Timestamp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：SysOpenApi<br>
 * 类描述：open api信息
 *
 * @author sunjx
 */
@ApiModel(value = "open api信息")
public class SysOpenApi {

    @ApiModelProperty(value = "accessKey")
    private Long accessKey;
    @ApiModelProperty(value = "MD5(access_key + access_secret)")
    private String accessSecretMd5;
    @ApiModelProperty(value = "ctime")
    private Timestamp ctime;
    @ApiModelProperty(value = "说明")
    private String desc;
    @ApiModelProperty(value = "id")
    private Integer id;
    @ApiModelProperty(value = "权限列表, 多个逗号分隔")
    private String roles;
    @ApiModelProperty(value = "1启用 0禁用")
    private Integer zt;

    public Long getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(Long value) {
        this.accessKey = value;
    }

    public String getAccessSecretMd5() {
        return accessSecretMd5;
    }

    public void setAccessSecretMd5(String value) {
        this.accessSecretMd5 = value;
    }

    public Timestamp getCtime() {
        return ctime;
    }

    public void setCtime(Timestamp value) {
        this.ctime = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String value) {
        this.desc = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer value) {
        this.id = value;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String value) {
        this.roles = value;
    }

    public Integer getZt() {
        return zt;
    }

    public void setZt(Integer value) {
        this.zt = value;
    }


}