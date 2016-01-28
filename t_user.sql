/*
Navicat MySQL Data Transfer

Source Server         : 10.0.0.251_3306
Source Server Version : 50616
Source Host           : 10.0.0.251:3306
Source Database       : account_center2

Target Server Type    : MYSQL
Target Server Version : 50616
File Encoding         : 65001

Date: 2016-01-28 15:03:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(255) NOT NULL,
  `birth` datetime DEFAULT NULL,
  `name` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `sex` tinyint(1) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
