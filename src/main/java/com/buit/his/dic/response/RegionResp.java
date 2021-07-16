   
package com.buit.his.dic.response;

import io.swagger.annotations.ApiModel;


/**
 * 类名称：SysVar<br> 
 * 类描述：获取全局变量服务<br>
 * @author All
 */
@ApiModel(value="获取全局变量服务")
public class RegionResp  {
	private Integer id;
	private String name;
	private String level;
	private String parentId;
	 private String pyCode;
	 private String wbCode;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getPyCode() {
		return pyCode;
	}
	public void setPyCode(String pyCode) {
		this.pyCode = pyCode;
	}
	public String getWbCode() {
		return wbCode;
	}
	public void setWbCode(String wbCode) {
		this.wbCode = wbCode;
	}
   
}