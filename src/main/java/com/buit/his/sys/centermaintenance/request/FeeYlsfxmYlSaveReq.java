
package com.buit.his.sys.centermaintenance.request;


import java.math.BigDecimal;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：FeeYlsfxmYlSaveReq<br>
 * 类描述：公用_医疗收费_明细<br>
 * @author GONGFANGZHOU
 */
@ApiModel(value="公用_医疗收费_ylsaveReq")
public class FeeYlsfxmYlSaveReq {
	
	@ApiModelProperty(value="费用属性表单")
	private FeeYlsfxmBody feeYlsfxmBody;
	
	@ApiModelProperty(value="费用别名集合")
	private List<PubFybmBody> pubFybmBodyList;
	
	@ApiModelProperty(value="费用限制集合")
	private List<PubFyxzBody> pubFyxzBodyList;
	
	public FeeYlsfxmBody getFeeYlsfxmBody() {
		return feeYlsfxmBody;
	}

	public void setFeeYlsfxmBody(FeeYlsfxmBody feeYlsfxmBody) {
		this.feeYlsfxmBody = feeYlsfxmBody;
	}

	public List<PubFybmBody> getPubFybmBodyList() {
		return pubFybmBodyList;
	}

	public void setPubFybmBodyList(List<PubFybmBody> pubFybmBodyList) {
		this.pubFybmBodyList = pubFybmBodyList;
	}

	public List<PubFyxzBody> getPubFyxzBodyList() {
		return pubFyxzBodyList;
	}

	public void setPubFyxzBodyList(List<PubFyxzBody> pubFyxzBodyList) {
		this.pubFyxzBodyList = pubFyxzBodyList;
	}

	public static class FeeYlsfxmBody {
		@ApiModelProperty(value="病案首页归并")
	    private Integer basygb;
		
		@ApiModelProperty(value="报表归并")
	    private Integer bbgb;
		
		@ApiModelProperty(value="笔画代码")
	    private String bhdm;
		
		@ApiModelProperty(value="标准价格")
	    private BigDecimal bzjg;
		
		@ApiModelProperty(value="材料标志")
	    private Integer clbz;
		
		@ApiModelProperty(value="材料对应(字典:sys_dict_config:36)")
	    private String cldym;
		
		@ApiModelProperty(value="费用单位")
	    private String fydw;
		
		@ApiModelProperty(value="费用归并")
	    private Integer fygb;
		
		@ApiModelProperty(value="费用名称(手术名称)")
	    private String fymc;
		
		@ApiModelProperty(value="费用序号")
	    private Integer fyxh;
		
		@ApiModelProperty(value="黄码编码")
	    private String hmbm;
		
		@ApiModelProperty(value="角形代码")
	    private String jxdm;
		
		@ApiModelProperty(value="明细标志")
	    private Integer mxbz;
		
		@ApiModelProperty(value="门诊使用")
	    private Integer mzsy;
		
	    @ApiModelProperty(value="拼音代码")
	    private String pydm;
	   
	    @ApiModelProperty(value="其他代码")
	    private String qtdm;
	    
	    @ApiModelProperty(value="特殊检查")
	    private Integer tjfy;
	    
	    @ApiModelProperty(value="特殊治疗")
	    private Integer txzl;
	      
	    @ApiModelProperty(value="五笔代码")
	    private String wbdm;
	    
	    @ApiModelProperty(value="项目编码")
	    private String xmbm;
	    
	    @ApiModelProperty(value="项目类别 | 4.检验 5.检查 6.手术 7.治疗 8.护理 9.饮食 10.卫材 99.其他")
	    private Integer xmlx;
	    
	    @ApiModelProperty(value="医保编码")
	    private String ybbm;
	    
	    @ApiModelProperty(value="医保单位")
	    private String ybdw;
	    
	    @ApiModelProperty(value="医保名称")
	    private String ybmc;
	    
	    @ApiModelProperty(value="医技使用")
	    private Integer yjsy;
	    
	    @ApiModelProperty(value="材料规格")
	    private String yyclgg;
	    
	    @ApiModelProperty(value="医用品牌")
	    private String yypp;
	    
	    @ApiModelProperty(value="注册证号")
	    private String zczh;
	    
	    @ApiModelProperty(value="作废判别")
	    private Integer zfpb;
	    
	    @ApiModelProperty(value="总限额")
	    private BigDecimal zjxe;
	    
	    @ApiModelProperty(value="执行科室")
	    private Integer zxks;
	    
	    @ApiModelProperty(value="住院使用")
	    private Integer zysy;

	    @ApiModelProperty("手术编码")
		private Integer ssbm;

		public Integer getSsbm() {
			return ssbm;
		}

		public void setSsbm(Integer ssbm) {
			this.ssbm = ssbm;
		}

		public Integer getBasygb() {
			return basygb;
		}

		public void setBasygb(Integer basygb) {
			this.basygb = basygb;
		}

		public Integer getBbgb() {
			return bbgb;
		}

		public void setBbgb(Integer bbgb) {
			this.bbgb = bbgb;
		}

		public String getBhdm() {
			return bhdm;
		}

		public void setBhdm(String bhdm) {
			this.bhdm = bhdm;
		}

		public BigDecimal getBzjg() {
			return bzjg;
		}

		public void setBzjg(BigDecimal bzjg) {
			this.bzjg = bzjg;
		}

		public Integer getClbz() {
			return clbz;
		}

		public void setClbz(Integer clbz) {
			this.clbz = clbz;
		}

		public String getCldym() {
			return cldym;
		}

		public void setCldym(String cldym) {
			this.cldym = cldym;
		}

		public String getFydw() {
			return fydw;
		}

		public void setFydw(String fydw) {
			this.fydw = fydw;
		}

		public Integer getFygb() {
			return fygb;
		}

		public void setFygb(Integer fygb) {
			this.fygb = fygb;
		}

		public String getFymc() {
			return fymc;
		}

		public void setFymc(String fymc) {
			this.fymc = fymc;
		}

		public Integer getFyxh() {
			return fyxh;
		}

		public void setFyxh(Integer fyxh) {
			this.fyxh = fyxh;
		}

		public String getHmbm() {
			return hmbm;
		}

		public void setHmbm(String hmbm) {
			this.hmbm = hmbm;
		}

		public String getJxdm() {
			return jxdm;
		}

		public void setJxdm(String jxdm) {
			this.jxdm = jxdm;
		}

		public Integer getMxbz() {
			return mxbz;
		}

		public void setMxbz(Integer mxbz) {
			this.mxbz = mxbz;
		}

		public Integer getMzsy() {
			return mzsy;
		}

		public void setMzsy(Integer mzsy) {
			this.mzsy = mzsy;
		}

		public String getPydm() {
			return pydm;
		}

		public void setPydm(String pydm) {
			this.pydm = pydm;
		}

		public String getQtdm() {
			return qtdm;
		}

		public void setQtdm(String qtdm) {
			this.qtdm = qtdm;
		}

		public Integer getTjfy() {
			return tjfy;
		}

		public void setTjfy(Integer tjfy) {
			this.tjfy = tjfy;
		}

		public Integer getTxzl() {
			return txzl;
		}

		public void setTxzl(Integer txzl) {
			this.txzl = txzl;
		}

		public String getWbdm() {
			return wbdm;
		}

		public void setWbdm(String wbdm) {
			this.wbdm = wbdm;
		}

		public String getXmbm() {
			return xmbm;
		}

		public void setXmbm(String xmbm) {
			this.xmbm = xmbm;
		}

		public Integer getXmlx() {
			return xmlx;
		}

		public void setXmlx(Integer xmlx) {
			this.xmlx = xmlx;
		}

		public String getYbbm() {
			return ybbm;
		}

		public void setYbbm(String ybbm) {
			this.ybbm = ybbm;
		}

		public String getYbdw() {
			return ybdw;
		}

		public void setYbdw(String ybdw) {
			this.ybdw = ybdw;
		}

		public String getYbmc() {
			return ybmc;
		}

		public void setYbmc(String ybmc) {
			this.ybmc = ybmc;
		}

		public Integer getYjsy() {
			return yjsy;
		}

		public void setYjsy(Integer yjsy) {
			this.yjsy = yjsy;
		}

		public String getYyclgg() {
			return yyclgg;
		}

		public void setYyclgg(String yyclgg) {
			this.yyclgg = yyclgg;
		}

		public String getYypp() {
			return yypp;
		}

		public void setYypp(String yypp) {
			this.yypp = yypp;
		}

		public String getZczh() {
			return zczh;
		}

		public void setZczh(String zczh) {
			this.zczh = zczh;
		}

		public Integer getZfpb() {
			return zfpb;
		}

		public void setZfpb(Integer zfpb) {
			this.zfpb = zfpb;
		}

		public BigDecimal getZjxe() {
			return zjxe;
		}

		public void setZjxe(BigDecimal zjxe) {
			this.zjxe = zjxe;
		}

		public Integer getZxks() {
			return zxks;
		}

		public void setZxks(Integer zxks) {
			this.zxks = zxks;
		}

		public Integer getZysy() {
			return zysy;
		}

		public void setZysy(Integer zysy) {
			this.zysy = zysy;
		}
		
	}
	
	public static class PubFybmBody {
		
		@ApiModelProperty(value="笔画码")
		private String bhdm;
		 
		@ApiModelProperty(value="编码分类")
		private Integer bmfl;
		 
		@ApiModelProperty(value="编码序号")
	    private Integer bmxh;
	    
		@ApiModelProperty(value="费用名称")
	    private String fymc;
	    
		@ApiModelProperty(value="费用序号")
	    private Integer fyxh;
	    
		@ApiModelProperty(value="角形码")
		private String jxdm;
	    
	  	@ApiModelProperty(value="拼音码")
	  	private String pydm;
	    
	  	@ApiModelProperty(value="拼音码")
	  	private String qtdm;
	    
	  	@ApiModelProperty(value="拼音码")
		private String wbdm;

		public String getBhdm() {
			return bhdm;
		}

		public void setBhdm(String bhdm) {
			this.bhdm = bhdm;
		}

		public Integer getBmfl() {
			return bmfl;
		}

		public void setBmfl(Integer bmfl) {
			this.bmfl = bmfl;
		}

		public Integer getBmxh() {
			return bmxh;
		}

		public void setBmxh(Integer bmxh) {
			this.bmxh = bmxh;
		}

		public String getFymc() {
			return fymc;
		}

		public void setFymc(String fymc) {
			this.fymc = fymc;
		}

		public Integer getFyxh() {
			return fyxh;
		}

		public void setFyxh(Integer fyxh) {
			this.fyxh = fyxh;
		}

		public String getJxdm() {
			return jxdm;
		}

		public void setJxdm(String jxdm) {
			this.jxdm = jxdm;
		}

		public String getPydm() {
			return pydm;
		}

		public void setPydm(String pydm) {
			this.pydm = pydm;
		}

		public String getQtdm() {
			return qtdm;
		}

		public void setQtdm(String qtdm) {
			this.qtdm = qtdm;
		}

		public String getWbdm() {
			return wbdm;
		}

		public void setWbdm(String wbdm) {
			this.wbdm = wbdm;
		}	  	
	  	
	}
 
    public static class PubFyxzBody {
    	
    	@ApiModelProperty(value="病人性质")
    	private Integer brxz;
    	
    	@ApiModelProperty(value="超限比例")
    	private BigDecimal cxbl;
    	
    	@ApiModelProperty(value="费用限额")
    	private BigDecimal fyxe;
    	
    	@ApiModelProperty(value="费用序号")
    	private Integer fyxh;
    	
    	@ApiModelProperty(value="病人性质")
    	private String xzmc;
    	
    	@ApiModelProperty(value="自负比例")
    	private BigDecimal zfbl;

		public Integer getBrxz() {
			return brxz;
		}

		public void setBrxz(Integer brxz) {
			this.brxz = brxz;
		}

		public BigDecimal getCxbl() {
			return cxbl;
		}

		public void setCxbl(BigDecimal cxbl) {
			this.cxbl = cxbl;
		}

		public BigDecimal getFyxe() {
			return fyxe;
		}

		public void setFyxe(BigDecimal fyxe) {
			this.fyxe = fyxe;
		}

		public Integer getFyxh() {
			return fyxh;
		}

		public void setFyxh(Integer fyxh) {
			this.fyxh = fyxh;
		}

		public String getXzmc() {
			return xzmc;
		}

		public void setXzmc(String xzmc) {
			this.xzmc = xzmc;
		}

		public BigDecimal getZfbl() {
			return zfbl;
		}

		public void setZfbl(BigDecimal zfbl) {
			this.zfbl = zfbl;
		}
    	
    }
	
	
	
}
