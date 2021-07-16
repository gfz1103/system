//   
//package com.buit.his.user.response;
//
//import java.sql.Timestamp;
//
//import com.buit.his.commons.PageQuery;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//
//
///**
// * 类名称：SysMenu<br> 
// * 类描述：系统菜单表<br>
// */
//@ApiModel(value="系统菜单表")
//public class SysMenuResp  extends  PageQuery{
//    @ApiModelProperty(value="菜单数据ID")
//    private Integer menuId;
//    @ApiModelProperty(value="数据版本")
//    private Integer dataVersion;
//    @ApiModelProperty(value="数据创建时间")
//    private Timestamp gmtCreate;
//    @ApiModelProperty(value="数据修改时间")
//    private Timestamp gmtModify;
//    @ApiModelProperty(value="医疗机构ID")
//    private Integer hospitalId;
//    @ApiModelProperty(value="菜单代码")
//    private String menuCode;
//    @ApiModelProperty(value="菜单名称")
//    private String menuName;
//    @ApiModelProperty(value="父类菜单ID")
//    private Integer parentMenuId;
//    @ApiModelProperty(value="菜单对应模板ID")
//    private Integer modelId;
//    @ApiModelProperty(value="标准菜单标识")
//    private String basicMenuFlag;
//    @ApiModelProperty(value="菜单类型标识")
//    private String modelTypeFlag;
//    @ApiModelProperty(value="排序")
//    private Integer menuSort;
//    @ApiModelProperty(value="图标")
//    private String menuIcon;
//    @ApiModelProperty(value="显示标识")
//    private String displayFlag;
//    @ApiModelProperty(value="拼音码")
//    private String pyCode;
//    @ApiModelProperty(value="五笔码")
//    private String wbCode;
//    @ApiModelProperty(value="菜单类别")
//    private Integer menuLevel;
//    @ApiModelProperty(value="系统类别")
//    private String sysType;
//    @ApiModelProperty(value="菜单指向地址")
//    private String menuUrl;
//    @ApiModelProperty(value="菜单图标")
//    private String menuStyle;
//    @ApiModelProperty(value="操作类型")
//    private String actionType;
//    @ApiModelProperty(value="动态路由")
//    private String routeName;
//    @ApiModelProperty(value="自定义报表ID")
//    private Integer reportId;
//    @ApiModelProperty(value="模块说明")
//    private String modelRemark;
//    @ApiModelProperty(value="模块对应控制器名称，插件式模块的特殊要求")
//    private String modelFunName;
//    @ApiModelProperty(value="模块对应文件路径")
//    private String modelFilePath;
//    /**
//     * 设置:菜单数据ID
//     */
//    public void setMenuId(Integer value) {
//        this.menuId = value;
//    }
//    /**
//     * 获取:菜单数据ID
//     */
//    public Integer getMenuId() {
//        return menuId;
//    }
//    /**
//     * 设置:数据版本
//     */
//    public void setDataVersion(Integer value) {
//        this.dataVersion = value;
//    }
//    /**
//     * 获取:数据版本
//     */
//    public Integer getDataVersion() {
//        return dataVersion;
//    }
//    /**
//     * 设置:数据创建时间
//     */
//    public void setGmtCreate(Timestamp value) {
//        this.gmtCreate = value;
//    }
//    /**
//     * 获取:数据创建时间
//     */
//    public Timestamp getGmtCreate() {
//        return gmtCreate;
//    }
//    /**
//     * 设置:数据修改时间
//     */
//    public void setGmtModify(Timestamp value) {
//        this.gmtModify = value;
//    }
//    /**
//     * 获取:数据修改时间
//     */
//    public Timestamp getGmtModify() {
//        return gmtModify;
//    }
//    /**
//     * 设置:医疗机构ID
//     */
//    public void setHospitalId(Integer value) {
//        this.hospitalId = value;
//    }
//    /**
//     * 获取:医疗机构ID
//     */
//    public Integer getHospitalId() {
//        return hospitalId;
//    }
//    /**
//     * 设置:菜单代码
//     */
//    public void setMenuCode(String value) {
//        this.menuCode = value;
//    }
//    /**
//     * 获取:菜单代码
//     */
//    public String getMenuCode() {
//        return menuCode;
//    }
//    /**
//     * 设置:菜单名称
//     */
//    public void setMenuName(String value) {
//        this.menuName = value;
//    }
//    /**
//     * 获取:菜单名称
//     */
//    public String getMenuName() {
//        return menuName;
//    }
//    /**
//     * 设置:父类菜单ID
//     */
//    public void setParentMenuId(Integer value) {
//        this.parentMenuId = value;
//    }
//    /**
//     * 获取:父类菜单ID
//     */
//    public Integer getParentMenuId() {
//        return parentMenuId;
//    }
//    /**
//     * 设置:菜单对应模板ID
//     */
//    public void setModelId(Integer value) {
//        this.modelId = value;
//    }
//    /**
//     * 获取:菜单对应模板ID
//     */
//    public Integer getModelId() {
//        return modelId;
//    }
//    /**
//     * 设置:标准菜单标识
//     */
//    public void setBasicMenuFlag(String value) {
//        this.basicMenuFlag = value;
//    }
//    /**
//     * 获取:标准菜单标识
//     */
//    public String getBasicMenuFlag() {
//        return basicMenuFlag;
//    }
//    /**
//     * 设置:菜单类型标识
//     */
//    public void setModelTypeFlag(String value) {
//        this.modelTypeFlag = value;
//    }
//    /**
//     * 获取:菜单类型标识
//     */
//    public String getModelTypeFlag() {
//        return modelTypeFlag;
//    }
//    /**
//     * 设置:排序
//     */
//    public void setMenuSort(Integer value) {
//        this.menuSort = value;
//    }
//    /**
//     * 获取:排序
//     */
//    public Integer getMenuSort() {
//        return menuSort;
//    }
//    /**
//     * 设置:图标
//     */
//    public void setMenuIcon(String value) {
//        this.menuIcon = value;
//    }
//    /**
//     * 获取:图标
//     */
//    public String getMenuIcon() {
//        return menuIcon;
//    }
//    /**
//     * 设置:显示标识
//     */
//    public void setDisplayFlag(String value) {
//        this.displayFlag = value;
//    }
//    /**
//     * 获取:显示标识
//     */
//    public String getDisplayFlag() {
//        return displayFlag;
//    }
//    /**
//     * 设置:拼音码
//     */
//    public void setPyCode(String value) {
//        this.pyCode = value;
//    }
//    /**
//     * 获取:拼音码
//     */
//    public String getPyCode() {
//        return pyCode;
//    }
//    /**
//     * 设置:五笔码
//     */
//    public void setWbCode(String value) {
//        this.wbCode = value;
//    }
//    /**
//     * 获取:五笔码
//     */
//    public String getWbCode() {
//        return wbCode;
//    }
//    /**
//     * 设置:菜单类别
//     */
//    public void setMenuLevel(Integer value) {
//        this.menuLevel = value;
//    }
//    /**
//     * 获取:菜单类别
//     */
//    public Integer getMenuLevel() {
//        return menuLevel;
//    }
//    /**
//     * 设置:系统类别
//     */
//    public void setSysType(String value) {
//        this.sysType = value;
//    }
//    /**
//     * 获取:系统类别
//     */
//    public String getSysType() {
//        return sysType;
//    }
//    /**
//     * 设置:菜单指向地址
//     */
//    public void setMenuUrl(String value) {
//        this.menuUrl = value;
//    }
//    /**
//     * 获取:菜单指向地址
//     */
//    public String getMenuUrl() {
//        return menuUrl;
//    }
//    /**
//     * 设置:菜单图标
//     */
//    public void setMenuStyle(String value) {
//        this.menuStyle = value;
//    }
//    /**
//     * 获取:菜单图标
//     */
//    public String getMenuStyle() {
//        return menuStyle;
//    }
//    /**
//     * 设置:操作类型
//     */
//    public void setActionType(String value) {
//        this.actionType = value;
//    }
//    /**
//     * 获取:操作类型
//     */
//    public String getActionType() {
//        return actionType;
//    }
//    /**
//     * 设置:动态路由
//     */
//    public void setRouteName(String value) {
//        this.routeName = value;
//    }
//    /**
//     * 获取:动态路由
//     */
//    public String getRouteName() {
//        return routeName;
//    }
//    /**
//     * 设置:自定义报表ID
//     */
//    public void setReportId(Integer value) {
//        this.reportId = value;
//    }
//    /**
//     * 获取:自定义报表ID
//     */
//    public Integer getReportId() {
//        return reportId;
//    }
//    /**
//     * 设置:模块说明
//     */
//    public void setModelRemark(String value) {
//        this.modelRemark = value;
//    }
//    /**
//     * 获取:模块说明
//     */
//    public String getModelRemark() {
//        return modelRemark;
//    }
//    /**
//     * 设置:模块对应控制器名称，插件式模块的特殊要求
//     */
//    public void setModelFunName(String value) {
//        this.modelFunName = value;
//    }
//    /**
//     * 获取:模块对应控制器名称，插件式模块的特殊要求
//     */
//    public String getModelFunName() {
//        return modelFunName;
//    }
//    /**
//     * 设置:模块对应文件路径
//     */
//    public void setModelFilePath(String value) {
//        this.modelFilePath = value;
//    }
//    /**
//     * 获取:模块对应文件路径
//     */
//    public String getModelFilePath() {
//        return modelFilePath;
//    }
//}