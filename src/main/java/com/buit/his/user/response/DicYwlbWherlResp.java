   
package com.buit.his.user.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：DicYwlb<br> 
 * 类描述：业务类别表<br>
 * @author WENGL
 */
@ApiModel(value="业务类别表")
public class DicYwlbWherlResp  {    
    @ApiModelProperty(value="筛选条件")
    private int btWhere;
    @ApiModelProperty(value="筛选条件中文名")
    private String btWhereCn;    
    
    public DicYwlbWherlResp(int btWhere, String btWhereCn) {
		super();
		this.btWhere = btWhere;
		this.btWhereCn = btWhereCn;
	}
	/**
     * 设置:筛选条件
     */
    public void setBtWhere(int value) {
        this.btWhere = value;
    }
    /**
     * 获取:筛选条件
     */
    public int getBtWhere() {
        return btWhere;
    }   
    public String getBtWhereCn() {
		return btWhereCn;
	}
	public void setBtWhereCn(String btWhereCn) {
		this.btWhereCn = btWhereCn;
	}
}
