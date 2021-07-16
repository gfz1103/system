CREATE TABLE `im_dic_ypyf_fjjf`  (
  `ID` int(0) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `YPYF` int(0) NULL COMMENT '药品用法序号',
  `FYXH` int(0) NULL COMMENT '附加项目',
  `JFFS` int(0) NULL COMMENT '计费方式1.按频次2.按日3.按频次每日最大数',
  `JFSL` int(0) NULL COMMENT '计费数量',
  `PCBM` varchar(6) NULL COMMENT '频次编码',
  `JGID` int(0) NULL COMMENT '机构id',
  PRIMARY KEY (`ID`)
) COMMENT = '住院_药品用法_附加计费';