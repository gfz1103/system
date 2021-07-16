package com.buit.his.dic.request;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：DicGbsj01<br> 
 * 类描述：标准数据主记录<br>
 * @author 老花生
 */
@ApiModel(value="医院字典主表-新增")
public class DicGbsj01AddReq {
    @NotBlank(message = "名称 不能为空")
    @ApiModelProperty(value="代码")
    private String primaryDataCode;
    @NotBlank(message = "名称 不能为空")
    @ApiModelProperty(value="名称")
    private String primaryDataName;

    public String getPrimaryDataCode() {
        return primaryDataCode;
    }

    public void setPrimaryDataCode(String primaryDataCode) {
        this.primaryDataCode = primaryDataCode;
    }

    public String getPrimaryDataName() {
        return primaryDataName;
    }

    public void setPrimaryDataName(String primaryDataName) {
        this.primaryDataName = primaryDataName;
    }
}
