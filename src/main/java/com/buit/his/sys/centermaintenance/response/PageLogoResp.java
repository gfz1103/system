
package com.buit.his.sys.centermaintenance.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




@ApiModel(value = "医疗卫生机构索引表")
public class PageLogoResp {
    @ApiModelProperty(value = "首页小logo1")
    private String pageLogo1;
    @ApiModelProperty(value = "首页小logo2")
    private String pageLogo2;
    @ApiModelProperty(value = "首页小logo3")
    private String pageLogo3;
    @ApiModelProperty(value = "首页小logo4")
    private String pageLogo4;
    @ApiModelProperty(value = "首页小logo5")
    private String pageLogo5;

    public String getPageLogo1() {
        return pageLogo1;
    }

    public void setPageLogo1(String pageLogo1) {
        this.pageLogo1 = pageLogo1;
    }

    public String getPageLogo2() {
        return pageLogo2;
    }

    public void setPageLogo2(String pageLogo2) {
        this.pageLogo2 = pageLogo2;
    }

    public String getPageLogo3() {
        return pageLogo3;
    }

    public void setPageLogo3(String pageLogo3) {
        this.pageLogo3 = pageLogo3;
    }

    public String getPageLogo4() {
        return pageLogo4;
    }

    public void setPageLogo4(String pageLogo4) {
        this.pageLogo4 = pageLogo4;
    }

    public String getPageLogo5() {
        return pageLogo5;
    }

    public void setPageLogo5(String pageLogo5) {
        this.pageLogo5 = pageLogo5;
    }
}
