   
package com.buit.his.sys.centermaintenance.request;

import java.sql.Timestamp;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：ImDicYpyfFjjf<br> 
 * 类描述：住院_药品用法_附加计费<br>
 * @author GONGFANGZHOU
 */
@ApiModel(value="住院_药品用法_附加计费_Req")
public class ImDicYpyfFjjfReq  extends  PageQuery{
    @ApiModelProperty(value="序号")
    private Integer id;
    @ApiModelProperty(value="药品用法序号")
    private Integer ypyf;
    @ApiModelProperty(value="附加项目")
    private Integer fyxh;
    @ApiModelProperty(value="计费方式1.按频次2.按日3.按频次每日最大数")
    private Integer jffs;
    @ApiModelProperty(value="计费数量")
    private Integer jfsl;
    @ApiModelProperty(value="频次编码")
    private String pcbm;
    @ApiModelProperty(value="机构id", hidden = true)
    private Integer jgid;
    /**
     * 设置:序号
     */
    public void setId(Integer value) {
        this.id = value;
    }
    /**
     * 获取:序号
     */
    public Integer getId() {
        return id;
    }
    /**
     * 设置:药品用法序号
     */
    public void setYpyf(Integer value) {
        this.ypyf = value;
    }
    /**
     * 获取:药品用法序号
     */
    public Integer getYpyf() {
        return ypyf;
    }
    /**
     * 设置:附加项目
     */
    public void setFyxh(Integer value) {
        this.fyxh = value;
    }
    /**
     * 获取:附加项目
     */
    public Integer getFyxh() {
        return fyxh;
    }
    /**
     * 设置:计费方式1.按频次2.按日3.按频次每日最大数
     */
    public void setJffs(Integer value) {
        this.jffs = value;
    }
    /**
     * 获取:计费方式1.按频次2.按日3.按频次每日最大数
     */
    public Integer getJffs() {
        return jffs;
    }
    /**
     * 设置:计费数量
     */
    public void setJfsl(Integer value) {
        this.jfsl = value;
    }
    /**
     * 获取:计费数量
     */
    public Integer getJfsl() {
        return jfsl;
    }
    /**
     * 设置:频次编码
     */
    public void setPcbm(String value) {
        this.pcbm = value;
    }
    /**
     * 获取:频次编码
     */
    public String getPcbm() {
        return pcbm;
    }
    /**
     * 设置:机构id
     */
    public void setJgid(Integer value) {
        this.jgid = value;
    }
    /**
     * 获取:机构id
     */
    public Integer getJgid() {
        return jgid;
    }
}