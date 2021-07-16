   
package com.buit.his.user.response;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：DicYwlb<br> 
 * 类描述：业务类别表<br>
 * @author WENGL
 */
@ApiModel(value="where条件")
public class DicYwlbTabelResp  {

    @ApiModelProperty(value="业务表名")
    private String btTableName;
    @ApiModelProperty(value="业务表中文名")
    private String btTableNameCn;
    @ApiModelProperty(value="筛选条件")
    private List<DicYwlbWherlResp> btWhereList;  
    /**
     * 设置:业务表名
     */
    public void setBtTableName(String value) {
        this.btTableName = value;
    }
    /**
     * 获取:业务表名
     */
    public String getBtTableName() {
        return btTableName;
    }
	public String getBtTableNameCn() {
		return btTableNameCn;
	}
	public void setBtTableNameCn(String btTableNameCn) {
		this.btTableNameCn = btTableNameCn;
	}
	public List<DicYwlbWherlResp> getBtWhereList() {
		return btWhereList;
	}
	public void setBtWhereList(List<DicYwlbWherlResp> btWhereList) {
		this.btWhereList = btWhereList;
	}
    
}
