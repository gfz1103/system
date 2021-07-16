-- 设备类型表
CREATE TABLE `his`.`sys_device_type`
(
    `TYPE_ID`              int(0)                                                        NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `TYPE_NAME`            varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NULL DEFAULT NULL COMMENT '名称',
    `MODEL`                varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '型号',
    `MANUFACTURER_NAME`    varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '厂商名称',
    `MANUFACTURER_TEL`     varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NULL DEFAULT NULL COMMENT '厂商电话',
    `MANUFACTURER_ADDRESS` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '厂商地址',
    `DRIVER_LOCATION`      text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci         NULL COMMENT '默认驱动安装地址',
    `HTTP_PORT`            varchar(10)                                                   NULL COMMENT '默认HTTP端口',
    `HTTPS_PORT`           varchar(10)                                                   NULL COMMENT '默认HTTPS端口',
    PRIMARY KEY (`TYPE_ID`)
);

-- 设备终端表
CREATE TABLE `his`.`dic_device`
(
    `DEVICE_ID`      int         NOT NULL AUTO_INCREMENT COMMENT '设备序列号',
    `TYPE_ID`        int         NOT NULL COMMENT '设备类型ID | 关联dic_device_type.id',
    `JGID`           int         NOT NULL COMMENT '医疗机构代码',
    `IP`             varchar(20) NOT NULL COMMENT 'ip地址',
    `INVOKING_WAY`   int         NULL COMMENT '调用方式 | 1：厂家提供可安装的本地服务 2：发布java程序调用动态库',
    `DIVER_LOCATION` text        NULL COMMENT '驱动地址 | 本地服务或tomcat启动exe/bat可执行文件所在目录的绝对路径(包含文件名)',
    `DLL_LOCATION`   text        NULL COMMENT '依赖地址 | 动态库dll/so文件所在目录的绝对路径(包含文件名)',
    `HTTP_PORT`      varchar(10) NULL COMMENT 'HTTP端口号',
    `HTTPS_PORT`     varchar(10) NULL COMMENT 'HTTPS端口号',
    `STATUS`         int         NOT NULL COMMENT '设备状态 | 0：启用， 1：停用',
    PRIMARY KEY (`DEVICE_ID`)
);

-- 设备调用接口表
CREATE TABLE `his`.`dic_device_interface`
(
    `INTERFACE_ID`   int          NOT NULL AUTO_INCREMENT COMMENT '接口标识',
    `INTERFACE_NAME` varchar(100) NOT NULL COMMENT '接口名称',
    `TYPE_ID`        int          NOT NULL COMMENT '设备类型ID | 关联dic_device_type.id',
    `URL`            varchar(200) NOT NULL COMMENT '接口调用地址',
    `DESCRIPTION`    text         NULL COMMENT '功能描述',
    `RESULT_EXAMPLE` text         NULL COMMENT '接口返回示例',
    PRIMARY KEY (`INTERFACE_ID`)
);

