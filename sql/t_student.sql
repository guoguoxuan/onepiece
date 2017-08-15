/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : db_ly

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2017-08-15 08:29:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_student`
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `stuId` int(11) NOT NULL AUTO_INCREMENT,
  `stuNo` varchar(20) DEFAULT NULL,
  `stuName` varchar(20) DEFAULT NULL,
  `sex` varchar(20) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `gradeId` int(11) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `stuDesc` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`stuId`),
  KEY `gradeId` (`gradeId`),
  CONSTRAINT `t_student_ibfk_1` FOREIGN KEY (`gradeId`) REFERENCES `t_grade` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('1', '080606119', '小美', '女', '1999-11-03', '8', '3344768@qq.com', 'Good Girls');
INSERT INTO `t_student` VALUES ('2', '080606119', '小美', '女', '1999-11-03', '8', '3344768@qq.com', 'Good Girls');
INSERT INTO `t_student` VALUES ('3', '080606119', '小美', '女', '1999-11-03', '1', '3344768@qq.com', 'Good Girls');
INSERT INTO `t_student` VALUES ('4', '080606119', '小美', '女', '1999-11-03', '1', '3344768@qq.com', 'Good Girls');
INSERT INTO `t_student` VALUES ('19', '080606119', '小美', '女', '1999-11-03', '1', '3344768@qq.com', 'Good Girls');
INSERT INTO `t_student` VALUES ('20', '080606119', '小美', '女', '1999-11-03', '1', '3344768@qq.com', 'Good Girls');
INSERT INTO `t_student` VALUES ('21', '080606119', '小美', '女', '1999-11-03', '1', '3344768@qq.com', 'Good Girls');
INSERT INTO `t_student` VALUES ('22', '080606119', '小美', '女', '1999-11-03', '1', '3344768@qq.com', 'Good Girls');
INSERT INTO `t_student` VALUES ('23', '080606110', '张三', '男', '1989-11-03', '1', '107878@qq.com', 'Good');
INSERT INTO `t_student` VALUES ('24', '080606110', '张三', '男', '1989-11-03', '1', '107878@qq.com', 'Good');
INSERT INTO `t_student` VALUES ('45', '080606110', '张三', '男', '1989-11-03', '1', '107878@qq.com', 'Good');
INSERT INTO `t_student` VALUES ('46', '080606110', '张三', '男', '1989-11-03', '1', '107878@qq.com', 'Good');
INSERT INTO `t_student` VALUES ('47', '080606110', '张三', '男', '1989-11-03', '1', '107878@qq.com', 'Good');
INSERT INTO `t_student` VALUES ('48', '080606110', '张三', '男', '1989-11-03', '1', '107878@qq.com', 'Good');
INSERT INTO `t_student` VALUES ('49', '080606110', '张三', '男', '1989-11-03', '1', '107878@qq.com', 'Good');
INSERT INTO `t_student` VALUES ('50', '080606110', '张三', '男', '1989-11-03', '1', '107878@qq.com', 'Good');
INSERT INTO `t_student` VALUES ('51', '080606110', '张三', '男', '1989-11-03', '1', '107878@qq.com', 'Good');
INSERT INTO `t_student` VALUES ('52', '080606110', '张三', '男', '1989-11-03', '1', '107878@qq.com', 'Good');
INSERT INTO `t_student` VALUES ('53', '080606110', '张三', '男', '1989-11-03', '1', '107878@qq.com', 'Good');
INSERT INTO `t_student` VALUES ('54', '080606110', '张三', '男', '1989-11-03', '1', '107878@qq.com', 'Good');
INSERT INTO `t_student` VALUES ('55', '080606110', '张三', '男', '1989-11-03', '1', '107878@qq.com', 'Good');
INSERT INTO `t_student` VALUES ('56', '080606110', '张三', '男', '1989-11-03', '1', '107878@qq.com', 'Good');
INSERT INTO `t_student` VALUES ('57', '080606110', '张三', '男', '1989-11-03', '1', '107878@qq.com', 'Good');
INSERT INTO `t_student` VALUES ('62', '111', '111', '男', '2017-07-31', '13', '111@qq.com', '11111');
INSERT INTO `t_student` VALUES ('63', '111', '111', '女', '2017-07-31', '13', '111@qq.com', '1111');
INSERT INTO `t_student` VALUES ('64', '2222', '2222', '女', '2017-07-31', '23', '222@qq.com', '');
