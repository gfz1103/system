   
package com.buit.his.sys.centermaintenance.request;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：OptMzfsReq<br> 
 * 类描述：<br>
 * @author GONGFANGZHOU
 */
@ApiModel(value="OptMzfs_Req")
public class OptMzfsReq  {
    @ApiModelProperty(value="主键")
    private Integer mzid;
    @ApiModelProperty(value="麻醉代码")
    private Integer mzdm;
    @ApiModelProperty(value="麻醉名称")
    private String mzmc;
    @ApiModelProperty(value="拼音代码")
    private String pydm;
    /**
     * 设置:mzid
     */
    public void setMzid(Integer value) {
        this.mzid = value;
    }
    /**
     * 获取:mzid
     */
    public Integer getMzid() {
        return mzid;
    }
    /**
     * 设置:mzdm
     */
    public void setMzdm(Integer value) {
        this.mzdm = value;
    }
    /**
     * 获取:mzdm
     */
    public Integer getMzdm() {
        return mzdm;
    }
    /**
     * 设置:mzmc
     */
    public void setMzmc(String value) {
        this.mzmc = value;
    }
    /**
     * 获取:mzmc
     */
    public String getMzmc() {
        return mzmc;
    }
    /**
     * 设置:pydm
     */
    public void setPydm(String value) {
        this.pydm = value;
    }
    /**
     * 获取:pydm
     */
    public String getPydm() {
        return pydm;
    }
}
