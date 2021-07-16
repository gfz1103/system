package com.buit.his.sys.centermaintenance.response;

import com.buit.his.sys.centermaintenance.model.FeeYlsfxm;

/**
 * @Description
 * @Author yueyu
 * @Date 2020/11/10 10:53
 */
public class SsFeeYlsfxmResp extends FeeYlsfxm {

    private Integer ssbm;
    private String ssmc;

    public Integer getSsbm() {
        return ssbm;
    }

    public void setSsbm(Integer ssbm) {
        this.ssbm = ssbm;
    }

    public String getSsmc() {
        return ssmc;
    }

    public void setSsmc(String ssmc) {
        this.ssmc = ssmc;
    }
}
