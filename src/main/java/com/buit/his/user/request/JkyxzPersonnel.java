package com.buit.his.user.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * 类名称：HrPersonnel<br> 
 * 类描述：员工信息
 * @author 神算子 
 * @ApiModel(value="员工信息")
 */
public class JkyxzPersonnel extends PageQuery {
    /** 员工ID */
    private Integer personid;
    /** 姓名 */
    private String personname;
    /** 作废判别 */
    private String iscancel;

    private Integer officecode;

    private String officename;

    private Integer organizcode;


    private String pyzj;
    private String organizname;

    private String prescriberight;
    private String narcoticright;
    private String psychotropicright;

	

	/** 设置:员工ID  */
    public void setPersonid(Integer value) {
        this.personid = value;
    }
    /** 获取:员工ID */
    public Integer getPersonid() {
        return personid;
    }

    /** 设置:姓名  */
    public void setPersonname(String value) {
        this.personname = value;
    }
    /** 获取:姓名 */
    public String getPersonname() {
        return personname;
    }



    /** 设置:所在科室KSDM  */
    public void setOfficecode(Integer value) {
        this.officecode = value;
    }
    /** 获取:所在科室KSDM */
    public Integer getOfficecode() {
        return officecode;
    }

    /** 设置:所在机构JGID  */
    public void setOrganizcode(Integer value) {
        this.organizcode = value;
    }
    /** 获取:所在机构JGID */
    public Integer getOrganizcode() {
        return organizcode;
    }


    /** 设置:拼音代码PYDM  */
    public void setPycode(String value) {
        this.pyzj = value;
    }
    /** 获取:拼音代码PYDM */
    public String getPycode() {
        return pyzj;
    }



    /** 设置:开处方权KCFQ  */
    public void setPrescriberight(String value) {
        this.prescriberight = value;
    }
    /** 获取:开处方权KCFQ */
    public String getPrescriberight() {
        return prescriberight;
    }

    /** 设置:麻醉药权MZYQ  */
    public void setNarcoticright(String value) {
        this.narcoticright = value;
    }
    /** 获取:麻醉药权MZYQ */
    public String getNarcoticright() {
        return narcoticright;
    }

    /** 设置:精神药权JSYQ  */
    public void setPsychotropicright(String value) {
        this.psychotropicright = value;
    }
    /** 获取:精神药权JSYQ */
    public String getPsychotropicright() {
        return psychotropicright;
    }

    public String getIscancel() {
        return iscancel;
    }

    public void setIscancel(String iscancel) {
        this.iscancel = iscancel;
    }

    public String getOfficename() {
        return officename;
    }

    public void setOfficename(String officename) {
        this.officename = officename;
    }

    public String getPyzj() {
        return pyzj;
    }

    public void setPyzj(String pyzj) {
        this.pyzj = pyzj;
    }

    public String getOrganizname() {
        return organizname;
    }

    public void setOrganizname(String organizname) {
        this.organizname = organizname;
    }
}
