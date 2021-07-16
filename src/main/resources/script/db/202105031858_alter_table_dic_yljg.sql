ALTER TABLE `his`.`dic_yljg` MODIFY COLUMN `SETUP_DATE` date COMMENT '医院成立日期';
ALTER TABLE `his`.`dic_yljg` MODIFY COLUMN `REVOKE_DATE` date  COMMENT '医院注销日期';
--医院成立日期 注销日期改成yyyy-mm-dd 格式
