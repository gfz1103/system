package com.buit.his.dic.response;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author All
 */
@ApiModel(value="字典主记录")
public class Maindic {
	 @ApiModelProperty(value="字典主记录")
	String dk;
	 @ApiModelProperty(value="名称")
	String dname;
	 @ApiModelProperty(value="数据版本")
	Integer dversion;
	
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public Integer getDversion() {
		return dversion;
	}
	public void setDversion(Integer dversion) {
		this.dversion = dversion;
	}
	List<Sondic> son;
	public String getDk() {
		return dk;
	}
	public void setDk(String dk) {
		this.dk = dk;
	}
	public List<Sondic> getSon() {
		return son;
	}
	public void setSon(List<Sondic> son) {
		this.son = son;
	}
}
