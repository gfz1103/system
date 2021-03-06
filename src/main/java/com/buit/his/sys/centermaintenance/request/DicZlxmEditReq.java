
package com.buit.his.sys.centermaintenance.request;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;


/**
 * 类名称：DicZlxm<br>
 * 类描述：诊疗项目-编辑<br>
 * @author 老花生
 */
@ApiModel(value="诊疗项目-编辑")
public class DicZlxmEditReq {
    @NotNull(message = "诊疗项目ID不能为空")
    @ApiModelProperty(value="诊疗项目ID",required = true)
    private Integer zlxmid;
    @ApiModelProperty(value="项目名称")
    private String xmmc;
    @ApiModelProperty(value="拼音代码")
    private String pydm;
    @ApiModelProperty(value="五笔代码")
    private String wbdm;
    @ApiModelProperty(value="备注")
    private String memo;
    @ApiModelProperty(value="作废标志 0=未作废  1=已作废")
    private String zfbz;
    @ApiModelProperty(value="长期医嘱使用,0:未使用,1:使用")
    private String czsy;
    @ApiModelProperty(value="临时医嘱使用,0:未使用,1:使用")
    private String lzsy;
    @ApiModelProperty(value="门诊使用,0:未使用,1:使用")
    private String mzsy;
    @ApiModelProperty(value="住院使用,0:未使用,1:使用")
    private String zysy;
    @ApiModelProperty(value="体检使用,0:未使用,1:使用")
    private String tjsy;
    @ApiModelProperty(value="医技类型")
    private Integer yjlx;
    @ApiModelProperty(value="检查知情同意书")
    private String jczqtys;
    @ApiModelProperty(value="注意事项")
    private String zysx;
    @ApiModelProperty(value="执行科室")
    private Integer zxks;

    private List<DiccZlsfdzReq> diccZlsfdzEditReqList;

    /**
     * 设置:诊疗项目 ID
     */
    public void setZlxmid(Integer value) {
        this.zlxmid = value;
    }
    /**
     * 获取:诊疗项目 ID
     */
    public Integer getZlxmid() {
        return zlxmid;
    }
    /**
     * 设置:项目名称
     */
    public void setXmmc(String value) {
        this.xmmc = value;
    }
    /**
     * 获取:项目名称
     */
    public String getXmmc() {
        return xmmc;
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
     * 设置:五笔代码
     */
    public void setWbdm(String value) {
        this.wbdm = value;
    }
    /**
     * 获取:五笔代码
     */
    public String getWbdm() {
        return wbdm;
    }
    /**
     * 设置:备注
     */
    public void setMemo(String value) {
        this.memo = value;
    }
    /**
     * 获取:备注
     */
    public String getMemo() {
        return memo;
    }
    /**
     * 设置:作废标志 0=未作废  1=已作废
     */
    public void setZfbz(String value) {
        this.zfbz = value;
    }
    /**
     * 获取:作废标志 0=未作废  1=已作废
     */
    public String getZfbz() {
        return zfbz;
    }
    /**
     * 设置:长期医嘱使用
     */
    public void setCzsy(String value) {
        this.czsy = value;
    }
    /**
     * 获取:长期医嘱使用
     */
    public String getCzsy() {
        return czsy;
    }
    /**
     * 设置:临时医嘱使用
     */
    public void setLzsy(String value) {
        this.lzsy = value;
    }
    /**
     * 获取:临时医嘱使用
     */
    public String getLzsy() {
        return lzsy;
    }
    /**
     * 设置:门诊使用
     */
    public void setMzsy(String value) {
        this.mzsy = value;
    }
    /**
     * 获取:门诊使用
     */
    public String getMzsy() {
        return mzsy;
    }
    /**
     * 设置:住院使用
     */
    public void setZysy(String value) {
        this.zysy = value;
    }
    /**
     * 获取:住院使用
     */
    public String getZysy() {
        return zysy;
    }
    /**
     * 设置:提交使用
     */
    public void setTjsy(String value) {
        this.tjsy = value;
    }
    /**
     * 获取:提交使用
     */
    public String getTjsy() {
        return tjsy;
    }
    /**
     * 设置:医技类型
     */
    public void setYjlx(Integer value) {
        this.yjlx = value;
    }
    /**
     * 获取:医技类型
     */
    public Integer getYjlx() {
        return yjlx;
    }
    /**
     * 设置:检查知情同意书
     */
    public void setJczqtys(String value) {
        this.jczqtys = value;
    }
    /**
     * 获取:检查知情同意书
     */
    public String getJczqtys() {
        return jczqtys;
    }
    /**
     * 设置:注意事项
     */
    public void setZysx(String value) {
        this.zysx = value;
    }
    /**
     * 获取:注意事项
     */
    public String getZysx() {
        return zysx;
    }
    /**
     * 设置:执行科室
     */
    public void setZxks(Integer value) {
        this.zxks = value;
    }
    /**
     * 获取:执行科室
     */
    public Integer getZxks() {
        return zxks;
    }

    public List<DiccZlsfdzReq> getDiccZlsfdzEditReqList() {
        return diccZlsfdzEditReqList;
    }

    public void setDiccZlsfdzEditReqList(List<DiccZlsfdzReq> diccZlsfdzEditReqList) {
        this.diccZlsfdzEditReqList = diccZlsfdzEditReqList;
    }
}
