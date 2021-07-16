   
package com.buit.his.user.response;

import java.util.List;

import com.buit.his.user.model.SysMenu;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：SysMenu<br> 
 * 类描述：系统菜单表<br>
 */
@ApiModel(value="系统菜单表")
public class SysMenuSystemResp  {
	@ApiModelProperty(value="系统名称")
	private String systemName;
    @ApiModelProperty(value="菜单List")
    private List<SysMenu> menuList;
	public String getSystemName() {
		return systemName;
	}
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	public List<SysMenu> getMenuList() {
		return menuList;
	}
	public void setMenuList(List<SysMenu> menuList) {
		this.menuList = menuList;
	}
}