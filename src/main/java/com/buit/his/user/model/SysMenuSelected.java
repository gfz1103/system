package com.buit.his.user.model;

import java.util.List;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：SysMenu<br>
 * 类描述：系统菜单表<br>
 * @author All
 */
@ApiModel(value = "系统菜单表")
public class SysMenuSelected extends PageQuery {
	@ApiModelProperty(value = "菜单数据ID")
	/** 菜单数据ID */
	private Integer menuId;
	@ApiModelProperty(value = "菜单代码")
	/** 菜单代码 */
	private String menuCode;
	@ApiModelProperty(value = "菜单名称")
	/** 菜单名称 */
	private String menuName;
	@ApiModelProperty(value = "父类菜单ID")
	/** 父类菜单ID */
	private Integer parentMenuId = 0;
	@ApiModelProperty(value = "用户组数据ID")
	/** 用户组数据ID */
	private Integer groupId;
	@ApiModelProperty(value = "医疗机构ID")
	/** 医疗机构ID */
	private Integer hospitalId;
	@ApiModelProperty(value = "子节点集合")

	//@ApiModelProperty(value="拼音码")
	private String pyCode;
	//@ApiModelProperty(value="五笔码")
	private String wbCode;

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

	/** 子集合 */
	private List<SysMenuSelected> childMenuList;

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public Integer getParentMenuId() {
		return parentMenuId;
	}

	public void setParentMenuId(Integer parentMenuId) {
		this.parentMenuId = parentMenuId;
	}

	public List<SysMenuSelected> getChildMenuList() {
		return childMenuList;
	}

	public void setChildMenuList(List<SysMenuSelected> childMenuList) {
		this.childMenuList = childMenuList;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

}