//   
//package com.buit.his.sys.msg.request;
//
//import java.sql.Timestamp;
//
//import com.buit.commons.PageQuery;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//
//
///**
// * 类名称：MessJsjl<br> 
// * 类描述：消息危急值接收记录<br>
// * @author GONGFANGZHOU
// */
//@ApiModel(value="消息危急值接收记录")
//public class MessJsjlReq  extends  PageQuery{
//    @ApiModelProperty(value="消息接收记录主键")
//    private Integer messJsjlId;
//    @ApiModelProperty(value="消息主键")
//    private Integer messId;
//    @ApiModelProperty(value="科室ID")
//    private Integer ksId;
//    @ApiModelProperty(value="用户ID")
//    private Integer userId;
//    @ApiModelProperty(value="消息接收时间")
//    private Timestamp jsTime;
//    @ApiModelProperty(value="业务类型(1:住院护士站,2:住院医生站)")
//    private Integer ywType;
//    /**
//     * 设置:消息接收记录主键
//     */
//    public void setMessJsjlId(Integer value) {
//        this.messJsjlId = value;
//    }
//    /**
//     * 获取:消息接收记录主键
//     */
//    public Integer getMessJsjlId() {
//        return messJsjlId;
//    }
//    /**
//     * 设置:消息主键
//     */
//    public void setMessId(Integer value) {
//        this.messId = value;
//    }
//    /**
//     * 获取:消息主键
//     */
//    public Integer getMessId() {
//        return messId;
//    }
//    /**
//     * 设置:科室ID
//     */
//    public void setKsId(Integer value) {
//        this.ksId = value;
//    }
//    /**
//     * 获取:科室ID
//     */
//    public Integer getKsId() {
//        return ksId;
//    }
//    /**
//     * 设置:用户ID
//     */
//    public void setUserId(Integer value) {
//        this.userId = value;
//    }
//    /**
//     * 获取:用户ID
//     */
//    public Integer getUserId() {
//        return userId;
//    }
//    /**
//     * 设置:消息接收时间
//     */
//    public void setJsTime(Timestamp value) {
//        this.jsTime = value;
//    }
//    /**
//     * 获取:消息接收时间
//     */
//    public Timestamp getJsTime() {
//        return jsTime;
//    }
//    /**
//     * 设置:业务类型(1:住院护士站,2:住院医生站)
//     */
//    public void setYwType(Integer value) {
//        this.ywType = value;
//    }
//    /**
//     * 获取:业务类型(1:住院护士站,2:住院医生站)
//     */
//    public Integer getYwType() {
//        return ywType;
//    }
//}