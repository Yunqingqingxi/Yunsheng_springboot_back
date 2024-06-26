/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80033 (8.0.33)
 Source Host           : localhost:3306
 Source Schema         : score_system

 Target Server Type    : MySQL
 Target Server Version : 80033 (8.0.33)
 File Encoding         : 65001

 Date: 26/06/2024 14:20:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for nine
-- ----------------------------
DROP TABLE IF EXISTS `nine`;
CREATE TABLE `nine`
(
    `id`  int                                                           NOT NULL,
    `ec`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `num` int                                                           NULL DEFAULT NULL,
    `day` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nine
-- ----------------------------
INSERT INTO `nine`
VALUES (-1571737599, '吃饭支出', 3000, '6月');

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score`
(
    `id`      int                                                           NOT NULL,
    `name`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `teacher` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `ascore`  int                                                           NULL DEFAULT NULL,
    `bscore`  int                                                           NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score`
VALUES (1674678273, '张三', '12', 2220333, 0);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`
(
    `id`            int                                                           NOT NULL,
    `student_id`    int                                                           NULL DEFAULT NULL,
    `student_name`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `student_score` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student`
VALUES (-1160769535, 123, '张三', '100');
INSERT INTO `student`
VALUES (-1039028222, 10, '1', '10');
INSERT INTO `student`
VALUES (-875556863, 1, '02', '20');
INSERT INTO `student`
VALUES (1427189762, 2, '2', '2');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`       int                                                           NOT NULL,
    `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user`
VALUES (-2070937599, '265837359', '2658373594');
INSERT INTO `user`
VALUES (-1710100479, '2849153537', '233polaris');
INSERT INTO `user`
VALUES (-1135513599, '6666', '5464654');
INSERT INTO `user`
VALUES (-971919358, '1234567890', '12345678');
INSERT INTO `user`
VALUES (-900648959, '7777777', '7777777');
INSERT INTO `user`
VALUES (-514760703, '12341234', '12341234');
INSERT INTO `user`
VALUES (-447741950, '2658373594', '2658373594');
INSERT INTO `user`
VALUES (-40816639, '77777777', '77777777');
INSERT INTO `user`
VALUES (1, '123456', '123456');
INSERT INTO `user`
VALUES (13742081, '12345678', '12345678');
INSERT INTO `user`
VALUES (38924289, '1422804868', '233polaris');
INSERT INTO `user`
VALUES (332488706, '1231234', '1231234');
INSERT INTO `user`
VALUES (336687106, '14293020', '233ppolaris');
INSERT INTO `user`
VALUES (403812354, '1234567', '1234567');
INSERT INTO `user`
VALUES (487677954, '123123', '1231123');
INSERT INTO `user`
VALUES (592523265, '1512980', '1512980');
INSERT INTO `user`
VALUES (898707458, '15129809112', '15129809112');
INSERT INTO `user`
VALUES (1292988418, '777777', '777777');
INSERT INTO `user`
VALUES (1464954882, '666666', '666666');
INSERT INTO `user`
VALUES (1561407489, '123456789', '123456789');
INSERT INTO `user`
VALUES (1930522626, '147766', '147766');

SET FOREIGN_KEY_CHECKS = 1;
