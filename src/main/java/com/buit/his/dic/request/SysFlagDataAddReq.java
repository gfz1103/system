package com.buit.his.dic.request;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：SysFlagData<br>
 * 类描述：标识数据主记录<br>
 * @author All
 */
@ApiModel(value="标识数据主记录")
public class SysFlagDataAddReq {
    @NotNull(message = "医疗机构ID不能为空")
    @ApiModelProperty(value="医疗机构ID")
    private Integer hospitalId;

    @NotNull(message = "标识代码不能为空")
    @ApiModelProperty(value="标识代码")
    private String flagdataCode;

    @NotNull(message = "标识名称不能为空")
    @ApiModelProperty(value="标识称")
    private String flagdataName;

    @NotNull(message = "标准依据标识不能为空")
    @ApiModelProperty(value="数标准依据标识")
    private String identificationFlag;

    @NotNull(message = "归类树节点ID不能为空")
    @ApiModelProperty(value="归类树节点ID")
    private Integer nodeId;

    /**
     * 设置:医疗机构ID
     */
    public void setHospitalId(Integer value) {
        this.hospitalId = value;
    }
    /**
     * 获取:医疗机构ID
     */
    public Integer getHospitalId() {
        return hospitalId;
    }
    /**
     * 设置:标识数据代码
     */
    public void setFlagdataCode(String value) {
        this.flagdataCode = value;
    }
    /**
     * 获取:标识数据代码
     */
    public String getFlagdataCode() {
        return flagdataCode;
    }
    /**
     * 设置:标识数据名称
     */
    public void setFlagdataName(String value) {
        this.flagdataName = value;
    }
    /**
     * 获取:标识数据名称
     */
    public String getFlagdataName() {
        return flagdataName;
    }

    /**
     * 设置:数据标准依据标识
     */
    public void setIdentificationFlag(String value) {
        this.identificationFlag = value;
    }
    /**
     * 获取:数据标准依据标识
     */
    public String getIdentificationFlag() {
        return identificationFlag;
    }
    /**
     * 设置:归类树节点的ID
     */
    public void setNodeId(Integer value) {
        this.nodeId = value;
    }
    /**
     * 获取:归类树节点的ID
     */
    public Integer getNodeId() {
        return nodeId;
    }
}