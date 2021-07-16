
package com.buit.his.sys.centermaintenance.request;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：PubBrxz<br>
 * 类描述：公用_病人性质 | 包括自费、公费、记帐等添加<br>
 * @author "MLeo"
 */
@ApiModel(value="公用_病人性质保存")
public class PubBrxzSaveReq{
    @Valid
    @ApiModelProperty(value = "添加列表", required = true)
    private List<PubBrxzAddReq> adds;

    public List<PubBrxzAddReq> getAdds() {
        return adds;
    }

    public void setAdds(List<PubBrxzAddReq> adds) {
        this.adds = adds;
    }

    public static class PubBrxzAddReq {
        @ApiModelProperty(value = "性质代码", required = true)
        private Integer brxz;
        @ApiModelProperty(value = "药品序号", required = true)
        private Integer ypxh;
        @ApiModelProperty(value = "自负比例")
        private BigDecimal zfbl;


        public Integer getBrxz() {
            return brxz;
        }

        public void setBrxz(Integer brxz) {
            this.brxz = brxz;
        }

        public Integer getYpxh() {
            return ypxh;
        }

        public void setYpxh(Integer ypxh) {
            this.ypxh = ypxh;
        }

        public BigDecimal getZfbl() {
            return zfbl;
        }

        public void setZfbl(BigDecimal zfbl) {
            this.zfbl = zfbl;
        }
    }
}
