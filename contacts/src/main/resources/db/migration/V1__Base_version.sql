DROP TABLE IF EXISTS sys_user ;
CREATE TABLE `sys_user` (
  `ID` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '主键',
  `name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户名',
  `account` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '账号',
  `password` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='系统用户表';

DROP TABLE IF EXISTS contact ;
CREATE TABLE `contact` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `phone_number` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `email_address` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;