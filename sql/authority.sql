/*
 Navicat Premium Data Transfer

 Source Server         : mysql8
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : authority

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 16/02/2020 21:34:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '用户唯一id',
  `account` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户账号',
  `name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '名字',
  `password` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '123456' COMMENT '用户密码',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否已删除，0否',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_modified_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `create_user_id` int unsigned DEFAULT NULL COMMENT '创建账户人',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `account_unique_index` (`account`) USING BTREE COMMENT 'account账户唯一索引',
  KEY `user_account_fk_id` (`create_user_id`) USING BTREE,
  CONSTRAINT `user_account_fk_id` FOREIGN KEY (`create_user_id`) REFERENCES `account` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of account
-- ----------------------------
BEGIN;
INSERT INTO `account` VALUES (1, 'ligang', '李刚', '123456', b'0', '2020-02-14 03:06:34', NULL, 1);
INSERT INTO `account` VALUES (2, 'muhua', '慕华', '123456', b'0', '2020-02-14 03:08:53', NULL, 1);
INSERT INTO `account` VALUES (3, 'liuyifei', '刘亦菲', '123456', b'0', '2020-02-15 12:19:15', NULL, 1);
INSERT INTO `account` VALUES (4, 'yangchaoyue', '杨超越', '123456', b'0', '2020-02-15 12:20:10', NULL, 1);
INSERT INTO `account` VALUES (5, 'lihua', '李华', '654321', b'1', '2020-02-16 08:46:16', NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '权限唯一id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '权限名',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '权限描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of permission
-- ----------------------------
BEGIN;
INSERT INTO `permission` VALUES (1, 'administrator', '2020-02-14 03:42:02', '所有权限');
INSERT INTO `permission` VALUES (2, 'account-create', '2020-02-14 03:43:30', '账户创建权限');
INSERT INTO `permission` VALUES (3, 'account-delete', '2020-02-14 03:45:02', '账户删除权限');
INSERT INTO `permission` VALUES (4, 'account-update', '2020-02-14 03:49:01', '账户修改权限');
INSERT INTO `permission` VALUES (5, 'account-select', '2020-02-14 03:58:50', '账户查询权限');
INSERT INTO `permission` VALUES (7, 'role-create', '2020-02-15 11:24:39', '角色创建权限');
INSERT INTO `permission` VALUES (8, 'role-delete', '2020-02-15 11:24:54', '角色删除权限');
INSERT INTO `permission` VALUES (9, 'role-update', '2020-02-15 11:25:02', '角色修改权限');
INSERT INTO `permission` VALUES (10, 'role-select', '2020-02-15 11:25:10', '角色查询权限');
INSERT INTO `permission` VALUES (11, 'permission-create', '2020-02-15 11:24:39', '权限增加权限');
INSERT INTO `permission` VALUES (12, 'permission-delete', '2020-02-15 11:24:54', '权限删除权限');
INSERT INTO `permission` VALUES (13, 'permission-update', '2020-02-15 11:25:02', '权限修改权限');
INSERT INTO `permission` VALUES (14, 'permission-select', '2020-02-15 11:25:10', '权限查询权限');
INSERT INTO `permission` VALUES (15, 'add-role', '2020-02-15 11:37:54', '给账户添加角色');
INSERT INTO `permission` VALUES (16, 'add-permission', '2020-02-15 11:38:11', '给角色添加权限');
INSERT INTO `permission` VALUES (17, 'update-role', '2020-02-15 11:40:01', '修改角色绑定的权限');
COMMIT;

-- ----------------------------
-- Table structure for rel_account_role
-- ----------------------------
DROP TABLE IF EXISTS `rel_account_role`;
CREATE TABLE `rel_account_role` (
  `account_id` int unsigned NOT NULL,
  `role_id` int unsigned NOT NULL,
  KEY `f_account_id` (`account_id`),
  KEY `f_role_id` (`role_id`),
  CONSTRAINT `f_account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `f_role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of rel_account_role
-- ----------------------------
BEGIN;
INSERT INTO `rel_account_role` VALUES (4, 4);
INSERT INTO `rel_account_role` VALUES (1, 1);
INSERT INTO `rel_account_role` VALUES (5, 2);
COMMIT;

-- ----------------------------
-- Table structure for rel_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `rel_role_permission`;
CREATE TABLE `rel_role_permission` (
  `role_id` int unsigned NOT NULL,
  `permission_id` int unsigned NOT NULL,
  KEY `froleid` (`role_id`),
  KEY `privid` (`permission_id`),
  CONSTRAINT `froleid` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `privid` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of rel_role_permission
-- ----------------------------
BEGIN;
INSERT INTO `rel_role_permission` VALUES (2, 3);
INSERT INTO `rel_role_permission` VALUES (2, 4);
INSERT INTO `rel_role_permission` VALUES (2, 5);
INSERT INTO `rel_role_permission` VALUES (3, 5);
INSERT INTO `rel_role_permission` VALUES (3, 7);
INSERT INTO `rel_role_permission` VALUES (3, 8);
COMMIT;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '角色名',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of role
-- ----------------------------
BEGIN;
INSERT INTO `role` VALUES (1, 'sys-admin', '2020-02-14 03:10:32', '系统管理员');
INSERT INTO `role` VALUES (2, 'role-admin', '2020-02-14 03:11:08', '角色管理员');
INSERT INTO `role` VALUES (3, 'permission-admin', '2020-02-14 03:18:28', '权限管理员');
INSERT INTO `role` VALUES (4, 'account-admin', '2020-02-14 03:18:54', '账户管理员');
INSERT INTO `role` VALUES (6, 'student', '2020-02-14 03:38:43', '学生');
INSERT INTO `role` VALUES (7, 'human-resource', '2020-02-14 03:39:40', '人力资源');
INSERT INTO `role` VALUES (8, 'monitor', '2020-02-14 04:54:53', '班长');
INSERT INTO `role` VALUES (9, 'xxxxx', '2020-02-14 04:54:53', 'test角色');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
