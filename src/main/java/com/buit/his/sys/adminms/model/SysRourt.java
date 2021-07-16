package com.buit.his.sys.adminms.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名称：SysRourt<br> 
 * 类描述：前台发布端口
 * @author DESKTOP-OK78BUA 
 * @ApiModel(value="前台发布端口")
 */
public class SysRourt  {
	//@ApiModelProperty(value="rourtId")
    /** rourtId */
    private Integer rourtId;
	//@ApiModelProperty(value="module")
    /** module */
    private String module;
	//@ApiModelProperty(value="1表示为true,0表示为false")
    /** 1表示为true,0表示为false */
    private Boolean defaultRegister;
	//@ApiModelProperty(value="devEntry")
    /** devEntry */
    private String devEntry;
	//@ApiModelProperty(value="depEntry")
    /** depEntry */
    private String depEntry;
	//@ApiModelProperty(value="routerBase")
    /** routerBase */
    private String routerBase;
    private List<String> data =new ArrayList<>();
    
    public List<String> getData() {
		return data;
	}
	public void setData(List<String> data) {
		this.data = data;
	}
	/** 设置:rourtId  */
    public void setRourtId(Integer value) {
        this.rourtId = value;
    }
    /** 获取:rourtId */
    public Integer getRourtId() {
        return rourtId;
    }

    /** 设置:module  */
    public void setModule(String value) {
        this.module = value;
    }
    /** 获取:module */
    public String getModule() {
        return module;
    }

    /** 设置:1表示为true,0表示为false  */
    public void setDefaultRegister(Boolean value) {
        this.defaultRegister = value;
    }
    /** 获取:1表示为true,0表示为false */
    public Boolean getDefaultRegister() {
        return defaultRegister;
    }

    /** 设置:devEntry  */
    public void setDevEntry(String value) {
        this.devEntry = value;
    }
    /** 获取:devEntry */
    public String getDevEntry() {
        return devEntry;
    }

    /** 设置:depEntry  */
    public void setDepEntry(String value) {
        this.depEntry = value;
    }
    /** 获取:depEntry */
    public String getDepEntry() {
        return depEntry;
    }

    /** 设置:routerBase  */
    public void setRouterBase(String value) {
        this.routerBase = value;
    }
    /** 获取:routerBase */
    public String getRouterBase() {
        return routerBase;
    }


}