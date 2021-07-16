ALTER TABLE `his`.`sys_device_type` comment '办公设备型号表';
ALTER TABLE `his`.`dic_device` comment '办公设备表';
ALTER TABLE `his`.`dic_device_interface` comment '办公设备调用接口表';

ALTER TABLE `his`.`dic_device`
    ADD COLUMN `SERIAL_NUMBER` varchar(30) NOT NULL COMMENT '设备序列号' AFTER `DEVICE_ID`,
    MODIFY COLUMN `DEVICE_ID` int(0) NOT NULL AUTO_INCREMENT COMMENT '设备主键' FIRST,
    MODIFY COLUMN `TYPE_ID` int(0) NOT NULL COMMENT '设备类型ID | 关联dic_device_type.type_id' AFTER `DEVICE_ID`;

ALTER TABLE `his`.`dic_device_interface`
    MODIFY COLUMN `TYPE_ID` int(0) NOT NULL COMMENT '设备类型ID | 关联dic_device_type.type_id' AFTER `INTERFACE_NAME`;