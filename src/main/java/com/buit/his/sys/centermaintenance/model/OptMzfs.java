package com.buit.his.sys.centermaintenance.model;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：OptMzfs<br> 
 * 类描述：
 * @author GONGFANGZHOU 
 * @ApiModel(value="")
 */
public class OptMzfs  extends  PageQuery{
	@ApiModelProperty(value="主键")
    /** mzid */
    private Integer mzid;
	@ApiModelProperty(value="麻醉代码")
    /** mzdm */
    private Integer mzdm;
	@ApiModelProperty(value="麻醉名称")
    /** mzmc */
    private String mzmc;
	@ApiModelProperty(value="拼音代码")
    /** pydm */
    private String pydm;

    /** 设置:mzid  */
    public void setMzid(Integer value) {
        this.mzid = value;
    }
    /** 获取:mzid */
    public Integer getMzid() {
        return mzid;
    }

    /** 设置:mzdm  */
    public void setMzdm(Integer value) {
        this.mzdm = value;
    }
    /** 获取:mzdm */
    public Integer getMzdm() {
        return mzdm;
    }

    /** 设置:mzmc  */
    public void setMzmc(String value) {
        this.mzmc = value;
    }
    /** 获取:mzmc */
    public String getMzmc() {
        return mzmc;
    }

    /** 设置:pydm  */
    public void setPydm(String value) {
        this.pydm = value;
    }
    /** 获取:pydm */
    public String getPydm() {
        return pydm;
    }


}
