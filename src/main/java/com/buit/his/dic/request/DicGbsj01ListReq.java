package com.buit.his.dic.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：DicGbsj01<br>
 * 类描述：标准数据主记录<br>
 * @author 老花生
 */
@ApiModel(value="标准数据集合请求")
public class DicGbsj01ListReq{

    @ApiModelProperty(value="标准数据ID")
    private Integer primarydataId;
    @ApiModelProperty(value="查询信息")
    private String searchValue;
    @ApiModelProperty(value="停用标识 1 停用 0启用",hidden = true)
    private String stopFlag;
	@ApiModelProperty(value="医疗机构ID", hidden = true)
    private Integer hospitalId;

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public Integer getPrimarydataId() {
        return primarydataId;
    }

    public void setPrimarydataId(Integer primarydataId) {
        this.primarydataId = primarydataId;
    }

    public String getStopFlag() {
        return stopFlag;
    }

    public void setStopFlag(String stopFlag) {
        this.stopFlag = stopFlag;
    }

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
    
}
