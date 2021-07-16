   
package com.buit.his.sys.msg.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：MessJsr<br> 
 * 类描述：消息推送-接收人<br>
 * @author 神算子
 */
@ApiModel(value="消息推送-接收人")
public class MessJsrReq {
    @ApiModelProperty(value="科室ID")
    private Integer ksId;
    @ApiModelProperty(value="用户ID")
    private Integer userId;
    /**
     * 设置:科室ID
     */
    public void setKsId(Integer value) {
        this.ksId = value;
    }
    /**
     * 获取:科室ID
     */
    public Integer getKsId() {
        return ksId;
    }
    /**
     * 设置:用户ID
     */
    public void setUserId(Integer value) {
        this.userId = value;
    }
    /**
     * 获取:用户ID
     */
    public Integer getUserId() {
        return userId;
    }
}