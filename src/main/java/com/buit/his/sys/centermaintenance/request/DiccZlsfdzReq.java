
package com.buit.his.sys.centermaintenance.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：DiccZlsfdz<br>
 * 类描述：诊疗收费对照<br>
 *
 * @author 老花生
 */
@ApiModel(value = "诊疗收费对照")
public class DiccZlsfdzReq {
    @ApiModelProperty(value = "主键记录序号")
    private Integer jlxh;
    @ApiModelProperty(value = "诊疗项目ID")
    private Integer zlxmid;
    @ApiModelProperty(value = "费用序号")
    private Integer fyxh;
    @ApiModelProperty(value = "费用数量")
    private Integer fysl;

    /**
     * 设置:主键记录序号
     */
    public void setJlxh(Integer value) {
        this.jlxh = value;
    }

    /**
     * 获取:主键记录序号
     */
    public Integer getJlxh() {
        return jlxh;
    }

    /**
     * 设置:诊疗项目ID
     */
    public void setZlxmid(Integer value) {
        this.zlxmid = value;
    }

    /**
     * 获取:诊疗项目ID
     */
    public Integer getZlxmid() {
        return zlxmid;
    }

    /**
     * 设置:费用序号
     */
    public void setFyxh(Integer value) {
        this.fyxh = value;
    }

    /**
     * 获取:费用序号
     */
    public Integer getFyxh() {
        return fyxh;
    }

    /**
     * 设置:费用数量
     */
    public void setFysl(Integer value) {
        this.fysl = value;
    }

    /**
     * 获取:费用数量
     */
    public Integer getFysl() {
        return fysl;
    }
}
