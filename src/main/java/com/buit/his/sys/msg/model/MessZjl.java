package com.buit.his.sys.msg.model;

import java.sql.Timestamp;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：MessZjl<br> 
 * 类描述：消息推送-主记录
 * @author 神算子 
 * @ApiModel(value="消息推送-主记录")
 */
public class MessZjl  extends  PageQuery{
	@ApiModelProperty(value="消息主键")
    /** 消息主键 */
    private Integer messId;
	@ApiModelProperty(value="消息标题")
    /** 消息标题 */
    private String messTitle;
	@ApiModelProperty(value="消息内容")
    /** 消息内容 */
    private String messContent;
	@ApiModelProperty(value="创建时间")
    /** 创建时间 */
    private Timestamp ctime;
	@ApiModelProperty(value="创建人Id")
    /** 创建人Id */
    private Integer cuserId;
	@ApiModelProperty(value="创建人姓名")
    /** 创建人姓名 */
    private String cuserName;
	@ApiModelProperty(value="提醒时间间隔单位分钟")
    /** 提醒时间间隔单位分钟 */
    private Integer callInterval;
	@ApiModelProperty(value="业务类型:1指定用户或科室,2:所有在线用户")
    /** 业务类型:1指定用户或科室,2:所有在线用户 */
    private Integer messType;
	@ApiModelProperty(value="业务ID")
    /** 业务ID */
    private Integer callId;
	@ApiModelProperty(value="1:未完成,2:已经完成")
    /** 1:未完成,2:已经完成 */
    private Integer isFinish;
	@ApiModelProperty(value="下次通知时间")
    /** 下次通知时间 */
    private Timestamp nextTime;
	@ApiModelProperty(value="消息过期时间")
    /** 消息过期时间 */
    private Timestamp messTimeOut;
	@ApiModelProperty(value="业务类型1:危机值,2:会诊申请")
    /** 业务类型1:危机值,2:会诊申请 */
    private Integer serType;

    /** 设置:消息主键  */
    public void setMessId(Integer value) {
        this.messId = value;
    }
    /** 获取:消息主键 */
    public Integer getMessId() {
        return messId;
    }

    /** 设置:消息标题  */
    public void setMessTitle(String value) {
        this.messTitle = value;
    }
    /** 获取:消息标题 */
    public String getMessTitle() {
        return messTitle;
    }

    /** 设置:消息内容  */
    public void setMessContent(String value) {
        this.messContent = value;
    }
    /** 获取:消息内容 */
    public String getMessContent() {
        return messContent;
    }

    /** 设置:创建时间  */
    public void setCtime(Timestamp value) {
        this.ctime = value;
    }
    /** 获取:创建时间 */
    public Timestamp getCtime() {
        return ctime;
    }

    /** 设置:创建人Id  */
    public void setCuserId(Integer value) {
        this.cuserId = value;
    }
    /** 获取:创建人Id */
    public Integer getCuserId() {
        return cuserId;
    }

    /** 设置:创建人姓名  */
    public void setCuserName(String value) {
        this.cuserName = value;
    }
    /** 获取:创建人姓名 */
    public String getCuserName() {
        return cuserName;
    }

    /** 设置:提醒时间间隔单位分钟  */
    public void setCallInterval(Integer value) {
        this.callInterval = value;
    }
    /** 获取:提醒时间间隔单位分钟 */
    public Integer getCallInterval() {
        return callInterval;
    }

    /** 设置:业务类型:1指定用户或科室,2:所有在线用户  */
    public void setMessType(Integer value) {
        this.messType = value;
    }
    /** 获取:业务类型:1指定用户或科室,2:所有在线用户 */
    public Integer getMessType() {
        return messType;
    }

    /** 设置:业务ID  */
    public void setCallId(Integer value) {
        this.callId = value;
    }
    /** 获取:业务ID */
    public Integer getCallId() {
        return callId;
    }

    /** 设置:1:未完成,2:已经完成  */
    public void setIsFinish(Integer value) {
        this.isFinish = value;
    }
    /** 获取:1:未完成,2:已经完成 */
    public Integer getIsFinish() {
        return isFinish;
    }

    /** 设置:下次通知时间  */
    public void setNextTime(Timestamp value) {
        this.nextTime = value;
    }
    /** 获取:下次通知时间 */
    public Timestamp getNextTime() {
        return nextTime;
    }

    /** 设置:消息过期时间  */
    public void setMessTimeOut(Timestamp value) {
        this.messTimeOut = value;
    }
    /** 获取:消息过期时间 */
    public Timestamp getMessTimeOut() {
        return messTimeOut;
    }

    /** 设置:业务类型1:危机值,2:会诊申请  */
    public void setSerType(Integer value) {
        this.serType = value;
    }
    /** 获取:业务类型1:危机值,2:会诊申请 */
    public Integer getSerType() {
        return serType;
    }


}