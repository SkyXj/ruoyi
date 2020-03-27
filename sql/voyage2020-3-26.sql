/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50623
 Source Host           : localhost:3306
 Source Schema         : voyage

 Target Server Type    : MySQL
 Target Server Version : 50623
 File Encoding         : 65001

 Date: 26/03/2020 21:37:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for gen_table
-- ----------------------------
DROP TABLE IF EXISTS `gen_table`;
CREATE TABLE `gen_table`  (
  `table_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `table_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '表名称',
  `table_comment` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '表描述',
  `class_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '实体类名称',
  `tpl_category` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT 'crud' COMMENT '使用的模板（crud单表操作 tree树表操作）',
  `package_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '生成包路径',
  `module_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '生成模块名',
  `business_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '生成业务名',
  `function_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '生成功能名',
  `function_author` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '生成功能作者',
  `options` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '其它生成选项',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`table_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '代码生成业务表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of gen_table
-- ----------------------------
INSERT INTO `gen_table` VALUES (1, 'zh_device', '设备名称', 'ZhDevice', 'crud', 'com.ruoyi.zh', 'zh', 'device', '走航', 'ruoyi', '{}', 'admin', '2020-02-23 17:11:04', '', '2020-02-24 19:40:31', NULL);
INSERT INTO `gen_table` VALUES (2, 'zh_collect_record', '走航记录', 'ZhCollectRecord', 'crud', 'com.ruoyi.zh', 'zh', 'collectRecord', '走航记录', 'ruoyi', '{}', 'admin', '2020-02-24 19:15:57', '', '2020-02-24 19:39:20', NULL);
INSERT INTO `gen_table` VALUES (4, 'zh_point', '控点', 'ZhPoint', 'crud', 'com.ruoyi.zh', 'zh', 'point', '控点', 'ruoyi', '{}', 'admin', '2020-02-24 21:00:11', '', '2020-02-24 21:00:49', NULL);
INSERT INTO `gen_table` VALUES (5, 'zh_color', '颜色', 'ZhColor', 'crud', 'com.ruoyi.zh', 'zh', 'color', '颜色', 'ruoyi', '{}', 'admin', '2020-03-03 17:56:33', '', '2020-03-03 17:57:45', NULL);
INSERT INTO `gen_table` VALUES (7, 'zh_simple_color', '物质因子颜色关联', 'ZhSimpleColor', 'crud', 'com.ruoyi.zh', 'zh', 'simpleColor', '物质因子颜色关联', 'ruoyi', '{}', 'admin', '2020-03-04 15:28:38', '', '2020-03-04 15:31:40', NULL);
INSERT INTO `gen_table` VALUES (8, 'zh_category', '颜色标准', 'ZhCategory', 'crud', 'com.ruoyi.zh', 'zh', 'category', '颜色标准', 'ruoyi', '{}', 'admin', '2020-03-04 15:28:53', '', '2020-03-04 15:32:05', NULL);
INSERT INTO `gen_table` VALUES (11, 'zh_factor', '因子表', 'ZhFactor', 'crud', 'com.ruoyi.zh', 'zh', 'factor', '因子', 'ruoyi', '{}', 'admin', '2020-03-04 16:03:49', '', '2020-03-04 16:04:04', NULL);
INSERT INTO `gen_table` VALUES (12, 'zh_link_category_factor_color', '物质因子颜色关联', 'ZhLinkCategoryFactorColor', 'crud', 'com.ruoyi.zh', 'zh', 'categoryFactorColor', '物质因子颜色关联', 'ruoyi', '{}', 'admin', '2020-03-04 17:23:56', '', '2020-03-04 17:24:56', NULL);
INSERT INTO `gen_table` VALUES (13, 'zh_link_category_factor_simple_color', '物质因子颜色关联', 'ZhLinkCategoryFactorSimpleColor', 'crud', 'com.ruoyi.zh', 'zh', 'categoryFactorSimpleColor', '物质因子颜色关联', 'ruoyi', '{}', 'admin', '2020-03-04 17:23:56', '', '2020-03-04 17:25:14', NULL);

-- ----------------------------
-- Table structure for gen_table_column
-- ----------------------------
DROP TABLE IF EXISTS `gen_table_column`;
CREATE TABLE `gen_table_column`  (
  `column_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `table_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '归属表编号',
  `column_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '列名称',
  `column_comment` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '列描述',
  `column_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '列类型',
  `java_type` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'JAVA类型',
  `java_field` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'JAVA字段名',
  `is_pk` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否主键（1是）',
  `is_increment` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否自增（1是）',
  `is_required` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否必填（1是）',
  `is_insert` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否为插入字段（1是）',
  `is_edit` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否编辑字段（1是）',
  `is_list` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否列表字段（1是）',
  `is_query` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否查询字段（1是）',
  `query_type` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT 'EQ' COMMENT '查询方式（等于、不等于、大于、小于、范围）',
  `html_type` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件）',
  `dict_type` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '字典类型',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`column_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 103 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '代码生成业务表字段' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of gen_table_column
-- ----------------------------
INSERT INTO `gen_table_column` VALUES (1, '1', 'id', '设备id', 'int(11)', 'Long', 'id', '1', '0', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2020-02-23 17:11:04', '', '2020-02-24 19:40:31');
INSERT INTO `gen_table_column` VALUES (2, '1', 'name', '设备名称', 'varchar(20)', 'String', 'name', '0', '0', '1', '1', '1', '1', '1', 'LIKE', 'input', '', 2, 'admin', '2020-02-23 17:11:04', '', '2020-02-24 19:40:31');
INSERT INTO `gen_table_column` VALUES (3, '1', 'code', '设备编号', 'varchar(50)', 'String', 'code', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 3, 'admin', '2020-02-23 17:11:04', '', '2020-02-24 19:40:31');
INSERT INTO `gen_table_column` VALUES (4, '1', 'company', '公司名称', 'varchar(50)', 'String', 'company', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 4, 'admin', '2020-02-23 17:11:04', '', '2020-02-24 19:40:31');
INSERT INTO `gen_table_column` VALUES (5, '1', 'address', '公司地址', 'varchar(50)', 'String', 'address', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 5, 'admin', '2020-02-23 17:11:04', '', '2020-02-24 19:40:31');
INSERT INTO `gen_table_column` VALUES (6, '1', 'img', '公司图片', 'varchar(50)', 'String', 'img', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 6, 'admin', '2020-02-23 17:11:04', '', '2020-02-24 19:40:31');
INSERT INTO `gen_table_column` VALUES (7, '1', 'status', '采集状态:0 未开始,1 开始', 'int(1)', 'Integer', 'status', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'radio', 'zh_status', 7, 'admin', '2020-02-23 17:11:04', '', '2020-02-24 19:40:31');
INSERT INTO `gen_table_column` VALUES (8, '1', 'correct_status', '校正状态:0 未开始,1 开始', 'int(1)', 'Integer', 'correctStatus', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'radio', 'zh_status', 8, 'admin', '2020-02-23 17:11:04', '', '2020-02-24 19:40:31');
INSERT INTO `gen_table_column` VALUES (9, '1', 'weather_status', '天气状态:0 未开始,1 开始', 'int(1)', 'Integer', 'weatherStatus', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'radio', 'zh_status', 9, 'admin', '2020-02-23 17:11:04', '', '2020-02-24 19:40:31');
INSERT INTO `gen_table_column` VALUES (10, '1', 'gps_status', '定位状态:0 未开始,1 开始', 'int(1)', 'Integer', 'gpsStatus', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'radio', 'zh_status', 10, 'admin', '2020-02-23 17:11:04', '', '2020-02-24 19:40:31');
INSERT INTO `gen_table_column` VALUES (11, '1', 'created_date', '创建时间', 'datetime', 'Date', 'createdDate', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 11, 'admin', '2020-02-23 17:11:04', '', '2020-02-24 19:40:31');
INSERT INTO `gen_table_column` VALUES (12, '1', 'updated_date', '修改时间', 'datetime', 'Date', 'updatedDate', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 12, 'admin', '2020-02-23 17:11:04', '', '2020-02-24 19:40:31');
INSERT INTO `gen_table_column` VALUES (13, '2', 'id', 'id', 'int(11)', 'Long', 'id', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2020-02-24 19:15:57', '', '2020-02-24 19:39:20');
INSERT INTO `gen_table_column` VALUES (14, '2', 'device_code', '设备编号', 'varchar(50)', 'String', 'deviceCode', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 2, 'admin', '2020-02-24 19:15:57', '', '2020-02-24 19:39:20');
INSERT INTO `gen_table_column` VALUES (15, '2', 'start_time', '开始时间', 'datetime', 'Date', 'startTime', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 3, 'admin', '2020-02-24 19:15:57', '', '2020-02-24 19:39:20');
INSERT INTO `gen_table_column` VALUES (16, '2', 'end_time', '结束时间', 'datetime', 'Date', 'endTime', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 4, 'admin', '2020-02-24 19:15:57', '', '2020-02-24 19:39:20');
INSERT INTO `gen_table_column` VALUES (17, '2', 'point_name', '敏感点名称', 'varchar(50)', 'String', 'pointName', '0', '0', NULL, '1', '1', '1', '1', 'LIKE', 'input', '', 5, 'admin', '2020-02-24 19:15:57', '', '2020-02-24 19:39:20');
INSERT INTO `gen_table_column` VALUES (22, '4', 'id', 'id', 'int(11)', 'Long', 'id', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2020-02-24 21:00:11', '', '2020-02-24 21:00:49');
INSERT INTO `gen_table_column` VALUES (23, '4', 'name', '名称', 'varchar(50)', 'String', 'name', '0', '0', '1', '1', '1', '1', '1', 'LIKE', 'input', '', 2, 'admin', '2020-02-24 21:00:11', '', '2020-02-24 21:00:49');
INSERT INTO `gen_table_column` VALUES (24, '4', 'lng', '经度', 'varchar(50)', 'String', 'lng', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 3, 'admin', '2020-02-24 21:00:11', '', '2020-02-24 21:00:49');
INSERT INTO `gen_table_column` VALUES (25, '4', 'lat', '纬度', 'varchar(50)', 'String', 'lat', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 4, 'admin', '2020-02-24 21:00:11', '', '2020-02-24 21:00:49');
INSERT INTO `gen_table_column` VALUES (26, '4', 'created_time', '创建时间', 'datetime', 'Date', 'createdTime', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 5, 'admin', '2020-02-24 21:00:11', '', '2020-02-24 21:00:49');
INSERT INTO `gen_table_column` VALUES (27, '4', 'updated_time', '修改时间', 'datetime', 'Date', 'updatedTime', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 6, 'admin', '2020-02-24 21:00:11', '', '2020-02-24 21:00:49');
INSERT INTO `gen_table_column` VALUES (28, '5', 'id', '编号', 'int(11)', 'Long', 'id', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2020-03-03 17:56:33', '', '2020-03-03 17:57:45');
INSERT INTO `gen_table_column` VALUES (29, '5', 'color_str', '颜色字符', 'varchar(50)', 'String', 'colorStr', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 2, 'admin', '2020-03-03 17:56:33', '', '2020-03-03 17:57:45');
INSERT INTO `gen_table_column` VALUES (30, '5', 'create_by', '创建人', 'varchar(20)', 'String', 'createBy', '0', '0', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 3, 'admin', '2020-03-03 17:56:33', '', '2020-03-03 17:57:45');
INSERT INTO `gen_table_column` VALUES (31, '5', 'create_time', '创建时间', 'datetime', 'Date', 'createTime', '0', '0', NULL, '1', NULL, NULL, NULL, 'EQ', 'datetime', '', 4, 'admin', '2020-03-03 17:56:33', '', '2020-03-03 17:57:45');
INSERT INTO `gen_table_column` VALUES (32, '5', 'update_by', '修改人', 'varchar(20)', 'String', 'updateBy', '0', '0', NULL, '1', '1', NULL, NULL, 'EQ', 'input', '', 5, 'admin', '2020-03-03 17:56:33', '', '2020-03-03 17:57:45');
INSERT INTO `gen_table_column` VALUES (33, '5', 'update_time', '修改时间', 'datetime', 'Date', 'updateTime', '0', '0', NULL, '1', '1', NULL, NULL, 'EQ', 'datetime', '', 6, 'admin', '2020-03-03 17:56:33', '', '2020-03-03 17:57:45');
INSERT INTO `gen_table_column` VALUES (42, '7', 'id', '编号', 'int(11)', 'Long', 'id', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2020-03-04 15:28:38', '', '2020-03-04 15:31:40');
INSERT INTO `gen_table_column` VALUES (43, '7', 'start_value', '开始值', 'int(11)', 'Long', 'startValue', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 2, 'admin', '2020-03-04 15:28:38', '', '2020-03-04 15:31:40');
INSERT INTO `gen_table_column` VALUES (44, '7', 'end_value', '结束值', 'int(11)', 'Long', 'endValue', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 3, 'admin', '2020-03-04 15:28:38', '', '2020-03-04 15:31:40');
INSERT INTO `gen_table_column` VALUES (45, '7', 'create_by', '创建人', 'varchar(20)', 'String', 'createBy', '0', '0', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 4, 'admin', '2020-03-04 15:28:38', '', '2020-03-04 15:31:40');
INSERT INTO `gen_table_column` VALUES (46, '7', 'create_time', '创建时间', 'datetime', 'Date', 'createTime', '0', '0', NULL, '1', NULL, NULL, NULL, 'EQ', 'datetime', '', 5, 'admin', '2020-03-04 15:28:38', '', '2020-03-04 15:31:40');
INSERT INTO `gen_table_column` VALUES (47, '7', 'update_by', '修改人', 'varchar(20)', 'String', 'updateBy', '0', '0', NULL, '1', '1', NULL, NULL, 'EQ', 'input', '', 6, 'admin', '2020-03-04 15:28:38', '', '2020-03-04 15:31:40');
INSERT INTO `gen_table_column` VALUES (48, '7', 'update_time', '修改时间', 'datetime', 'Date', 'updateTime', '0', '0', NULL, '1', '1', NULL, NULL, 'EQ', 'datetime', '', 7, 'admin', '2020-03-04 15:28:38', '', '2020-03-04 15:31:40');
INSERT INTO `gen_table_column` VALUES (49, '8', 'id', '编号', 'int(11)', 'Long', 'id', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2020-03-04 15:28:53', '', '2020-03-04 15:32:05');
INSERT INTO `gen_table_column` VALUES (50, '8', 'name', '标准名称', 'varchar(20)', 'String', 'name', '0', '0', '1', '1', '1', '1', '1', 'LIKE', 'input', '', 2, 'admin', '2020-03-04 15:28:53', '', '2020-03-04 15:32:05');
INSERT INTO `gen_table_column` VALUES (51, '8', 'create_by', '创建人', 'varchar(20)', 'String', 'createBy', '0', '0', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 3, 'admin', '2020-03-04 15:28:53', '', '2020-03-04 15:32:05');
INSERT INTO `gen_table_column` VALUES (52, '8', 'create_time', '创建时间', 'datetime', 'Date', 'createTime', '0', '0', NULL, '1', NULL, NULL, NULL, 'EQ', 'datetime', '', 4, 'admin', '2020-03-04 15:28:53', '', '2020-03-04 15:32:05');
INSERT INTO `gen_table_column` VALUES (53, '8', 'update_by', '修改人', 'varchar(20)', 'String', 'updateBy', '0', '0', NULL, '1', '1', NULL, NULL, 'EQ', 'input', '', 5, 'admin', '2020-03-04 15:28:53', '', '2020-03-04 15:32:05');
INSERT INTO `gen_table_column` VALUES (54, '8', 'update_time', '修改时间', 'datetime', 'Date', 'updateTime', '0', '0', NULL, '1', '1', NULL, NULL, 'EQ', 'datetime', '', 6, 'admin', '2020-03-04 15:28:53', '', '2020-03-04 15:32:05');
INSERT INTO `gen_table_column` VALUES (75, '11', 'id', '编号', 'int(11)', 'Long', 'id', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2020-03-04 16:03:49', '', '2020-03-04 16:04:04');
INSERT INTO `gen_table_column` VALUES (76, '11', 'name', '因子名称', 'varchar(20)', 'String', 'name', '0', '0', '1', '1', '1', '1', '1', 'LIKE', 'input', '', 2, 'admin', '2020-03-04 16:03:49', '', '2020-03-04 16:04:04');
INSERT INTO `gen_table_column` VALUES (77, '11', 'ename', '英文名称', 'varchar(20)', 'String', 'ename', '0', '0', '1', '1', '1', '1', '1', 'LIKE', 'input', '', 3, 'admin', '2020-03-04 16:03:49', '', '2020-03-04 16:04:04');
INSERT INTO `gen_table_column` VALUES (78, '11', 'formula', '分子式', 'varchar(50)', 'String', 'formula', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 4, 'admin', '2020-03-04 16:03:49', '', '2020-03-04 16:04:04');
INSERT INTO `gen_table_column` VALUES (79, '11', 'weight', '分子量', 'double(10,3)', 'Double', 'weight', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 5, 'admin', '2020-03-04 16:03:49', '', '2020-03-04 16:04:04');
INSERT INTO `gen_table_column` VALUES (80, '11', 'smell', '气味', 'varchar(50)', 'String', 'smell', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 6, 'admin', '2020-03-04 16:03:49', '', '2020-03-04 16:04:04');
INSERT INTO `gen_table_column` VALUES (81, '11', 'warning', '预警值', 'double(10,2)', 'Double', 'warning', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 7, 'admin', '2020-03-04 16:03:49', '', '2020-03-04 16:04:04');
INSERT INTO `gen_table_column` VALUES (82, '11', 'danger', '报警值', 'double(10,2)', 'Double', 'danger', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 8, 'admin', '2020-03-04 16:03:49', '', '2020-03-04 16:04:04');
INSERT INTO `gen_table_column` VALUES (83, '11', 'create_by', '创建人', 'varchar(20)', 'String', 'createBy', '0', '0', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 9, 'admin', '2020-03-04 16:03:49', '', '2020-03-04 16:04:04');
INSERT INTO `gen_table_column` VALUES (84, '11', 'create_time', '创建时间', 'datetime', 'Date', 'createTime', '0', '0', NULL, '1', NULL, NULL, NULL, 'EQ', 'datetime', '', 10, 'admin', '2020-03-04 16:03:49', '', '2020-03-04 16:04:04');
INSERT INTO `gen_table_column` VALUES (85, '11', 'update_by', '修改人', 'varchar(20)', 'String', 'updateBy', '0', '0', NULL, '1', '1', NULL, NULL, 'EQ', 'input', '', 11, 'admin', '2020-03-04 16:03:49', '', '2020-03-04 16:04:04');
INSERT INTO `gen_table_column` VALUES (86, '11', 'update_time', '修改时间', 'datetime', 'Date', 'updateTime', '0', '0', NULL, '1', '1', NULL, NULL, 'EQ', 'datetime', '', 12, 'admin', '2020-03-04 16:03:49', '', '2020-03-04 16:04:04');
INSERT INTO `gen_table_column` VALUES (87, '12', 'id', '编号', 'int(11)', 'Long', 'id', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2020-03-04 17:23:56', '', '2020-03-04 17:24:56');
INSERT INTO `gen_table_column` VALUES (88, '12', 'category_id', '标准编号', 'int(11)', 'Long', 'categoryId', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 2, 'admin', '2020-03-04 17:23:56', '', '2020-03-04 17:24:56');
INSERT INTO `gen_table_column` VALUES (89, '12', 'factor_id', '因子编号', 'int(11)', 'Long', 'factorId', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 3, 'admin', '2020-03-04 17:23:56', '', '2020-03-04 17:24:56');
INSERT INTO `gen_table_column` VALUES (90, '12', 'color_id', '颜色编号', 'int(11)', 'Long', 'colorId', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 4, 'admin', '2020-03-04 17:23:56', '', '2020-03-04 17:24:56');
INSERT INTO `gen_table_column` VALUES (91, '12', 'create_by', '创建人', 'varchar(20)', 'String', 'createBy', '0', '0', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 5, 'admin', '2020-03-04 17:23:56', '', '2020-03-04 17:24:56');
INSERT INTO `gen_table_column` VALUES (92, '12', 'create_time', '创建时间', 'datetime', 'Date', 'createTime', '0', '0', NULL, '1', NULL, NULL, NULL, 'EQ', 'datetime', '', 6, 'admin', '2020-03-04 17:23:56', '', '2020-03-04 17:24:56');
INSERT INTO `gen_table_column` VALUES (93, '12', 'update_by', '修改人', 'varchar(20)', 'String', 'updateBy', '0', '0', NULL, '1', '1', NULL, NULL, 'EQ', 'input', '', 7, 'admin', '2020-03-04 17:23:56', '', '2020-03-04 17:24:56');
INSERT INTO `gen_table_column` VALUES (94, '12', 'update_time', '修改时间', 'datetime', 'Date', 'updateTime', '0', '0', NULL, '1', '1', NULL, NULL, 'EQ', 'datetime', '', 8, 'admin', '2020-03-04 17:23:56', '', '2020-03-04 17:24:56');
INSERT INTO `gen_table_column` VALUES (95, '13', 'id', '编号', 'int(11)', 'Long', 'id', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2020-03-04 17:23:56', '', '2020-03-04 17:25:14');
INSERT INTO `gen_table_column` VALUES (96, '13', 'category_id', '标准编号', 'int(11)', 'Long', 'categoryId', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 2, 'admin', '2020-03-04 17:23:56', '', '2020-03-04 17:25:14');
INSERT INTO `gen_table_column` VALUES (97, '13', 'factor_id', '因子编号', 'int(11)', 'Long', 'factorId', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 3, 'admin', '2020-03-04 17:23:56', '', '2020-03-04 17:25:14');
INSERT INTO `gen_table_column` VALUES (98, '13', 'simple_color_id', '单个颜色编号', 'int(11)', 'Long', 'simpleColorId', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 4, 'admin', '2020-03-04 17:23:56', '', '2020-03-04 17:25:14');
INSERT INTO `gen_table_column` VALUES (99, '13', 'create_by', '创建人', 'varchar(20)', 'String', 'createBy', '0', '0', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 5, 'admin', '2020-03-04 17:23:56', '', '2020-03-04 17:25:14');
INSERT INTO `gen_table_column` VALUES (100, '13', 'create_time', '创建时间', 'datetime', 'Date', 'createTime', '0', '0', NULL, '1', NULL, NULL, NULL, 'EQ', 'datetime', '', 6, 'admin', '2020-03-04 17:23:56', '', '2020-03-04 17:25:14');
INSERT INTO `gen_table_column` VALUES (101, '13', 'update_by', '修改人', 'varchar(20)', 'String', 'updateBy', '0', '0', NULL, '1', '1', NULL, NULL, 'EQ', 'input', '', 7, 'admin', '2020-03-04 17:23:56', '', '2020-03-04 17:25:14');
INSERT INTO `gen_table_column` VALUES (102, '13', 'update_time', '修改时间', 'datetime', 'Date', 'updateTime', '0', '0', NULL, '1', '1', NULL, NULL, 'EQ', 'datetime', '', 8, 'admin', '2020-03-04 17:23:56', '', '2020-03-04 17:25:14');

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config`  (
  `config_id` int(5) NOT NULL AUTO_INCREMENT COMMENT '参数主键',
  `config_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '参数名称',
  `config_key` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '参数键名',
  `config_value` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '参数键值',
  `config_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT 'N' COMMENT '系统内置（Y是 N否）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`config_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '参数配置表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES (1, '主框架页-默认皮肤样式名称', 'sys.index.skinName', 'skin-blue', 'Y', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '蓝色 skin-blue、绿色 skin-green、紫色 skin-purple、红色 skin-red、黄色 skin-yellow');
INSERT INTO `sys_config` VALUES (2, '用户管理-账号初始密码', 'sys.user.initPassword', '123456', 'Y', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '初始化密码 123456');
INSERT INTO `sys_config` VALUES (3, '主框架页-侧边栏主题', 'sys.index.sideTheme', 'theme-dark', 'Y', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '深色主题theme-dark，浅色主题theme-light');

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`  (
  `dept_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `parent_id` bigint(20) NULL DEFAULT 0 COMMENT '父部门id',
  `ancestors` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '祖级列表',
  `dept_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '部门名称',
  `order_num` int(4) NULL DEFAULT 0 COMMENT '显示顺序',
  `leader` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '负责人',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '部门状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 110 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '部门表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES (100, 0, '0', '若依科技', 0, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES (101, 100, '0,100', '深圳总公司', 1, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES (102, 100, '0,100', '长沙分公司', 2, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES (103, 101, '0,100,101', '研发部门', 1, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES (104, 101, '0,100,101', '市场部门', 2, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES (105, 101, '0,100,101', '测试部门', 3, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES (106, 101, '0,100,101', '财务部门', 4, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES (107, 101, '0,100,101', '运维部门', 5, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES (108, 102, '0,100,102', '市场部门', 1, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES (109, 102, '0,100,102', '财务部门', 2, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');

-- ----------------------------
-- Table structure for sys_dict_data
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_data`;
CREATE TABLE `sys_dict_data`  (
  `dict_code` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典编码',
  `dict_sort` int(4) NULL DEFAULT 0 COMMENT '字典排序',
  `dict_label` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '字典标签',
  `dict_value` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '字典键值',
  `dict_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '字典类型',
  `css_class` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '样式属性（其他样式扩展）',
  `list_class` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '表格回显样式',
  `is_default` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT 'N' COMMENT '是否默认（Y是 N否）',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '字典数据表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_dict_data
-- ----------------------------
INSERT INTO `sys_dict_data` VALUES (1, 1, '男', '0', 'sys_user_sex', '', '', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '性别男');
INSERT INTO `sys_dict_data` VALUES (2, 2, '女', '1', 'sys_user_sex', '', '', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '性别女');
INSERT INTO `sys_dict_data` VALUES (3, 3, '未知', '2', 'sys_user_sex', '', '', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '性别未知');
INSERT INTO `sys_dict_data` VALUES (4, 1, '显示', '0', 'sys_show_hide', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '显示菜单');
INSERT INTO `sys_dict_data` VALUES (5, 2, '隐藏', '1', 'sys_show_hide', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '隐藏菜单');
INSERT INTO `sys_dict_data` VALUES (6, 1, '正常', '0', 'sys_normal_disable', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '正常状态');
INSERT INTO `sys_dict_data` VALUES (7, 2, '停用', '1', 'sys_normal_disable', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '停用状态');
INSERT INTO `sys_dict_data` VALUES (8, 1, '正常', '0', 'sys_job_status', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '正常状态');
INSERT INTO `sys_dict_data` VALUES (9, 2, '暂停', '1', 'sys_job_status', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '停用状态');
INSERT INTO `sys_dict_data` VALUES (10, 1, '默认', 'DEFAULT', 'sys_job_group', '', '', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '默认分组');
INSERT INTO `sys_dict_data` VALUES (11, 2, '系统', 'SYSTEM', 'sys_job_group', '', '', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统分组');
INSERT INTO `sys_dict_data` VALUES (12, 1, '是', 'Y', 'sys_yes_no', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统默认是');
INSERT INTO `sys_dict_data` VALUES (13, 2, '否', 'N', 'sys_yes_no', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统默认否');
INSERT INTO `sys_dict_data` VALUES (14, 1, '通知', '1', 'sys_notice_type', '', 'warning', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '通知');
INSERT INTO `sys_dict_data` VALUES (15, 2, '公告', '2', 'sys_notice_type', '', 'success', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '公告');
INSERT INTO `sys_dict_data` VALUES (16, 1, '正常', '0', 'sys_notice_status', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '正常状态');
INSERT INTO `sys_dict_data` VALUES (17, 2, '关闭', '1', 'sys_notice_status', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '关闭状态');
INSERT INTO `sys_dict_data` VALUES (18, 1, '新增', '1', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '新增操作');
INSERT INTO `sys_dict_data` VALUES (19, 2, '修改', '2', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '修改操作');
INSERT INTO `sys_dict_data` VALUES (20, 3, '删除', '3', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '删除操作');
INSERT INTO `sys_dict_data` VALUES (21, 4, '授权', '4', 'sys_oper_type', '', 'primary', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '授权操作');
INSERT INTO `sys_dict_data` VALUES (22, 5, '导出', '5', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '导出操作');
INSERT INTO `sys_dict_data` VALUES (23, 6, '导入', '6', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '导入操作');
INSERT INTO `sys_dict_data` VALUES (24, 7, '强退', '7', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '强退操作');
INSERT INTO `sys_dict_data` VALUES (25, 8, '生成代码', '8', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '生成操作');
INSERT INTO `sys_dict_data` VALUES (26, 9, '清空数据', '9', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '清空操作');
INSERT INTO `sys_dict_data` VALUES (27, 1, '成功', '0', 'sys_common_status', '', 'primary', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '正常状态');
INSERT INTO `sys_dict_data` VALUES (28, 2, '失败', '1', 'sys_common_status', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '停用状态');
INSERT INTO `sys_dict_data` VALUES (29, 1, '停止', '0', 'zh_status', NULL, 'info', 'Y', '0', 'admin', '2020-02-23 17:51:50', 'ry', '2020-02-23 17:52:11', '停止状态');
INSERT INTO `sys_dict_data` VALUES (30, 2, '开始', '1', 'zh_status', NULL, 'info', 'N', '0', 'admin', '2020-02-23 17:51:53', 'ry', '2020-02-23 17:52:14', '开始状态');

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type`  (
  `dict_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典主键',
  `dict_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '字典名称',
  `dict_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '字典类型',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_id`) USING BTREE,
  UNIQUE INDEX `dict_type`(`dict_type`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '字典类型表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------
INSERT INTO `sys_dict_type` VALUES (1, '用户性别', 'sys_user_sex', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '用户性别列表');
INSERT INTO `sys_dict_type` VALUES (2, '菜单状态', 'sys_show_hide', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '菜单状态列表');
INSERT INTO `sys_dict_type` VALUES (3, '系统开关', 'sys_normal_disable', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统开关列表');
INSERT INTO `sys_dict_type` VALUES (4, '任务状态', 'sys_job_status', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '任务状态列表');
INSERT INTO `sys_dict_type` VALUES (5, '任务分组', 'sys_job_group', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '任务分组列表');
INSERT INTO `sys_dict_type` VALUES (6, '系统是否', 'sys_yes_no', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统是否列表');
INSERT INTO `sys_dict_type` VALUES (7, '通知类型', 'sys_notice_type', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '通知类型列表');
INSERT INTO `sys_dict_type` VALUES (8, '通知状态', 'sys_notice_status', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '通知状态列表');
INSERT INTO `sys_dict_type` VALUES (9, '操作类型', 'sys_oper_type', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '操作类型列表');
INSERT INTO `sys_dict_type` VALUES (10, '系统状态', 'sys_common_status', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '登录状态列表');
INSERT INTO `sys_dict_type` VALUES (11, '状态', 'zh_status', '0', 'admin', '2020-02-23 17:49:39', 'ry', '2020-02-23 17:49:45', '开始停止状态');

-- ----------------------------
-- Table structure for sys_job
-- ----------------------------
DROP TABLE IF EXISTS `sys_job`;
CREATE TABLE `sys_job`  (
  `job_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务ID',
  `job_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '任务名称',
  `job_group` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'DEFAULT' COMMENT '任务组名',
  `invoke_target` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '调用目标字符串',
  `cron_expression` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT 'cron执行表达式',
  `misfire_policy` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '3' COMMENT '计划执行错误策略（1立即执行 2执行一次 3放弃执行）',
  `concurrent` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '1' COMMENT '是否并发执行（0允许 1禁止）',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '状态（0正常 1暂停）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '备注信息',
  PRIMARY KEY (`job_id`, `job_name`, `job_group`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '定时任务调度表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_job
-- ----------------------------
INSERT INTO `sys_job` VALUES (1, '系统默认（无参）', 'DEFAULT', 'ryTask.ryNoParams', '0/10 * * * * ?', '3', '1', '1', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_job` VALUES (2, '系统默认（有参）', 'DEFAULT', 'ryTask.ryParams(\'ry\')', '0/15 * * * * ?', '3', '1', '1', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_job` VALUES (3, '系统默认（多参）', 'DEFAULT', 'ryTask.ryMultipleParams(\'ry\', true, 2000L, 316.50D, 100)', '0/20 * * * * ?', '3', '1', '1', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');

-- ----------------------------
-- Table structure for sys_job_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_job_log`;
CREATE TABLE `sys_job_log`  (
  `job_log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务日志ID',
  `job_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '任务名称',
  `job_group` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '任务组名',
  `invoke_target` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '调用目标字符串',
  `job_message` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '日志信息',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '执行状态（0正常 1失败）',
  `exception_info` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '异常信息',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`job_log_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '定时任务调度日志表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sys_logininfor
-- ----------------------------
DROP TABLE IF EXISTS `sys_logininfor`;
CREATE TABLE `sys_logininfor`  (
  `info_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '访问ID',
  `user_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '用户账号',
  `ipaddr` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '登录IP地址',
  `login_location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '登录地点',
  `browser` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '浏览器类型',
  `os` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '操作系统',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '登录状态（0成功 1失败）',
  `msg` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '提示消息',
  `login_time` datetime(0) NULL DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`info_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 267 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统访问记录' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_logininfor
-- ----------------------------
INSERT INTO `sys_logininfor` VALUES (100, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-13 18:26:41');
INSERT INTO `sys_logininfor` VALUES (101, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '退出成功', '2020-02-13 18:30:34');
INSERT INTO `sys_logininfor` VALUES (102, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '1', '验证码已失效', '2020-02-13 18:41:35');
INSERT INTO `sys_logininfor` VALUES (103, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-13 18:41:51');
INSERT INTO `sys_logininfor` VALUES (104, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-19 19:26:12');
INSERT INTO `sys_logininfor` VALUES (105, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-20 12:13:39');
INSERT INTO `sys_logininfor` VALUES (106, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-20 13:44:14');
INSERT INTO `sys_logininfor` VALUES (107, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-20 14:55:15');
INSERT INTO `sys_logininfor` VALUES (108, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-22 00:02:14');
INSERT INTO `sys_logininfor` VALUES (109, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-22 16:03:10');
INSERT INTO `sys_logininfor` VALUES (110, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '1', '验证码错误', '2020-02-22 16:12:20');
INSERT INTO `sys_logininfor` VALUES (111, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-22 16:12:26');
INSERT INTO `sys_logininfor` VALUES (112, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '退出成功', '2020-02-22 16:14:30');
INSERT INTO `sys_logininfor` VALUES (113, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-22 16:14:41');
INSERT INTO `sys_logininfor` VALUES (114, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-22 16:18:59');
INSERT INTO `sys_logininfor` VALUES (115, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-22 16:20:46');
INSERT INTO `sys_logininfor` VALUES (116, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '1', '验证码错误', '2020-02-22 16:22:27');
INSERT INTO `sys_logininfor` VALUES (117, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-22 16:22:37');
INSERT INTO `sys_logininfor` VALUES (118, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-22 16:27:31');
INSERT INTO `sys_logininfor` VALUES (119, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-22 16:34:37');
INSERT INTO `sys_logininfor` VALUES (120, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-22 16:37:53');
INSERT INTO `sys_logininfor` VALUES (121, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-22 16:47:34');
INSERT INTO `sys_logininfor` VALUES (122, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-22 16:49:44');
INSERT INTO `sys_logininfor` VALUES (123, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-22 17:06:03');
INSERT INTO `sys_logininfor` VALUES (124, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-22 17:07:16');
INSERT INTO `sys_logininfor` VALUES (125, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '1', '验证码已失效', '2020-02-22 17:07:23');
INSERT INTO `sys_logininfor` VALUES (126, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-22 17:08:21');
INSERT INTO `sys_logininfor` VALUES (127, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '1', '验证码错误', '2020-02-22 17:10:01');
INSERT INTO `sys_logininfor` VALUES (128, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-22 17:12:04');
INSERT INTO `sys_logininfor` VALUES (129, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-22 17:12:55');
INSERT INTO `sys_logininfor` VALUES (130, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-22 17:13:25');
INSERT INTO `sys_logininfor` VALUES (131, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-22 17:33:20');
INSERT INTO `sys_logininfor` VALUES (132, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-22 18:08:51');
INSERT INTO `sys_logininfor` VALUES (133, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-22 18:37:18');
INSERT INTO `sys_logininfor` VALUES (134, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-22 18:48:23');
INSERT INTO `sys_logininfor` VALUES (135, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '1', '验证码错误', '2020-02-22 19:27:48');
INSERT INTO `sys_logininfor` VALUES (136, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-22 19:27:53');
INSERT INTO `sys_logininfor` VALUES (137, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-23 10:38:32');
INSERT INTO `sys_logininfor` VALUES (138, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-23 10:56:46');
INSERT INTO `sys_logininfor` VALUES (139, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-23 11:02:23');
INSERT INTO `sys_logininfor` VALUES (140, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-23 11:04:37');
INSERT INTO `sys_logininfor` VALUES (141, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-23 15:17:10');
INSERT INTO `sys_logininfor` VALUES (142, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-23 16:10:54');
INSERT INTO `sys_logininfor` VALUES (143, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '退出成功', '2020-02-23 18:03:20');
INSERT INTO `sys_logininfor` VALUES (144, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '1', '验证码错误', '2020-02-23 18:03:27');
INSERT INTO `sys_logininfor` VALUES (145, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-23 18:03:34');
INSERT INTO `sys_logininfor` VALUES (146, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '1', '验证码已失效', '2020-02-23 19:40:43');
INSERT INTO `sys_logininfor` VALUES (147, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-23 19:40:49');
INSERT INTO `sys_logininfor` VALUES (148, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-23 20:14:46');
INSERT INTO `sys_logininfor` VALUES (149, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-23 20:56:56');
INSERT INTO `sys_logininfor` VALUES (150, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-23 23:08:47');
INSERT INTO `sys_logininfor` VALUES (151, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-24 00:03:35');
INSERT INTO `sys_logininfor` VALUES (152, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-24 01:46:58');
INSERT INTO `sys_logininfor` VALUES (153, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-24 01:54:21');
INSERT INTO `sys_logininfor` VALUES (154, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-24 09:48:01');
INSERT INTO `sys_logininfor` VALUES (155, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-24 10:56:13');
INSERT INTO `sys_logininfor` VALUES (156, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-24 11:46:41');
INSERT INTO `sys_logininfor` VALUES (157, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-24 17:43:50');
INSERT INTO `sys_logininfor` VALUES (158, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-24 19:06:32');
INSERT INTO `sys_logininfor` VALUES (159, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-24 20:54:14');
INSERT INTO `sys_logininfor` VALUES (160, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-25 10:46:42');
INSERT INTO `sys_logininfor` VALUES (161, 'admin', '192.168.31.50', '内网IP', 'Chrome', 'Windows 10', '1', '验证码已失效', '2020-02-25 11:36:17');
INSERT INTO `sys_logininfor` VALUES (162, 'admin', '192.168.31.50', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-25 11:36:25');
INSERT INTO `sys_logininfor` VALUES (163, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-25 11:37:01');
INSERT INTO `sys_logininfor` VALUES (164, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-26 17:18:14');
INSERT INTO `sys_logininfor` VALUES (165, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-26 18:56:29');
INSERT INTO `sys_logininfor` VALUES (166, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-26 21:33:03');
INSERT INTO `sys_logininfor` VALUES (167, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-26 22:18:25');
INSERT INTO `sys_logininfor` VALUES (168, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-26 22:38:06');
INSERT INTO `sys_logininfor` VALUES (169, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-27 17:35:05');
INSERT INTO `sys_logininfor` VALUES (170, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-27 18:24:10');
INSERT INTO `sys_logininfor` VALUES (171, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '1', '验证码错误', '2020-02-27 21:16:32');
INSERT INTO `sys_logininfor` VALUES (172, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '1', '验证码错误', '2020-02-27 21:16:32');
INSERT INTO `sys_logininfor` VALUES (173, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-27 21:16:32');
INSERT INTO `sys_logininfor` VALUES (174, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-27 21:16:32');
INSERT INTO `sys_logininfor` VALUES (175, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-27 21:16:43');
INSERT INTO `sys_logininfor` VALUES (176, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-27 21:59:27');
INSERT INTO `sys_logininfor` VALUES (177, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-27 22:38:45');
INSERT INTO `sys_logininfor` VALUES (178, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-03 16:24:39');
INSERT INTO `sys_logininfor` VALUES (179, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-03 17:54:20');
INSERT INTO `sys_logininfor` VALUES (180, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '1', '验证码错误', '2020-03-04 15:26:49');
INSERT INTO `sys_logininfor` VALUES (181, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-04 15:26:55');
INSERT INTO `sys_logininfor` VALUES (182, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-04 21:58:06');
INSERT INTO `sys_logininfor` VALUES (183, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-05 10:14:00');
INSERT INTO `sys_logininfor` VALUES (184, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-05 11:33:29');
INSERT INTO `sys_logininfor` VALUES (185, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-05 12:22:46');
INSERT INTO `sys_logininfor` VALUES (186, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-05 12:23:55');
INSERT INTO `sys_logininfor` VALUES (187, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-05 16:37:15');
INSERT INTO `sys_logininfor` VALUES (188, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-06 14:50:02');
INSERT INTO `sys_logininfor` VALUES (189, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-08 14:54:09');
INSERT INTO `sys_logininfor` VALUES (190, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-09 20:24:14');
INSERT INTO `sys_logininfor` VALUES (191, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-10 13:39:56');
INSERT INTO `sys_logininfor` VALUES (192, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-11 14:09:06');
INSERT INTO `sys_logininfor` VALUES (193, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-11 14:10:39');
INSERT INTO `sys_logininfor` VALUES (194, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-11 14:11:39');
INSERT INTO `sys_logininfor` VALUES (195, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-11 14:14:54');
INSERT INTO `sys_logininfor` VALUES (196, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-11 14:21:01');
INSERT INTO `sys_logininfor` VALUES (197, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-11 14:32:14');
INSERT INTO `sys_logininfor` VALUES (198, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-11 14:32:21');
INSERT INTO `sys_logininfor` VALUES (199, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-11 14:33:57');
INSERT INTO `sys_logininfor` VALUES (200, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-11 14:34:06');
INSERT INTO `sys_logininfor` VALUES (201, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-11 14:35:31');
INSERT INTO `sys_logininfor` VALUES (202, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-11 14:41:14');
INSERT INTO `sys_logininfor` VALUES (203, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-11 14:52:37');
INSERT INTO `sys_logininfor` VALUES (204, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-11 14:52:56');
INSERT INTO `sys_logininfor` VALUES (205, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-11 14:53:20');
INSERT INTO `sys_logininfor` VALUES (206, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-11 14:54:00');
INSERT INTO `sys_logininfor` VALUES (207, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '1', '验证码错误', '2020-03-11 14:54:32');
INSERT INTO `sys_logininfor` VALUES (208, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-11 14:54:43');
INSERT INTO `sys_logininfor` VALUES (209, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-11 14:55:54');
INSERT INTO `sys_logininfor` VALUES (210, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-11 19:57:57');
INSERT INTO `sys_logininfor` VALUES (211, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-11 19:58:13');
INSERT INTO `sys_logininfor` VALUES (212, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-11 19:59:48');
INSERT INTO `sys_logininfor` VALUES (213, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '1', '验证码错误', '2020-03-11 21:46:20');
INSERT INTO `sys_logininfor` VALUES (214, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-11 21:46:34');
INSERT INTO `sys_logininfor` VALUES (215, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-11 22:01:35');
INSERT INTO `sys_logininfor` VALUES (216, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-11 22:16:25');
INSERT INTO `sys_logininfor` VALUES (217, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-12 09:51:44');
INSERT INTO `sys_logininfor` VALUES (218, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '1', '验证码错误', '2020-03-12 10:10:43');
INSERT INTO `sys_logininfor` VALUES (219, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-12 10:10:51');
INSERT INTO `sys_logininfor` VALUES (220, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-12 10:37:18');
INSERT INTO `sys_logininfor` VALUES (221, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-12 10:38:43');
INSERT INTO `sys_logininfor` VALUES (222, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-12 10:39:31');
INSERT INTO `sys_logininfor` VALUES (223, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-12 10:40:23');
INSERT INTO `sys_logininfor` VALUES (224, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-12 10:44:41');
INSERT INTO `sys_logininfor` VALUES (225, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-12 10:50:50');
INSERT INTO `sys_logininfor` VALUES (226, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-12 11:03:51');
INSERT INTO `sys_logininfor` VALUES (227, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-12 11:07:41');
INSERT INTO `sys_logininfor` VALUES (228, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-12 11:15:50');
INSERT INTO `sys_logininfor` VALUES (229, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '1', '验证码错误', '2020-03-12 11:19:54');
INSERT INTO `sys_logininfor` VALUES (230, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-12 11:19:59');
INSERT INTO `sys_logininfor` VALUES (231, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-12 11:31:56');
INSERT INTO `sys_logininfor` VALUES (232, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '1', '验证码错误', '2020-03-12 12:25:16');
INSERT INTO `sys_logininfor` VALUES (233, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-12 12:25:23');
INSERT INTO `sys_logininfor` VALUES (234, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-13 10:49:58');
INSERT INTO `sys_logininfor` VALUES (235, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-14 16:20:55');
INSERT INTO `sys_logininfor` VALUES (236, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-14 18:33:18');
INSERT INTO `sys_logininfor` VALUES (237, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-14 19:54:10');
INSERT INTO `sys_logininfor` VALUES (238, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-14 20:12:52');
INSERT INTO `sys_logininfor` VALUES (239, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-14 22:27:59');
INSERT INTO `sys_logininfor` VALUES (240, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-15 17:01:21');
INSERT INTO `sys_logininfor` VALUES (241, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-15 19:28:01');
INSERT INTO `sys_logininfor` VALUES (242, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-15 22:16:46');
INSERT INTO `sys_logininfor` VALUES (243, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-15 22:20:23');
INSERT INTO `sys_logininfor` VALUES (244, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-15 22:21:28');
INSERT INTO `sys_logininfor` VALUES (245, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-16 01:12:57');
INSERT INTO `sys_logininfor` VALUES (246, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '1', '验证码错误', '2020-03-16 01:21:06');
INSERT INTO `sys_logininfor` VALUES (247, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-16 01:21:26');
INSERT INTO `sys_logininfor` VALUES (248, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-16 03:25:54');
INSERT INTO `sys_logininfor` VALUES (249, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-16 04:27:13');
INSERT INTO `sys_logininfor` VALUES (250, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-16 10:37:20');
INSERT INTO `sys_logininfor` VALUES (251, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-16 11:10:01');
INSERT INTO `sys_logininfor` VALUES (252, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-16 12:28:09');
INSERT INTO `sys_logininfor` VALUES (253, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-16 12:33:21');
INSERT INTO `sys_logininfor` VALUES (254, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-16 16:37:50');
INSERT INTO `sys_logininfor` VALUES (255, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-16 17:08:03');
INSERT INTO `sys_logininfor` VALUES (256, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-16 17:37:19');
INSERT INTO `sys_logininfor` VALUES (257, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-16 17:42:12');
INSERT INTO `sys_logininfor` VALUES (258, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-16 19:43:56');
INSERT INTO `sys_logininfor` VALUES (259, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-16 20:17:14');
INSERT INTO `sys_logininfor` VALUES (260, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-16 20:17:19');
INSERT INTO `sys_logininfor` VALUES (261, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-16 22:28:05');
INSERT INTO `sys_logininfor` VALUES (262, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '1', '验证码错误', '2020-03-18 16:35:46');
INSERT INTO `sys_logininfor` VALUES (263, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-18 16:35:50');
INSERT INTO `sys_logininfor` VALUES (264, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-18 20:04:12');
INSERT INTO `sys_logininfor` VALUES (265, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-19 21:45:02');
INSERT INTO `sys_logininfor` VALUES (266, 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-03-23 15:47:27');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '菜单名称',
  `parent_id` bigint(20) NULL DEFAULT 0 COMMENT '父菜单ID',
  `order_num` int(4) NULL DEFAULT 0 COMMENT '显示顺序',
  `path` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '路由地址',
  `component` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '组件路径',
  `is_frame` int(1) NULL DEFAULT 1 COMMENT '是否为外链（0是 1否）',
  `menu_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `perms` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '#' COMMENT '菜单图标',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1126 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '菜单权限表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, '系统管理', 0, 3, 'system', NULL, 1, 'M', '0', '', 'system', 'admin', '2018-03-16 11:33:00', 'admin', '2020-03-04 17:05:37', '系统管理目录');
INSERT INTO `sys_menu` VALUES (2, '系统监控', 0, 4, 'monitor', NULL, 1, 'M', '0', '', 'monitor', 'admin', '2018-03-16 11:33:00', 'admin', '2020-03-04 17:05:46', '系统监控目录');
INSERT INTO `sys_menu` VALUES (3, '系统工具', 0, 5, 'tool', NULL, 1, 'M', '0', '', 'tool', 'admin', '2018-03-16 11:33:00', 'admin', '2020-03-04 17:05:52', '系统工具目录');
INSERT INTO `sys_menu` VALUES (4, '若依官网', 0, 6, 'http://ruoyi.vip', NULL, 0, 'M', '1', '', 'guide', 'admin', '2018-03-16 11:33:00', 'admin', '2020-03-18 16:36:59', '若依官网地址');
INSERT INTO `sys_menu` VALUES (100, '用户管理', 1, 1, 'user', 'system/user/index', 1, 'C', '0', 'system:user:list', 'user', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '用户管理菜单');
INSERT INTO `sys_menu` VALUES (101, '角色管理', 1, 2, 'role', 'system/role/index', 1, 'C', '0', 'system:role:list', 'peoples', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '角色管理菜单');
INSERT INTO `sys_menu` VALUES (102, '菜单管理', 1, 3, 'menu', 'system/menu/index', 1, 'C', '0', 'system:menu:list', 'tree-table', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '菜单管理菜单');
INSERT INTO `sys_menu` VALUES (103, '部门管理', 1, 4, 'dept', 'system/dept/index', 1, 'C', '0', 'system:dept:list', 'tree', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '部门管理菜单');
INSERT INTO `sys_menu` VALUES (104, '岗位管理', 1, 5, 'post', 'system/post/index', 1, 'C', '0', 'system:post:list', 'post', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '岗位管理菜单');
INSERT INTO `sys_menu` VALUES (105, '字典管理', 1, 6, 'dict', 'system/dict/index', 1, 'C', '0', 'system:dict:list', 'dict', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '字典管理菜单');
INSERT INTO `sys_menu` VALUES (106, '参数设置', 1, 7, 'config', 'system/config/index', 1, 'C', '0', 'system:config:list', 'edit', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '参数设置菜单');
INSERT INTO `sys_menu` VALUES (107, '通知公告', 1, 8, 'notice', 'system/notice/index', 1, 'C', '0', 'system:notice:list', 'message', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '通知公告菜单');
INSERT INTO `sys_menu` VALUES (108, '日志管理', 1, 9, 'log', 'system/log/index', 1, 'M', '0', '', 'log', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '日志管理菜单');
INSERT INTO `sys_menu` VALUES (109, '在线用户', 2, 1, 'online', 'monitor/online/index', 1, 'C', '0', 'monitor:online:list', 'online', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '在线用户菜单');
INSERT INTO `sys_menu` VALUES (110, '定时任务', 2, 2, 'job', 'monitor/job/index', 1, 'C', '0', 'monitor:job:list', 'job', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '定时任务菜单');
INSERT INTO `sys_menu` VALUES (111, '数据监控', 2, 3, 'druid', 'monitor/druid/index', 1, 'C', '0', 'monitor:druid:list', 'druid', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '数据监控菜单');
INSERT INTO `sys_menu` VALUES (112, '服务监控', 2, 4, 'server', 'monitor/server/index', 1, 'C', '0', 'monitor:server:list', 'server', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '服务监控菜单');
INSERT INTO `sys_menu` VALUES (113, '表单构建', 3, 1, 'build', 'tool/build/index', 1, 'C', '0', 'tool:build:list', 'build', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '表单构建菜单');
INSERT INTO `sys_menu` VALUES (114, '代码生成', 3, 2, 'gen', 'tool/gen/index', 1, 'C', '0', 'tool:gen:list', 'code', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '代码生成菜单');
INSERT INTO `sys_menu` VALUES (115, '系统接口', 3, 3, 'swagger', 'tool/swagger/index', 1, 'C', '0', 'tool:swagger:list', 'swagger', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统接口菜单');
INSERT INTO `sys_menu` VALUES (500, '操作日志', 108, 1, 'operlog', 'monitor/operlog/index', 1, 'C', '0', 'monitor:operlog:list', 'form', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '操作日志菜单');
INSERT INTO `sys_menu` VALUES (501, '登录日志', 108, 2, 'logininfor', 'monitor/logininfor/index', 1, 'C', '0', 'monitor:logininfor:list', 'logininfor', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '登录日志菜单');
INSERT INTO `sys_menu` VALUES (1001, '用户查询', 100, 1, '', '', 1, 'F', '0', 'system:user:query', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1002, '用户新增', 100, 2, '', '', 1, 'F', '0', 'system:user:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1003, '用户修改', 100, 3, '', '', 1, 'F', '0', 'system:user:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1004, '用户删除', 100, 4, '', '', 1, 'F', '0', 'system:user:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1005, '用户导出', 100, 5, '', '', 1, 'F', '0', 'system:user:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1006, '用户导入', 100, 6, '', '', 1, 'F', '0', 'system:user:import', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1007, '重置密码', 100, 7, '', '', 1, 'F', '0', 'system:user:resetPwd', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1008, '角色查询', 101, 1, '', '', 1, 'F', '0', 'system:role:query', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1009, '角色新增', 101, 2, '', '', 1, 'F', '0', 'system:role:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1010, '角色修改', 101, 3, '', '', 1, 'F', '0', 'system:role:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1011, '角色删除', 101, 4, '', '', 1, 'F', '0', 'system:role:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1012, '角色导出', 101, 5, '', '', 1, 'F', '0', 'system:role:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1013, '菜单查询', 102, 1, '', '', 1, 'F', '0', 'system:menu:query', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1014, '菜单新增', 102, 2, '', '', 1, 'F', '0', 'system:menu:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1015, '菜单修改', 102, 3, '', '', 1, 'F', '0', 'system:menu:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1016, '菜单删除', 102, 4, '', '', 1, 'F', '0', 'system:menu:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1017, '部门查询', 103, 1, '', '', 1, 'F', '0', 'system:dept:query', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1018, '部门新增', 103, 2, '', '', 1, 'F', '0', 'system:dept:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1019, '部门修改', 103, 3, '', '', 1, 'F', '0', 'system:dept:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1020, '部门删除', 103, 4, '', '', 1, 'F', '0', 'system:dept:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1021, '岗位查询', 104, 1, '', '', 1, 'F', '0', 'system:post:query', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1022, '岗位新增', 104, 2, '', '', 1, 'F', '0', 'system:post:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1023, '岗位修改', 104, 3, '', '', 1, 'F', '0', 'system:post:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1024, '岗位删除', 104, 4, '', '', 1, 'F', '0', 'system:post:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1025, '岗位导出', 104, 5, '', '', 1, 'F', '0', 'system:post:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1026, '字典查询', 105, 1, '#', '', 1, 'F', '0', 'system:dict:query', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1027, '字典新增', 105, 2, '#', '', 1, 'F', '0', 'system:dict:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1028, '字典修改', 105, 3, '#', '', 1, 'F', '0', 'system:dict:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1029, '字典删除', 105, 4, '#', '', 1, 'F', '0', 'system:dict:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1030, '字典导出', 105, 5, '#', '', 1, 'F', '0', 'system:dict:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1031, '参数查询', 106, 1, '#', '', 1, 'F', '0', 'system:config:query', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1032, '参数新增', 106, 2, '#', '', 1, 'F', '0', 'system:config:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1033, '参数修改', 106, 3, '#', '', 1, 'F', '0', 'system:config:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1034, '参数删除', 106, 4, '#', '', 1, 'F', '0', 'system:config:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1035, '参数导出', 106, 5, '#', '', 1, 'F', '0', 'system:config:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1036, '公告查询', 107, 1, '#', '', 1, 'F', '0', 'system:notice:query', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1037, '公告新增', 107, 2, '#', '', 1, 'F', '0', 'system:notice:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1038, '公告修改', 107, 3, '#', '', 1, 'F', '0', 'system:notice:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1039, '公告删除', 107, 4, '#', '', 1, 'F', '0', 'system:notice:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1040, '操作查询', 500, 1, '#', '', 1, 'F', '0', 'monitor:operlog:query', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1041, '操作删除', 500, 2, '#', '', 1, 'F', '0', 'monitor:operlog:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1042, '日志导出', 500, 4, '#', '', 1, 'F', '0', 'monitor:operlog:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1043, '登录查询', 501, 1, '#', '', 1, 'F', '0', 'monitor:logininfor:query', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1044, '登录删除', 501, 2, '#', '', 1, 'F', '0', 'monitor:logininfor:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1045, '日志导出', 501, 3, '#', '', 1, 'F', '0', 'monitor:logininfor:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1046, '在线查询', 109, 1, '#', '', 1, 'F', '0', 'monitor:online:query', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1047, '批量强退', 109, 2, '#', '', 1, 'F', '0', 'monitor:online:batchLogout', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1048, '单条强退', 109, 3, '#', '', 1, 'F', '0', 'monitor:online:forceLogout', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1049, '任务查询', 110, 1, '#', '', 1, 'F', '0', 'monitor:job:query', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1050, '任务新增', 110, 2, '#', '', 1, 'F', '0', 'monitor:job:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1051, '任务修改', 110, 3, '#', '', 1, 'F', '0', 'monitor:job:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1052, '任务删除', 110, 4, '#', '', 1, 'F', '0', 'monitor:job:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1053, '状态修改', 110, 5, '#', '', 1, 'F', '0', 'monitor:job:changeStatus', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1054, '任务导出', 110, 7, '#', '', 1, 'F', '0', 'monitor:job:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1055, '生成查询', 114, 1, '#', '', 1, 'F', '0', 'tool:gen:query', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1056, '生成修改', 114, 2, '#', '', 1, 'F', '0', 'tool:gen:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1057, '生成删除', 114, 3, '#', '', 1, 'F', '0', 'tool:gen:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1058, '导入代码', 114, 2, '#', '', 1, 'F', '0', 'tool:gen:import', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1059, '预览代码', 114, 4, '#', '', 1, 'F', '0', 'tool:gen:preview', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1060, '生成代码', 114, 5, '#', '', 1, 'F', '0', 'tool:gen:code', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1061, '走航分析', 0, 1, 'voyage/analysis', NULL, 1, 'M', '0', '', 'list', 'admin', '2020-02-20 12:19:36', 'admin', '2020-03-05 17:36:36', '');
INSERT INTO `sys_menu` VALUES (1062, '控制中心', 1061, 1, 'controller', 'voyage/analysis/controller/index', 1, 'C', '0', 'voyage:analysis:controller:index', 'tool', 'admin', '2020-02-20 12:24:43', 'admin', '2020-03-05 17:49:47', '');
INSERT INTO `sys_menu` VALUES (1063, 'VOC走航', 1061, 2, 'cesium', 'voyage/analysis/cesium/index', 1, 'C', '0', 'voyage:analysis:cesium:index', 'component', 'admin', '2020-02-22 00:05:54', 'admin', '2020-03-05 18:28:03', '');
INSERT INTO `sys_menu` VALUES (1064, '设备管理', 1094, 1, 'device', 'voyage/setting/device/index', 1, 'C', '0', 'voyage:setting:device:index', 'eye', 'admin', '2018-03-01 00:00:00', 'admin', '2020-03-05 17:44:41', '走航菜单');
INSERT INTO `sys_menu` VALUES (1065, '走航查询', 1064, 1, '#', '', 1, 'F', '0', 'zh:device:query', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES (1066, '走航新增', 1064, 2, '#', '', 1, 'F', '0', 'zh:device:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES (1067, '走航修改', 1064, 3, '#', '', 1, 'F', '0', 'zh:device:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES (1068, '走航删除', 1064, 4, '#', '', 1, 'F', '0', 'zh:device:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES (1069, '走航导出', 1064, 5, '#', '', 1, 'F', '0', 'zh:device:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES (1070, '走航记录', 1061, 1, 'collectRecord', 'voyage/analysis/collectRecord/index', 1, 'C', '0', 'zh:collectRecord:list', 'chart', 'admin', '2018-03-01 00:00:00', 'admin', '2020-03-05 17:46:51', '走航记录菜单');
INSERT INTO `sys_menu` VALUES (1071, '走航记录查询', 1070, 1, '#', '', 1, 'F', '0', 'zh:collectRecord:query', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES (1072, '走航记录新增', 1070, 2, '#', '', 1, 'F', '0', 'zh:collectRecord:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES (1073, '走航记录修改', 1070, 3, '#', '', 1, 'F', '0', 'zh:collectRecord:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES (1074, '走航记录删除', 1070, 4, '#', '', 1, 'F', '0', 'zh:collectRecord:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES (1075, '走航记录导出', 1070, 5, '#', '', 1, 'F', '0', 'zh:collectRecord:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES (1076, '敏感点', 3, 1, 'point', 'voyage/setting/point/index', 1, 'C', '0', 'zh:point:list', 'example', 'admin', '2018-03-01 00:00:00', 'admin', '2020-03-05 17:47:08', '敏感点菜单');
INSERT INTO `sys_menu` VALUES (1077, '敏感点查询', 1076, 1, '#', '', 1, 'F', '0', 'zh:point:query', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES (1078, '敏感点新增', 1076, 2, '#', '', 1, 'F', '0', 'zh:point:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES (1079, '敏感点修改', 1076, 3, '#', '', 1, 'F', '0', 'zh:point:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES (1080, '敏感点删除', 1076, 4, '#', '', 1, 'F', '0', 'zh:point:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES (1081, '敏感点导出', 1076, 5, '#', '', 1, 'F', '0', 'zh:point:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES (1088, '因子管理', 1094, 1, 'factor', 'voyage/setting/factor/index', 1, 'C', '0', 'zh:factor:list', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-03-05 17:43:45', '因子菜单');
INSERT INTO `sys_menu` VALUES (1089, '因子查询', 1088, 1, '#', '', 1, 'F', '0', 'zh:factor:query', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES (1090, '因子新增', 1088, 2, '#', '', 1, 'F', '0', 'zh:factor:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES (1091, '因子修改', 1088, 3, '#', '', 1, 'F', '0', 'zh:factor:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES (1092, '因子删除', 1088, 4, '#', '', 1, 'F', '0', 'zh:factor:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES (1093, '因子导出', 1088, 5, '#', '', 1, 'F', '0', 'zh:factor:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES (1094, '走航设置', 0, 2, 'voyage/setting', NULL, 1, 'M', '0', '', 'dashboard', 'admin', '2020-03-04 16:54:34', 'admin', '2020-03-05 17:36:47', '');
INSERT INTO `sys_menu` VALUES (1095, '物质因子颜色关联', 1094, 1, 'categoryFactorColor', 'voyage/setting/categoryFactorColor/index', 1, 'C', '0', 'zh:categoryFactorColor:list', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-03-05 17:45:21', '物质因子颜色关联菜单');
INSERT INTO `sys_menu` VALUES (1096, '物质因子颜色关联查询', 1095, 1, '#', '', 1, 'F', '0', 'zh:categoryFactorColor:query', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES (1097, '物质因子颜色关联新增', 1095, 2, '#', '', 1, 'F', '0', 'zh:categoryFactorColor:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES (1098, '物质因子颜色关联修改', 1095, 3, '#', '', 1, 'F', '0', 'zh:categoryFactorColor:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES (1099, '物质因子颜色关联删除', 1095, 4, '#', '', 1, 'F', '0', 'zh:categoryFactorColor:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES (1100, '物质因子颜色关联导出', 1095, 5, '#', '', 1, 'F', '0', 'zh:categoryFactorColor:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES (1101, '单个物质因子颜色关联', 1094, 1, 'categoryFactorSimpleColor', 'voyage/setting/categoryFactorSimpleColor/index', 1, 'C', '0', 'zh:categoryFactorSimpleColor:list', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-03-05 17:45:30', '单个物质因子颜色关联菜单');
INSERT INTO `sys_menu` VALUES (1102, '单个物质因子颜色关联查询', 1101, 1, '#', '', 1, 'F', '0', 'zh:categoryFactorSimpleColor:query', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES (1103, '单个物质因子颜色关联新增', 1101, 2, '#', '', 1, 'F', '0', 'zh:categoryFactorSimpleColor:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES (1104, '单个物质因子颜色关联修改', 1101, 3, '#', '', 1, 'F', '0', 'zh:categoryFactorSimpleColor:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES (1105, '单个物质因子颜色关联删除', 1101, 4, '#', '', 1, 'F', '0', 'zh:categoryFactorSimpleColor:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES (1106, '单个物质因子颜色关联导出', 1101, 5, '#', '', 1, 'F', '0', 'zh:categoryFactorSimpleColor:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES (1107, '颜色标准', 1094, 1, 'category', 'voyage/setting/category/index', 1, 'C', '0', 'zh:category:list', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-03-05 17:45:43', '颜色标准菜单');
INSERT INTO `sys_menu` VALUES (1108, '颜色标准查询', 1107, 1, '#', '', 1, 'F', '0', 'zh:category:query', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES (1109, '颜色标准新增', 1107, 2, '#', '', 1, 'F', '0', 'zh:category:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES (1110, '颜色标准修改', 1107, 3, '#', '', 1, 'F', '0', 'zh:category:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES (1111, '颜色标准删除', 1107, 4, '#', '', 1, 'F', '0', 'zh:category:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES (1112, '颜色标准导出', 1107, 5, '#', '', 1, 'F', '0', 'zh:category:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES (1113, '颜色', 1094, 1, 'color', 'voyage/setting/color/index', 1, 'C', '0', 'zh:color:list', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-03-05 17:45:51', '颜色菜单');
INSERT INTO `sys_menu` VALUES (1114, '颜色查询', 1113, 1, '#', '', 1, 'F', '0', 'zh:color:query', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES (1115, '颜色新增', 1113, 2, '#', '', 1, 'F', '0', 'zh:color:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES (1116, '颜色修改', 1113, 3, '#', '', 1, 'F', '0', 'zh:color:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES (1117, '颜色删除', 1113, 4, '#', '', 1, 'F', '0', 'zh:color:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES (1118, '颜色导出', 1113, 5, '#', '', 1, 'F', '0', 'zh:color:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES (1119, '单个颜色各范围', 1094, 1, 'simpleColor', 'voyage/setting/simpleColor/index', 1, 'C', '0', 'zh:simpleColor:list', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-03-05 17:45:58', '物质因子颜色关联菜单');
INSERT INTO `sys_menu` VALUES (1120, '单个颜色各范围查询', 1119, 1, '#', '', 1, 'F', '0', 'zh:simpleColor:query', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-03-04 17:32:17', '');
INSERT INTO `sys_menu` VALUES (1121, '单个颜色各范围新增', 1119, 2, '#', '', 1, 'F', '0', 'zh:simpleColor:add', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-03-04 17:32:24', '');
INSERT INTO `sys_menu` VALUES (1122, '单个颜色各范围修改', 1119, 3, '#', '', 1, 'F', '0', 'zh:simpleColor:edit', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-03-04 17:32:31', '');
INSERT INTO `sys_menu` VALUES (1123, '单个颜色各范围删除', 1119, 4, '#', '', 1, 'F', '0', 'zh:simpleColor:remove', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-03-04 17:32:40', '');
INSERT INTO `sys_menu` VALUES (1124, '单个颜色各范围导出', 1119, 5, '#', '', 1, 'F', '0', 'zh:simpleColor:export', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2020-03-04 17:32:49', '');
INSERT INTO `sys_menu` VALUES (1125, '走航测试', 1061, 4, 'cesium/test', 'voyage/analysis/cesium/test', 1, 'C', '0', 'voyage:analysis:cesium:test', '404', 'admin', '2020-03-06 15:21:50', 'admin', '2020-03-06 15:22:25', '');

-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice`  (
  `notice_id` int(4) NOT NULL AUTO_INCREMENT COMMENT '公告ID',
  `notice_title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '公告标题',
  `notice_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '公告类型（1通知 2公告）',
  `notice_content` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '公告内容',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '公告状态（0正常 1关闭）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`notice_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '通知公告表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_notice
-- ----------------------------
INSERT INTO `sys_notice` VALUES (1, '温馨提醒：2018-07-01 若依新版本发布啦', '2', '新版本内容', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '管理员');
INSERT INTO `sys_notice` VALUES (2, '维护通知：2018-07-01 若依系统凌晨维护', '1', '维护内容', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '管理员');

-- ----------------------------
-- Table structure for sys_oper_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_oper_log`;
CREATE TABLE `sys_oper_log`  (
  `oper_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志主键',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '模块标题',
  `business_type` int(2) NULL DEFAULT 0 COMMENT '业务类型（0其它 1新增 2修改 3删除）',
  `method` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '方法名称',
  `request_method` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '请求方式',
  `operator_type` int(1) NULL DEFAULT 0 COMMENT '操作类别（0其它 1后台用户 2手机端用户）',
  `oper_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '操作人员',
  `dept_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '部门名称',
  `oper_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '请求URL',
  `oper_ip` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '主机地址',
  `oper_location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '操作地点',
  `oper_param` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '请求参数',
  `json_result` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '返回参数',
  `status` int(1) NULL DEFAULT 0 COMMENT '操作状态（0正常 1异常）',
  `error_msg` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '错误消息',
  `oper_time` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`oper_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 140 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '操作日志记录' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_oper_log
-- ----------------------------
INSERT INTO `sys_oper_log` VALUES (1, '菜单管理', 1, 'com.ruoyi.project.system.controller.SysMenuController.add()', 'POST', 1, 'admin', NULL, '/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"list\",\"orderNum\":\"1\",\"menuName\":\"全局配置\",\"params\":{},\"parentId\":0,\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"M\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-02-20 12:19:36');
INSERT INTO `sys_oper_log` VALUES (2, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"list\",\"orderNum\":\"0\",\"menuName\":\"全局配置\",\"params\":{},\"parentId\":0,\"path\":\"\",\"children\":[],\"createTime\":1582172376000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1061,\"menuType\":\"M\",\"perms\":\"\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-02-20 12:20:54');
INSERT INTO `sys_oper_log` VALUES (3, '菜单管理', 1, 'com.ruoyi.project.system.controller.SysMenuController.add()', 'POST', 1, 'admin', NULL, '/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"tool\",\"orderNum\":\"1\",\"menuName\":\"连接设置\",\"params\":{},\"parentId\":1061,\"path\":\"global\",\"component\":\"config/global/index\",\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"C\",\"perms\":\"config:global:index\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-02-20 12:24:44');
INSERT INTO `sys_oper_log` VALUES (4, '菜单管理', 1, 'com.ruoyi.project.system.controller.SysMenuController.add()', 'POST', 1, 'admin', NULL, '/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"component\",\"orderNum\":\"2\",\"menuName\":\"zh\",\"params\":{},\"parentId\":1061,\"path\":\"zh\",\"component\":\"/zh/CesiumViewer\",\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"C\",\"perms\":\"zh:cesiumviewer\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-02-22 00:05:54');
INSERT INTO `sys_oper_log` VALUES (5, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"component\",\"orderNum\":\"2\",\"menuName\":\"zh\",\"params\":{},\"parentId\":1061,\"path\":\"zh\",\"component\":\"zh/CesiumViewer\",\"children\":[],\"createTime\":1582301154000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1063,\"menuType\":\"C\",\"perms\":\"zh:cesiumviewer\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-02-22 00:07:20');
INSERT INTO `sys_oper_log` VALUES (6, '代码生成', 6, 'com.ruoyi.project.tool.gen.controller.GenController.importTableSave()', 'POST', 1, 'admin', NULL, '/ruoyi/tool/gen/importTable', '127.0.0.1', '内网IP', 'zh_device', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-02-23 17:11:04');
INSERT INTO `sys_oper_log` VALUES (7, '代码生成', 8, 'com.ruoyi.project.tool.gen.controller.GenController.batchGenCode()', 'GET', 1, 'admin', NULL, '/ruoyi/tool/gen/batchGenCode', '127.0.0.1', '内网IP', '{}', 'null', 0, NULL, '2020-02-23 17:19:33');
INSERT INTO `sys_oper_log` VALUES (8, '走航', 1, 'com.ruoyi.zh.controller.ZhDeviceController.add()', 'POST', 1, 'admin', NULL, '/ruoyi/zh/device', '127.0.0.1', '内网IP', '{\"img\":\"第三方\",\"address\":\"加速器\",\"code\":\"SPIMS001\",\"correctStatus\":0,\"updatedDate\":1582387200000,\"params\":{},\"weatherStatus\":0,\"createdDate\":1582041600000,\"gpsStatus\":0,\"name\":\"SPIMS测试\",\"company\":\"广州禾信\",\"status\":0}', 'null', 1, '\r\n### Error updating database.  Cause: java.sql.SQLException: Field \'id\' doesn\'t have a default value\r\n### The error may involve com.ruoyi.zh.mapper.ZhDeviceMapper.insertZhDevice-Inline\r\n### The error occurred while setting parameters\r\n### SQL: insert into zh_device          ( name,             code,             company,             address,             img,             status,             correct_status,             weather_status,             gps_status,             created_date,             updated_date )           values ( ?,             ?,             ?,             ?,             ?,             ?,             ?,             ?,             ?,             ?,             ? )\r\n### Cause: java.sql.SQLException: Field \'id\' doesn\'t have a default value\n; Field \'id\' doesn\'t have a default value; nested exception is java.sql.SQLException: Field \'id\' doesn\'t have a default value', '2020-02-23 17:42:15');
INSERT INTO `sys_oper_log` VALUES (9, '走航', 1, 'com.ruoyi.zh.controller.ZhDeviceController.add()', 'POST', 1, 'admin', NULL, '/ruoyi/zh/device', '127.0.0.1', '内网IP', '{\"img\":\"第三方\",\"address\":\"加速器\",\"code\":\"SPIMS001\",\"correctStatus\":0,\"updatedDate\":1582387200000,\"params\":{},\"weatherStatus\":0,\"createdDate\":1582041600000,\"gpsStatus\":0,\"name\":\"SPIMS测试\",\"company\":\"广州禾信\",\"status\":0}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-02-23 17:42:42');
INSERT INTO `sys_oper_log` VALUES (10, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"list\",\"orderNum\":\"0\",\"menuName\":\"走航分析\",\"params\":{},\"parentId\":0,\"path\":\"\",\"children\":[],\"createTime\":1582172376000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1061,\"menuType\":\"M\",\"perms\":\"\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-02-23 18:08:22');
INSERT INTO `sys_oper_log` VALUES (11, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"component\",\"orderNum\":\"2\",\"menuName\":\"VOC走航\",\"params\":{},\"parentId\":1061,\"path\":\"zh\",\"component\":\"zh/CesiumViewer\",\"children\":[],\"createTime\":1582301154000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1063,\"menuType\":\"C\",\"perms\":\"zh:cesiumviewer\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-02-23 18:08:50');
INSERT INTO `sys_oper_log` VALUES (12, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"#\",\"orderNum\":\"1\",\"menuName\":\"走航\",\"params\":{},\"parentId\":1061,\"path\":\"device\",\"component\":\"zh/device/index\",\"children\":[],\"createTime\":1519833600000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1064,\"menuType\":\"C\",\"perms\":\"zh:device:list\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-02-23 18:09:15');
INSERT INTO `sys_oper_log` VALUES (13, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"#\",\"orderNum\":\"1\",\"menuName\":\"设备控制\",\"params\":{},\"parentId\":1061,\"path\":\"device\",\"component\":\"zh/device/index\",\"children\":[],\"createTime\":1519833600000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1064,\"menuType\":\"C\",\"perms\":\"zh:device:list\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-02-23 18:09:39');
INSERT INTO `sys_oper_log` VALUES (14, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"eye\",\"orderNum\":\"1\",\"menuName\":\"设备控制\",\"params\":{},\"parentId\":1061,\"path\":\"device\",\"component\":\"zh/device/index\",\"children\":[],\"createTime\":1519833600000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1064,\"menuType\":\"C\",\"perms\":\"zh:device:list\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-02-24 00:41:20');
INSERT INTO `sys_oper_log` VALUES (15, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"eye\",\"orderNum\":\"1\",\"menuName\":\"设备管理\",\"params\":{},\"parentId\":1061,\"path\":\"device\",\"component\":\"zh/device/index\",\"children\":[],\"createTime\":1519833600000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1064,\"menuType\":\"C\",\"perms\":\"zh:device:list\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-02-24 02:51:20');
INSERT INTO `sys_oper_log` VALUES (16, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"tool\",\"orderNum\":\"1\",\"menuName\":\"控制中心\",\"params\":{},\"parentId\":1061,\"path\":\"global\",\"component\":\"config/global/index\",\"children\":[],\"createTime\":1582172683000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1062,\"menuType\":\"C\",\"perms\":\"config:global:index\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-02-24 02:51:33');
INSERT INTO `sys_oper_log` VALUES (17, '用户管理', 5, 'com.ruoyi.project.system.controller.SysUserController.export()', 'GET', 1, 'admin', NULL, '/ruoyi/system/user/export', '127.0.0.1', '内网IP', '{}', '{\"msg\":\"b6a0e679-330a-42b7-aa7d-4b8df4f07dcc_用户数据.xlsx\",\"code\":200}', 0, NULL, '2020-02-24 11:02:08');
INSERT INTO `sys_oper_log` VALUES (18, '代码生成', 6, 'com.ruoyi.project.tool.gen.controller.GenController.importTableSave()', 'POST', 1, 'admin', NULL, '/ruoyi/tool/gen/importTable', '127.0.0.1', '内网IP', 'zh_collect_record,zh_point', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-02-24 19:15:57');
INSERT INTO `sys_oper_log` VALUES (19, '代码生成', 2, 'com.ruoyi.project.tool.gen.controller.GenController.editSave()', 'PUT', 1, 'admin', NULL, '/ruoyi/tool/gen', '127.0.0.1', '内网IP', '{\"functionAuthor\":\"ruoyi\",\"columns\":[{\"usableColumn\":false,\"columnId\":13,\"isIncrement\":\"1\",\"increment\":true,\"insert\":true,\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"id\",\"htmlType\":\"input\",\"edit\":false,\"query\":false,\"columnComment\":\"id\",\"sort\":1,\"list\":false,\"params\":{},\"javaType\":\"Long\",\"queryType\":\"EQ\",\"columnType\":\"int(11)\",\"createBy\":\"admin\",\"isPk\":\"1\",\"createTime\":1582542957000,\"tableId\":2,\"pk\":true,\"columnName\":\"id\"},{\"usableColumn\":false,\"columnId\":14,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"deviceCode\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"设备编号\",\"isQuery\":\"1\",\"sort\":2,\"list\":true,\"params\":{},\"javaType\":\"String\",\"queryType\":\"EQ\",\"columnType\":\"varchar(50)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1582542957000,\"isEdit\":\"1\",\"tableId\":2,\"pk\":false,\"columnName\":\"device_code\"},{\"usableColumn\":false,\"columnId\":15,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"startTime\",\"htmlType\":\"datetime\",\"edit\":true,\"query\":true,\"columnComment\":\"开始时间\",\"isQuery\":\"1\",\"sort\":3,\"list\":true,\"params\":{},\"javaType\":\"Date\",\"queryType\":\"EQ\",\"columnType\":\"datetime\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1582542957000,\"isEdit\":\"1\",\"tableId\":2,\"pk\":false,\"columnName\":\"start_time\"},{\"usableColumn\":false,\"columnId\":16,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"endTime\",\"htmlType\":\"datetime\",\"edit\":true,\"query\":true,\"columnComment\":\"结束时间\",\"isQuery\":\"1\",\"sort\":4,\"list\":true,\"params\":{},\"javaType\":\"Date\",\"queryType\":\"EQ\",\"columnType\":\"datetime\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1582542957000,\"isEdit\":\"1\",\"tableId\":2,\"pk\":false,\"columnName\":\"end_time\"},{\"usableCol', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-02-24 19:28:41');
INSERT INTO `sys_oper_log` VALUES (20, '代码生成', 2, 'com.ruoyi.project.tool.gen.controller.GenController.editSave()', 'PUT', 1, 'admin', NULL, '/ruoyi/tool/gen', '127.0.0.1', '内网IP', '{\"functionAuthor\":\"ruoyi\",\"columns\":[{\"usableColumn\":false,\"columnId\":13,\"isIncrement\":\"1\",\"increment\":true,\"insert\":true,\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"id\",\"htmlType\":\"input\",\"edit\":false,\"query\":false,\"columnComment\":\"id\",\"updateTime\":1582543721000,\"sort\":1,\"list\":false,\"params\":{},\"javaType\":\"Long\",\"queryType\":\"EQ\",\"columnType\":\"int(11)\",\"createBy\":\"admin\",\"isPk\":\"1\",\"createTime\":1582542957000,\"tableId\":2,\"pk\":true,\"columnName\":\"id\"},{\"usableColumn\":false,\"columnId\":14,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"deviceCode\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"设备编号\",\"isQuery\":\"1\",\"updateTime\":1582543721000,\"sort\":2,\"list\":true,\"params\":{},\"javaType\":\"String\",\"queryType\":\"EQ\",\"columnType\":\"varchar(50)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1582542957000,\"isEdit\":\"1\",\"tableId\":2,\"pk\":false,\"columnName\":\"device_code\"},{\"usableColumn\":false,\"columnId\":15,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"startTime\",\"htmlType\":\"datetime\",\"edit\":true,\"query\":true,\"columnComment\":\"开始时间\",\"isQuery\":\"1\",\"updateTime\":1582543721000,\"sort\":3,\"list\":true,\"params\":{},\"javaType\":\"Date\",\"queryType\":\"EQ\",\"columnType\":\"datetime\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1582542957000,\"isEdit\":\"1\",\"tableId\":2,\"pk\":false,\"columnName\":\"start_time\"},{\"usableColumn\":false,\"columnId\":16,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"endTime\",\"htmlType\":\"datetime\",\"edit\":true,\"query\":true,\"columnComment\":\"结束时间\",\"isQuery\":\"1\",\"updateTime\":1582543721000,\"sort\":4,\"list\":true,\"params\":{},\"javaType\":\"Date\",\"queryType\":\"EQ\",\"columnType\":\"datetime\",\"createBy\":\"admin\",\"i', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-02-24 19:39:20');
INSERT INTO `sys_oper_log` VALUES (21, '代码生成', 2, 'com.ruoyi.project.tool.gen.controller.GenController.editSave()', 'PUT', 1, 'admin', NULL, '/ruoyi/tool/gen', '127.0.0.1', '内网IP', '{\"functionAuthor\":\"ruoyi\",\"columns\":[{\"usableColumn\":false,\"columnId\":18,\"isIncrement\":\"1\",\"increment\":true,\"insert\":true,\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"id\",\"htmlType\":\"input\",\"edit\":false,\"query\":false,\"columnComment\":\"id\",\"sort\":1,\"list\":false,\"params\":{},\"javaType\":\"Long\",\"queryType\":\"EQ\",\"columnType\":\"int(11)\",\"createBy\":\"admin\",\"isPk\":\"1\",\"createTime\":1582542957000,\"tableId\":3,\"pk\":true,\"columnName\":\"id\"},{\"usableColumn\":false,\"columnId\":19,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"name\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"敏感点名称\",\"isQuery\":\"1\",\"sort\":2,\"list\":true,\"params\":{},\"javaType\":\"String\",\"queryType\":\"LIKE\",\"columnType\":\"varchar(50)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1582542957000,\"isEdit\":\"1\",\"tableId\":3,\"pk\":false,\"columnName\":\"name\"},{\"usableColumn\":false,\"columnId\":20,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"createdTime\",\"htmlType\":\"datetime\",\"edit\":true,\"query\":true,\"columnComment\":\"创建时间\",\"isQuery\":\"1\",\"sort\":3,\"list\":true,\"params\":{},\"javaType\":\"Date\",\"queryType\":\"EQ\",\"columnType\":\"datetime\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1582542957000,\"isEdit\":\"1\",\"tableId\":3,\"pk\":false,\"columnName\":\"created_time\"},{\"usableColumn\":false,\"columnId\":21,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"updatedTime\",\"htmlType\":\"datetime\",\"edit\":true,\"query\":true,\"columnComment\":\"修改时间\",\"isQuery\":\"1\",\"sort\":4,\"list\":true,\"params\":{},\"javaType\":\"Date\",\"queryType\":\"EQ\",\"columnType\":\"datetime\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1582542957000,\"isEdit\":\"1\",\"tableId\":3,\"pk\":false,\"columnName\":\"updated_time\"}],\"busines', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-02-24 19:40:12');
INSERT INTO `sys_oper_log` VALUES (22, '代码生成', 2, 'com.ruoyi.project.tool.gen.controller.GenController.editSave()', 'PUT', 1, 'admin', NULL, '/ruoyi/tool/gen', '127.0.0.1', '内网IP', '{\"functionAuthor\":\"ruoyi\",\"columns\":[{\"usableColumn\":false,\"columnId\":1,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"id\",\"htmlType\":\"input\",\"edit\":false,\"query\":false,\"columnComment\":\"设备id\",\"sort\":1,\"list\":false,\"params\":{},\"javaType\":\"Long\",\"queryType\":\"EQ\",\"columnType\":\"int(11)\",\"createBy\":\"admin\",\"isPk\":\"1\",\"createTime\":1582449064000,\"tableId\":1,\"pk\":true,\"columnName\":\"id\"},{\"usableColumn\":false,\"columnId\":2,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"name\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"设备名称\",\"isQuery\":\"1\",\"sort\":2,\"list\":true,\"params\":{},\"javaType\":\"String\",\"queryType\":\"LIKE\",\"columnType\":\"varchar(20)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1582449064000,\"isEdit\":\"1\",\"tableId\":1,\"pk\":false,\"columnName\":\"name\"},{\"usableColumn\":false,\"columnId\":3,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"code\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"设备编号\",\"isQuery\":\"1\",\"sort\":3,\"list\":true,\"params\":{},\"javaType\":\"String\",\"queryType\":\"EQ\",\"columnType\":\"varchar(50)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1582449064000,\"isEdit\":\"1\",\"tableId\":1,\"pk\":false,\"columnName\":\"code\"},{\"usableColumn\":false,\"columnId\":4,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"company\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"公司名称\",\"isQuery\":\"1\",\"sort\":4,\"list\":true,\"params\":{},\"javaType\":\"String\",\"queryType\":\"EQ\",\"columnType\":\"varchar(50)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1582449064000,\"isEdit\":\"1\",\"tableId\":1,\"pk\":false,\"columnName\":\"company\"},{\"usableColumn\"', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-02-24 19:40:31');
INSERT INTO `sys_oper_log` VALUES (23, '代码生成', 8, 'com.ruoyi.project.tool.gen.controller.GenController.batchGenCode()', 'GET', 1, 'admin', NULL, '/ruoyi/tool/gen/batchGenCode', '127.0.0.1', '内网IP', '{}', 'null', 0, NULL, '2020-02-24 20:39:39');
INSERT INTO `sys_oper_log` VALUES (24, '走航记录', 1, 'com.ruoyi.zh.controller.ZhCollectRecordController.add()', 'POST', 1, 'admin', NULL, '/ruoyi/zh/collectRecord', '127.0.0.1', '内网IP', '{\"pointName\":\"士大夫\",\"startTime\":1580486400000,\"deviceCode\":\"1\",\"endTime\":1582473600000,\"id\":1}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-02-24 20:55:00');
INSERT INTO `sys_oper_log` VALUES (25, '敏感点', 1, 'com.ruoyi.zh.controller.ZhPointController.add()', 'POST', 1, 'admin', NULL, '/ruoyi/zh/point', '127.0.0.1', '内网IP', '{\"updatedTime\":1582473600000,\"params\":{},\"name\":\"广州\",\"createdTime\":1582473600000,\"id\":1}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-02-24 20:55:15');
INSERT INTO `sys_oper_log` VALUES (26, '代码生成', 3, 'com.ruoyi.project.tool.gen.controller.GenController.remove()', 'DELETE', 1, 'admin', NULL, '/ruoyi/tool/gen/3', '127.0.0.1', '内网IP', '{tableIds=3}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-02-24 20:59:56');
INSERT INTO `sys_oper_log` VALUES (27, '代码生成', 6, 'com.ruoyi.project.tool.gen.controller.GenController.importTableSave()', 'POST', 1, 'admin', NULL, '/ruoyi/tool/gen/importTable', '127.0.0.1', '内网IP', 'zh_point', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-02-24 21:00:11');
INSERT INTO `sys_oper_log` VALUES (28, '代码生成', 2, 'com.ruoyi.project.tool.gen.controller.GenController.editSave()', 'PUT', 1, 'admin', NULL, '/ruoyi/tool/gen', '127.0.0.1', '内网IP', '{\"functionAuthor\":\"ruoyi\",\"columns\":[{\"usableColumn\":false,\"columnId\":22,\"isIncrement\":\"1\",\"increment\":true,\"insert\":true,\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"id\",\"htmlType\":\"input\",\"edit\":false,\"query\":false,\"columnComment\":\"id\",\"sort\":1,\"list\":false,\"params\":{},\"javaType\":\"Long\",\"queryType\":\"EQ\",\"columnType\":\"int(11)\",\"createBy\":\"admin\",\"isPk\":\"1\",\"createTime\":1582549211000,\"tableId\":4,\"pk\":true,\"columnName\":\"id\"},{\"usableColumn\":false,\"columnId\":23,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"name\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"名称\",\"isQuery\":\"1\",\"sort\":2,\"list\":true,\"params\":{},\"javaType\":\"String\",\"queryType\":\"LIKE\",\"columnType\":\"varchar(50)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1582549211000,\"isEdit\":\"1\",\"tableId\":4,\"pk\":false,\"columnName\":\"name\"},{\"usableColumn\":false,\"columnId\":24,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"lng\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"经度\",\"isQuery\":\"1\",\"sort\":3,\"list\":true,\"params\":{},\"javaType\":\"String\",\"queryType\":\"EQ\",\"columnType\":\"varchar(50)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1582549211000,\"isEdit\":\"1\",\"tableId\":4,\"pk\":false,\"columnName\":\"lng\"},{\"usableColumn\":false,\"columnId\":25,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"lat\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"纬度\",\"isQuery\":\"1\",\"sort\":4,\"list\":true,\"params\":{},\"javaType\":\"String\",\"queryType\":\"EQ\",\"columnType\":\"varchar(50)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1582549211000,\"isEdit\":\"1\",\"tableId\":4,\"pk\":false,\"columnName\":\"lat\"},{\"usableColumn', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-02-24 21:00:49');
INSERT INTO `sys_oper_log` VALUES (29, '代码生成', 8, 'com.ruoyi.project.tool.gen.controller.GenController.batchGenCode()', 'GET', 1, 'admin', NULL, '/ruoyi/tool/gen/batchGenCode', '127.0.0.1', '内网IP', '{}', 'null', 0, NULL, '2020-02-24 21:00:53');
INSERT INTO `sys_oper_log` VALUES (30, '控点', 1, 'com.ruoyi.zh.controller.ZhPointController.add()', 'POST', 1, 'admin', NULL, '/ruoyi/zh/point', '127.0.0.1', '内网IP', '{\"lng\":\"113\",\"params\":{},\"name\":\"广州禾信\",\"id\":1,\"lat\":\"23\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-02-24 21:04:52');
INSERT INTO `sys_oper_log` VALUES (31, '走航记录', 3, 'com.ruoyi.zh.controller.ZhCollectRecordController.remove()', 'DELETE', 1, 'admin', NULL, '/ruoyi/zh/collectRecord/2', '127.0.0.1', '内网IP', '{ids=2}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-02-26 20:29:52');
INSERT INTO `sys_oper_log` VALUES (32, '走航记录', 3, 'com.ruoyi.zh.controller.ZhCollectRecordController.remove()', 'DELETE', 1, 'admin', NULL, '/ruoyi/zh/collectRecord/4', '127.0.0.1', '内网IP', '{ids=4}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-02-26 20:29:55');
INSERT INTO `sys_oper_log` VALUES (33, '走航记录', 3, 'com.ruoyi.zh.controller.ZhCollectRecordController.remove()', 'DELETE', 1, 'admin', NULL, '/ruoyi/zh/collectRecord/6', '127.0.0.1', '内网IP', '{ids=6}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-02-26 20:29:58');
INSERT INTO `sys_oper_log` VALUES (34, '走航记录', 3, 'com.ruoyi.zh.controller.ZhCollectRecordController.remove()', 'DELETE', 1, 'admin', NULL, '/ruoyi/zh/collectRecord/7', '127.0.0.1', '内网IP', '{ids=7}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-02-26 20:30:01');
INSERT INTO `sys_oper_log` VALUES (35, '走航记录', 3, 'com.ruoyi.zh.controller.ZhCollectRecordController.remove()', 'DELETE', 1, 'admin', NULL, '/ruoyi/zh/collectRecord/10', '127.0.0.1', '内网IP', '{ids=10}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-02-26 20:30:03');
INSERT INTO `sys_oper_log` VALUES (36, '走航记录', 3, 'com.ruoyi.zh.controller.ZhCollectRecordController.remove()', 'DELETE', 1, 'admin', NULL, '/ruoyi/zh/collectRecord/11', '127.0.0.1', '内网IP', '{ids=11}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-02-26 20:30:07');
INSERT INTO `sys_oper_log` VALUES (37, '走航记录', 3, 'com.ruoyi.zh.controller.ZhCollectRecordController.remove()', 'DELETE', 1, 'admin', NULL, '/ruoyi/zh/collectRecord/15', '127.0.0.1', '内网IP', '{ids=15}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-02-26 20:30:10');
INSERT INTO `sys_oper_log` VALUES (38, '代码生成', 6, 'com.ruoyi.project.tool.gen.controller.GenController.importTableSave()', 'POST', 1, 'admin', NULL, '/ruoyi/tool/gen/importTable', '127.0.0.1', '内网IP', 'zh_color', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-03 17:56:33');
INSERT INTO `sys_oper_log` VALUES (39, '代码生成', 2, 'com.ruoyi.project.tool.gen.controller.GenController.editSave()', 'PUT', 1, 'admin', NULL, '/ruoyi/tool/gen', '127.0.0.1', '内网IP', '{\"functionAuthor\":\"ruoyi\",\"columns\":[{\"usableColumn\":false,\"columnId\":28,\"isIncrement\":\"1\",\"increment\":true,\"insert\":true,\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"id\",\"htmlType\":\"input\",\"edit\":false,\"query\":false,\"columnComment\":\"编号\",\"sort\":1,\"list\":false,\"params\":{},\"javaType\":\"Long\",\"queryType\":\"EQ\",\"columnType\":\"int(11)\",\"createBy\":\"admin\",\"isPk\":\"1\",\"createTime\":1583229393000,\"tableId\":5,\"pk\":true,\"columnName\":\"id\"},{\"usableColumn\":false,\"columnId\":29,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"colorStr\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"颜色字符\",\"isQuery\":\"1\",\"sort\":2,\"list\":true,\"params\":{},\"javaType\":\"String\",\"queryType\":\"EQ\",\"columnType\":\"varchar(50)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1583229393000,\"isEdit\":\"1\",\"tableId\":5,\"pk\":false,\"columnName\":\"color_str\"},{\"usableColumn\":false,\"columnId\":30,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"dictType\":\"\",\"required\":false,\"superColumn\":true,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"createBy\",\"htmlType\":\"input\",\"edit\":false,\"query\":false,\"columnComment\":\"创建人\",\"sort\":3,\"list\":false,\"params\":{},\"javaType\":\"String\",\"queryType\":\"EQ\",\"columnType\":\"varchar(20)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1583229393000,\"tableId\":5,\"pk\":false,\"columnName\":\"create_by\"},{\"usableColumn\":false,\"columnId\":31,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"dictType\":\"\",\"required\":false,\"superColumn\":true,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"createTime\",\"htmlType\":\"datetime\",\"edit\":false,\"query\":false,\"columnComment\":\"创建时间\",\"sort\":4,\"list\":false,\"params\":{},\"javaType\":\"Date\",\"queryType\":\"EQ\",\"columnType\":\"datetime\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1583229393000,\"tableId\":5,\"pk\":false,\"columnName\":\"create_time\"},{\"usableColumn\":false,\"columnId\":32,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-03 17:57:45');
INSERT INTO `sys_oper_log` VALUES (40, '代码生成', 6, 'com.ruoyi.project.tool.gen.controller.GenController.importTableSave()', 'POST', 1, 'admin', NULL, '/ruoyi/tool/gen/importTable', '127.0.0.1', '内网IP', 'zh_link_category_factor_simple_color,zh_simple_color', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 15:28:38');
INSERT INTO `sys_oper_log` VALUES (41, '代码生成', 6, 'com.ruoyi.project.tool.gen.controller.GenController.importTableSave()', 'POST', 1, 'admin', NULL, '/ruoyi/tool/gen/importTable', '127.0.0.1', '内网IP', 'zh_category,zh_factor,zh_link_category_factor_color', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 15:28:53');
INSERT INTO `sys_oper_log` VALUES (42, '代码生成', 2, 'com.ruoyi.project.tool.gen.controller.GenController.editSave()', 'PUT', 1, 'admin', NULL, '/ruoyi/tool/gen', '127.0.0.1', '内网IP', '{\"functionAuthor\":\"ruoyi\",\"columns\":[{\"usableColumn\":false,\"columnId\":34,\"isIncrement\":\"1\",\"increment\":true,\"insert\":true,\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"id\",\"htmlType\":\"input\",\"edit\":false,\"query\":false,\"columnComment\":\"编号\",\"sort\":1,\"list\":false,\"params\":{},\"javaType\":\"Long\",\"queryType\":\"EQ\",\"columnType\":\"int(11)\",\"createBy\":\"admin\",\"isPk\":\"1\",\"createTime\":1583306918000,\"tableId\":6,\"pk\":true,\"columnName\":\"id\"},{\"usableColumn\":false,\"columnId\":35,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"categoryId\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"编号\",\"isQuery\":\"1\",\"sort\":2,\"list\":true,\"params\":{},\"javaType\":\"Long\",\"queryType\":\"EQ\",\"columnType\":\"int(11)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1583306918000,\"isEdit\":\"1\",\"tableId\":6,\"pk\":false,\"columnName\":\"category_id\"},{\"usableColumn\":false,\"columnId\":36,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"factorId\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"编号\",\"isQuery\":\"1\",\"sort\":3,\"list\":true,\"params\":{},\"javaType\":\"Long\",\"queryType\":\"EQ\",\"columnType\":\"int(11)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1583306918000,\"isEdit\":\"1\",\"tableId\":6,\"pk\":false,\"columnName\":\"factor_id\"},{\"usableColumn\":false,\"columnId\":37,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"simpleColorId\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"编号\",\"isQuery\":\"1\",\"sort\":4,\"list\":true,\"params\":{},\"javaType\":\"Long\",\"queryType\":\"EQ\",\"columnType\":\"int(11)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1583306918000,\"isEdit\":\"1\",\"tableId\":6,\"pk\":false,\"columnName\":\"simple', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 15:29:18');
INSERT INTO `sys_oper_log` VALUES (43, '代码生成', 2, 'com.ruoyi.project.tool.gen.controller.GenController.editSave()', 'PUT', 1, 'admin', NULL, '/ruoyi/tool/gen', '127.0.0.1', '内网IP', '{\"functionAuthor\":\"ruoyi\",\"columns\":[{\"usableColumn\":false,\"columnId\":34,\"isIncrement\":\"1\",\"increment\":true,\"insert\":true,\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"id\",\"htmlType\":\"input\",\"edit\":false,\"query\":false,\"columnComment\":\"编号\",\"updateTime\":1583306958000,\"sort\":1,\"list\":false,\"params\":{},\"javaType\":\"Long\",\"queryType\":\"EQ\",\"columnType\":\"int(11)\",\"createBy\":\"admin\",\"isPk\":\"1\",\"createTime\":1583306918000,\"tableId\":6,\"pk\":true,\"columnName\":\"id\"},{\"usableColumn\":false,\"columnId\":35,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"categoryId\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"编号\",\"isQuery\":\"1\",\"updateTime\":1583306958000,\"sort\":2,\"list\":true,\"params\":{},\"javaType\":\"Long\",\"queryType\":\"EQ\",\"columnType\":\"int(11)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1583306918000,\"isEdit\":\"1\",\"tableId\":6,\"pk\":false,\"columnName\":\"category_id\"},{\"usableColumn\":false,\"columnId\":36,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"factorId\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"编号\",\"isQuery\":\"1\",\"updateTime\":1583306958000,\"sort\":3,\"list\":true,\"params\":{},\"javaType\":\"Long\",\"queryType\":\"EQ\",\"columnType\":\"int(11)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1583306918000,\"isEdit\":\"1\",\"tableId\":6,\"pk\":false,\"columnName\":\"factor_id\"},{\"usableColumn\":false,\"columnId\":37,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"simpleColorId\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"编号\",\"isQuery\":\"1\",\"updateTime\":1583306958000,\"sort\":4,\"list\":true,\"params\":{},\"javaType\":\"Long\",\"queryType\":\"EQ\",\"columnType\":\"int(11)\",\"crea', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 15:30:15');
INSERT INTO `sys_oper_log` VALUES (44, '代码生成', 2, 'com.ruoyi.project.tool.gen.controller.GenController.editSave()', 'PUT', 1, 'admin', NULL, '/ruoyi/tool/gen', '127.0.0.1', '内网IP', '{\"functionAuthor\":\"ruoyi\",\"columns\":[{\"usableColumn\":false,\"columnId\":42,\"isIncrement\":\"1\",\"increment\":true,\"insert\":true,\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"id\",\"htmlType\":\"input\",\"edit\":false,\"query\":false,\"columnComment\":\"编号\",\"sort\":1,\"list\":false,\"params\":{},\"javaType\":\"Long\",\"queryType\":\"EQ\",\"columnType\":\"int(11)\",\"createBy\":\"admin\",\"isPk\":\"1\",\"createTime\":1583306918000,\"tableId\":7,\"pk\":true,\"columnName\":\"id\"},{\"usableColumn\":false,\"columnId\":43,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"startValue\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"开始值\",\"isQuery\":\"1\",\"sort\":2,\"list\":true,\"params\":{},\"javaType\":\"Long\",\"queryType\":\"EQ\",\"columnType\":\"int(11)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1583306918000,\"isEdit\":\"1\",\"tableId\":7,\"pk\":false,\"columnName\":\"start_value\"},{\"usableColumn\":false,\"columnId\":44,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"endValue\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"结束值\",\"isQuery\":\"1\",\"sort\":3,\"list\":true,\"params\":{},\"javaType\":\"Long\",\"queryType\":\"EQ\",\"columnType\":\"int(11)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1583306918000,\"isEdit\":\"1\",\"tableId\":7,\"pk\":false,\"columnName\":\"end_value\"},{\"usableColumn\":false,\"columnId\":45,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"dictType\":\"\",\"required\":false,\"superColumn\":true,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"createBy\",\"htmlType\":\"input\",\"edit\":false,\"query\":false,\"columnComment\":\"创建人\",\"sort\":4,\"list\":false,\"params\":{},\"javaType\":\"String\",\"queryType\":\"EQ\",\"columnType\":\"varchar(20)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1583306918000,\"tableId\":7,\"pk\":false,\"columnName\":\"create_by\"},{\"usableColumn\":false,\"columnId\":46,\"isIncrement\":\"0\",\"increment\":false,\"ins', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 15:31:40');
INSERT INTO `sys_oper_log` VALUES (45, '代码生成', 2, 'com.ruoyi.project.tool.gen.controller.GenController.editSave()', 'PUT', 1, 'admin', NULL, '/ruoyi/tool/gen', '127.0.0.1', '内网IP', '{\"functionAuthor\":\"ruoyi\",\"columns\":[{\"usableColumn\":false,\"columnId\":49,\"isIncrement\":\"1\",\"increment\":true,\"insert\":true,\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"id\",\"htmlType\":\"input\",\"edit\":false,\"query\":false,\"columnComment\":\"编号\",\"sort\":1,\"list\":false,\"params\":{},\"javaType\":\"Long\",\"queryType\":\"EQ\",\"columnType\":\"int(11)\",\"createBy\":\"admin\",\"isPk\":\"1\",\"createTime\":1583306933000,\"tableId\":8,\"pk\":true,\"columnName\":\"id\"},{\"usableColumn\":false,\"columnId\":50,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"name\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"标准名称\",\"isQuery\":\"1\",\"sort\":2,\"list\":true,\"params\":{},\"javaType\":\"String\",\"queryType\":\"LIKE\",\"columnType\":\"varchar(20)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1583306933000,\"isEdit\":\"1\",\"tableId\":8,\"pk\":false,\"columnName\":\"name\"},{\"usableColumn\":false,\"columnId\":51,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"dictType\":\"\",\"required\":false,\"superColumn\":true,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"createBy\",\"htmlType\":\"input\",\"edit\":false,\"query\":false,\"columnComment\":\"创建人\",\"sort\":3,\"list\":false,\"params\":{},\"javaType\":\"String\",\"queryType\":\"EQ\",\"columnType\":\"varchar(20)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1583306933000,\"tableId\":8,\"pk\":false,\"columnName\":\"create_by\"},{\"usableColumn\":false,\"columnId\":52,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"dictType\":\"\",\"required\":false,\"superColumn\":true,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"createTime\",\"htmlType\":\"datetime\",\"edit\":false,\"query\":false,\"columnComment\":\"创建时间\",\"sort\":4,\"list\":false,\"params\":{},\"javaType\":\"Date\",\"queryType\":\"EQ\",\"columnType\":\"datetime\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1583306933000,\"tableId\":8,\"pk\":false,\"columnName\":\"create_time\"},{\"usableColumn\":false,\"columnId\":53,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"dictTy', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 15:32:05');
INSERT INTO `sys_oper_log` VALUES (46, '代码生成', 2, 'com.ruoyi.project.tool.gen.controller.GenController.editSave()', 'PUT', 1, 'admin', NULL, '/ruoyi/tool/gen', '127.0.0.1', '内网IP', '{\"functionAuthor\":\"ruoyi\",\"columns\":[{\"usableColumn\":false,\"columnId\":55,\"isIncrement\":\"1\",\"increment\":true,\"insert\":true,\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"id\",\"htmlType\":\"input\",\"edit\":false,\"query\":false,\"columnComment\":\"编号\",\"sort\":1,\"list\":false,\"params\":{},\"javaType\":\"Long\",\"queryType\":\"EQ\",\"columnType\":\"int(11)\",\"createBy\":\"admin\",\"isPk\":\"1\",\"createTime\":1583306933000,\"tableId\":9,\"pk\":true,\"columnName\":\"id\"},{\"usableColumn\":false,\"columnId\":56,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"name\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"因子名称\",\"isQuery\":\"1\",\"sort\":2,\"list\":true,\"params\":{},\"javaType\":\"String\",\"queryType\":\"LIKE\",\"columnType\":\"varchar(20)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1583306933000,\"isEdit\":\"1\",\"tableId\":9,\"pk\":false,\"columnName\":\"name\"},{\"usableColumn\":false,\"columnId\":57,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"eName\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"英文名称\",\"isQuery\":\"1\",\"sort\":3,\"list\":true,\"params\":{},\"javaType\":\"String\",\"queryType\":\"LIKE\",\"columnType\":\"varchar(20)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1583306933000,\"isEdit\":\"1\",\"tableId\":9,\"pk\":false,\"columnName\":\"e_name\"},{\"usableColumn\":false,\"columnId\":58,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"formula\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"分子式\",\"isQuery\":\"1\",\"sort\":4,\"list\":true,\"params\":{},\"javaType\":\"String\",\"queryType\":\"EQ\",\"columnType\":\"varchar(50)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1583306933000,\"isEdit\":\"1\",\"tableId\":9,\"pk\":false,\"columnName\":\"form', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 15:32:44');
INSERT INTO `sys_oper_log` VALUES (47, '代码生成', 2, 'com.ruoyi.project.tool.gen.controller.GenController.editSave()', 'PUT', 1, 'admin', NULL, '/ruoyi/tool/gen', '127.0.0.1', '内网IP', '{\"functionAuthor\":\"ruoyi\",\"columns\":[{\"usableColumn\":false,\"columnId\":67,\"isIncrement\":\"1\",\"increment\":true,\"insert\":true,\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"id\",\"htmlType\":\"input\",\"edit\":false,\"query\":false,\"columnComment\":\"编号\",\"sort\":1,\"list\":false,\"params\":{},\"javaType\":\"Long\",\"queryType\":\"EQ\",\"columnType\":\"int(11)\",\"createBy\":\"admin\",\"isPk\":\"1\",\"createTime\":1583306933000,\"tableId\":10,\"pk\":true,\"columnName\":\"id\"},{\"usableColumn\":false,\"columnId\":68,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"categoryId\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"编号\",\"isQuery\":\"1\",\"sort\":2,\"list\":true,\"params\":{},\"javaType\":\"Long\",\"queryType\":\"EQ\",\"columnType\":\"int(11)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1583306933000,\"isEdit\":\"1\",\"tableId\":10,\"pk\":false,\"columnName\":\"category_id\"},{\"usableColumn\":false,\"columnId\":69,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"factorId\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"编号\",\"isQuery\":\"1\",\"sort\":3,\"list\":true,\"params\":{},\"javaType\":\"Long\",\"queryType\":\"EQ\",\"columnType\":\"int(11)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1583306933000,\"isEdit\":\"1\",\"tableId\":10,\"pk\":false,\"columnName\":\"factor_id\"},{\"usableColumn\":false,\"columnId\":70,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"colorId\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"编号\",\"isQuery\":\"1\",\"sort\":4,\"list\":true,\"params\":{},\"javaType\":\"Long\",\"queryType\":\"EQ\",\"columnType\":\"int(11)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1583306933000,\"isEdit\":\"1\",\"tableId\":10,\"pk\":false,\"columnName\":\"color_id', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 15:32:58');
INSERT INTO `sys_oper_log` VALUES (48, '代码生成', 8, 'com.ruoyi.project.tool.gen.controller.GenController.batchGenCode()', 'GET', 1, 'admin', NULL, '/ruoyi/tool/gen/batchGenCode', '127.0.0.1', '内网IP', '{}', 'null', 0, NULL, '2020-03-04 15:33:43');
INSERT INTO `sys_oper_log` VALUES (49, '代码生成', 8, 'com.ruoyi.project.tool.gen.controller.GenController.batchGenCode()', 'GET', 1, 'admin', NULL, '/ruoyi/tool/gen/batchGenCode', '127.0.0.1', '内网IP', '{}', 'null', 0, NULL, '2020-03-04 15:39:15');
INSERT INTO `sys_oper_log` VALUES (50, '代码生成', 8, 'com.ruoyi.project.tool.gen.controller.GenController.batchGenCode()', 'GET', 1, 'admin', NULL, '/ruoyi/tool/gen/batchGenCode', '127.0.0.1', '内网IP', '{}', 'null', 0, NULL, '2020-03-04 15:39:38');
INSERT INTO `sys_oper_log` VALUES (51, '代码生成', 2, 'com.ruoyi.project.tool.gen.controller.GenController.editSave()', 'PUT', 1, 'admin', NULL, '/ruoyi/tool/gen', '127.0.0.1', '内网IP', '{\"functionAuthor\":\"ruoyi\",\"columns\":[{\"usableColumn\":false,\"columnId\":34,\"isIncrement\":\"1\",\"increment\":true,\"insert\":true,\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"id\",\"htmlType\":\"input\",\"edit\":false,\"query\":false,\"columnComment\":\"编号\",\"updateTime\":1583307014000,\"sort\":1,\"list\":false,\"params\":{},\"javaType\":\"Long\",\"queryType\":\"EQ\",\"columnType\":\"int(11)\",\"createBy\":\"admin\",\"isPk\":\"1\",\"createTime\":1583306918000,\"tableId\":6,\"pk\":true,\"columnName\":\"id\"},{\"usableColumn\":false,\"columnId\":35,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"categoryId\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"编号\",\"isQuery\":\"1\",\"updateTime\":1583307014000,\"sort\":2,\"list\":true,\"params\":{},\"javaType\":\"Long\",\"queryType\":\"EQ\",\"columnType\":\"int(11)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1583306918000,\"isEdit\":\"1\",\"tableId\":6,\"pk\":false,\"columnName\":\"category_id\"},{\"usableColumn\":false,\"columnId\":36,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"factorId\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"编号\",\"isQuery\":\"1\",\"updateTime\":1583307014000,\"sort\":3,\"list\":true,\"params\":{},\"javaType\":\"Long\",\"queryType\":\"EQ\",\"columnType\":\"int(11)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1583306918000,\"isEdit\":\"1\",\"tableId\":6,\"pk\":false,\"columnName\":\"factor_id\"},{\"usableColumn\":false,\"columnId\":37,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"simpleColorId\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"编号\",\"isQuery\":\"1\",\"updateTime\":1583307014000,\"sort\":4,\"list\":true,\"params\":{},\"javaType\":\"Long\",\"queryType\":\"EQ\",\"columnType\":\"int(11)\",\"crea', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 15:41:31');
INSERT INTO `sys_oper_log` VALUES (52, '代码生成', 2, 'com.ruoyi.project.tool.gen.controller.GenController.editSave()', 'PUT', 1, 'admin', NULL, '/ruoyi/tool/gen', '127.0.0.1', '内网IP', '{\"functionAuthor\":\"ruoyi\",\"columns\":[{\"usableColumn\":false,\"columnId\":67,\"isIncrement\":\"1\",\"increment\":true,\"insert\":true,\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"id\",\"htmlType\":\"input\",\"edit\":false,\"query\":false,\"columnComment\":\"编号\",\"updateTime\":1583307177000,\"sort\":1,\"list\":false,\"params\":{},\"javaType\":\"Long\",\"queryType\":\"EQ\",\"columnType\":\"int(11)\",\"createBy\":\"admin\",\"isPk\":\"1\",\"createTime\":1583306933000,\"tableId\":10,\"pk\":true,\"columnName\":\"id\"},{\"usableColumn\":false,\"columnId\":68,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"categoryId\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"编号\",\"isQuery\":\"1\",\"updateTime\":1583307177000,\"sort\":2,\"list\":true,\"params\":{},\"javaType\":\"Long\",\"queryType\":\"EQ\",\"columnType\":\"int(11)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1583306933000,\"isEdit\":\"1\",\"tableId\":10,\"pk\":false,\"columnName\":\"category_id\"},{\"usableColumn\":false,\"columnId\":69,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"factorId\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"编号\",\"isQuery\":\"1\",\"updateTime\":1583307178000,\"sort\":3,\"list\":true,\"params\":{},\"javaType\":\"Long\",\"queryType\":\"EQ\",\"columnType\":\"int(11)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1583306933000,\"isEdit\":\"1\",\"tableId\":10,\"pk\":false,\"columnName\":\"factor_id\"},{\"usableColumn\":false,\"columnId\":70,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"colorId\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"编号\",\"isQuery\":\"1\",\"updateTime\":1583307178000,\"sort\":4,\"list\":true,\"params\":{},\"javaType\":\"Long\",\"queryType\":\"EQ\",\"columnType\":\"int(11)\",\"createB', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 15:41:56');
INSERT INTO `sys_oper_log` VALUES (53, '代码生成', 8, 'com.ruoyi.project.tool.gen.controller.GenController.batchGenCode()', 'GET', 1, 'admin', NULL, '/ruoyi/tool/gen/batchGenCode', '127.0.0.1', '内网IP', '{}', 'null', 0, NULL, '2020-03-04 15:42:18');
INSERT INTO `sys_oper_log` VALUES (54, '因子', 1, 'com.ruoyi.zh.controller.ZhFactorController.add()', 'POST', 1, 'admin', NULL, '/ruoyi/zh/factor', '127.0.0.1', '内网IP', '{\"weight\":28.0,\"danger\":11.0,\"params\":{},\"smell\":\"刺激\",\"createTime\":1583308487712,\"name\":\"TVOC\",\"formula\":\"CO\",\"warning\":11.0}', 'null', 1, '\r\n### Error updating database.  Cause: java.sql.SQLException: Field \'e_name\' doesn\'t have a default value\r\n### The error may involve com.ruoyi.zh.mapper.ZhFactorMapper.insertZhFactor-Inline\r\n### The error occurred while setting parameters\r\n### SQL: insert into zh_factor          ( name,                          formula,             weight,             smell,             warning,             danger,                          create_time )           values ( ?,                          ?,             ?,             ?,             ?,             ?,                          ? )\r\n### Cause: java.sql.SQLException: Field \'e_name\' doesn\'t have a default value\n; Field \'e_name\' doesn\'t have a default value; nested exception is java.sql.SQLException: Field \'e_name\' doesn\'t have a default value', '2020-03-04 15:54:47');
INSERT INTO `sys_oper_log` VALUES (55, '因子', 1, 'com.ruoyi.zh.controller.ZhFactorController.add()', 'POST', 1, 'admin', NULL, '/ruoyi/zh/factor', '127.0.0.1', '内网IP', '{\"weight\":28.0,\"danger\":11.0,\"params\":{},\"smell\":\"刺激\",\"createTime\":1583308493532,\"name\":\"TVOC\",\"formula\":\"CO\",\"warning\":11.0}', 'null', 1, '\r\n### Error updating database.  Cause: java.sql.SQLException: Field \'e_name\' doesn\'t have a default value\r\n### The error may involve com.ruoyi.zh.mapper.ZhFactorMapper.insertZhFactor-Inline\r\n### The error occurred while setting parameters\r\n### SQL: insert into zh_factor          ( name,                          formula,             weight,             smell,             warning,             danger,                          create_time )           values ( ?,                          ?,             ?,             ?,             ?,             ?,                          ? )\r\n### Cause: java.sql.SQLException: Field \'e_name\' doesn\'t have a default value\n; Field \'e_name\' doesn\'t have a default value; nested exception is java.sql.SQLException: Field \'e_name\' doesn\'t have a default value', '2020-03-04 15:54:53');
INSERT INTO `sys_oper_log` VALUES (56, '因子', 1, 'com.ruoyi.zh.controller.ZhFactorController.add()', 'POST', 1, 'admin', NULL, '/ruoyi/zh/factor', '127.0.0.1', '内网IP', '{\"weight\":28.0,\"danger\":11.0,\"params\":{},\"smell\":\"刺激\",\"createTime\":1583308499087,\"name\":\"TVOC\",\"formula\":\"CO\",\"warning\":11.0}', 'null', 1, '\r\n### Error updating database.  Cause: java.sql.SQLException: Field \'e_name\' doesn\'t have a default value\r\n### The error may involve com.ruoyi.zh.mapper.ZhFactorMapper.insertZhFactor-Inline\r\n### The error occurred while setting parameters\r\n### SQL: insert into zh_factor          ( name,                          formula,             weight,             smell,             warning,             danger,                          create_time )           values ( ?,                          ?,             ?,             ?,             ?,             ?,                          ? )\r\n### Cause: java.sql.SQLException: Field \'e_name\' doesn\'t have a default value\n; Field \'e_name\' doesn\'t have a default value; nested exception is java.sql.SQLException: Field \'e_name\' doesn\'t have a default value', '2020-03-04 15:54:59');
INSERT INTO `sys_oper_log` VALUES (57, '因子', 1, 'com.ruoyi.zh.controller.ZhFactorController.add()', 'POST', 1, 'admin', NULL, '/ruoyi/zh/factor', '127.0.0.1', '内网IP', '{\"weight\":28.0,\"danger\":11.0,\"params\":{},\"smell\":\"刺激\",\"createTime\":1583308833249,\"name\":\"TVOC\",\"formula\":\"Co\",\"warning\":11.0}', 'null', 1, '\r\n### Error updating database.  Cause: java.sql.SQLException: Field \'e_name\' doesn\'t have a default value\r\n### The error may involve com.ruoyi.zh.mapper.ZhFactorMapper.insertZhFactor-Inline\r\n### The error occurred while setting parameters\r\n### SQL: insert into zh_factor          ( name,                          formula,             weight,             smell,             warning,             danger,                          create_time )           values ( ?,                          ?,             ?,             ?,             ?,             ?,                          ? )\r\n### Cause: java.sql.SQLException: Field \'e_name\' doesn\'t have a default value\n; Field \'e_name\' doesn\'t have a default value; nested exception is java.sql.SQLException: Field \'e_name\' doesn\'t have a default value', '2020-03-04 16:00:33');
INSERT INTO `sys_oper_log` VALUES (58, '因子', 1, 'com.ruoyi.zh.controller.ZhFactorController.add()', 'POST', 1, 'admin', NULL, '/ruoyi/zh/factor', '127.0.0.1', '内网IP', '{\"weight\":28.0,\"danger\":11.0,\"params\":{},\"smell\":\"刺激\",\"createTime\":1583308833207,\"name\":\"TVOC\",\"formula\":\"CO\",\"warning\":11.0}', 'null', 1, '\r\n### Error updating database.  Cause: java.sql.SQLException: Field \'e_name\' doesn\'t have a default value\r\n### The error may involve com.ruoyi.zh.mapper.ZhFactorMapper.insertZhFactor-Inline\r\n### The error occurred while setting parameters\r\n### SQL: insert into zh_factor          ( name,                          formula,             weight,             smell,             warning,             danger,                          create_time )           values ( ?,                          ?,             ?,             ?,             ?,             ?,                          ? )\r\n### Cause: java.sql.SQLException: Field \'e_name\' doesn\'t have a default value\n; Field \'e_name\' doesn\'t have a default value; nested exception is java.sql.SQLException: Field \'e_name\' doesn\'t have a default value', '2020-03-04 16:00:33');
INSERT INTO `sys_oper_log` VALUES (59, '因子', 1, 'com.ruoyi.zh.controller.ZhFactorController.add()', 'POST', 1, 'admin', NULL, '/ruoyi/zh/factor', '127.0.0.1', '内网IP', '{\"weight\":28.0,\"danger\":11.0,\"params\":{},\"smell\":\"刺激\",\"createTime\":1583308883639,\"name\":\"TVOC\",\"formula\":\"Co\",\"warning\":11.0}', 'null', 1, '\r\n### Error updating database.  Cause: java.sql.SQLException: Field \'e_name\' doesn\'t have a default value\r\n### The error may involve com.ruoyi.zh.mapper.ZhFactorMapper.insertZhFactor-Inline\r\n### The error occurred while setting parameters\r\n### SQL: insert into zh_factor          ( name,                          formula,             weight,             smell,             warning,             danger,                          create_time )           values ( ?,                          ?,             ?,             ?,             ?,             ?,                          ? )\r\n### Cause: java.sql.SQLException: Field \'e_name\' doesn\'t have a default value\n; Field \'e_name\' doesn\'t have a default value; nested exception is java.sql.SQLException: Field \'e_name\' doesn\'t have a default value', '2020-03-04 16:01:24');
INSERT INTO `sys_oper_log` VALUES (60, '代码生成', 3, 'com.ruoyi.project.tool.gen.controller.GenController.remove()', 'DELETE', 1, 'admin', NULL, '/ruoyi/tool/gen/9', '127.0.0.1', '内网IP', '{tableIds=9}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 16:03:37');
INSERT INTO `sys_oper_log` VALUES (61, '代码生成', 6, 'com.ruoyi.project.tool.gen.controller.GenController.importTableSave()', 'POST', 1, 'admin', NULL, '/ruoyi/tool/gen/importTable', '127.0.0.1', '内网IP', 'zh_factor', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 16:03:49');
INSERT INTO `sys_oper_log` VALUES (62, '代码生成', 2, 'com.ruoyi.project.tool.gen.controller.GenController.editSave()', 'PUT', 1, 'admin', NULL, '/ruoyi/tool/gen', '127.0.0.1', '内网IP', '{\"functionAuthor\":\"ruoyi\",\"columns\":[{\"usableColumn\":false,\"columnId\":75,\"isIncrement\":\"1\",\"increment\":true,\"insert\":true,\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"id\",\"htmlType\":\"input\",\"edit\":false,\"query\":false,\"columnComment\":\"编号\",\"sort\":1,\"list\":false,\"params\":{},\"javaType\":\"Long\",\"queryType\":\"EQ\",\"columnType\":\"int(11)\",\"createBy\":\"admin\",\"isPk\":\"1\",\"createTime\":1583309029000,\"tableId\":11,\"pk\":true,\"columnName\":\"id\"},{\"usableColumn\":false,\"columnId\":76,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"name\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"因子名称\",\"isQuery\":\"1\",\"sort\":2,\"list\":true,\"params\":{},\"javaType\":\"String\",\"queryType\":\"LIKE\",\"columnType\":\"varchar(20)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1583309029000,\"isEdit\":\"1\",\"tableId\":11,\"pk\":false,\"columnName\":\"name\"},{\"usableColumn\":false,\"columnId\":77,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"ename\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"英文名称\",\"isQuery\":\"1\",\"sort\":3,\"list\":true,\"params\":{},\"javaType\":\"String\",\"queryType\":\"LIKE\",\"columnType\":\"varchar(20)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1583309029000,\"isEdit\":\"1\",\"tableId\":11,\"pk\":false,\"columnName\":\"ename\"},{\"usableColumn\":false,\"columnId\":78,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"formula\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"分子式\",\"isQuery\":\"1\",\"sort\":4,\"list\":true,\"params\":{},\"javaType\":\"String\",\"queryType\":\"EQ\",\"columnType\":\"varchar(50)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1583309029000,\"isEdit\":\"1\",\"tableId\":11,\"pk\":false,\"columnName\":\"formula\"},{\"usabl', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 16:04:05');
INSERT INTO `sys_oper_log` VALUES (63, '菜单管理', 3, 'com.ruoyi.project.system.controller.SysMenuController.remove()', 'DELETE', 1, 'admin', NULL, '/ruoyi/system/menu/1082', '127.0.0.1', '内网IP', '{menuId=1082}', '{\"msg\":\"存在子菜单,不允许删除\",\"code\":500}', 0, NULL, '2020-03-04 16:40:52');
INSERT INTO `sys_oper_log` VALUES (64, '菜单管理', 3, 'com.ruoyi.project.system.controller.SysMenuController.remove()', 'DELETE', 1, 'admin', NULL, '/ruoyi/system/menu/1083', '127.0.0.1', '内网IP', '{menuId=1083}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 16:41:00');
INSERT INTO `sys_oper_log` VALUES (65, '菜单管理', 3, 'com.ruoyi.project.system.controller.SysMenuController.remove()', 'DELETE', 1, 'admin', NULL, '/ruoyi/system/menu/1084', '127.0.0.1', '内网IP', '{menuId=1084}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 16:41:03');
INSERT INTO `sys_oper_log` VALUES (66, '菜单管理', 3, 'com.ruoyi.project.system.controller.SysMenuController.remove()', 'DELETE', 1, 'admin', NULL, '/ruoyi/system/menu/1085', '127.0.0.1', '内网IP', '{menuId=1085}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 16:41:06');
INSERT INTO `sys_oper_log` VALUES (67, '菜单管理', 3, 'com.ruoyi.project.system.controller.SysMenuController.remove()', 'DELETE', 1, 'admin', NULL, '/ruoyi/system/menu/1086', '127.0.0.1', '内网IP', '{menuId=1086}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 16:41:09');
INSERT INTO `sys_oper_log` VALUES (68, '菜单管理', 3, 'com.ruoyi.project.system.controller.SysMenuController.remove()', 'DELETE', 1, 'admin', NULL, '/ruoyi/system/menu/1087', '127.0.0.1', '内网IP', '{menuId=1087}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 16:41:13');
INSERT INTO `sys_oper_log` VALUES (69, '菜单管理', 3, 'com.ruoyi.project.system.controller.SysMenuController.remove()', 'DELETE', 1, 'admin', NULL, '/ruoyi/system/menu/1082', '127.0.0.1', '内网IP', '{menuId=1082}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 16:41:17');
INSERT INTO `sys_oper_log` VALUES (70, '代码生成', 8, 'com.ruoyi.project.tool.gen.controller.GenController.batchGenCode()', 'GET', 1, 'admin', NULL, '/ruoyi/tool/gen/batchGenCode', '127.0.0.1', '内网IP', '{}', 'null', 0, NULL, '2020-03-04 16:44:12');
INSERT INTO `sys_oper_log` VALUES (71, '因子', 1, 'com.ruoyi.zh.controller.ZhFactorController.add()', 'POST', 1, 'admin', NULL, '/ruoyi/zh/factor', '127.0.0.1', '内网IP', '{\"params\":{},\"ename\":\"TVOC\",\"createTime\":1583311660542,\"name\":\"TVOC\",\"id\":1}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 16:47:40');
INSERT INTO `sys_oper_log` VALUES (72, '因子', 1, 'com.ruoyi.zh.controller.ZhFactorController.add()', 'POST', 1, 'admin', NULL, '/ruoyi/zh/factor', '127.0.0.1', '内网IP', '{\"params\":{},\"ename\":\"dx\",\"createTime\":1583311791232,\"name\":\"丁烯\",\"id\":2}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 16:49:51');
INSERT INTO `sys_oper_log` VALUES (73, '菜单管理', 1, 'com.ruoyi.project.system.controller.SysMenuController.add()', 'POST', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"dashboard\",\"orderNum\":\"1\",\"menuName\":\"走航设置\",\"params\":{},\"parentId\":0,\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"M\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 16:54:35');
INSERT INTO `sys_oper_log` VALUES (74, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"dashboard\",\"orderNum\":\"1.5\",\"menuName\":\"走航设置\",\"params\":{},\"parentId\":0,\"path\":\"\",\"children\":[],\"createTime\":1583312074000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1094,\"menuType\":\"M\",\"perms\":\"\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 16:55:05');
INSERT INTO `sys_oper_log` VALUES (75, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"dashboard\",\"orderNum\":\"1\",\"menuName\":\"走航设置\",\"params\":{},\"parentId\":0,\"path\":\"\",\"children\":[],\"createTime\":1583312074000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1094,\"menuType\":\"M\",\"perms\":\"\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 17:05:28');
INSERT INTO `sys_oper_log` VALUES (76, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"system\",\"orderNum\":\"2\",\"menuName\":\"系统管理\",\"params\":{},\"parentId\":0,\"path\":\"system\",\"children\":[],\"createTime\":1521171180000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1,\"menuType\":\"M\",\"perms\":\"\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 17:05:37');
INSERT INTO `sys_oper_log` VALUES (77, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"monitor\",\"orderNum\":\"3\",\"menuName\":\"系统监控\",\"params\":{},\"parentId\":0,\"path\":\"monitor\",\"children\":[],\"createTime\":1521171180000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":2,\"menuType\":\"M\",\"perms\":\"\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 17:05:46');
INSERT INTO `sys_oper_log` VALUES (78, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"tool\",\"orderNum\":\"4\",\"menuName\":\"系统工具\",\"params\":{},\"parentId\":0,\"path\":\"tool\",\"children\":[],\"createTime\":1521171180000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":3,\"menuType\":\"M\",\"perms\":\"\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 17:05:52');
INSERT INTO `sys_oper_log` VALUES (79, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"guide\",\"orderNum\":\"5\",\"menuName\":\"若依官网\",\"params\":{},\"parentId\":0,\"path\":\"http://ruoyi.vip\",\"children\":[],\"createTime\":1521171180000,\"updateBy\":\"admin\",\"isFrame\":\"0\",\"menuId\":4,\"menuType\":\"M\",\"perms\":\"\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 17:05:58');
INSERT INTO `sys_oper_log` VALUES (80, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"#\",\"orderNum\":\"1\",\"menuName\":\"因子管理\",\"params\":{},\"parentId\":1094,\"path\":\"factor\",\"component\":\"zh/factor/index\",\"children\":[],\"createTime\":1519833600000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1088,\"menuType\":\"C\",\"perms\":\"zh:factor:list\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 17:08:10');
INSERT INTO `sys_oper_log` VALUES (81, '代码生成', 3, 'com.ruoyi.project.tool.gen.controller.GenController.remove()', 'DELETE', 1, 'admin', NULL, '/ruoyi/tool/gen/10,6', '127.0.0.1', '内网IP', '{tableIds=10,6}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 17:23:46');
INSERT INTO `sys_oper_log` VALUES (82, '代码生成', 6, 'com.ruoyi.project.tool.gen.controller.GenController.importTableSave()', 'POST', 1, 'admin', NULL, '/ruoyi/tool/gen/importTable', '127.0.0.1', '内网IP', 'zh_link_category_factor_color,zh_link_category_factor_simple_color', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 17:23:56');
INSERT INTO `sys_oper_log` VALUES (83, '代码生成', 2, 'com.ruoyi.project.tool.gen.controller.GenController.editSave()', 'PUT', 1, 'admin', NULL, '/ruoyi/tool/gen', '127.0.0.1', '内网IP', '{\"functionAuthor\":\"ruoyi\",\"columns\":[{\"usableColumn\":false,\"columnId\":87,\"isIncrement\":\"1\",\"increment\":true,\"insert\":true,\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"id\",\"htmlType\":\"input\",\"edit\":false,\"query\":false,\"columnComment\":\"编号\",\"sort\":1,\"list\":false,\"params\":{},\"javaType\":\"Long\",\"queryType\":\"EQ\",\"columnType\":\"int(11)\",\"createBy\":\"admin\",\"isPk\":\"1\",\"createTime\":1583313836000,\"tableId\":12,\"pk\":true,\"columnName\":\"id\"},{\"usableColumn\":false,\"columnId\":88,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"categoryId\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"标准编号\",\"isQuery\":\"1\",\"sort\":2,\"list\":true,\"params\":{},\"javaType\":\"Long\",\"queryType\":\"EQ\",\"columnType\":\"int(11)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1583313836000,\"isEdit\":\"1\",\"tableId\":12,\"pk\":false,\"columnName\":\"category_id\"},{\"usableColumn\":false,\"columnId\":89,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"factorId\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"因子编号\",\"isQuery\":\"1\",\"sort\":3,\"list\":true,\"params\":{},\"javaType\":\"Long\",\"queryType\":\"EQ\",\"columnType\":\"int(11)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1583313836000,\"isEdit\":\"1\",\"tableId\":12,\"pk\":false,\"columnName\":\"factor_id\"},{\"usableColumn\":false,\"columnId\":90,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"colorId\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"颜色编号\",\"isQuery\":\"1\",\"sort\":4,\"list\":true,\"params\":{},\"javaType\":\"Long\",\"queryType\":\"EQ\",\"columnType\":\"int(11)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1583313836000,\"isEdit\":\"1\",\"tableId\":12,\"pk\":false,\"columnName\":\"co', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 17:24:56');
INSERT INTO `sys_oper_log` VALUES (84, '代码生成', 2, 'com.ruoyi.project.tool.gen.controller.GenController.editSave()', 'PUT', 1, 'admin', NULL, '/ruoyi/tool/gen', '127.0.0.1', '内网IP', '{\"functionAuthor\":\"ruoyi\",\"columns\":[{\"usableColumn\":false,\"columnId\":95,\"isIncrement\":\"1\",\"increment\":true,\"insert\":true,\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"id\",\"htmlType\":\"input\",\"edit\":false,\"query\":false,\"columnComment\":\"编号\",\"sort\":1,\"list\":false,\"params\":{},\"javaType\":\"Long\",\"queryType\":\"EQ\",\"columnType\":\"int(11)\",\"createBy\":\"admin\",\"isPk\":\"1\",\"createTime\":1583313836000,\"tableId\":13,\"pk\":true,\"columnName\":\"id\"},{\"usableColumn\":false,\"columnId\":96,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"categoryId\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"标准编号\",\"isQuery\":\"1\",\"sort\":2,\"list\":true,\"params\":{},\"javaType\":\"Long\",\"queryType\":\"EQ\",\"columnType\":\"int(11)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1583313836000,\"isEdit\":\"1\",\"tableId\":13,\"pk\":false,\"columnName\":\"category_id\"},{\"usableColumn\":false,\"columnId\":97,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"factorId\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"因子编号\",\"isQuery\":\"1\",\"sort\":3,\"list\":true,\"params\":{},\"javaType\":\"Long\",\"queryType\":\"EQ\",\"columnType\":\"int(11)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1583313836000,\"isEdit\":\"1\",\"tableId\":13,\"pk\":false,\"columnName\":\"factor_id\"},{\"usableColumn\":false,\"columnId\":98,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"simpleColorId\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"单个颜色编号\",\"isQuery\":\"1\",\"sort\":4,\"list\":true,\"params\":{},\"javaType\":\"Long\",\"queryType\":\"EQ\",\"columnType\":\"int(11)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1583313836000,\"isEdit\":\"1\",\"tableId\":13,\"pk\":false,\"columnN', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 17:25:15');
INSERT INTO `sys_oper_log` VALUES (85, '代码生成', 8, 'com.ruoyi.project.tool.gen.controller.GenController.batchGenCode()', 'GET', 1, 'admin', NULL, '/ruoyi/tool/gen/batchGenCode', '127.0.0.1', '内网IP', '{}', 'null', 0, NULL, '2020-03-04 17:25:23');
INSERT INTO `sys_oper_log` VALUES (86, '因子', 1, 'com.ruoyi.zh.controller.ZhFactorController.add()', 'POST', 1, 'admin', NULL, '/ruoyi/zh/factor', '127.0.0.1', '内网IP', '{\"params\":{},\"ename\":\"TVOC\",\"createTime\":1583314058463,\"name\":\"TVOC\"}', 'null', 1, '\r\n### Error updating database.  Cause: java.sql.SQLSyntaxErrorException: Unknown column \'ename\' in \'field list\'\r\n### The error may involve com.ruoyi.zh.mapper.ZhFactorMapper.insertZhFactor-Inline\r\n### The error occurred while setting parameters\r\n### SQL: insert into zh_factor          ( name,             ename,                                                                                           create_time )           values ( ?,             ?,                                                                                           ? )\r\n### Cause: java.sql.SQLSyntaxErrorException: Unknown column \'ename\' in \'field list\'\n; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: Unknown column \'ename\' in \'field list\'', '2020-03-04 17:27:38');
INSERT INTO `sys_oper_log` VALUES (87, '因子', 1, 'com.ruoyi.zh.controller.ZhFactorController.add()', 'POST', 1, 'admin', NULL, '/ruoyi/zh/factor', '127.0.0.1', '内网IP', '{\"params\":{},\"ename\":\"TVOC\",\"createTime\":1583314064859,\"name\":\"TVOC\"}', 'null', 1, '\r\n### Error updating database.  Cause: java.sql.SQLSyntaxErrorException: Unknown column \'ename\' in \'field list\'\r\n### The error may involve com.ruoyi.zh.mapper.ZhFactorMapper.insertZhFactor-Inline\r\n### The error occurred while setting parameters\r\n### SQL: insert into zh_factor          ( name,             ename,                                                                                           create_time )           values ( ?,             ?,                                                                                           ? )\r\n### Cause: java.sql.SQLSyntaxErrorException: Unknown column \'ename\' in \'field list\'\n; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: Unknown column \'ename\' in \'field list\'', '2020-03-04 17:27:44');
INSERT INTO `sys_oper_log` VALUES (88, '因子', 1, 'com.ruoyi.zh.controller.ZhFactorController.add()', 'POST', 1, 'admin', NULL, '/ruoyi/zh/factor', '127.0.0.1', '内网IP', '{\"params\":{},\"ename\":\"TVOC\",\"createTime\":1583314070407,\"name\":\"TVOC\"}', 'null', 1, '\r\n### Error updating database.  Cause: java.sql.SQLSyntaxErrorException: Unknown column \'ename\' in \'field list\'\r\n### The error may involve com.ruoyi.zh.mapper.ZhFactorMapper.insertZhFactor-Inline\r\n### The error occurred while setting parameters\r\n### SQL: insert into zh_factor          ( name,             ename,                                                                                           create_time )           values ( ?,             ?,                                                                                           ? )\r\n### Cause: java.sql.SQLSyntaxErrorException: Unknown column \'ename\' in \'field list\'\n; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: Unknown column \'ename\' in \'field list\'', '2020-03-04 17:27:50');
INSERT INTO `sys_oper_log` VALUES (89, '因子', 1, 'com.ruoyi.zh.controller.ZhFactorController.add()', 'POST', 1, 'admin', NULL, '/ruoyi/zh/factor', '127.0.0.1', '内网IP', '{\"params\":{},\"ename\":\"TVOC\",\"createTime\":1583314107145,\"name\":\"TVOC\",\"id\":1}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 17:28:27');
INSERT INTO `sys_oper_log` VALUES (90, '因子', 1, 'com.ruoyi.zh.controller.ZhFactorController.add()', 'POST', 1, 'admin', NULL, '/ruoyi/zh/factor', '127.0.0.1', '内网IP', '{\"params\":{},\"ename\":\"DX\",\"createTime\":1583314129218,\"name\":\"丁烯\",\"id\":2}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 17:28:49');
INSERT INTO `sys_oper_log` VALUES (91, '颜色标准', 1, 'com.ruoyi.zh.controller.ZhCategoryController.add()', 'POST', 1, 'admin', NULL, '/ruoyi/zh/category', '127.0.0.1', '内网IP', '{\"createTime\":1583314142188,\"name\":\"禾信专用\",\"id\":1,\"params\":{}}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 17:29:02');
INSERT INTO `sys_oper_log` VALUES (92, '颜色', 1, 'com.ruoyi.zh.controller.ZhColorController.add()', 'POST', 1, 'admin', NULL, '/ruoyi/zh/color', '127.0.0.1', '内网IP', '{\"createTime\":1583314189042,\"colorStr\":\"4CE600\",\"id\":1,\"params\":{}}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 17:29:49');
INSERT INTO `sys_oper_log` VALUES (93, '颜色', 1, 'com.ruoyi.zh.controller.ZhColorController.add()', 'POST', 1, 'admin', NULL, '/ruoyi/zh/color', '127.0.0.1', '内网IP', '{\"createTime\":1583314249808,\"colorStr\":\"E60000\",\"id\":2,\"params\":{}}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 17:30:49');
INSERT INTO `sys_oper_log` VALUES (94, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"#\",\"orderNum\":\"1\",\"menuName\":\"单个颜色各范围\",\"params\":{},\"parentId\":1094,\"path\":\"simpleColor\",\"component\":\"zh/simpleColor/index\",\"children\":[],\"createTime\":1519833600000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1119,\"menuType\":\"C\",\"perms\":\"zh:simpleColor:list\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 17:32:06');
INSERT INTO `sys_oper_log` VALUES (95, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"#\",\"orderNum\":\"1\",\"menuName\":\"单个颜色各范围查询\",\"params\":{},\"parentId\":1119,\"path\":\"#\",\"component\":\"\",\"children\":[],\"createTime\":1519833600000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1120,\"menuType\":\"F\",\"perms\":\"zh:simpleColor:query\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 17:32:17');
INSERT INTO `sys_oper_log` VALUES (96, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"#\",\"orderNum\":\"2\",\"menuName\":\"单个颜色各范围新增\",\"params\":{},\"parentId\":1119,\"path\":\"#\",\"component\":\"\",\"children\":[],\"createTime\":1519833600000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1121,\"menuType\":\"F\",\"perms\":\"zh:simpleColor:add\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 17:32:24');
INSERT INTO `sys_oper_log` VALUES (97, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"#\",\"orderNum\":\"2\",\"menuName\":\"单个颜色各范围新增\",\"params\":{},\"parentId\":1119,\"path\":\"#\",\"component\":\"\",\"children\":[],\"createTime\":1519833600000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1121,\"menuType\":\"F\",\"perms\":\"zh:simpleColor:add\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 17:32:24');
INSERT INTO `sys_oper_log` VALUES (98, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"#\",\"orderNum\":\"3\",\"menuName\":\"单个颜色各范围修改\",\"params\":{},\"parentId\":1119,\"path\":\"#\",\"component\":\"\",\"children\":[],\"createTime\":1519833600000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1122,\"menuType\":\"F\",\"perms\":\"zh:simpleColor:edit\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 17:32:31');
INSERT INTO `sys_oper_log` VALUES (99, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"#\",\"orderNum\":\"4\",\"menuName\":\"单个颜色各范围删除\",\"params\":{},\"parentId\":1119,\"path\":\"#\",\"component\":\"\",\"children\":[],\"createTime\":1519833600000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1123,\"menuType\":\"F\",\"perms\":\"zh:simpleColor:remove\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 17:32:40');
INSERT INTO `sys_oper_log` VALUES (100, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"#\",\"orderNum\":\"5\",\"menuName\":\"单个颜色各范围导出\",\"params\":{},\"parentId\":1119,\"path\":\"#\",\"component\":\"\",\"children\":[],\"createTime\":1519833600000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1124,\"menuType\":\"F\",\"perms\":\"zh:simpleColor:export\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 17:32:49');
INSERT INTO `sys_oper_log` VALUES (101, '物质因子颜色关联', 1, 'com.ruoyi.zh.controller.ZhLinkCategoryFactorColorController.add()', 'POST', 1, 'admin', NULL, '/ruoyi/zh/categoryFactorColor', '127.0.0.1', '内网IP', '{\"colorId\":1,\"params\":{},\"factorId\":1,\"createTime\":1583314417672,\"id\":1,\"categoryId\":1}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 17:33:37');
INSERT INTO `sys_oper_log` VALUES (102, '物质因子颜色关联', 1, 'com.ruoyi.zh.controller.ZhLinkCategoryFactorColorController.add()', 'POST', 1, 'admin', NULL, '/ruoyi/zh/categoryFactorColor', '127.0.0.1', '内网IP', '{\"colorId\":2,\"params\":{},\"factorId\":2,\"createTime\":1583314421946,\"id\":2,\"categoryId\":1}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-04 17:33:42');
INSERT INTO `sys_oper_log` VALUES (103, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"dashboard\",\"orderNum\":\"2\",\"menuName\":\"走航设置\",\"params\":{},\"parentId\":0,\"path\":\"voyagesetting\",\"children\":[],\"createTime\":1583312074000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1094,\"menuType\":\"M\",\"perms\":\"\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-05 10:15:34');
INSERT INTO `sys_oper_log` VALUES (104, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"list\",\"orderNum\":\"1\",\"menuName\":\"走航分析\",\"params\":{},\"parentId\":0,\"path\":\"voyageAnalysis\",\"children\":[],\"createTime\":1582172376000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1061,\"menuType\":\"M\",\"perms\":\"\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-05 10:16:10');
INSERT INTO `sys_oper_log` VALUES (105, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"dashboard\",\"orderNum\":\"2\",\"menuName\":\"走航设置\",\"params\":{},\"parentId\":0,\"path\":\"voyageSetting\",\"children\":[],\"createTime\":1583312074000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1094,\"menuType\":\"M\",\"perms\":\"\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-05 10:16:18');
INSERT INTO `sys_oper_log` VALUES (106, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"dashboard\",\"orderNum\":\"2\",\"menuName\":\"走航设置\",\"params\":{},\"parentId\":0,\"path\":\"zh\",\"children\":[],\"createTime\":1583312074000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1094,\"menuType\":\"M\",\"perms\":\"\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-05 10:22:38');
INSERT INTO `sys_oper_log` VALUES (107, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"list\",\"orderNum\":\"1\",\"menuName\":\"走航分析\",\"params\":{},\"parentId\":0,\"path\":\"\",\"children\":[],\"createTime\":1582172376000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1061,\"menuType\":\"M\",\"perms\":\"\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-05 10:22:53');
INSERT INTO `sys_oper_log` VALUES (108, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"dashboard\",\"orderNum\":\"2\",\"menuName\":\"走航设置\",\"params\":{},\"parentId\":0,\"path\":\"voyageSetting\",\"children\":[],\"createTime\":1583312074000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1094,\"menuType\":\"M\",\"perms\":\"\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-05 10:23:52');
INSERT INTO `sys_oper_log` VALUES (109, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"list\",\"orderNum\":\"1\",\"menuName\":\"走航分析\",\"params\":{},\"parentId\":0,\"path\":\"\",\"children\":[],\"createTime\":1582172376000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1061,\"menuType\":\"M\",\"perms\":\"\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-05 10:30:16');
INSERT INTO `sys_oper_log` VALUES (110, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"list\",\"orderNum\":\"1\",\"menuName\":\"走航分析\",\"params\":{},\"parentId\":0,\"path\":\"\",\"children\":[],\"createTime\":1582172376000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1061,\"menuType\":\"M\",\"perms\":\"\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-05 10:33:12');
INSERT INTO `sys_oper_log` VALUES (111, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"list\",\"orderNum\":\"1\",\"menuName\":\"走航分析\",\"params\":{},\"parentId\":0,\"path\":\"/\",\"children\":[],\"createTime\":1582172376000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1061,\"menuType\":\"M\",\"perms\":\"\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-05 10:33:32');
INSERT INTO `sys_oper_log` VALUES (112, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"list\",\"orderNum\":\"1\",\"menuName\":\"走航分析\",\"params\":{},\"parentId\":0,\"path\":\"voyage/analysis\",\"children\":[],\"createTime\":1582172376000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1061,\"menuType\":\"M\",\"perms\":\"\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-05 17:36:37');
INSERT INTO `sys_oper_log` VALUES (113, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"dashboard\",\"orderNum\":\"2\",\"menuName\":\"走航设置\",\"params\":{},\"parentId\":0,\"path\":\"voyage/setting\",\"children\":[],\"createTime\":1583312074000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1094,\"menuType\":\"M\",\"perms\":\"\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-05 17:36:47');
INSERT INTO `sys_oper_log` VALUES (114, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"tool\",\"orderNum\":\"1\",\"menuName\":\"控制中心\",\"params\":{},\"parentId\":1061,\"path\":\"analysis/controller\",\"component\":\"voyage/analysis/analysis/controller/index\",\"children\":[],\"createTime\":1582172683000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1062,\"menuType\":\"C\",\"perms\":\"voyage:analysis:analysis:controller:index\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-05 17:40:22');
INSERT INTO `sys_oper_log` VALUES (115, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"eye\",\"orderNum\":\"1\",\"menuName\":\"设备管理\",\"params\":{},\"parentId\":1094,\"path\":\"setting/device\",\"component\":\"voyage/setting/device/index\",\"children\":[],\"createTime\":1519833600000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1064,\"menuType\":\"C\",\"perms\":\"voyage:setting:device:index\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-05 17:41:40');
INSERT INTO `sys_oper_log` VALUES (116, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"component\",\"orderNum\":\"2\",\"menuName\":\"VOC走航\",\"params\":{},\"parentId\":1061,\"path\":\"analysis/cesium\",\"component\":\"voyage/analysis/cesium/index\",\"children\":[],\"createTime\":1582301154000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1063,\"menuType\":\"C\",\"perms\":\"voyage:analysis:cesium:index\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-05 17:42:36');
INSERT INTO `sys_oper_log` VALUES (117, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"#\",\"orderNum\":\"1\",\"menuName\":\"因子管理\",\"params\":{},\"parentId\":1094,\"path\":\"factor\",\"component\":\"voyage/setting/factor/index\",\"children\":[],\"createTime\":1519833600000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1088,\"menuType\":\"C\",\"perms\":\"zh:factor:list\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-05 17:43:45');
INSERT INTO `sys_oper_log` VALUES (118, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"tool\",\"orderNum\":\"1\",\"menuName\":\"控制中心\",\"params\":{},\"parentId\":1061,\"path\":\"controller\",\"component\":\"voyage/analysis/analysis/controller/index\",\"children\":[],\"createTime\":1582172683000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1062,\"menuType\":\"C\",\"perms\":\"voyage:analysis:analysis:controller:index\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-05 17:44:05');
INSERT INTO `sys_oper_log` VALUES (119, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"component\",\"orderNum\":\"2\",\"menuName\":\"VOC走航\",\"params\":{},\"parentId\":1061,\"path\":\"cesium\",\"component\":\"voyage/analysis/cesium/index\",\"children\":[],\"createTime\":1582301154000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1063,\"menuType\":\"C\",\"perms\":\"voyage:analysis:cesium:index\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-05 17:44:31');
INSERT INTO `sys_oper_log` VALUES (120, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"eye\",\"orderNum\":\"1\",\"menuName\":\"设备管理\",\"params\":{},\"parentId\":1094,\"path\":\"device\",\"component\":\"voyage/setting/device/index\",\"children\":[],\"createTime\":1519833600000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1064,\"menuType\":\"C\",\"perms\":\"voyage:setting:device:index\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-05 17:44:41');
INSERT INTO `sys_oper_log` VALUES (121, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"#\",\"orderNum\":\"1\",\"menuName\":\"物质因子颜色关联\",\"params\":{},\"parentId\":1094,\"path\":\"categoryFactorColor\",\"component\":\"voyage/setting/categoryFactorColor/index\",\"children\":[],\"createTime\":1519833600000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1095,\"menuType\":\"C\",\"perms\":\"zh:categoryFactorColor:list\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-05 17:45:21');
INSERT INTO `sys_oper_log` VALUES (122, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"#\",\"orderNum\":\"1\",\"menuName\":\"单个物质因子颜色关联\",\"params\":{},\"parentId\":1094,\"path\":\"categoryFactorSimpleColor\",\"component\":\"voyage/setting/categoryFactorSimpleColor/index\",\"children\":[],\"createTime\":1519833600000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1101,\"menuType\":\"C\",\"perms\":\"zh:categoryFactorSimpleColor:list\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-05 17:45:30');
INSERT INTO `sys_oper_log` VALUES (123, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"#\",\"orderNum\":\"1\",\"menuName\":\"颜色标准\",\"params\":{},\"parentId\":1094,\"path\":\"category\",\"component\":\"voyage/setting/category/index\",\"children\":[],\"createTime\":1519833600000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1107,\"menuType\":\"C\",\"perms\":\"zh:category:list\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-05 17:45:44');
INSERT INTO `sys_oper_log` VALUES (124, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"#\",\"orderNum\":\"1\",\"menuName\":\"颜色\",\"params\":{},\"parentId\":1094,\"path\":\"color\",\"component\":\"voyage/setting/color/index\",\"children\":[],\"createTime\":1519833600000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1113,\"menuType\":\"C\",\"perms\":\"zh:color:list\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-05 17:45:51');
INSERT INTO `sys_oper_log` VALUES (125, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"#\",\"orderNum\":\"1\",\"menuName\":\"单个颜色各范围\",\"params\":{},\"parentId\":1094,\"path\":\"simpleColor\",\"component\":\"voyage/setting/simpleColor/index\",\"children\":[],\"createTime\":1519833600000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1119,\"menuType\":\"C\",\"perms\":\"zh:simpleColor:list\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-05 17:45:58');
INSERT INTO `sys_oper_log` VALUES (126, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"#\",\"orderNum\":\"1\",\"menuName\":\"走航记录\",\"params\":{},\"parentId\":3,\"path\":\"collectRecord\",\"component\":\"voyage/analysis/collectRecord/index\",\"children\":[],\"createTime\":1519833600000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1070,\"menuType\":\"C\",\"perms\":\"zh:collectRecord:list\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-05 17:46:34');
INSERT INTO `sys_oper_log` VALUES (127, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"chart\",\"orderNum\":\"1\",\"menuName\":\"走航记录\",\"params\":{},\"parentId\":1061,\"path\":\"collectRecord\",\"component\":\"voyage/analysis/collectRecord/index\",\"children\":[],\"createTime\":1519833600000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1070,\"menuType\":\"C\",\"perms\":\"zh:collectRecord:list\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-05 17:46:51');
INSERT INTO `sys_oper_log` VALUES (128, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"example\",\"orderNum\":\"1\",\"menuName\":\"敏感点\",\"params\":{},\"parentId\":3,\"path\":\"point\",\"component\":\"voyage/setting/point/index\",\"children\":[],\"createTime\":1519833600000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1076,\"menuType\":\"C\",\"perms\":\"zh:point:list\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-05 17:47:08');
INSERT INTO `sys_oper_log` VALUES (129, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"tool\",\"orderNum\":\"1\",\"menuName\":\"控制中心\",\"params\":{},\"parentId\":1061,\"path\":\"controller\",\"component\":\"voyage/analysis/controller/index\",\"children\":[],\"createTime\":1582172683000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1062,\"menuType\":\"C\",\"perms\":\"voyage:analysis:controller:index\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-05 17:49:47');
INSERT INTO `sys_oper_log` VALUES (130, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"component\",\"orderNum\":\"2\",\"menuName\":\"VOC走航\",\"params\":{},\"parentId\":1061,\"path\":\"cesium\",\"component\":\"voyage/analysis/cesium/test\",\"children\":[],\"createTime\":1582301154000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1063,\"menuType\":\"C\",\"perms\":\"voyage:analysis:cesium:index\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-05 18:13:44');
INSERT INTO `sys_oper_log` VALUES (131, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"component\",\"orderNum\":\"2\",\"menuName\":\"VOC走航\",\"params\":{},\"parentId\":1061,\"path\":\"cesium\",\"component\":\"voyage/analysis/cesium/index\",\"children\":[],\"createTime\":1582301154000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1063,\"menuType\":\"C\",\"perms\":\"voyage:analysis:cesium:index\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-05 18:28:03');
INSERT INTO `sys_oper_log` VALUES (132, '菜单管理', 1, 'com.ruoyi.project.system.controller.SysMenuController.add()', 'POST', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"404\",\"orderNum\":\"4\",\"menuName\":\"走航测试\",\"params\":{},\"parentId\":1061,\"path\":\"cesium\",\"component\":\"voyage/analysis/cesium/test\",\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"C\",\"perms\":\"voyage:analysis:cesium:test\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-06 15:21:50');
INSERT INTO `sys_oper_log` VALUES (133, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"404\",\"orderNum\":\"4\",\"menuName\":\"走航测试\",\"params\":{},\"parentId\":1061,\"path\":\"cesium/test\",\"component\":\"voyage/analysis/cesium/test\",\"children\":[],\"createTime\":1583479310000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1125,\"menuType\":\"C\",\"perms\":\"voyage:analysis:cesium:test\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-06 15:22:25');
INSERT INTO `sys_oper_log` VALUES (134, '颜色标准', 2, 'com.ruoyi.zh.controller.ZhCategoryController.edit()', 'PUT', 1, NULL, NULL, '/ruoyi/zh/category', '127.0.0.1', '内网IP', '{\"name\":\"禾信专用1\",\"updateTime\":1583904868621,\"id\":1,\"params\":{}}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-11 13:34:29');
INSERT INTO `sys_oper_log` VALUES (135, '用户管理', 5, 'com.ruoyi.project.system.controller.SysUserController.export()', 'GET', 1, 'admin', NULL, '/ruoyi/system/user/export', '127.0.0.1', '内网IP', '{}', '{\"msg\":\"9c218594-9d08-4178-9a22-67a240294bfe_用户数据.xlsx\",\"code\":200}', 0, NULL, '2020-03-16 03:57:58');
INSERT INTO `sys_oper_log` VALUES (136, '用户管理', 5, 'com.ruoyi.project.system.controller.SysUserController.export()', 'GET', 1, 'admin', NULL, '/ruoyi/system/user/export', '127.0.0.1', '内网IP', '{}', '{\"msg\":\"477db32d-0377-4bca-9b05-31bf6b3980a1_用户数据.xlsx\",\"code\":200}', 0, NULL, '2020-03-16 03:58:46');
INSERT INTO `sys_oper_log` VALUES (137, '菜单管理', 3, 'com.ruoyi.project.system.controller.SysMenuController.remove()', 'DELETE', 1, 'admin', NULL, '/ruoyi/system/menu/4', '127.0.0.1', '内网IP', '{menuId=4}', '{\"msg\":\"菜单已分配,不允许删除\",\"code\":500}', 0, NULL, '2020-03-18 16:36:47');
INSERT INTO `sys_oper_log` VALUES (138, '菜单管理', 2, 'com.ruoyi.project.system.controller.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/ruoyi/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"1\",\"icon\":\"guide\",\"orderNum\":\"6\",\"menuName\":\"若依官网\",\"params\":{},\"parentId\":0,\"path\":\"http://ruoyi.vip\",\"children\":[],\"createTime\":1521171180000,\"updateBy\":\"admin\",\"isFrame\":\"0\",\"menuId\":4,\"menuType\":\"M\",\"perms\":\"\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2020-03-18 16:36:59');
INSERT INTO `sys_oper_log` VALUES (139, '菜单管理', 3, 'com.ruoyi.project.system.controller.SysMenuController.remove()', 'DELETE', 1, 'admin', NULL, '/ruoyi/system/menu/4', '127.0.0.1', '内网IP', '{menuId=4}', '{\"msg\":\"菜单已分配,不允许删除\",\"code\":500}', 0, NULL, '2020-03-18 16:37:09');

-- ----------------------------
-- Table structure for sys_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_post`;
CREATE TABLE `sys_post`  (
  `post_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '岗位ID',
  `post_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '岗位编码',
  `post_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '岗位名称',
  `post_sort` int(4) NOT NULL COMMENT '显示顺序',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`post_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '岗位信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_post
-- ----------------------------
INSERT INTO `sys_post` VALUES (1, 'ceo', '董事长', 1, '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_post` VALUES (2, 'se', '项目经理', 2, '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_post` VALUES (3, 'hr', '人力资源', 3, '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_post` VALUES (4, 'user', '普通员工', 4, '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色名称',
  `role_key` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色权限字符串',
  `role_sort` int(4) NOT NULL COMMENT '显示顺序',
  `data_scope` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '管理员', 'admin', 1, '1', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '管理员');
INSERT INTO `sys_role` VALUES (2, '普通角色', 'common', 2, '2', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '普通角色');

-- ----------------------------
-- Table structure for sys_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_dept`;
CREATE TABLE `sys_role_dept`  (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `dept_id` bigint(20) NOT NULL COMMENT '部门ID',
  PRIMARY KEY (`role_id`, `dept_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色和部门关联表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role_dept
-- ----------------------------
INSERT INTO `sys_role_dept` VALUES (2, 100);
INSERT INTO `sys_role_dept` VALUES (2, 101);
INSERT INTO `sys_role_dept` VALUES (2, 105);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`, `menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色和菜单关联表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (2, 1);
INSERT INTO `sys_role_menu` VALUES (2, 2);
INSERT INTO `sys_role_menu` VALUES (2, 3);
INSERT INTO `sys_role_menu` VALUES (2, 4);
INSERT INTO `sys_role_menu` VALUES (2, 100);
INSERT INTO `sys_role_menu` VALUES (2, 101);
INSERT INTO `sys_role_menu` VALUES (2, 102);
INSERT INTO `sys_role_menu` VALUES (2, 103);
INSERT INTO `sys_role_menu` VALUES (2, 104);
INSERT INTO `sys_role_menu` VALUES (2, 105);
INSERT INTO `sys_role_menu` VALUES (2, 106);
INSERT INTO `sys_role_menu` VALUES (2, 107);
INSERT INTO `sys_role_menu` VALUES (2, 108);
INSERT INTO `sys_role_menu` VALUES (2, 109);
INSERT INTO `sys_role_menu` VALUES (2, 110);
INSERT INTO `sys_role_menu` VALUES (2, 111);
INSERT INTO `sys_role_menu` VALUES (2, 112);
INSERT INTO `sys_role_menu` VALUES (2, 113);
INSERT INTO `sys_role_menu` VALUES (2, 114);
INSERT INTO `sys_role_menu` VALUES (2, 115);
INSERT INTO `sys_role_menu` VALUES (2, 500);
INSERT INTO `sys_role_menu` VALUES (2, 501);
INSERT INTO `sys_role_menu` VALUES (2, 1000);
INSERT INTO `sys_role_menu` VALUES (2, 1001);
INSERT INTO `sys_role_menu` VALUES (2, 1002);
INSERT INTO `sys_role_menu` VALUES (2, 1003);
INSERT INTO `sys_role_menu` VALUES (2, 1004);
INSERT INTO `sys_role_menu` VALUES (2, 1005);
INSERT INTO `sys_role_menu` VALUES (2, 1006);
INSERT INTO `sys_role_menu` VALUES (2, 1007);
INSERT INTO `sys_role_menu` VALUES (2, 1008);
INSERT INTO `sys_role_menu` VALUES (2, 1009);
INSERT INTO `sys_role_menu` VALUES (2, 1010);
INSERT INTO `sys_role_menu` VALUES (2, 1011);
INSERT INTO `sys_role_menu` VALUES (2, 1012);
INSERT INTO `sys_role_menu` VALUES (2, 1013);
INSERT INTO `sys_role_menu` VALUES (2, 1014);
INSERT INTO `sys_role_menu` VALUES (2, 1015);
INSERT INTO `sys_role_menu` VALUES (2, 1016);
INSERT INTO `sys_role_menu` VALUES (2, 1017);
INSERT INTO `sys_role_menu` VALUES (2, 1018);
INSERT INTO `sys_role_menu` VALUES (2, 1019);
INSERT INTO `sys_role_menu` VALUES (2, 1020);
INSERT INTO `sys_role_menu` VALUES (2, 1021);
INSERT INTO `sys_role_menu` VALUES (2, 1022);
INSERT INTO `sys_role_menu` VALUES (2, 1023);
INSERT INTO `sys_role_menu` VALUES (2, 1024);
INSERT INTO `sys_role_menu` VALUES (2, 1025);
INSERT INTO `sys_role_menu` VALUES (2, 1026);
INSERT INTO `sys_role_menu` VALUES (2, 1027);
INSERT INTO `sys_role_menu` VALUES (2, 1028);
INSERT INTO `sys_role_menu` VALUES (2, 1029);
INSERT INTO `sys_role_menu` VALUES (2, 1030);
INSERT INTO `sys_role_menu` VALUES (2, 1031);
INSERT INTO `sys_role_menu` VALUES (2, 1032);
INSERT INTO `sys_role_menu` VALUES (2, 1033);
INSERT INTO `sys_role_menu` VALUES (2, 1034);
INSERT INTO `sys_role_menu` VALUES (2, 1035);
INSERT INTO `sys_role_menu` VALUES (2, 1036);
INSERT INTO `sys_role_menu` VALUES (2, 1037);
INSERT INTO `sys_role_menu` VALUES (2, 1038);
INSERT INTO `sys_role_menu` VALUES (2, 1039);
INSERT INTO `sys_role_menu` VALUES (2, 1040);
INSERT INTO `sys_role_menu` VALUES (2, 1041);
INSERT INTO `sys_role_menu` VALUES (2, 1042);
INSERT INTO `sys_role_menu` VALUES (2, 1043);
INSERT INTO `sys_role_menu` VALUES (2, 1044);
INSERT INTO `sys_role_menu` VALUES (2, 1045);
INSERT INTO `sys_role_menu` VALUES (2, 1046);
INSERT INTO `sys_role_menu` VALUES (2, 1047);
INSERT INTO `sys_role_menu` VALUES (2, 1048);
INSERT INTO `sys_role_menu` VALUES (2, 1049);
INSERT INTO `sys_role_menu` VALUES (2, 1050);
INSERT INTO `sys_role_menu` VALUES (2, 1051);
INSERT INTO `sys_role_menu` VALUES (2, 1052);
INSERT INTO `sys_role_menu` VALUES (2, 1053);
INSERT INTO `sys_role_menu` VALUES (2, 1054);
INSERT INTO `sys_role_menu` VALUES (2, 1055);
INSERT INTO `sys_role_menu` VALUES (2, 1056);
INSERT INTO `sys_role_menu` VALUES (2, 1057);
INSERT INTO `sys_role_menu` VALUES (2, 1058);
INSERT INTO `sys_role_menu` VALUES (2, 1059);
INSERT INTO `sys_role_menu` VALUES (2, 1060);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `dept_id` bigint(20) NULL DEFAULT NULL COMMENT '部门ID',
  `user_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户账号',
  `nick_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户昵称',
  `user_type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '00' COMMENT '用户类型（00系统用户）',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '手机号码',
  `sex` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `avatar` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '头像地址',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '密码',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `login_ip` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后登陆IP',
  `login_date` datetime(0) NULL DEFAULT NULL COMMENT '最后登陆时间',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 103, 'admin', '若依', '00', 'ry@163.com', '15888888888', '1', '', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '0', '0', '127.0.0.1', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '管理员');
INSERT INTO `sys_user` VALUES (2, 105, 'ry', '若依', '00', 'ry@qq.com', '15666666666', '1', '', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '0', '0', '127.0.0.1', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '测试员');

-- ----------------------------
-- Table structure for sys_user_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_post`;
CREATE TABLE `sys_user_post`  (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `post_id` bigint(20) NOT NULL COMMENT '岗位ID',
  PRIMARY KEY (`user_id`, `post_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户与岗位关联表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user_post
-- ----------------------------
INSERT INTO `sys_user_post` VALUES (1, 1);
INSERT INTO `sys_user_post` VALUES (2, 2);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户和角色关联表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1);
INSERT INTO `sys_user_role` VALUES (2, 2);

-- ----------------------------
-- Table structure for zh_category
-- ----------------------------
DROP TABLE IF EXISTS `zh_category`;
CREATE TABLE `zh_category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '标准名称',
  `create_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '颜色标准' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of zh_category
-- ----------------------------
INSERT INTO `zh_category` VALUES (1, '禾信专用1', NULL, '2020-03-04 17:29:02', NULL, '2020-03-11 13:34:29');

-- ----------------------------
-- Table structure for zh_collect_record
-- ----------------------------
DROP TABLE IF EXISTS `zh_collect_record`;
CREATE TABLE `zh_collect_record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `device_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '设备编号',
  `start_time` datetime(0) NULL DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '结束时间',
  `point_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '控点名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of zh_collect_record
-- ----------------------------
INSERT INTO `zh_collect_record` VALUES (1, 'SPIMS001', '2019-09-26 18:49:59', '2019-09-26 19:53:39', '广州禾信');
INSERT INTO `zh_collect_record` VALUES (2, 'SPIMS001', '2019-09-26 18:49:59', '2019-09-26 19:53:39', '广州禾信');
INSERT INTO `zh_collect_record` VALUES (3, 'SPIMS001', '2019-09-26 18:49:59', '2019-09-26 19:53:39', '广州禾信');
INSERT INTO `zh_collect_record` VALUES (4, 'SPIMS001', '2019-09-26 18:49:59', '2019-09-26 19:53:39', '广州禾信');
INSERT INTO `zh_collect_record` VALUES (5, 'SPIMS001', '2019-09-26 18:49:59', '2019-09-26 19:53:39', '广州禾信');
INSERT INTO `zh_collect_record` VALUES (6, 'SPIMS001', '2019-09-26 18:49:59', '2019-09-26 19:53:39', '广州禾信');
INSERT INTO `zh_collect_record` VALUES (7, 'SPIMS001', '2019-09-26 18:49:59', '2019-09-26 19:53:39', '广州禾信');
INSERT INTO `zh_collect_record` VALUES (8, 'SPIMS001', '2019-09-26 18:49:59', '2019-09-26 19:53:39', '广州禾信');
INSERT INTO `zh_collect_record` VALUES (9, 'SPIMS001', '2019-09-26 18:49:59', '2019-09-26 19:53:39', '广州禾信');
INSERT INTO `zh_collect_record` VALUES (10, 'SPIMS001', '2019-09-26 18:49:59', '2019-09-26 19:53:39', '广州禾信');
INSERT INTO `zh_collect_record` VALUES (11, 'SPIMS001', '2019-09-26 18:49:59', '2019-09-26 19:53:39', '广州禾信');
INSERT INTO `zh_collect_record` VALUES (12, 'SPIMS001', '2019-09-26 18:49:59', '2019-09-26 19:53:39', '广州禾信');
INSERT INTO `zh_collect_record` VALUES (13, 'SPIMS001', '2019-09-26 18:49:59', '2019-09-26 19:53:39', '广州禾信');
INSERT INTO `zh_collect_record` VALUES (14, 'SPIMS001', '2019-09-26 18:49:59', '2019-09-26 19:53:39', '广州禾信');
INSERT INTO `zh_collect_record` VALUES (15, 'SPIMS001', '2019-09-26 18:49:59', '2019-09-26 19:53:39', '广州禾信');
INSERT INTO `zh_collect_record` VALUES (16, 'SPIMS001', '2019-09-26 18:49:59', '2019-09-26 19:53:39', '广州禾信');
INSERT INTO `zh_collect_record` VALUES (17, 'SPIMS001', '2019-09-26 18:49:59', '2019-09-26 19:53:39', '广州禾信');
INSERT INTO `zh_collect_record` VALUES (18, 'SPIMS001', '2019-09-26 18:49:59', '2019-09-26 19:53:39', '广州禾信');
INSERT INTO `zh_collect_record` VALUES (19, 'SPIMS001', '2019-09-26 18:49:59', '2019-09-26 19:53:39', '广州禾信');
INSERT INTO `zh_collect_record` VALUES (20, 'SPIMS001', '2019-09-26 18:49:59', '2019-09-26 19:53:39', '广州禾信');
INSERT INTO `zh_collect_record` VALUES (21, 'SPIMS001', '2019-09-26 18:49:59', '2019-09-26 19:53:39', '广州禾信');
INSERT INTO `zh_collect_record` VALUES (22, 'SPIMS001', '2019-09-26 18:49:59', '2019-09-26 19:53:39', '广州禾信');
INSERT INTO `zh_collect_record` VALUES (23, 'SPIMS001', '2019-09-26 18:49:59', '2019-09-26 19:53:39', '广州禾信');
INSERT INTO `zh_collect_record` VALUES (24, 'SPIMS001', '2019-09-26 18:49:59', '2019-09-26 19:53:39', '广州禾信');
INSERT INTO `zh_collect_record` VALUES (25, 'SPIMS001', '2019-09-26 18:49:59', '2019-09-26 19:53:39', '广州禾信');
INSERT INTO `zh_collect_record` VALUES (27, 'SPIMS001', '2019-09-26 18:49:59', '2019-09-26 19:53:39', '广州禾信');
INSERT INTO `zh_collect_record` VALUES (28, 'SPIMS001', '2019-09-26 18:49:59', '2019-09-26 19:53:39', '广州禾信');
INSERT INTO `zh_collect_record` VALUES (29, 'SPIMS001', '2019-09-26 18:49:59', '2019-09-26 19:53:39', '广州禾信');
INSERT INTO `zh_collect_record` VALUES (30, 'SPIMS001', '2019-09-08 09:45:47', '2019-09-08 16:55:14', '广州禾信');
INSERT INTO `zh_collect_record` VALUES (31, 'SPIMS001', '2019-09-08 09:45:47', '2019-09-08 16:55:14', '广州禾信');

-- ----------------------------
-- Table structure for zh_color
-- ----------------------------
DROP TABLE IF EXISTS `zh_color`;
CREATE TABLE `zh_color`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `color_str` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '颜色字符',
  `create_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '颜色' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of zh_color
-- ----------------------------
INSERT INTO `zh_color` VALUES (1, '4CE600', NULL, '2020-03-04 17:29:49', NULL, NULL);
INSERT INTO `zh_color` VALUES (2, 'E60000', NULL, '2020-03-04 17:30:50', NULL, NULL);
INSERT INTO `zh_color` VALUES (3, 'D1FF73', NULL, NULL, NULL, NULL);
INSERT INTO `zh_color` VALUES (4, 'C500FF', NULL, NULL, NULL, NULL);
INSERT INTO `zh_color` VALUES (5, '53261f', NULL, NULL, NULL, NULL);

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
  `created_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updated_date` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of zh_device
-- ----------------------------
INSERT INTO `zh_device` VALUES (1, 'SPIMS测试', 'SPIMS001', '广州禾信', '加速器', '第三方', 0, 0, 0, 0, '2020-02-19 00:00:00', '2020-02-23 00:00:00');

-- ----------------------------
-- Table structure for zh_factor
-- ----------------------------
DROP TABLE IF EXISTS `zh_factor`;
CREATE TABLE `zh_factor`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '因子名称',
  `ename` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '英文名称',
  `formula` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '分子式',
  `weight` double(10, 3) NOT NULL DEFAULT 0.000 COMMENT '分子量',
  `smell` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '气味',
  `warning` double(10, 2) NULL DEFAULT NULL COMMENT '预警值',
  `danger` double(10, 2) NULL DEFAULT NULL COMMENT '报警值',
  `create_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '因子表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of zh_factor
-- ----------------------------
INSERT INTO `zh_factor` VALUES (1, 'TVOC', 'TVOC', '', 0.000, '', NULL, NULL, NULL, '2020-03-04 17:28:27', NULL, NULL);
INSERT INTO `zh_factor` VALUES (2, '丁烯', 'DX', '', 0.000, '', NULL, NULL, NULL, '2020-03-04 17:28:49', NULL, NULL);
INSERT INTO `zh_factor` VALUES (3, '甲苯', 'JB', '', 0.000, '', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `zh_factor` VALUES (4, '三氯乙烯', 'SLYX', '', 0.000, '', NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for zh_link_category_factor_color
-- ----------------------------
DROP TABLE IF EXISTS `zh_link_category_factor_color`;
CREATE TABLE `zh_link_category_factor_color`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `category_id` int(11) NOT NULL COMMENT '标准编号',
  `factor_id` int(11) NOT NULL COMMENT '因子编号',
  `color_id` int(11) NOT NULL COMMENT '颜色编号',
  `create_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '物质因子颜色关联' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of zh_link_category_factor_color
-- ----------------------------
INSERT INTO `zh_link_category_factor_color` VALUES (1, 1, 2, 5, NULL, '2020-03-04 17:33:38', NULL, NULL);
INSERT INTO `zh_link_category_factor_color` VALUES (2, 1, 4, 4, NULL, '2020-03-04 17:33:42', NULL, NULL);

-- ----------------------------
-- Table structure for zh_link_category_factor_simple_color
-- ----------------------------
DROP TABLE IF EXISTS `zh_link_category_factor_simple_color`;
CREATE TABLE `zh_link_category_factor_simple_color`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `category_id` int(11) NOT NULL COMMENT '标准编号',
  `factor_id` int(11) NOT NULL COMMENT '因子编号',
  `simple_color_id` int(11) NOT NULL COMMENT '单个颜色编号',
  `create_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '物质因子颜色关联' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for zh_point
-- ----------------------------
DROP TABLE IF EXISTS `zh_point`;
CREATE TABLE `zh_point`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `lng` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '经度',
  `lat` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '纬度',
  `created_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updated_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of zh_point
-- ----------------------------
INSERT INTO `zh_point` VALUES (1, '广州禾信', '113', '23', NULL, NULL);

-- ----------------------------
-- Table structure for zh_simple_color
-- ----------------------------
DROP TABLE IF EXISTS `zh_simple_color`;
CREATE TABLE `zh_simple_color`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `start_value` int(11) NULL DEFAULT NULL COMMENT '开始值',
  `end_value` int(11) NULL DEFAULT NULL COMMENT '结束值',
  `create_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '物质因子颜色关联' ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
