   
package com.buit.his.sys.centermaintenance.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：FeeXmfytj01QueryReq<br> 
 * 类描述：<br>
 * @author GONGFANGZHOU
 */
@ApiModel(value="公用_费用调价_queryReq")
public class FeeXmfytj01QueryReq {
    @ApiModelProperty(value="调价方式")
    private Integer tjfs;
    
    @ApiModelProperty(value="执行日期")
    private String zxrq;
    
    @ApiModelProperty(value = "执行判别 | 0：未执行 1：已执行")
    private Integer zxpb;
    
    @ApiModelProperty(value="机构Id", hidden = true)
    private Integer jgid;
    
    @ApiModelProperty(value="开始执行日期(查询)", hidden = true)
    private String kszxrq;
    
    @ApiModelProperty(value="结束执行日期(查询)", hidden = true)
    private String jszxrq;

	public Integer getTjfs() {
		return tjfs;
	}

	public void setTjfs(Integer tjfs) {
		this.tjfs = tjfs;
	}

	public String getZxrq() {
		return zxrq;
	}

	public void setZxrq(String zxrq) {
		this.zxrq = zxrq;
	}

	public Integer getZxpb() {
		return zxpb;
	}

	public void setZxpb(Integer zxpb) {
		this.zxpb = zxpb;
	}

	public Integer getJgid() {
		return jgid;
	}

	public void setJgid(Integer jgid) {
		this.jgid = jgid;
	}

	public String getKszxrq() {
		return kszxrq;
	}

	public void setKszxrq(String kszxrq) {
		this.kszxrq = kszxrq;
	}

	public String getJszxrq() {
		return jszxrq;
	}

	public void setJszxrq(String jszxrq) {
		this.jszxrq = jszxrq;
	}
   
    
}
