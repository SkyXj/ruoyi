/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.1.246
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : 192.168.1.246:3306
 Source Schema         : voyage

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 28/05/2020 09:51:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for zh_point
-- ----------------------------
DROP TABLE IF EXISTS `zh_point`;
CREATE TABLE `zh_point`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `lng` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '经度',
  `lat` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '纬度',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '敏感点' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of zh_point
-- ----------------------------
INSERT INTO `zh_point` VALUES (1, '示例敏感点', NULL, NULL, 'test', '2020-04-29 09:48:28', '', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
