   
package com.buit.his.sys.centermaintenance.response;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：FeeXmfytj02<br> 
 * 类描述：<br>
 * @author GONGFANGZHOU
 */
@ApiModel(value="公用_费用调价02_Resp")
public class FeeXmfytj02Resp {
    @ApiModelProperty(value="识别序号")
    private Integer sbxh;
    @ApiModelProperty(value="机构ID")
    private Integer jgid;
    @ApiModelProperty(value="调价单号")
    private Integer tjdh;
    @ApiModelProperty(value="费用序号")
    private Integer fyxh;
    @ApiModelProperty(value="原价格")
    private BigDecimal yjg;
    @ApiModelProperty(value="新价格")
    private BigDecimal xjg;
    
    @ApiModelProperty(value="费用名称")
    private String fymc;
    
    @ApiModelProperty(value="费用单位")
    private String fydw;
    
    @ApiModelProperty(value="标准价格")
    private BigDecimal bzjg;
    
    @ApiModelProperty(value="标准价格")
    private Integer fygb;
    
    /**
     * 设置:识别序号
     */
    public void setSbxh(Integer value) {
        this.sbxh = value;
    }
    /**
     * 获取:识别序号
     */
    public Integer getSbxh() {
        return sbxh;
    }
    /**
     * 设置:机构ID
     */
    public void setJgid(Integer value) {
        this.jgid = value;
    }
    /**
     * 获取:机构ID
     */
    public Integer getJgid() {
        return jgid;
    }
    /**
     * 设置:调价单号
     */
    public void setTjdh(Integer value) {
        this.tjdh = value;
    }
    /**
     * 获取:调价单号
     */
    public Integer getTjdh() {
        return tjdh;
    }
    /**
     * 设置:费用序号
     */
    public void setFyxh(Integer value) {
        this.fyxh = value;
    }
    /**
     * 获取:费用序号
     */
    public Integer getFyxh() {
        return fyxh;
    }
    /**
     * 设置:原价格
     */
    public void setYjg(BigDecimal value) {
        this.yjg = value;
    }
    /**
     * 获取:原价格
     */
    public BigDecimal getYjg() {
        return yjg;
    }
    /**
     * 设置:新价格
     */
    public void setXjg(BigDecimal value) {
        this.xjg = value;
    }
    /**
     * 获取:新价格
     */
    public BigDecimal getXjg() {
        return xjg;
    }
    
	public String getFymc() {
		return fymc;
	}
	
	public void setFymc(String fymc) {
		this.fymc = fymc;
	}
	
	public String getFydw() {
		return fydw;
	}
	
	public void setFydw(String fydw) {
		this.fydw = fydw;
	}
	
	public BigDecimal getBzjg() {
		return bzjg;
	}
	
	public void setBzjg(BigDecimal bzjg) {
		this.bzjg = bzjg;
	}
	
	public Integer getFygb() {
		return fygb;
	}
	
	public void setFygb(Integer fygb) {
		this.fygb = fygb;
	}
    
    
}
