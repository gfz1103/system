CREATE TABLE `gzhc_tjkc_log`  (
  `JLXH` int(0) NOT NULL COMMENT '记录序号',
  `JGID` int(0) NULL DEFAULT NULL COMMENT '机构id',
  `TJDH` int(0) NOT NULL COMMENT '调价单号 | 关联 fee_xmfytj01.TJDH',
  `SBXH` int(0) NOT NULL COMMENT '识别序号 | 关联 fee_xmfytj02.SBXH',
  `FYXH` int(0) NOT NULL COMMENT '费用序号 | 关联 fee_ylsfxm.FYXH',
  `KSDM` int(0) NOT NULL COMMENT '病区ID | 关联 dic_kszd.ID',
  `GG` varchar(50) NOT NULL COMMENT '规格',
  `XH` varchar(50) NOT NULL COMMENT '型号',
  `DW` varchar(50) NOT NULL COMMENT '单位',
  `YBBM` varchar(100) NOT NULL COMMENT '医保编码',
  `SCCJ` varchar(200) NOT NULL COMMENT '生产厂家',
  `JHJG` decimal(8, 4) NOT NULL COMMENT '进货价格',
  `KCSL` decimal(8, 4) NOT NULL COMMENT '库存数量',
  `SXRQ` datetime(0) NOT NULL COMMENT '生效日期',
  PRIMARY KEY (`JLXH`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '高值耗材调价库存日志表' ROW_FORMAT = Dynamic;