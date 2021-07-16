package com.buit.his.sys.centermaintenance.response;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：CisJcsq02ZlxmResp<br> 
 * 类描述：检查申请单明细<br>
 * @author 老花生
 */
@ApiModel(value="医技类型_zlxmResp")
public class DicYjlxZlxmResp {
    @ApiModelProperty(value="主键id")
    private Integer id;
    
    @ApiModelProperty(value="名称")
    private String label;
    
    @ApiModelProperty(value="上级类型")
    private Integer pid;
    
    @ApiModelProperty(value="费用单价")
    private Integer sort;
    
    @ApiModelProperty(value="节点集合")
    private List<DicYjlxZlxmResp> children;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public List<DicYjlxZlxmResp> getChildren() {
		return children;
	}

	public void setChildren(List<DicYjlxZlxmResp> children) {
		this.children = children;
	}
 
  
}
