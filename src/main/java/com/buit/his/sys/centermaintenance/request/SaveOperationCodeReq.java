package com.buit.his.sys.centermaintenance.request;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Description
 * @Author yueyu
 * @Date 2020/11/9 15:32
 */
public class SaveOperationCodeReq {

    @ApiModelProperty("手术id")
    private Integer id;
    @ApiModelProperty("手术名称")
    @NotBlank
    private String ssmc;
    @ApiModelProperty("拼音代码")
    private String pydm;
    @ApiModelProperty("icd编码")
    @NotBlank
    private String icdCode;
    @NotNull
    @ApiModelProperty("手术等级")
    private Integer ssdj;
    @ApiModelProperty("作废标志，0：否，1：是")
    private Integer zfbz;

    public Integer getZfbz() {
        return zfbz;
    }

    public void setZfbz(Integer zfbz) {
        this.zfbz = zfbz;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSsmc() {
        return ssmc;
    }

    public void setSsmc(String ssmc) {
        this.ssmc = ssmc;
    }

    public String getPydm() {
        return pydm;
    }

    public void setPydm(String pydm) {
        this.pydm = pydm;
    }

    public String getIcdCode() {
        return icdCode;
    }

    public void setIcdCode(String icdCode) {
        this.icdCode = icdCode;
    }

    public Integer getSsdj() {
        return ssdj;
    }

    public void setSsdj(Integer ssdj) {
        this.ssdj = ssdj;
    }
}
