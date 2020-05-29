DROP TABLE IF EXISTS `zh_file`;
CREATE TABLE `zh_file`  (
    `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
    `file_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文件名',
    `size` int(11) NULL DEFAULT NULL COMMENT '文件大小kb',
    `path` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文件路径',
    `durability` int(1) NULL DEFAULT 0 COMMENT '是否入库',
    `collect_record_id` int(11) NOT NULL COMMENT '走航id',
    `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
    `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
    `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
    `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
    `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文件表' ROW_FORMAT = Compact;
alter table zh_file add index collect_record_id (collect_record_id) COMMENT '走航id索引';