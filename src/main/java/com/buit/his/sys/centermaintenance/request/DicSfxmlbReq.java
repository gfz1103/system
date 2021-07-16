   
package com.buit.his.sys.centermaintenance.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：DicSfxmlb<br> 
 * 类描述：公用_收费项目<br>
 * @author GONGFANGZHOU
 */
@ApiModel(value="公用_收费项目_Req")
public class DicSfxmlbReq {
    @ApiModelProperty(value="收费项目")
    private Integer sfxm;
    @ApiModelProperty(value="收费名称")
    private String sfmc;
    @ApiModelProperty(value="名称缩写")
    private String mcsx;
    @ApiModelProperty(value="费用分类 | 1.医疗收入 2.药品收入 3.其他收入")
    private Integer fyfl;
    @ApiModelProperty(value="门诊使用")
    private Integer mzsy;
    @ApiModelProperty(value="住院使用")
    private Integer zysy;
    @ApiModelProperty(value="门诊归并")
    private Integer mzgb;
    @ApiModelProperty(value="住院归并")
    private Integer zygb;
    @ApiModelProperty(value="费用类别")
    private Integer fylb;
    @ApiModelProperty(value="拼音代码")
    private String pydm;
    @ApiModelProperty(value="保险项目 | 保险项目归并，与ZY_DBXM中XMXH对应")
    private Integer bxxm;
    @ApiModelProperty(value="科目编码")
    private String kmbm;
    @ApiModelProperty(value="排列顺序")
    private String plsx;
    @ApiModelProperty(value="类别代码 | 对应GY_SYFYGB的类别代码")
    private Integer lbdm;
    @ApiModelProperty(value="basygb")
    private Integer basygb;
    @ApiModelProperty(value="门诊排列")
    private String mzpl;
    @ApiModelProperty(value="住院排列")
    private String zypl;
    @ApiModelProperty(value="药品账簿类别,1是0否")
    private Integer zblb;
    @ApiModelProperty(value="医保住院项目")
    private String ybzyxm;
    @ApiModelProperty(value="医保门诊项目")
    private String ybmzxm;
    @ApiModelProperty(value="nhxm")
    private String nhxm;
    @ApiModelProperty(value="英文名称")
    private String ywmc;
    @ApiModelProperty(value="保存方式")
    private String opStatus;
    @ApiModelProperty(value="当前收费项目编码流水号")
    private Integer dqsfxmlsh;

    public Integer getDqsfxmlsh() {
        return dqsfxmlsh;
    }

    public void setDqsfxmlsh(Integer dqsfxmlsh) {
        this.dqsfxmlsh = dqsfxmlsh;
    }

    /**
     * 设置:收费项目
     */
    public void setSfxm(Integer value) {
        this.sfxm = value;
    }
    /**
     * 获取:收费项目
     */
    public Integer getSfxm() {
        return sfxm;
    }
    /**
     * 设置:收费名称
     */
    public void setSfmc(String value) {
        this.sfmc = value;
    }
    /**
     * 获取:收费名称
     */
    public String getSfmc() {
        return sfmc;
    }
    /**
     * 设置:名称缩写
     */
    public void setMcsx(String value) {
        this.mcsx = value;
    }
    /**
     * 获取:名称缩写
     */
    public String getMcsx() {
        return mcsx;
    }
    /**
     * 设置:费用分类 | 1.医疗收入 2.药品收入 3.其他收入
     */
    public void setFyfl(Integer value) {
        this.fyfl = value;
    }
    /**
     * 获取:费用分类 | 1.医疗收入 2.药品收入 3.其他收入
     */
    public Integer getFyfl() {
        return fyfl;
    }
    /**
     * 设置:门诊使用
     */
    public void setMzsy(Integer value) {
        this.mzsy = value;
    }
    /**
     * 获取:门诊使用
     */
    public Integer getMzsy() {
        return mzsy;
    }
    /**
     * 设置:住院使用
     */
    public void setZysy(Integer value) {
        this.zysy = value;
    }
    /**
     * 获取:住院使用
     */
    public Integer getZysy() {
        return zysy;
    }
    /**
     * 设置:门诊归并
     */
    public void setMzgb(Integer value) {
        this.mzgb = value;
    }
    /**
     * 获取:门诊归并
     */
    public Integer getMzgb() {
        return mzgb;
    }
    /**
     * 设置:住院归并
     */
    public void setZygb(Integer value) {
        this.zygb = value;
    }
    /**
     * 获取:住院归并
     */
    public Integer getZygb() {
        return zygb;
    }
    /**
     * 设置:费用类别
     */
    public void setFylb(Integer value) {
        this.fylb = value;
    }
    /**
     * 获取:费用类别
     */
    public Integer getFylb() {
        return fylb;
    }
    /**
     * 设置:拼音代码
     */
    public void setPydm(String value) {
        this.pydm = value;
    }
    /**
     * 获取:拼音代码
     */
    public String getPydm() {
        return pydm;
    }
    /**
     * 设置:保险项目 | 保险项目归并，与ZY_DBXM中XMXH对应
     */
    public void setBxxm(Integer value) {
        this.bxxm = value;
    }
    /**
     * 获取:保险项目 | 保险项目归并，与ZY_DBXM中XMXH对应
     */
    public Integer getBxxm() {
        return bxxm;
    }
    /**
     * 设置:科目编码
     */
    public void setKmbm(String value) {
        this.kmbm = value;
    }
    /**
     * 获取:科目编码
     */
    public String getKmbm() {
        return kmbm;
    }
    /**
     * 设置:排列顺序
     */
    public void setPlsx(String value) {
        this.plsx = value;
    }
    /**
     * 获取:排列顺序
     */
    public String getPlsx() {
        return plsx;
    }
    /**
     * 设置:类别代码 | 对应GY_SYFYGB的类别代码
     */
    public void setLbdm(Integer value) {
        this.lbdm = value;
    }
    /**
     * 获取:类别代码 | 对应GY_SYFYGB的类别代码
     */
    public Integer getLbdm() {
        return lbdm;
    }
    /**
     * 设置:basygb
     */
    public void setBasygb(Integer value) {
        this.basygb = value;
    }
    /**
     * 获取:basygb
     */
    public Integer getBasygb() {
        return basygb;
    }
    /**
     * 设置:门诊排列
     */
    public void setMzpl(String value) {
        this.mzpl = value;
    }
    /**
     * 获取:门诊排列
     */
    public String getMzpl() {
        return mzpl;
    }
    /**
     * 设置:住院排列
     */
    public void setZypl(String value) {
        this.zypl = value;
    }
    /**
     * 获取:住院排列
     */
    public String getZypl() {
        return zypl;
    }
    /**
     * 设置:药品账簿类别,1是0否
     */
    public void setZblb(Integer value) {
        this.zblb = value;
    }
    /**
     * 获取:药品账簿类别,1是0否
     */
    public Integer getZblb() {
        return zblb;
    }
    /**
     * 设置:医保住院项目
     */
    public void setYbzyxm(String value) {
        this.ybzyxm = value;
    }
    /**
     * 获取:医保住院项目
     */
    public String getYbzyxm() {
        return ybzyxm;
    }
    /**
     * 设置:医保门诊项目
     */
    public void setYbmzxm(String value) {
        this.ybmzxm = value;
    }
    /**
     * 获取:医保门诊项目
     */
    public String getYbmzxm() {
        return ybmzxm;
    }
    /**
     * 设置:nhxm
     */
    public void setNhxm(String value) {
        this.nhxm = value;
    }
    /**
     * 获取:nhxm
     */
    public String getNhxm() {
        return nhxm;
    }
    /**
     * 设置:英文名称
     */
    public void setYwmc(String value) {
        this.ywmc = value;
    }
    /**
     * 获取:英文名称
     */
    public String getYwmc() {
        return ywmc;
    }
    
	public String getOpStatus() {
		return opStatus;
	}
	
	public void setOpStatus(String opStatus) {
		this.opStatus = opStatus;
	}
    
    
}
