package com.buit.his.sys.openapi.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @Author sunjx
 * @Date 2020-12-15 15:36
 * @Description
 **/
@ApiModel("收费项目明细详情响应")
public class QuerySfxmmxDetailResponse {

    @ApiModelProperty(value = "病案首页归并")
    private Integer basygb;
    @ApiModelProperty(value = "病案首页项目")
    private Integer basyxm;
    @ApiModelProperty(value = "报表归并")
    private Integer bbgb;
    @ApiModelProperty(value = "bbgb1")
    private Integer bbgb1;
    @ApiModelProperty(value = "笔画代码")
    private String bhdm;
    @ApiModelProperty(value = "blbz")
    private Integer blbz;
    @ApiModelProperty(value = "标准价格")
    private BigDecimal bzjg;
    @ApiModelProperty(value = "重复提醒标志")
    private Integer cftxbz;
    @ApiModelProperty(value = "材料标志")
    private Integer clbz;
    @ApiModelProperty(value = "材料项目分组合并 ")
    private String cldym;
    @ApiModelProperty(value = "dz")
    private String dz;
    @ApiModelProperty(value = "dzbh")
    private String dzbh;
    @ApiModelProperty(value = "flzzf")
    private Integer flzzf;
    @ApiModelProperty(value = "fydj")
    private BigDecimal fydj;
    @ApiModelProperty(value = "费用单位")
    private String fydw;
    @ApiModelProperty(value = "fyetjmbz")
    private String fyetjmbz;
    @ApiModelProperty(value = "费用归并")
    private Integer fygb;
    @ApiModelProperty(value = "fyjmbm")
    private String fyjmbm;
    @ApiModelProperty(value = "fyks")
    private Integer fyks;
    @ApiModelProperty(value = "fylb")
    private Integer fylb;
    @ApiModelProperty(value = "费用名称")
    private String fymc;
    @ApiModelProperty(value = "费用描述")
    private String fyms;
    @ApiModelProperty(value = "费用序号")
    private Integer fyxh;
    @ApiModelProperty(value = "gnxh")
    private Integer gnxh;
    @ApiModelProperty(value = "hlxmlb")
    private String hlxmlb;
    @ApiModelProperty(value = "hlzx")
    private Integer hlzx;
    @ApiModelProperty(value = "黄码编码")
    private String hmbm;
    @ApiModelProperty(value = "住院检查申请单")
    private Integer jcsq;
    @ApiModelProperty(value = "检查知情同意书")
    private String jczqtys;
    @ApiModelProperty(value = "jxcs")
    private String jxcs;
    @ApiModelProperty(value = "角形代码")
    private String jxdm;
    @ApiModelProperty(value = "jxxmlb")
    private String jxxmlb;
    @ApiModelProperty(value = "LIS类型")
    private Integer lislx;
    @ApiModelProperty(value = "mgh")
    private Integer mgh;
    @ApiModelProperty(value = "明细标志")
    private Integer mxbz;
    @ApiModelProperty(value = "门诊申请单")
    private Integer mzsq;
    @ApiModelProperty(value = "门诊使用")
    private Integer mzsy;
    @ApiModelProperty(value = "拼音代码")
    private String pydm;
    @ApiModelProperty(value = "其他代码")
    private String qtdm;
    @ApiModelProperty(value = "rislx")
    private Integer rislx;
    @ApiModelProperty(value = "是否参与绩效分析")
    private Integer sfjxfx;
    @ApiModelProperty(value = "ssstj")
    private Integer ssstj;
    @ApiModelProperty(value = "特殊检查")
    private Integer tjfy;
    @ApiModelProperty(value = "tsfy")
    private String tsfy;
    @ApiModelProperty(value = "特殊提示")
    private String tsts;
    @ApiModelProperty(value = "特殊项目类型")
    private String tsxmlx;
    @ApiModelProperty(value = "特殊治疗")
    private Integer txzl;
    @ApiModelProperty(value = "五笔代码")
    private String wbdm;
    @ApiModelProperty(value = "项目编码")
    private String xmbm;
    @ApiModelProperty(value = "项目分类 | 维护为GY_XMFLZD（项目分类字典）中的项目分类")
    private Integer xmfl;
    @ApiModelProperty(value = "项目科室")
    private Integer xmks;
    @ApiModelProperty(value = "项目类别 | 4.检验 5.检查 6.手术 7.治疗 8.护理 9.饮食 10.卫材 99.其他")
    private Integer xmlx;
    @ApiModelProperty(value = "医保编码")
    private String ybbm;
    @ApiModelProperty(value = "医保单位")
    private String ybdw;
    @ApiModelProperty(value = "医保名称")
    private String ybmc;
    @ApiModelProperty(value = "医保项目计费标志")
    private String ybxmjfbz;
    @ApiModelProperty(value = "yjck")
    private Integer yjck;
    @ApiModelProperty(value = "医技接口")
    private Integer yjjk;
    @ApiModelProperty(value = "医技类型")
    private Integer yjlx;
    @ApiModelProperty(value = "医技使用")
    private Integer yjsy;
    @ApiModelProperty(value = "ylxz")
    private BigDecimal ylxz;
    @ApiModelProperty(value = "材料规格")
    private String yyclgg;
    @ApiModelProperty(value = "医用品牌")
    private String yypp;
    @ApiModelProperty(value = "注册证号")
    private String zczh;
    @ApiModelProperty(value = "作废判别")
    private Integer zfpb;
    @ApiModelProperty(value = "总限额")
    private BigDecimal zjxe;
    @ApiModelProperty(value = "执行科室")
    private Integer zxks;
    @ApiModelProperty(value = "注意事项")
    private String zysx;
    @ApiModelProperty(value = "住院使用")
    private Integer zysy;
    @ApiModelProperty(value = "住院项目标志")
    private Integer zyxmbz;

    public Integer getBasygb() {
        return basygb;
    }

    public void setBasygb(Integer basygb) {
        this.basygb = basygb;
    }

    public Integer getBasyxm() {
        return basyxm;
    }

    public void setBasyxm(Integer basyxm) {
        this.basyxm = basyxm;
    }

    public Integer getBbgb() {
        return bbgb;
    }

    public void setBbgb(Integer bbgb) {
        this.bbgb = bbgb;
    }

    public Integer getBbgb1() {
        return bbgb1;
    }

    public void setBbgb1(Integer bbgb1) {
        this.bbgb1 = bbgb1;
    }

    public String getBhdm() {
        return bhdm;
    }

    public void setBhdm(String bhdm) {
        this.bhdm = bhdm;
    }

    public Integer getBlbz() {
        return blbz;
    }

    public void setBlbz(Integer blbz) {
        this.blbz = blbz;
    }

    public BigDecimal getBzjg() {
        return bzjg;
    }

    public void setBzjg(BigDecimal bzjg) {
        this.bzjg = bzjg;
    }

    public Integer getCftxbz() {
        return cftxbz;
    }

    public void setCftxbz(Integer cftxbz) {
        this.cftxbz = cftxbz;
    }

    public Integer getClbz() {
        return clbz;
    }

    public void setClbz(Integer clbz) {
        this.clbz = clbz;
    }

    public String getCldym() {
        return cldym;
    }

    public void setCldym(String cldym) {
        this.cldym = cldym;
    }

    public String getDz() {
        return dz;
    }

    public void setDz(String dz) {
        this.dz = dz;
    }

    public String getDzbh() {
        return dzbh;
    }

    public void setDzbh(String dzbh) {
        this.dzbh = dzbh;
    }

    public Integer getFlzzf() {
        return flzzf;
    }

    public void setFlzzf(Integer flzzf) {
        this.flzzf = flzzf;
    }

    public BigDecimal getFydj() {
        return fydj;
    }

    public void setFydj(BigDecimal fydj) {
        this.fydj = fydj;
    }

    public String getFydw() {
        return fydw;
    }

    public void setFydw(String fydw) {
        this.fydw = fydw;
    }

    public String getFyetjmbz() {
        return fyetjmbz;
    }

    public void setFyetjmbz(String fyetjmbz) {
        this.fyetjmbz = fyetjmbz;
    }

    public Integer getFygb() {
        return fygb;
    }

    public void setFygb(Integer fygb) {
        this.fygb = fygb;
    }

    public String getFyjmbm() {
        return fyjmbm;
    }

    public void setFyjmbm(String fyjmbm) {
        this.fyjmbm = fyjmbm;
    }

    public Integer getFyks() {
        return fyks;
    }

    public void setFyks(Integer fyks) {
        this.fyks = fyks;
    }

    public Integer getFylb() {
        return fylb;
    }

    public void setFylb(Integer fylb) {
        this.fylb = fylb;
    }

    public String getFymc() {
        return fymc;
    }

    public void setFymc(String fymc) {
        this.fymc = fymc;
    }

    public String getFyms() {
        return fyms;
    }

    public void setFyms(String fyms) {
        this.fyms = fyms;
    }

    public Integer getFyxh() {
        return fyxh;
    }

    public void setFyxh(Integer fyxh) {
        this.fyxh = fyxh;
    }

    public Integer getGnxh() {
        return gnxh;
    }

    public void setGnxh(Integer gnxh) {
        this.gnxh = gnxh;
    }

    public String getHlxmlb() {
        return hlxmlb;
    }

    public void setHlxmlb(String hlxmlb) {
        this.hlxmlb = hlxmlb;
    }

    public Integer getHlzx() {
        return hlzx;
    }

    public void setHlzx(Integer hlzx) {
        this.hlzx = hlzx;
    }

    public String getHmbm() {
        return hmbm;
    }

    public void setHmbm(String hmbm) {
        this.hmbm = hmbm;
    }

    public Integer getJcsq() {
        return jcsq;
    }

    public void setJcsq(Integer jcsq) {
        this.jcsq = jcsq;
    }

    public String getJczqtys() {
        return jczqtys;
    }

    public void setJczqtys(String jczqtys) {
        this.jczqtys = jczqtys;
    }

    public String getJxcs() {
        return jxcs;
    }

    public void setJxcs(String jxcs) {
        this.jxcs = jxcs;
    }

    public String getJxdm() {
        return jxdm;
    }

    public void setJxdm(String jxdm) {
        this.jxdm = jxdm;
    }

    public String getJxxmlb() {
        return jxxmlb;
    }

    public void setJxxmlb(String jxxmlb) {
        this.jxxmlb = jxxmlb;
    }

    public Integer getLislx() {
        return lislx;
    }

    public void setLislx(Integer lislx) {
        this.lislx = lislx;
    }

    public Integer getMgh() {
        return mgh;
    }

    public void setMgh(Integer mgh) {
        this.mgh = mgh;
    }

    public Integer getMxbz() {
        return mxbz;
    }

    public void setMxbz(Integer mxbz) {
        this.mxbz = mxbz;
    }

    public Integer getMzsq() {
        return mzsq;
    }

    public void setMzsq(Integer mzsq) {
        this.mzsq = mzsq;
    }

    public Integer getMzsy() {
        return mzsy;
    }

    public void setMzsy(Integer mzsy) {
        this.mzsy = mzsy;
    }

    public String getPydm() {
        return pydm;
    }

    public void setPydm(String pydm) {
        this.pydm = pydm;
    }

    public String getQtdm() {
        return qtdm;
    }

    public void setQtdm(String qtdm) {
        this.qtdm = qtdm;
    }

    public Integer getRislx() {
        return rislx;
    }

    public void setRislx(Integer rislx) {
        this.rislx = rislx;
    }

    public Integer getSfjxfx() {
        return sfjxfx;
    }

    public void setSfjxfx(Integer sfjxfx) {
        this.sfjxfx = sfjxfx;
    }

    public Integer getSsstj() {
        return ssstj;
    }

    public void setSsstj(Integer ssstj) {
        this.ssstj = ssstj;
    }

    public Integer getTjfy() {
        return tjfy;
    }

    public void setTjfy(Integer tjfy) {
        this.tjfy = tjfy;
    }

    public String getTsfy() {
        return tsfy;
    }

    public void setTsfy(String tsfy) {
        this.tsfy = tsfy;
    }

    public String getTsts() {
        return tsts;
    }

    public void setTsts(String tsts) {
        this.tsts = tsts;
    }

    public String getTsxmlx() {
        return tsxmlx;
    }

    public void setTsxmlx(String tsxmlx) {
        this.tsxmlx = tsxmlx;
    }

    public Integer getTxzl() {
        return txzl;
    }

    public void setTxzl(Integer txzl) {
        this.txzl = txzl;
    }

    public String getWbdm() {
        return wbdm;
    }

    public void setWbdm(String wbdm) {
        this.wbdm = wbdm;
    }

    public String getXmbm() {
        return xmbm;
    }

    public void setXmbm(String xmbm) {
        this.xmbm = xmbm;
    }

    public Integer getXmfl() {
        return xmfl;
    }

    public void setXmfl(Integer xmfl) {
        this.xmfl = xmfl;
    }

    public Integer getXmks() {
        return xmks;
    }

    public void setXmks(Integer xmks) {
        this.xmks = xmks;
    }

    public Integer getXmlx() {
        return xmlx;
    }

    public void setXmlx(Integer xmlx) {
        this.xmlx = xmlx;
    }

    public String getYbbm() {
        return ybbm;
    }

    public void setYbbm(String ybbm) {
        this.ybbm = ybbm;
    }

    public String getYbdw() {
        return ybdw;
    }

    public void setYbdw(String ybdw) {
        this.ybdw = ybdw;
    }

    public String getYbmc() {
        return ybmc;
    }

    public void setYbmc(String ybmc) {
        this.ybmc = ybmc;
    }

    public String getYbxmjfbz() {
        return ybxmjfbz;
    }

    public void setYbxmjfbz(String ybxmjfbz) {
        this.ybxmjfbz = ybxmjfbz;
    }

    public Integer getYjck() {
        return yjck;
    }

    public void setYjck(Integer yjck) {
        this.yjck = yjck;
    }

    public Integer getYjjk() {
        return yjjk;
    }

    public void setYjjk(Integer yjjk) {
        this.yjjk = yjjk;
    }

    public Integer getYjlx() {
        return yjlx;
    }

    public void setYjlx(Integer yjlx) {
        this.yjlx = yjlx;
    }

    public Integer getYjsy() {
        return yjsy;
    }

    public void setYjsy(Integer yjsy) {
        this.yjsy = yjsy;
    }

    public BigDecimal getYlxz() {
        return ylxz;
    }

    public void setYlxz(BigDecimal ylxz) {
        this.ylxz = ylxz;
    }

    public String getYyclgg() {
        return yyclgg;
    }

    public void setYyclgg(String yyclgg) {
        this.yyclgg = yyclgg;
    }

    public String getYypp() {
        return yypp;
    }

    public void setYypp(String yypp) {
        this.yypp = yypp;
    }

    public String getZczh() {
        return zczh;
    }

    public void setZczh(String zczh) {
        this.zczh = zczh;
    }

    public Integer getZfpb() {
        return zfpb;
    }

    public void setZfpb(Integer zfpb) {
        this.zfpb = zfpb;
    }

    public BigDecimal getZjxe() {
        return zjxe;
    }

    public void setZjxe(BigDecimal zjxe) {
        this.zjxe = zjxe;
    }

    public Integer getZxks() {
        return zxks;
    }

    public void setZxks(Integer zxks) {
        this.zxks = zxks;
    }

    public String getZysx() {
        return zysx;
    }

    public void setZysx(String zysx) {
        this.zysx = zysx;
    }

    public Integer getZysy() {
        return zysy;
    }

    public void setZysy(Integer zysy) {
        this.zysy = zysy;
    }

    public Integer getZyxmbz() {
        return zyxmbz;
    }

    public void setZyxmbz(Integer zyxmbz) {
        this.zyxmbz = zyxmbz;
    }
}
