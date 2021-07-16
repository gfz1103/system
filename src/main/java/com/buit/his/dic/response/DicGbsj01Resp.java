
package com.buit.his.dic.response;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：DicGbsj01<br>
 * 类描述：标准数据主记录<br>
 * @author 老花生
 */
@ApiModel(value="标准数据主记录")
public class DicGbsj01Resp  extends PageQuery {
    @ApiModelProperty(value="标准数据ID")
    private Integer primarydataId;
    @ApiModelProperty(value="标准数据代码")
    private String primaryDataCode;
    @ApiModelProperty(value="标准数据名称")
    private String primaryDataName;
    @ApiModelProperty(value="值域代码")
    private String rangeCode;

    /**
     * 设置:标准数据ID
     */
    public void setPrimarydataId(Integer value) {
        this.primarydataId = value;
    }
    /**
     * 获取:标准数据ID
     */
    public Integer getPrimarydataId() {
        return primarydataId;
    }
    /**
     * 设置:标准数据代码
     */
    public void setPrimaryDataCode(String value) {
        this.primaryDataCode = value;
    }
    /**
     * 获取:标准数据代码
     */
    public String getPrimaryDataCode() {
        return primaryDataCode;
    }
    /**
     * 设置:标准数据名称
     */
    public void setPrimaryDataName(String value) {
        this.primaryDataName = value;
    }
    /**
     * 获取:标准数据名称
     */
    public String getPrimaryDataName() {
        return primaryDataName;
    }

    public String getRangeCode() {
        return rangeCode;
    }

    public void setRangeCode(String rangeCode) {
        this.rangeCode = rangeCode;
    }
}
