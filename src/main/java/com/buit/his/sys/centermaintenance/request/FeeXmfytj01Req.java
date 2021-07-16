   
package com.buit.his.sys.centermaintenance.request;

import com.buit.his.sys.centermaintenance.model.FeeXmfytj02;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * 类名称：FeeXmfytj01Req<br> 
 * 类描述：<br>
 * @author GONGFANGZHOU
 */
@ApiModel(value="公用_费用调价_Req")
public class FeeXmfytj01Req {

	@ApiModelProperty(value="定时日期")
    private Date dsrq;
	
	@ApiModelProperty(value="机构ID")
    private Integer jgid;
	
	@ApiModelProperty(value="录入工号")
    private String rrgh;
    
    @ApiModelProperty(value="录入日期")
    private Timestamp rrrq;

    @ApiModelProperty(value="生效工号")
    private String sxgh;
    
    @ApiModelProperty(value="生效日期")
    private Timestamp sxrq;
    
    @ApiModelProperty(value="生效判别")
    private Integer sxpb;
    
    @ApiModelProperty(value="调价单号")
    private Integer tjdh;
    
    @ApiModelProperty(value="调价方式")
    private Integer tjfs;
    
    @ApiModelProperty(value="调价文号")
    private String tjwh;

    @ApiModelProperty(value="执行工号")
    private String zxgh;
    
    @ApiModelProperty(value="执行日期")
    private Timestamp zxrq;
    
    @ApiModelProperty(value="执行判别")
    private Integer zxpb;
    
    @ApiModelProperty(value="保存方式")
    private String opStatus;
    
    @ApiModelProperty(value="费用调价集合")
    private List<FeeXmfytj02> fytj02List;

	public Date getDsrq() {
		return dsrq;
	}

	public void setDsrq(Date dsrq) {
		this.dsrq = dsrq;
	}

	public Integer getJgid() {
		return jgid;
	}

	public void setJgid(Integer jgid) {
		this.jgid = jgid;
	}

	public String getRrgh() {
		return rrgh;
	}

	public void setRrgh(String rrgh) {
		this.rrgh = rrgh;
	}

	public Timestamp getRrrq() {
		return rrrq;
	}

	public void setRrrq(Timestamp rrrq) {
		this.rrrq = rrrq;
	}

	public String getSxgh() {
		return sxgh;
	}

	public void setSxgh(String sxgh) {
		this.sxgh = sxgh;
	}

	public Timestamp getSxrq() {
		return sxrq;
	}

	public void setSxrq(Timestamp sxrq) {
		this.sxrq = sxrq;
	}

	public Integer getSxpb() {
		return sxpb;
	}

	public void setSxpb(Integer sxpb) {
		this.sxpb = sxpb;
	}

	public Integer getTjdh() {
		return tjdh;
	}

	public void setTjdh(Integer tjdh) {
		this.tjdh = tjdh;
	}

	public Integer getTjfs() {
		return tjfs;
	}

	public void setTjfs(Integer tjfs) {
		this.tjfs = tjfs;
	}

	public String getTjwh() {
		return tjwh;
	}

	public void setTjwh(String tjwh) {
		this.tjwh = tjwh;
	}

	public String getZxgh() {
		return zxgh;
	}

	public void setZxgh(String zxgh) {
		this.zxgh = zxgh;
	}

	public Timestamp getZxrq() {
		return zxrq;
	}

	public void setZxrq(Timestamp zxrq) {
		this.zxrq = zxrq;
	}

	public Integer getZxpb() {
		return zxpb;
	}

	public void setZxpb(Integer zxpb) {
		this.zxpb = zxpb;
	}

	public String getOpStatus() {
		return opStatus;
	}

	public void setOpStatus(String opStatus) {
		this.opStatus = opStatus;
	}

	public List<FeeXmfytj02> getFytj02List() {
		return fytj02List;
	}

	public void setFytj02List(List<FeeXmfytj02> fytj02List) {
		this.fytj02List = fytj02List;
	}
 
}
