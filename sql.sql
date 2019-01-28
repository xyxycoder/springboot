/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50527
 Source Host           : localhost:3306
 Source Schema         : itxy

 Target Server Type    : MySQL
 Target Server Version : 50527
 File Encoding         : 65001

 Date: 28/01/2019 14:35:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `password_salt` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '盐值',
  `last_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后登录时间',
  `create_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `is_lock` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号是否锁定 0：否，1：锁定',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号是否删除 0：否，1：是',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 47 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (43, 'wj', 'ec08ad85f0296f9ea71ee63e60629424', 'c7723fbd120376270f2f6b134b0771be', '2019-01-17 11:00:35', '2019-01-17 11:00:35', '0', '0');
INSERT INTO `user` VALUES (44, 'xy', 'ecdc3441829c9363c2231cd322ce46f2', '5a565c023afd873eb64161d5ea33f1fa', '2019-01-17 14:49:33', '2019-01-17 14:49:33', '0', '0');
INSERT INTO `user` VALUES (45, 'qwer', 'be97874fbd8b61ab981c3a03c2a73678', '04490ecb6b3602a77202e739a40e36be', '2019-01-17 16:40:00', '2019-01-17 16:40:00', '0', '0');
INSERT INTO `user` VALUES (46, 'wjw', '78cfa4ea3eb76c483bfd8756f1df01dc', '06e1ecdd0313d6c1f22c3c4061d4c15c', '2019-01-24 10:28:31', '2019-01-24 10:28:30', '0', '0');

SET FOREIGN_KEY_CHECKS = 1;
