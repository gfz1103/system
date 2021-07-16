CREATE TABLE `dic_ssbm` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ssmc` varchar(255) DEFAULT NULL COMMENT '手术名称',
  `icd_code` varchar(255) DEFAULT NULL COMMENT 'icd码',
  `ssdj` int DEFAULT NULL COMMENT '手术等级',
  `pydm` varchar(255) DEFAULT NULL COMMENT '拼音代码',
  `zfbz` int(10) unsigned zerofill DEFAULT NULL COMMENT '作废标志，1：作废，0：未作废',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='手术编码表';
ALTER TABLE `his`.`cmo_ssxmgx`
CHANGE COLUMN `jbxh` `ssxh` int(0) NULL DEFAULT NULL COMMENT '疾病序号' AFTER `fyxh`;

ALTER TABLE sys_group ADD COLUMN SYSTEM_TYPE int(0) DEFAULT NULL COMMENT '系统类型';

