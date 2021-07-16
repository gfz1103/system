package com.buit.his.dic.request;

import javax.validation.constraints.NotNull;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：DicGbsj01<br>
 * 类描述：标准数据主记录<br>
 * @author 老花生
 */
@ApiModel(value="标准疾病诊断分页请求")
public class DicGbsj01PageReq extends PageQuery {

    @NotNull(message = "主表ID 不能为空")
    @ApiModelProperty(value="主表ID")
    private Integer primarydataId;
    @ApiModelProperty(value="查询信息")
    private String searchValue;
	@ApiModelProperty(value="医疗机构ID", hidden = true)
    private Integer hospitalId;

    public Integer getPrimarydataId() {
        return primarydataId;
    }

    public void setPrimarydataId(Integer primarydataId) {
        this.primarydataId = primarydataId;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
}
