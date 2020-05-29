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

 Date: 28/05/2020 09:52:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for zh_device
-- ----------------------------
DROP TABLE IF EXISTS `zh_device`;
CREATE TABLE `zh_device`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '设备id',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '设备名称',
  `code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '设备编号',
  `company` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '公司名称',
  `address` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '公司地址',
  `img` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '公司图片',
  `status` int(1) NOT NULL DEFAULT 0 COMMENT '采集状态:0 未开始,1 开始',
  `correct_status` int(1) NOT NULL DEFAULT 0 COMMENT '校正状态:0 未开始,1 开始',
  `weather_status` int(1) NOT NULL DEFAULT 0 COMMENT '天气状态:0 未开始,1 开始',
  `gps_status` int(1) NOT NULL DEFAULT 0 COMMENT '定位状态:0 未开始,1 开始',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of zh_device
-- ----------------------------
INSERT INTO `zh_device` VALUES (1, 'SPIMS', 'SPIMS-1001', '示例', '示例', NULL, 0, 0, 0, 0, 'test', '2020-04-29 09:48:15', '', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
