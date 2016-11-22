-- ----------------------------
-- Table structure for holiday_info
-- ----------------------------
DROP TABLE IF EXISTS `holiday_info`;
CREATE TABLE `holiday_info` (
  `ID` varchar(32) NOT NULL,
  `delflag` char(1) DEFAULT '0',
  `create_date` datetime DEFAULT NULL,
  `modify_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `username` varchar(32) DEFAULT NULL,
  `inputer` varchar(32) DEFAULT NULL,
  `checker` varchar(32) DEFAULT NULL,
  `sts` char(1) DEFAULT '0',
  `country` varchar(3) DEFAULT NULL,
  `market_type` varchar(16) DEFAULT NULL,
  `holiday_date` date DEFAULT NULL,
  `holiday_reason` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;


INSERT INTO `holiday_info` VALUES ('1bj7i4demiegm', '0', '2015-12-25 16:09:01', '2015-12-25 16:09:16', 'alice', NULL, NULL, '0', 'CNY', 'CIB', '2018-4-1', '双休日');
INSERT INTO `holiday_info` VALUES ('1bj7i4fgeq6gn', '0', '2015-12-25 16:09:01', '2015-12-25 16:09:16', 'alice', NULL, NULL, '0', 'CNY', 'CIB', '2018-4-5', '清明节');