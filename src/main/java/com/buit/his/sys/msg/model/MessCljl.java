package com.buit.his.sys.msg.model;

import java.sql.Timestamp;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：MessCljl<br> 
 * 类描述：消息推送-处理记录
 * @author 神算子 
 * @ApiModel(value="消息推送-处理记录")
 */
public class MessCljl  extends  PageQuery{
	@ApiModelProperty(value="消息接收主键")
    /** 消息接收主键 */
    private Integer messCljlId;
	@ApiModelProperty(value="消息主键")
    /** 消息主键 */
    private Integer messId;
	@ApiModelProperty(value="科室ID")
    /** 科室ID */
    private Integer ksId;
	@ApiModelProperty(value="用户ID")
    /** 用户ID */
    private Integer userId;
	@ApiModelProperty(value="消息处理时间")
    /** 消息处理时间 */
    private Timestamp ctime;
	@ApiModelProperty(value="业务类型(1:住院护士站,2:住院医生站)")
    /** 业务类型(1:住院护士站,2:住院医生站) */
    private Integer ywtype;

    /** 设置:消息接收主键  */
    public void setMessCljlId(Integer value) {
        this.messCljlId = value;
    }
    /** 获取:消息接收主键 */
    public Integer getMessCljlId() {
        return messCljlId;
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

    /** 设置:消息处理时间  */
    public void setCtime(Timestamp value) {
        this.ctime = value;
    }
    /** 获取:消息处理时间 */
    public Timestamp getCtime() {
        return ctime;
    }
	public Integer getYwtype() {
		return ywtype;
	}
	public void setYwtype(Integer ywtype) {
		this.ywtype = ywtype;
	}


}