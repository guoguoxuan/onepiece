/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : db_ly

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2017-08-07 16:05:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_grade`
-- ----------------------------
DROP TABLE IF EXISTS `t_grade`;
CREATE TABLE `t_grade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gradeName` varchar(50) NOT NULL,
  `gradeDesc` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_grade
-- ----------------------------
INSERT INTO `t_grade` VALUES ('1', '08计算机', '08计算机本科');
INSERT INTO `t_grade` VALUES ('2', '09计算机', '09计算机本科');
INSERT INTO `t_grade` VALUES ('3', 'XX', 'XXXX');
INSERT INTO `t_grade` VALUES ('8', 'XX', 'XXXX');
INSERT INTO `t_grade` VALUES ('13', 'XX', 'XXXX');
INSERT INTO `t_grade` VALUES ('18', 'XX', 'XXXX');
INSERT INTO `t_grade` VALUES ('19', 'XX', 'XXXX');
INSERT INTO `t_grade` VALUES ('20', 'XX', 'XXXX');
INSERT INTO `t_grade` VALUES ('22', 'SS', 'SSSS');
INSERT INTO `t_grade` VALUES ('23', 'SS', 'SSSS');
INSERT INTO `t_grade` VALUES ('24', 'SS', 'SSSS');
INSERT INTO `t_grade` VALUES ('25', 'SS', 'SSSS');
INSERT INTO `t_grade` VALUES ('26', 'SS', 'SSSS');
INSERT INTO `t_grade` VALUES ('27', 'SS', 'SSSS');
INSERT INTO `t_grade` VALUES ('28', 'SS', 'SSSS');
INSERT INTO `t_grade` VALUES ('29', 'SS', 'SSSS');
INSERT INTO `t_grade` VALUES ('30', 'SS', 'SSSS');
INSERT INTO `t_grade` VALUES ('31', 'SS', 'SSSS');
INSERT INTO `t_grade` VALUES ('32', 'SS', 'SSSS');
INSERT INTO `t_grade` VALUES ('33', 'SS', 'SSSS');
INSERT INTO `t_grade` VALUES ('34', 'SS', 'SSSS');
INSERT INTO `t_grade` VALUES ('35', 'SS', 'SSSS');
INSERT INTO `t_grade` VALUES ('36', 'SS', 'SSSS');
INSERT INTO `t_grade` VALUES ('37', 'SS', 'SSSS');
INSERT INTO `t_grade` VALUES ('38', 'SS', 'SSSS');
INSERT INTO `t_grade` VALUES ('39', 'SS', 'SSSS');
INSERT INTO `t_grade` VALUES ('40', 'SS', 'SSSS');
INSERT INTO `t_grade` VALUES ('41', 'SS', 'SSSS');
INSERT INTO `t_grade` VALUES ('42', 'SS', 'SSSS');
INSERT INTO `t_grade` VALUES ('43', 'SS', 'SSSS');
INSERT INTO `t_grade` VALUES ('44', 'SS', 'SSSS');
INSERT INTO `t_grade` VALUES ('45', 'SS', 'SSSS');
