/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : bike

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 30/09/2019 11:40:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bicycle_catagory
-- ----------------------------
DROP TABLE IF EXISTS `bicycle_catagory`;
CREATE TABLE `bicycle_catagory`  (
  `CATAGORY_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CATAGORY_NAME` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `FRAME_TYPE` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `TIRE_TYPE` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `WEIGHT` decimal(3, 0) NULL DEFAULT NULL,
  `HEIGHT` decimal(3, 0) NULL DEFAULT NULL,
  `LENGTH` decimal(3, 0) NULL DEFAULT NULL,
  `RING_TYPE` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `BASKET` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `BACKSEAT` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `BICYCLE_SEAT` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `HANDBRAKE` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `REMARK` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `USER_ID` int(11) NOT NULL,
  `OPERATOR_TIME` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`CATAGORY_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bicycle_catagory
-- ----------------------------
INSERT INTO `bicycle_catagory` VALUES (1, '山地车', '钛合金', '米其林', 10, 1, 2, '电子', '塑料', '鱼尾型', '宝马', '碟刹', NULL, 1, '2019-4-5 10:2:3');
INSERT INTO `bicycle_catagory` VALUES (2, '超跑', '记忆金属', '米奇吨', 5, 1, 2, '手动', '纤维', '豚型', '奔驰', '碟刹', NULL, 1, '2019-5-5-10:23:25');

-- ----------------------------
-- Table structure for bicycle_deal
-- ----------------------------
DROP TABLE IF EXISTS `bicycle_deal`;
CREATE TABLE `bicycle_deal`  (
  `DEAL_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CREATE_TIME` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `DEAL_NAME` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `DEAL_TYPE` int(1) NOT NULL,
  `RECORD_ID` int(11) NOT NULL,
  `CARD_ID` int(11) NULL DEFAULT NULL,
  `IS_FEE` int(1) NOT NULL,
  `CHG_MONEY` decimal(13, 2) NULL DEFAULT NULL,
  `FEE_TYPE` int(11) NULL DEFAULT NULL,
  `BICYCLE_ID` int(11) NULL DEFAULT NULL,
  `PILE_ID` int(11) NULL DEFAULT NULL,
  `USER_ID` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`DEAL_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 51 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bicycle_deal
-- ----------------------------
INSERT INTO `bicycle_deal` VALUES (22, '2019-09-23 14:43:33', '新车购入', 1, 26, NULL, 1, 151515.30, 2, 112, NULL, 1);
INSERT INTO `bicycle_deal` VALUES (23, '2019-09-23 14:43:33', '新车购入', 1, 26, NULL, 1, 151515.30, 2, 113, NULL, 1);
INSERT INTO `bicycle_deal` VALUES (24, '2019-09-23 14:43:33', '新车购入', 1, 26, NULL, 1, 151515.30, 2, 114, NULL, 1);
INSERT INTO `bicycle_deal` VALUES (25, '2019-09-23 14:43:33', '新车购入', 1, 26, NULL, 1, 151515.30, 2, 115, NULL, 1);
INSERT INTO `bicycle_deal` VALUES (26, '2019-09-25 23:17:18', '普通调入', 5, 9, NULL, 0, 0.00, NULL, NULL, NULL, NULL);
INSERT INTO `bicycle_deal` VALUES (27, '2019-09-25 23:17:18', '普通调入', 5, 10, NULL, 0, 0.00, NULL, NULL, NULL, NULL);
INSERT INTO `bicycle_deal` VALUES (28, '2019-09-25 23:18:10', '普通调入', 5, 11, NULL, 0, 0.00, NULL, NULL, NULL, NULL);
INSERT INTO `bicycle_deal` VALUES (29, '2019-09-25 23:18:10', '普通调入', 5, 12, NULL, 0, 0.00, NULL, NULL, NULL, NULL);
INSERT INTO `bicycle_deal` VALUES (30, '2019-09-25 23:40:38', '新车购入', 1, 27, NULL, 1, 12121.00, 2, 116, NULL, 1);
INSERT INTO `bicycle_deal` VALUES (31, '2019-09-25 23:40:38', '新车购入', 1, 27, NULL, 1, 12121.00, 2, 117, NULL, 1);
INSERT INTO `bicycle_deal` VALUES (32, '2019-09-25 23:40:38', '新车购入', 1, 27, NULL, 1, 12121.00, 2, 118, NULL, 1);
INSERT INTO `bicycle_deal` VALUES (33, '2019-09-26 14:22:18', '新车购入', 1, 28, NULL, 1, 41434.52, 2, 119, NULL, 1);
INSERT INTO `bicycle_deal` VALUES (34, '2019-09-26 14:22:18', '新车购入', 1, 28, NULL, 1, 41434.52, 2, 120, NULL, 1);
INSERT INTO `bicycle_deal` VALUES (35, '2019-09-26 14:22:18', '新车购入', 1, 28, NULL, 1, 41434.52, 2, 121, NULL, 1);
INSERT INTO `bicycle_deal` VALUES (36, '2019-09-26 14:22:18', '新车购入', 1, 28, NULL, 1, 41434.52, 2, 122, NULL, 1);
INSERT INTO `bicycle_deal` VALUES (37, '2019-09-26 14:22:18', '新车购入', 1, 28, NULL, 1, 41434.52, 2, 123, NULL, 1);
INSERT INTO `bicycle_deal` VALUES (38, '2019-09-26 14:23:20', '普通调入', 5, 13, NULL, 0, 0.00, NULL, NULL, NULL, NULL);
INSERT INTO `bicycle_deal` VALUES (39, '2019-09-26 14:23:20', '普通调入', 5, 14, NULL, 0, 0.00, NULL, NULL, NULL, NULL);
INSERT INTO `bicycle_deal` VALUES (40, '2019-09-26 14:23:20', '普通调入', 5, 15, NULL, 0, 0.00, NULL, NULL, NULL, NULL);
INSERT INTO `bicycle_deal` VALUES (41, '2019-09-26 14:23:35', '普通调入', 5, 16, NULL, 0, 0.00, NULL, NULL, NULL, NULL);
INSERT INTO `bicycle_deal` VALUES (42, '2019-09-26 14:23:35', '普通调入', 5, 17, NULL, 0, 0.00, NULL, NULL, NULL, NULL);
INSERT INTO `bicycle_deal` VALUES (43, '2019-09-26 14:23:41', '普通调入', 5, 18, NULL, 0, 0.00, NULL, NULL, NULL, NULL);
INSERT INTO `bicycle_deal` VALUES (44, '2019-09-27 20:30:07', '普通调入', 5, 19, NULL, 0, 0.00, NULL, NULL, NULL, NULL);
INSERT INTO `bicycle_deal` VALUES (45, '2019-09-28 12:15:00', '普通调入', 5, 20, NULL, 0, 0.00, NULL, NULL, NULL, NULL);
INSERT INTO `bicycle_deal` VALUES (46, '2019-09-28 13:43:43', '新车购入', 1, 29, NULL, 1, 15563.90, 2, 124, NULL, 1);
INSERT INTO `bicycle_deal` VALUES (47, '2019-09-28 13:43:43', '新车购入', 1, 29, NULL, 1, 15563.90, 2, 125, NULL, 1);
INSERT INTO `bicycle_deal` VALUES (48, '2019-09-28 13:43:43', '新车购入', 1, 29, NULL, 1, 15563.90, 2, 126, NULL, 1);
INSERT INTO `bicycle_deal` VALUES (49, '2019-09-28 13:44:25', '普通调入', 5, 21, NULL, 0, 0.00, NULL, NULL, NULL, NULL);
INSERT INTO `bicycle_deal` VALUES (50, '2019-09-29 14:07:25', '新车购入', 1, 30, NULL, 1, 788.00, 2, 127, NULL, 1);
INSERT INTO `bicycle_deal` VALUES (51, '2019-09-29 15:22:13', '普通调入', 5, 22, NULL, 0, 0.00, NULL, NULL, NULL, NULL);
INSERT INTO `bicycle_deal` VALUES (52, '2019-09-29 16:04:22', '新车购入', 1, 31, NULL, 1, 15151.00, 2, 128, NULL, 1);
INSERT INTO `bicycle_deal` VALUES (53, '2019-09-29 16:04:22', '新车购入', 1, 31, NULL, 1, 15151.00, 2, 129, NULL, 1);
INSERT INTO `bicycle_deal` VALUES (54, '2019-09-29 16:04:22', '新车购入', 1, 31, NULL, 1, 15151.00, 2, 130, NULL, 1);
INSERT INTO `bicycle_deal` VALUES (55, '2019-09-29 16:05:31', '普通调入', 5, 23, NULL, 0, 0.00, NULL, NULL, NULL, NULL);
INSERT INTO `bicycle_deal` VALUES (56, '2019-09-29 16:05:31', '普通调入', 5, 24, NULL, 0, 0.00, NULL, NULL, NULL, NULL);
INSERT INTO `bicycle_deal` VALUES (57, '2019-09-29 16:05:31', '普通调入', 5, 25, NULL, 0, 0.00, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for bicycle_deploy
-- ----------------------------
DROP TABLE IF EXISTS `bicycle_deploy`;
CREATE TABLE `bicycle_deploy`  (
  `DEPLOY_ID` int(11) NOT NULL AUTO_INCREMENT,
  `BICYCLE_ID` int(11) NULL DEFAULT NULL,
  `FROM_PILE_ID` int(11) NULL DEFAULT NULL,
  `TO_PILE_ID` int(11) NULL DEFAULT NULL,
  `FROM_CARD_ID` int(11) NULL DEFAULT NULL,
  `FROM_TIME` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `TO_CARD_ID` int(11) NULL DEFAULT NULL,
  `TO_TIME` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `TO_REASON` int(1) NULL DEFAULT NULL,
  `FROM_REASON` int(1) NULL DEFAULT NULL,
  `REMARK` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `STATUS` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`DEPLOY_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bicycle_deploy
-- ----------------------------
INSERT INTO `bicycle_deploy` VALUES (9, 112, NULL, 1, NULL, NULL, NULL, '2019-09-25 23:17:18', 1, NULL, NULL, NULL);
INSERT INTO `bicycle_deploy` VALUES (10, 113, NULL, 2, NULL, NULL, NULL, '2019-09-25 23:17:18', 1, NULL, NULL, NULL);
INSERT INTO `bicycle_deploy` VALUES (11, 114, NULL, 3, NULL, NULL, NULL, '2019-09-25 23:18:10', 1, NULL, NULL, NULL);
INSERT INTO `bicycle_deploy` VALUES (12, 115, NULL, 4, NULL, NULL, NULL, '2019-09-25 23:18:10', 1, NULL, NULL, NULL);
INSERT INTO `bicycle_deploy` VALUES (13, 116, NULL, 5, NULL, NULL, NULL, '2019-09-26 14:23:20', 1, NULL, NULL, NULL);
INSERT INTO `bicycle_deploy` VALUES (14, 117, NULL, 6, NULL, NULL, NULL, '2019-09-26 14:23:20', 1, NULL, NULL, NULL);
INSERT INTO `bicycle_deploy` VALUES (15, 118, NULL, 7, NULL, NULL, NULL, '2019-09-26 14:23:20', 1, NULL, NULL, NULL);
INSERT INTO `bicycle_deploy` VALUES (16, 119, NULL, 8, NULL, NULL, NULL, '2019-09-26 14:23:35', 1, NULL, NULL, NULL);
INSERT INTO `bicycle_deploy` VALUES (17, 120, NULL, 11, NULL, NULL, NULL, '2019-09-26 14:23:35', 1, NULL, NULL, NULL);
INSERT INTO `bicycle_deploy` VALUES (18, 121, NULL, 12, NULL, NULL, NULL, '2019-09-26 14:23:41', 1, NULL, NULL, NULL);
INSERT INTO `bicycle_deploy` VALUES (19, 122, NULL, 16, NULL, NULL, NULL, '2019-09-27 20:30:07', 1, NULL, NULL, NULL);
INSERT INTO `bicycle_deploy` VALUES (20, 123, NULL, 17, NULL, NULL, NULL, '2019-09-28 12:15:00', 1, NULL, NULL, NULL);
INSERT INTO `bicycle_deploy` VALUES (21, 124, NULL, 18, NULL, NULL, NULL, '2019-09-28 13:44:25', 1, NULL, NULL, NULL);
INSERT INTO `bicycle_deploy` VALUES (22, 125, NULL, 13, NULL, NULL, NULL, '2019-09-29 15:22:13', 1, NULL, NULL, NULL);
INSERT INTO `bicycle_deploy` VALUES (23, 126, NULL, 9, NULL, NULL, NULL, '2019-09-29 16:05:31', 1, NULL, NULL, NULL);
INSERT INTO `bicycle_deploy` VALUES (24, 127, NULL, 14, NULL, NULL, NULL, '2019-09-29 16:05:31', 1, NULL, NULL, NULL);
INSERT INTO `bicycle_deploy` VALUES (25, 128, NULL, 15, NULL, NULL, NULL, '2019-09-29 16:05:31', 1, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for bicycle_info
-- ----------------------------
DROP TABLE IF EXISTS `bicycle_info`;
CREATE TABLE `bicycle_info`  (
  `BICYCLE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `BICYCLE_CODE` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `STATUS` int(1) NOT NULL,
  `PILE_ID` int(11) NULL DEFAULT NULL,
  `DESTROY_DATE` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `USER_ID` int(11) NULL DEFAULT NULL,
  `OPERATOR_TIME` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `CARD_ID` int(11) NULL DEFAULT NULL,
  `REMARK` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`BICYCLE_ID`) USING BTREE,
  INDEX `PILE_ID`(`PILE_ID`) USING BTREE,
  CONSTRAINT `bicycle_info_ibfk_1` FOREIGN KEY (`PILE_ID`) REFERENCES `bicycle_pile` (`PILE_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 128 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bicycle_info
-- ----------------------------
INSERT INTO `bicycle_info` VALUES (112, '10000022', 3, 1, NULL, 1, '2019-09-23 14:43:33', NULL, NULL);
INSERT INTO `bicycle_info` VALUES (113, '10000023', 3, 2, NULL, 1, '2019-09-23 14:43:33', NULL, NULL);
INSERT INTO `bicycle_info` VALUES (114, '10000024', 3, 3, NULL, 1, '2019-09-23 14:43:33', NULL, NULL);
INSERT INTO `bicycle_info` VALUES (115, '10000025', 3, 4, NULL, 1, '2019-09-23 14:43:33', NULL, NULL);
INSERT INTO `bicycle_info` VALUES (116, '10000026', 3, 5, NULL, 1, '2019-09-25 23:40:38', NULL, NULL);
INSERT INTO `bicycle_info` VALUES (117, '10000027', 3, 6, NULL, 1, '2019-09-25 23:40:38', NULL, NULL);
INSERT INTO `bicycle_info` VALUES (118, '10000028', 3, 7, NULL, 1, '2019-09-25 23:40:38', NULL, NULL);
INSERT INTO `bicycle_info` VALUES (119, '10000029', 3, 8, NULL, 1, '2019-09-26 14:22:18', NULL, NULL);
INSERT INTO `bicycle_info` VALUES (120, '10000030', 3, 11, NULL, 1, '2019-09-26 14:22:18', NULL, NULL);
INSERT INTO `bicycle_info` VALUES (121, '10000031', 3, 12, NULL, 1, '2019-09-26 14:22:18', NULL, NULL);
INSERT INTO `bicycle_info` VALUES (122, '10000032', 3, 16, NULL, 1, '2019-09-26 14:22:18', NULL, NULL);
INSERT INTO `bicycle_info` VALUES (123, '10000033', 3, 17, NULL, 1, '2019-09-26 14:22:18', NULL, NULL);
INSERT INTO `bicycle_info` VALUES (124, '10000034', 3, 18, NULL, 1, '2019-09-28 13:43:43', NULL, NULL);
INSERT INTO `bicycle_info` VALUES (125, '10000035', 3, 13, NULL, 1, '2019-09-28 13:43:43', NULL, NULL);
INSERT INTO `bicycle_info` VALUES (126, '10000036', 3, 9, NULL, 1, '2019-09-28 13:43:43', NULL, NULL);
INSERT INTO `bicycle_info` VALUES (127, '10000037', 3, 14, NULL, 1, '2019-09-29 14:07:25', NULL, NULL);
INSERT INTO `bicycle_info` VALUES (128, '10000038', 3, 15, NULL, 1, '2019-09-29 16:04:22', NULL, NULL);
INSERT INTO `bicycle_info` VALUES (129, '10000039', 1, NULL, NULL, 1, '2019-09-29 16:04:22', NULL, NULL);
INSERT INTO `bicycle_info` VALUES (130, '10000040', 1, NULL, NULL, 1, '2019-09-29 16:04:22', NULL, NULL);

-- ----------------------------
-- Table structure for bicycle_order
-- ----------------------------
DROP TABLE IF EXISTS `bicycle_order`;
CREATE TABLE `bicycle_order`  (
  `ORDER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ORDER_CODE` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `VENDER_ID` int(11) NULL DEFAULT NULL,
  `BUY_DATE` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `BUY_NUM` decimal(5, 0) NOT NULL,
  `BUY_PRICE` decimal(10, 2) NOT NULL,
  `PERSON_IN_CHARGE` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `INVOICE_NO` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `USER_ID` int(11) NULL DEFAULT NULL,
  `OPERATOR_TIME` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `REMARK` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `STATUS` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ORDER_ID`) USING BTREE,
  UNIQUE INDEX `ORDER_CODE`(`ORDER_CODE`) USING BTREE,
  INDEX `VENDER_ID`(`VENDER_ID`) USING BTREE,
  CONSTRAINT `bicycle_order_ibfk_1` FOREIGN KEY (`VENDER_ID`) REFERENCES `vender` (`VENDER_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bicycle_order
-- ----------------------------
INSERT INTO `bicycle_order` VALUES (26, 'order20190923144333', 1, '2019-09-01', 4, 151515.30, '🐖', 'adc6261616', 1, '2019-09-23 14:43:33', '滑行吧', NULL);
INSERT INTO `bicycle_order` VALUES (27, 'order20190925234038', 2, '2019-09-07', 3, 12121.00, '🐖', '4144142424', 1, '2019-09-25 23:40:38', '', NULL);
INSERT INTO `bicycle_order` VALUES (28, 'order20190926142218', 2, '2019-09-17', 5, 41434.52, '🐱', '121qq11212', 1, '2019-09-26 14:22:18', '', NULL);
INSERT INTO `bicycle_order` VALUES (29, 'order20190928134343', 1, '2019-09-25', 3, 15563.90, '🐟', 'io1231231', 1, '2019-09-28 13:43:43', '', NULL);
INSERT INTO `bicycle_order` VALUES (30, 'order20190929140725', 2, '2019-09-22', 1, 788.00, '🐍', '1231', 1, '2019-09-29 14:07:25', '', NULL);
INSERT INTO `bicycle_order` VALUES (31, 'order20190929160422', 2, '2019-09-04', 3, 15151.00, '123', '12321', 1, '2019-09-29 16:04:22', '11', NULL);

-- ----------------------------
-- Table structure for bicycle_order_detail
-- ----------------------------
DROP TABLE IF EXISTS `bicycle_order_detail`;
CREATE TABLE `bicycle_order_detail`  (
  `DETAIL_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CATAGORY_ID` int(11) NULL DEFAULT NULL,
  `ORDER_ID` int(11) NULL DEFAULT NULL,
  `BICYCLE_ID` int(11) NOT NULL,
  `CREATE_DATE` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `BATCH_NO` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `PRICE` decimal(10, 2) NULL DEFAULT NULL,
  `REMARK` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`DETAIL_ID`) USING BTREE,
  INDEX `CATAGORY_ID`(`CATAGORY_ID`) USING BTREE,
  INDEX `BICYCLE_ID`(`BICYCLE_ID`) USING BTREE,
  INDEX `ORDER_ID`(`ORDER_ID`) USING BTREE,
  CONSTRAINT `bicycle_order_detail_ibfk_4` FOREIGN KEY (`CATAGORY_ID`) REFERENCES `bicycle_catagory` (`CATAGORY_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `bicycle_order_detail_ibfk_5` FOREIGN KEY (`BICYCLE_ID`) REFERENCES `bicycle_info` (`BICYCLE_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `bicycle_order_detail_ibfk_6` FOREIGN KEY (`ORDER_ID`) REFERENCES `bicycle_order` (`ORDER_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 56 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bicycle_order_detail
-- ----------------------------
INSERT INTO `bicycle_order_detail` VALUES (40, 1, 26, 112, '2019-09-23', 'qqq111', 899.00, '11');
INSERT INTO `bicycle_order_detail` VALUES (41, 1, 26, 113, '2019-09-23', 'qqq111', 899.00, '11');
INSERT INTO `bicycle_order_detail` VALUES (42, 1, 26, 114, '2019-09-23', 'qqq111', 899.00, '11');
INSERT INTO `bicycle_order_detail` VALUES (43, 1, 26, 115, '2019-09-23', 'qqq111', 899.00, '11');
INSERT INTO `bicycle_order_detail` VALUES (44, 1, 27, 116, '2019-09-25', 'qwe12321', 655.00, 'good');
INSERT INTO `bicycle_order_detail` VALUES (45, 1, 27, 117, '2019-09-25', 'qwe12321', 655.00, 'good');
INSERT INTO `bicycle_order_detail` VALUES (46, 1, 27, 118, '2019-09-25', 'qwe12321', 655.00, 'good');
INSERT INTO `bicycle_order_detail` VALUES (47, 1, 28, 119, '2019-09-26', 'bat4445', 455.00, '好车');
INSERT INTO `bicycle_order_detail` VALUES (48, 1, 28, 120, '2019-09-26', 'bat4445', 455.00, '好车');
INSERT INTO `bicycle_order_detail` VALUES (49, 1, 28, 121, '2019-09-26', 'bat4445', 455.00, '好车');
INSERT INTO `bicycle_order_detail` VALUES (50, 1, 28, 122, '2019-09-26', 'bat4445', 455.00, '好车');
INSERT INTO `bicycle_order_detail` VALUES (51, 1, 28, 123, '2019-09-26', 'bat4445', 455.00, '好车');
INSERT INTO `bicycle_order_detail` VALUES (52, 2, 29, 124, '2019-09-28', '121121', 669.00, '豪车');
INSERT INTO `bicycle_order_detail` VALUES (53, 2, 29, 125, '2019-09-28', '121121', 669.00, '豪车');
INSERT INTO `bicycle_order_detail` VALUES (54, 2, 29, 126, '2019-09-28', '121121', 669.00, '豪车');
INSERT INTO `bicycle_order_detail` VALUES (55, 2, 30, 127, '2019-09-29', '11', 899.00, '1');
INSERT INTO `bicycle_order_detail` VALUES (56, 2, 31, 128, '2019-09-29', '121', 12.00, '12');
INSERT INTO `bicycle_order_detail` VALUES (57, 2, 31, 129, '2019-09-29', '121', 12.00, '12');
INSERT INTO `bicycle_order_detail` VALUES (58, 2, 31, 130, '2019-09-29', '121', 12.00, '12');

-- ----------------------------
-- Table structure for bicycle_pile
-- ----------------------------
DROP TABLE IF EXISTS `bicycle_pile`;
CREATE TABLE `bicycle_pile`  (
  `PILE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `VENDER_ID` int(11) NOT NULL,
  `PILE_CODE` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `STATION_ID` int(11) NOT NULL,
  `STATUS` int(1) NOT NULL,
  `INSTALL_TIME` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `DISASSEMBLY_TIME` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `USER_ID` int(11) NOT NULL,
  `OPERATOR_TIME` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `BICYCLE_ID` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `REMARK` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`PILE_ID`) USING BTREE,
  INDEX `STATION_ID`(`STATION_ID`) USING BTREE,
  INDEX `VENDER_ID`(`VENDER_ID`) USING BTREE,
  CONSTRAINT `bicycle_pile_ibfk_1` FOREIGN KEY (`STATION_ID`) REFERENCES `bicycle_station` (`STATION_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `bicycle_pile_ibfk_2` FOREIGN KEY (`VENDER_ID`) REFERENCES `vender` (`VENDER_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bicycle_pile
-- ----------------------------
INSERT INTO `bicycle_pile` VALUES (1, 2, '100252', 1, 1, '2019-1-1 14:25:6', NULL, 1, '2019-4-5', '112', NULL);
INSERT INTO `bicycle_pile` VALUES (2, 2, '100253', 1, 1, '2019-1-1 14:25:6', NULL, 1, '2019-4-5', '113', NULL);
INSERT INTO `bicycle_pile` VALUES (3, 2, '100254', 1, 1, '2019-1-1 14:25:6', NULL, 1, '2019-4-5', '114', NULL);
INSERT INTO `bicycle_pile` VALUES (4, 2, '100255', 1, 1, '2019-1-1 14:25:6', NULL, 1, '2019-4-5', '115', NULL);
INSERT INTO `bicycle_pile` VALUES (5, 2, '100256', 1, 1, '2019-1-1 14:25:6', NULL, 1, '2019-4-5', '116', NULL);
INSERT INTO `bicycle_pile` VALUES (6, 2, '100257', 1, 1, '2019-1-1 14:25:6', NULL, 1, '2019-4-5', '117', NULL);
INSERT INTO `bicycle_pile` VALUES (7, 2, '100258', 1, 1, '2019-1-1 14:25:6', NULL, 1, '2019-4-5', '118', NULL);
INSERT INTO `bicycle_pile` VALUES (8, 2, '100259', 1, 1, '2019-1-1 14:25:6', NULL, 1, '2019-4-5', '119', NULL);
INSERT INTO `bicycle_pile` VALUES (9, 2, '100260', 1, 1, '2019-1-1 14:25:6', NULL, 1, '2019-4-5', '126', NULL);
INSERT INTO `bicycle_pile` VALUES (10, 2, '100261', 1, 2, '2019-1-1 14:25:6', NULL, 1, '2019-4-5', NULL, NULL);
INSERT INTO `bicycle_pile` VALUES (11, 2, '100266', 2, 1, '2019-1-1 14:25:6', NULL, 1, '2019-4-5', '120', NULL);
INSERT INTO `bicycle_pile` VALUES (12, 2, '100267', 2, 1, '2019-1-1 14:25:6', NULL, 1, '2019-4-5', '121', NULL);
INSERT INTO `bicycle_pile` VALUES (13, 2, '100268', 2, 1, '2019-1-1 14:25:6', NULL, 1, '2019-4-5', '125', NULL);
INSERT INTO `bicycle_pile` VALUES (14, 2, '100269', 2, 1, '2019-1-1 14:25:6', NULL, 1, '2019-4-5', '127', NULL);
INSERT INTO `bicycle_pile` VALUES (15, 2, '100270', 2, 1, '2019-1-1 14:25:6', NULL, 1, '2019-4-5', '128', NULL);
INSERT INTO `bicycle_pile` VALUES (16, 2, '100330', 3, 1, '2019-1-1 14:25:6', NULL, 1, '2019-4-5', '122', NULL);
INSERT INTO `bicycle_pile` VALUES (17, 2, '100331', 3, 1, '2019-1-1 14:25:6', NULL, 1, '2019-4-5', '123', NULL);
INSERT INTO `bicycle_pile` VALUES (18, 2, '100332', 3, 1, '2019-1-1 14:25:6', NULL, 1, '2019-4-5', '124', NULL);
INSERT INTO `bicycle_pile` VALUES (19, 2, '100333', 3, 2, '2019-1-1 14:25:6', NULL, 1, '2019-4-5', NULL, NULL);
INSERT INTO `bicycle_pile` VALUES (20, 2, '100334', 3, 2, '2019-1-1 14:25:6', NULL, 1, '2019-4-5', NULL, NULL);
INSERT INTO `bicycle_pile` VALUES (21, 2, '100335', 3, 2, '2019-1-1 14:25:6', NULL, 1, '2019-4-5', NULL, NULL);

-- ----------------------------
-- Table structure for bicycle_record
-- ----------------------------
DROP TABLE IF EXISTS `bicycle_record`;
CREATE TABLE `bicycle_record`  (
  `RECORD_ID` int(11) NOT NULL AUTO_INCREMENT,
  `BICYCLE_ID` int(11) NOT NULL,
  `CARD_ID` int(11) NOT NULL,
  `RENT_TIME` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `RENT_PILE_ID` int(11) NOT NULL,
  `RETURN_TIME` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `RETURN_PILE_ID` int(11) NULL DEFAULT NULL,
  `MONEY` decimal(13, 2) NULL DEFAULT NULL,
  `REMARK` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`RECORD_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for bicycle_station
-- ----------------------------
DROP TABLE IF EXISTS `bicycle_station`;
CREATE TABLE `bicycle_station`  (
  `STATION_ID` int(11) NOT NULL AUTO_INCREMENT,
  `STATION_CODE` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `STATION_NAME` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `LONGITUDE` decimal(10, 5) NOT NULL,
  `LATITUDE` decimal(10, 5) NOT NULL,
  `BICYCLE_PILE_NUM` int(2) NOT NULL,
  `ADDRESS` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `PERSON_IN_CHARGE` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `BUILD_TIME` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `RUN_TIME` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `USER_ID` int(11) NULL DEFAULT NULL,
  `CREATE_TIME` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `REMARK` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`STATION_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bicycle_station
-- ----------------------------
INSERT INTO `bicycle_station` VALUES (1, '1001', '莫干山风情站点', 120.15488, 30.28942, 10, '杭州市莫干山路风情街999号', '王麻子', '2019-1-5 14：3：', '2019-3-5 15：3：3', 1, '2019-1-1 15：3：3', NULL);
INSERT INTO `bicycle_station` VALUES (2, '1002', '湖墅南路霸王站点', 120.16174, 30.27992, 5, '湖墅南路霸王街999号', '张三婆', '2019-2-3 14:23:55', '2019-2-20 14:23:55', 1, '2019-2-1 14:23:55', NULL);
INSERT INTO `bicycle_station` VALUES (3, '1003', '抚顺仙女下凡站点', 123.90963, 41.86955, 6, '抚顺市南口仙女村', '曹阿蛮', '2019-5-3 14:12:23', '2019-5-4 14:12:23', 1, '2019-4-3 14:12:23', NULL);

-- ----------------------------
-- Table structure for card
-- ----------------------------
DROP TABLE IF EXISTS `card`;
CREATE TABLE `card`  (
  `CARD_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CARD_CODE` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `CARD_TYPE` int(11) NOT NULL,
  `NAME` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `IDCARD` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `SEX` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `TELPHONE` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `MOBILE` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `EMAIL` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ADDRESS` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `WORK` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `ZXBJ` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `MONTHLY_MONEY` decimal(13, 2) NULL DEFAULT NULL,
  `FROZEN_MONEY` decimal(13, 2) NULL DEFAULT NULL,
  `WALLET_MONEY` decimal(13, 2) NULL DEFAULT NULL,
  `STATUS` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`CARD_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for card_info_record
-- ----------------------------
DROP TABLE IF EXISTS `card_info_record`;
CREATE TABLE `card_info_record`  (
  `RECORD_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CARD_ID` int(11) NOT NULL,
  `INFO_TYPE` decimal(1, 0) NOT NULL,
  `CREATE_TIME` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `USER_ID` int(11) NOT NULL,
  `REMARK` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`RECORD_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for card_record
-- ----------------------------
DROP TABLE IF EXISTS `card_record`;
CREATE TABLE `card_record`  (
  `RECORD_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CARD_ID` int(11) NOT NULL,
  `FEE_TYPE` int(11) NOT NULL,
  `CHG_MONTHLY_MONEY` decimal(13, 2) NULL DEFAULT NULL,
  `CHG_WALLET_MONEY` decimal(13, 2) NULL DEFAULT NULL,
  `CHG_FROZEN_MONEY` decimal(13, 2) NULL DEFAULT NULL,
  `CREATE_TIME` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `USER_ID` int(11) NULL DEFAULT NULL,
  `REMARK` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `ZXBJ` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`RECORD_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for msphase
-- ----------------------------
DROP TABLE IF EXISTS `msphase`;
CREATE TABLE `msphase`  (
  `PHASEID` int(11) NOT NULL AUTO_INCREMENT,
  `URL` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `DESCRIPTION` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`PHASEID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 58 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of msphase
-- ----------------------------
INSERT INTO `msphase` VALUES (1, '/msphase', '权限管理1');
INSERT INTO `msphase` VALUES (2, '/role', '角色管理');
INSERT INTO `msphase` VALUES (3, '/syuser', '人员管理');
INSERT INTO `msphase` VALUES (4, '/vender', '供应商管理');
INSERT INTO `msphase` VALUES (5, '/card', '办卡');
INSERT INTO `msphase` VALUES (6, '/charge', '充值');
INSERT INTO `msphase` VALUES (7, '/stationmanager', '车辆车桩管理');
INSERT INTO `msphase` VALUES (8, '/bicycletype', '车辆类型管理');
INSERT INTO `msphase` VALUES (9, '/buy', '车辆购入登记');
INSERT INTO `msphase` VALUES (10, '/instation', '新车入桩登记');
INSERT INTO `msphase` VALUES (11, '/repaire', '维修登记');
INSERT INTO `msphase` VALUES (54, '/destroy', '报废登记');

-- ----------------------------
-- Table structure for repair_record
-- ----------------------------
DROP TABLE IF EXISTS `repair_record`;
CREATE TABLE `repair_record`  (
  `RECORD_ID` int(11) NOT NULL AUTO_INCREMENT,
  `BICYCLE_ID` int(11) NOT NULL,
  `REPAIR_TYPE` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `REPAIR_PART` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `REPAIR_RESULT` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `FEE` decimal(7, 3) NULL DEFAULT NULL,
  `REPAIRER` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `REPAIR_DATE` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `REMARK` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `USER_ID` int(11) NULL DEFAULT NULL,
  `OPERATOR_TIME` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`RECORD_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sypermission
-- ----------------------------
DROP TABLE IF EXISTS `sypermission`;
CREATE TABLE `sypermission`  (
  `PERMISSIONID` int(11) NOT NULL AUTO_INCREMENT,
  `ROLEID` int(11) NOT NULL,
  `PHASEID` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`PERMISSIONID`) USING BTREE,
  INDEX `ROLEID`(`ROLEID`) USING BTREE,
  INDEX `PHASEID`(`PHASEID`) USING BTREE,
  CONSTRAINT `sypermission_ibfk_3` FOREIGN KEY (`ROLEID`) REFERENCES `syrole` (`ROLE_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `sypermission_ibfk_4` FOREIGN KEY (`PHASEID`) REFERENCES `msphase` (`PHASEID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 227 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sypermission
-- ----------------------------
INSERT INTO `sypermission` VALUES (202, 2, 1);
INSERT INTO `sypermission` VALUES (203, 2, 3);
INSERT INTO `sypermission` VALUES (218, 1, 3);
INSERT INTO `sypermission` VALUES (219, 1, 4);
INSERT INTO `sypermission` VALUES (220, 1, 6);
INSERT INTO `sypermission` VALUES (221, 1, 1);
INSERT INTO `sypermission` VALUES (222, 1, 2);
INSERT INTO `sypermission` VALUES (223, 1, 5);
INSERT INTO `sypermission` VALUES (224, 1, 7);
INSERT INTO `sypermission` VALUES (225, 1, 9);
INSERT INTO `sypermission` VALUES (226, 1, 10);
INSERT INTO `sypermission` VALUES (274, 11, 1);
INSERT INTO `sypermission` VALUES (275, 11, 2);

-- ----------------------------
-- Table structure for syrole
-- ----------------------------
DROP TABLE IF EXISTS `syrole`;
CREATE TABLE `syrole`  (
  `ROLE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ROLE_NAME` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ROLE_DESCRIBE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ROLE_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of syrole
-- ----------------------------
INSERT INTO `syrole` VALUES (1, 'admin', '管理员');
INSERT INTO `syrole` VALUES (2, 'guest', '来宾');
INSERT INTO `syrole` VALUES (11, 'www', 'w');

-- ----------------------------
-- Table structure for syuser
-- ----------------------------
DROP TABLE IF EXISTS `syuser`;
CREATE TABLE `syuser`  (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ROLE_ID` int(11) NULL DEFAULT NULL,
  `LOGIN_NAME` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `USERNAME` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `PASSWORD` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ACTIVE_FLAG` decimal(1, 0) NULL DEFAULT NULL,
  `ZXBJ` int(1) NOT NULL,
  `OFFICE_PHONE` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `MOBILE_PHONE` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `EMAIL` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`USER_ID`) USING BTREE,
  UNIQUE INDEX `LOGIN_NAME`(`LOGIN_NAME`) USING BTREE,
  INDEX `ROLE_ID`(`ROLE_ID`) USING BTREE,
  CONSTRAINT `syuser_ibfk_1` FOREIGN KEY (`ROLE_ID`) REFERENCES `syrole` (`ROLE_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of syuser
-- ----------------------------
INSERT INTO `syuser` VALUES (1, 1, 'ven', '宇宙嗨', '123', 0, 0, '13166789020', '13526749580', 'mayun@aili.com');
INSERT INTO `syuser` VALUES (2, 1, 'yu', '天王盖地虎', '123', 1, 1, '13265992543', '15233657749', 'mahuateng@tencent.com');
INSERT INTO `syuser` VALUES (3, NULL, 'xiaoyaozi', '逍遥子', '123', 0, 1, '13151515151', '15151563131', 'xiaoyaozi@aliyun.com');
INSERT INTO `syuser` VALUES (4, 11, 'lisi', '李四12', '123', NULL, 0, '110', '114', '555@qq.com');
INSERT INTO `syuser` VALUES (5, 1, 'haha', '123569', '333', NULL, 0, '123', '123', 'ee@qq.com');
INSERT INTO `syuser` VALUES (6, NULL, 'ven123', '123', '123', NULL, 0, '115', '115', 'iii@qq.com');
INSERT INTO `syuser` VALUES (7, NULL, 'li', 'www', '111', NULL, 0, '', '', '');
INSERT INTO `syuser` VALUES (8, NULL, '11212', '1121', '1212', NULL, 0, '121', '121', '121@qq.com');
INSERT INTO `syuser` VALUES (9, 1, '122', '121', '122', NULL, 0, '213', '123', '123@qq.com');
INSERT INTO `syuser` VALUES (10, NULL, '123', '123', '123', NULL, 1, '123', '123', '123');

-- ----------------------------
-- Table structure for vender
-- ----------------------------
DROP TABLE IF EXISTS `vender`;
CREATE TABLE `vender`  (
  `VENDER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `VENDER_CODE` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `VENDER_TYPE` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `VENDER_NAME` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ADDRESS` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `TELPHONE` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `CONTACTS` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `PRODUCT_LICENSE` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `BUSSINESS_REGISTRATION_NO` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `REGISTERED_CAPITAL` decimal(12, 2) NULL DEFAULT NULL,
  `USER_ID` int(11) NULL DEFAULT NULL,
  `CREATE_TIME` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `ZXBJ` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `REMARK` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`VENDER_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of vender
-- ----------------------------
INSERT INTO `vender` VALUES (1, 'sifei114', '2', '死飞骑行股份有限公司', '纽约市坡子街380号', '13215569942', '川普', '19770255322', '00000000123', 30000000.00, 1, '2019-9-5 10:00:00', '0', NULL);
INSERT INTO `vender` VALUES (2, 'zhanlang7', '2', '战狼车桩经营管理有限公司', '加拿大轮子街339号', '12369420125', '安倍晋级', '19323297661', '00003265600', 3611505181.00, 1, '2019-3-6 12：2：3', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
