ALTER TABLE `hr_personnel`
ADD COLUMN `WZFS` varchar(3) default '001' NOT NULL COMMENT '互联网问诊方式，三位配置，第一位视频问诊 第二位语音问诊 第三位图文问诊 图文问诊为1' ;
