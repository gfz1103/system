   
package com.buit.his.sys.msg.request;

import java.sql.Timestamp;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：MessZjl<br> 
 * 类描述：消息推送-主记录<br>
 * @author 神算子
 */
@ApiModel(value="消息推送-主记录")
public class MessZjlReq {
  
    @ApiModelProperty(value="消息标题")
    private String messTitle;
    @ApiModelProperty(value="消息内容")
    private String messContent;   
    @ApiModelProperty(value="创建人Id")
    private Integer cuserId;
    @ApiModelProperty(value="创建人姓名")
    private String cuserName;
    @ApiModelProperty(value="提醒时间间隔单位分钟")
    private Integer callInterval=1;
    @ApiModelProperty(value="业务类型:1指定用户或科室,2:所有在线用户,默认1")
    private Integer messType=1;
    @ApiModelProperty(value="业务ID")
    private Integer callId;
    @ApiModelProperty(value="1:未完成,2:已经完成")
    private Integer isFinish;  
    @ApiModelProperty(value="消息过期时间")
    private Timestamp messTimeOut;
    @ApiModelProperty(value="业务类型1:危机值,2:会诊申请")
    private Integer serType;
    @ApiModelProperty(value="消息过期时间")
    private List<MessJsrReq> jsrList;
  
    public List<MessJsrReq> getJsrList() {
		return jsrList;
	}
	public void setJsrList(List<MessJsrReq> jsrList) {
		this.jsrList = jsrList;
	}
	/**
     * 设置:消息标题
     */
    public void setMessTitle(String value) {
        this.messTitle = value;
    }
    /**
     * 获取:消息标题
     */
    public String getMessTitle() {
        return messTitle;
    }
    /**
     * 设置:消息内容
     */
    public void setMessContent(String value) {
        this.messContent = value;
    }
    /**
     * 获取:消息内容
     */
    public String getMessContent() {
        return messContent;
    }
    /**
     * 设置:创建人Id
     */
    public void setCuserId(Integer value) {
        this.cuserId = value;
    }
    /**
     * 获取:创建人Id
     */
    public Integer getCuserId() {
        return cuserId;
    }
    /**
     * 设置:创建人姓名
     */
    public void setCuserName(String value) {
        this.cuserName = value;
    }
    /**
     * 获取:创建人姓名
     */
    public String getCuserName() {
        return cuserName;
    }
    /**
     * 设置:提醒时间间隔单位分钟
     */
    public void setCallInterval(Integer value) {
        this.callInterval = value;
    }
    /**
     * 获取:提醒时间间隔单位分钟
     */
    public Integer getCallInterval() {
        return callInterval;
    }
    /**
     * 设置:业务类型:1,会诊提醒
     */
    public void setMessType(Integer value) {
        this.messType = value;
    }
    /**
     * 获取:业务类型:1,会诊提醒
     */
    public Integer getMessType() {
        return messType;
    }
    /**
     * 设置:业务ID
     */
    public void setCallId(Integer value) {
        this.callId = value;
    }
    /**
     * 获取:业务ID
     */
    public Integer getCallId() {
        return callId;
    }
    /**
     * 设置:1:未完成,2:已经完成
     */
    public void setIsFinish(Integer value) {
        this.isFinish = value;
    }
    /**
     * 获取:1:未完成,2:已经完成
     */
    public Integer getIsFinish() {
        return isFinish;
    }
    /**
     * 设置:消息过期时间
     */
    public void setMessTimeOut(Timestamp value) {
        this.messTimeOut = value;
    }
    /**
     * 获取:消息过期时间
     */
    public Timestamp getMessTimeOut() {
        return messTimeOut;
    }
}