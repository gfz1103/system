package com.buit.his.sys.centermaintenance.request;

import com.buit.commons.PageQuery;

/**
 * @Description
 * @Author yueyu
 * @Date 2020/11/9 16:23
 */
public class QueryOperationCodeReq extends PageQuery {


    private String pydm;

    public String getPydm() {
        return pydm;
    }

    public void setPydm(String pydm) {
        this.pydm = pydm;
    }
}
