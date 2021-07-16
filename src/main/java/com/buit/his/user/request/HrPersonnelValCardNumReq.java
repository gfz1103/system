   
package com.buit.his.user.request;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：HrPersonnel<br> 
 * 类描述：员工信息<br>
 * @author 神算子
 */
@ApiModel(value="验证身份证号是否被用过")
public class HrPersonnelValCardNumReq {	
	@ApiModelProperty(value="所在机构JGID",hidden = true)
    private Integer organizcode;
	@ApiModelProperty(value="身份证件类型")
	@NotEmpty
    private String cardtype;
    @ApiModelProperty(value="身份证件号码SFZH")
    @NotEmpty
    private String cardnum;	
    @ApiModelProperty(value="员工ID")
    private String personid; 
   
    /**
     * 设置:员工ID
     */
    public void setPersonid(String value) {
        this.personid = value;
    }
    /**
     * 获取:员工ID
     */
    public String getPersonid() {
        return personid;
    }
    
    /**
     * 设置:身份证件类型
     */
    public void setCardtype(String value) {
        this.cardtype = value;
    }
    /**
     * 获取:身份证件类型
     */
    public String getCardtype() {
        return cardtype;
    }
    /**
     * 设置:身份证件号码SFZH
     */
    public void setCardnum(String value) {
        this.cardnum = value;
    }
    /**
     * 获取:身份证件号码SFZH
     */
    public String getCardnum() {
        return cardnum;
    }
   
    /**
     * 设置:所在机构JGID
     */
    public void setOrganizcode(Integer value) {
        this.organizcode = value;
    }
    /**
     * 获取:所在机构JGID
     */
    public Integer getOrganizcode() {
        return organizcode;
    }
    
}
