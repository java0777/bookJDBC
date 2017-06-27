/*
Navicat MySQL Data Transfer

Source Server         : 本地连接5.5
Source Server Version : 50530
Source Host           : localhost:3306
Source Database       : bookdata

Target Server Type    : MYSQL
Target Server Version : 50530
File Encoding         : 65001

Date: 2017-06-27 17:18:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(255) DEFAULT NULL COMMENT '书籍名',
  `author` varchar(255) DEFAULT NULL COMMENT '书籍作者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', '亵渎', '烟雨江南');

-- ----------------------------
-- Table structure for book_catalog
-- ----------------------------
DROP TABLE IF EXISTS `book_catalog`;
CREATE TABLE `book_catalog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_id` int(11) DEFAULT NULL COMMENT '书籍相关主键',
  `catalog_name` varchar(255) DEFAULT NULL COMMENT '章节名',
  `file_dir` varchar(255) DEFAULT NULL COMMENT '相关文件所在目录',
  `file_name` varchar(255) DEFAULT NULL COMMENT '相关文件名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book_catalog
-- ----------------------------
