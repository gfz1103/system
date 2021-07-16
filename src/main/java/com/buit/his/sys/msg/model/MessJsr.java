package com.buit.his.sys.msg.model;

import com.buit.commons.PageQuery;

/**
 * 类名称：MessJsr<br> 
 * 类描述：消息推送-接收人
 * @author 神算子 
 * @ApiModel(value="消息推送-接收人")
 */
public class MessJsr  extends  PageQuery{
	//@ApiModelProperty(value="消息接收主键")
    /** 消息接收主键 */
    private Integer messJsId;
	//@ApiModelProperty(value="消息主键")
    /** 消息主键 */
    private Integer messId;
	//@ApiModelProperty(value="科室ID")
    /** 科室ID */
    private Integer ksId;
	//@ApiModelProperty(value="用户ID")
    /** 用户ID */
    private Integer userId;

    /** 设置:消息接收主键  */
    public void setMessJsId(Integer value) {
        this.messJsId = value;
    }
    /** 获取:消息接收主键 */
    public Integer getMessJsId() {
        return messJsId;
    }

    /** 设置:消息主键  */
    public void setMessId(Integer value) {
        this.messId = value;
    }
    /** 获取:消息主键 */
    public Integer getMessId() {
        return messId;
    }

    /** 设置:科室ID  */
    public void setKsId(Integer value) {
        this.ksId = value;
    }
    /** 获取:科室ID */
    public Integer getKsId() {
        return ksId;
    }

    /** 设置:用户ID  */
    public void setUserId(Integer value) {
        this.userId = value;
    }
    /** 获取:用户ID */
    public Integer getUserId() {
        return userId;
    }


}