
package com.buit.his.dic.request;

import javax.validation.constraints.NotNull;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：DicGbsj02<br>
 * 类描述：标准数据值域记录<br>
 * @author 老花生
 */
@ApiModel(value="标准数据值域记录")
public class DicGbsj02Req  extends  PageQuery{
    @NotNull(message = "版本数据ID不能为空")
    @ApiModelProperty(value="版本数据ID")
    private Integer dataversionId;
	@ApiModelProperty(value="医疗机构ID", hidden = true)
    private Integer hospitalId;
    /**
     * 设置:版本数据ID
     */
    public void setDataversionId(Integer value) {
        this.dataversionId = value;
    }
    /**
     * 获取:版本数据ID
     */
    public Integer getDataversionId() {
        return dataversionId;
    }
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
}
