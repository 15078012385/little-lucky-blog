/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : luckysix

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 19/07/2022 12:42:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_article
-- ----------------------------
DROP TABLE IF EXISTS `tb_article`;
CREATE TABLE `tb_article`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '文章ID',
  `user_id` int NULL DEFAULT NULL COMMENT '发布用户ID',
  `user_nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发布用户昵称',
  `user_avatar` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '发布用户头像',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文章标题',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '文章内容',
  `create_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建时间',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文章描述',
  `first_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '首图',
  `publish` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '发布' COMMENT '发布状态',
  `update_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改时间',
  `views` int(10) UNSIGNED ZEROFILL NULL DEFAULT 0000000000 COMMENT '浏览量',
  `category` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `category`(`category` ASC) USING BTREE,
  CONSTRAINT `tb_article_ibfk_1` FOREIGN KEY (`category`) REFERENCES `tb_category` (`name`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 210 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_article
-- ----------------------------
INSERT INTO `tb_article` VALUES (1, 1, 'Lucky-SIX ', 'https://img2.baidu.com/it/u=1458535318,1641608122&fm=253&fmt=auto&app=138&f=JPEG?w=224&h=224', 'Hello 你好呀！（原创）', '<h1>&nbsp; <font face=\"KaiTi\">大家好，我是Lucky-SIX.</font></h1><blockquote style=\"margin: 0 0 0 40px; border: none; padding: 0px;\"><p><font face=\"KaiTi\">欢迎来到我的个人博客.</font></p></blockquote><p>&nbsp; &nbsp; &nbsp;&nbsp;<img src=\"http://img.baidu.com/hi/jx2/j_0080.gif\"><img src=\"http://img.baidu.com/hi/jx2/j_0080.gif\"><img src=\"http://img.baidu.com/hi/jx2/j_0080.gif\"><img src=\"http://img.baidu.com/hi/jx2/j_0080.gif\"><img src=\"http://img.baidu.com/hi/jx2/j_0080.gif\"><img src=\"http://img.baidu.com/hi/jx2/j_0080.gif\"><img src=\"http://img.baidu.com/hi/jx2/j_0080.gif\"><br></p><p>&nbsp; &nbsp; &nbsp; <i style=\"\"><b style=\"\">&nbsp; <font color=\"#00cec9\">-----------------------------------------------------------------------------------------------------------------</font></b></i></p><blockquote style=\"margin: 0 0 0 40px; border: none; padding: 0px;\"><p>启动博客：<font color=\"#ff0000\"><span style=\"font-family: &quot;JetBrains Mono&quot;, monospace; font-size: 13.5pt; white-space: pre-wrap; font-style: italic;\">SpringApplication</span><span style=\"font-family: &quot;JetBrains Mono&quot;, monospace; font-size: 13.5pt; white-space: pre-wrap;\">.</span><span style=\"font-family: &quot;JetBrains Mono&quot;, monospace; font-size: 13.5pt; white-space: pre-wrap; font-style: italic;\">run</span><span style=\"font-family: &quot;JetBrains Mono&quot;, monospace; font-size: 13.5pt; white-space: pre-wrap;\">(</span><span style=\"font-family: &quot;JetBrains Mono&quot;, monospace; font-size: 13.5pt; white-space: pre-wrap; font-style: italic;\">LittleluckyBlogApplication</span><span style=\"font-family: &quot;JetBrains Mono&quot;, monospace; font-size: 13.5pt; white-space: pre-wrap;\">.</span><span style=\"font-family: &quot;JetBrains Mono&quot;, monospace; font-size: 13.5pt; white-space: pre-wrap;\">class</span><span style=\"font-family: &quot;JetBrains Mono&quot;, monospace; font-size: 13.5pt; white-space: pre-wrap;\">, </span><span style=\"font-family: &quot;JetBrains Mono&quot;, monospace; font-size: 13.5pt; white-space: pre-wrap; font-style: italic;\">args</span><span style=\"font-family: &quot;JetBrains Mono&quot;, monospace; font-size: 13.5pt; white-space: pre-wrap;\">)</span><span style=\"font-family: &quot;JetBrains Mono&quot;, monospace; font-size: 13.5pt; white-space: pre-wrap;\">;</span></font></p></blockquote><pre style=\"background-color:#2d2a2e;color:#fcfcfa;font-family:\'JetBrains Mono\',monospace;font-size:13.5pt;\"><span style=\"color:#ff6188;\">import </span><span style=\"color:#78dce8;font-style:italic;\">org.springframework.boot.SpringApplication</span><span style=\"color:#939293;\">;<br></span><span style=\"color:#ff6188;\">import </span><span style=\"color:#78dce8;font-style:italic;\">org.springframework.boot.autoconfigure.SpringBootApplication</span><span style=\"color:#939293;\">;<br></span><span style=\"color:#939293;\"><br></span><span style=\"color:#939293;\"><br></span><span style=\"color:#78dce8;font-style:italic;\">@SpringBootApplication<br></span><span style=\"color:#ff6188;\">public class </span><span style=\"color:#78dce8;font-style:italic;\">LittleluckyBlogApplication </span><span style=\"color:#ffd700;\">{<br></span><span style=\"color:#ffd700;\"><br></span><span style=\"color:#ffd700;\">    </span><span style=\"color:#ff6188;\">public static void </span><span style=\"color:#a9dc76;\">main</span><span style=\"color:#ffd700;\">(</span><span style=\"color:#78dce8;font-style:italic;\">String</span><span style=\"color:#ffd700;\">[] </span><span style=\"color:#f59762;font-style:italic;\">args</span><span style=\"color:#ffd700;\">) </span><span style=\"color:#87cefa;\">{<br></span><span style=\"color:#87cefa;\">        </span><span style=\"color:#78dce8;font-style:italic;\">SpringApplication</span><span style=\"color:#939293;\">.</span><span style=\"font-style:italic;\">run</span><span style=\"color:#ffd700;\">(</span><span style=\"color:#78dce8;font-style:italic;\">LittleluckyBlogApplication</span><span style=\"color:#939293;\">.</span><span style=\"color:#ff6188;\">class</span><span style=\"color:#939293;\">, </span><span style=\"color:#f59762;font-style:italic;\">args</span><span style=\"color:#ffd700;\">)</span><span style=\"color:#939293;\">;<br></span><span style=\"color:#939293;\">    </span><span style=\"color:#87cefa;\">}<br></span><span style=\"color:#87cefa;\"><br></span><span style=\"color:#ffd700;\">}</span></pre><p><br></p><p><br></p><div><br></div>', '2022-07-13 12:54:20', '知识就是力量。——培根', 'https://www.hualigs.cn/image/62d4eed3bdac9.jpg', '发布', '2022年07月18日 17时13分59秒', 0000000029, 'Java');

-- ----------------------------
-- Table structure for tb_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_category`;
CREATE TABLE `tb_category`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类名',
  `create_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '添加时间',
  `modify_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `name`(`name` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_category
-- ----------------------------
INSERT INTO `tb_category` VALUES (1, 'Java', '2022-07-13 12:52:20', '2022-07-13 12:52:22');
INSERT INTO `tb_category` VALUES (3, 'Go', '1', '2022年07月18日 11时55分57秒');
INSERT INTO `tb_category` VALUES (4, 'python', '1', '2022年07月18日 11时56分00秒');
INSERT INTO `tb_category` VALUES (5, 'mysql', '1', '2022年07月18日 11时56分02秒');

-- ----------------------------
-- Table structure for tb_img
-- ----------------------------
DROP TABLE IF EXISTS `tb_img`;
CREATE TABLE `tb_img`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `img_url` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '图片路径',
  `add_time` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '添加时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_img
-- ----------------------------

-- ----------------------------
-- Table structure for tb_log
-- ----------------------------
DROP TABLE IF EXISTS `tb_log`;
CREATE TABLE `tb_log`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `access_ip` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '访问者ip',
  `access_url` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '访问url',
  `access_method` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '访问的方法',
  `access_args` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '访问参数',
  `access_time` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '访问时间',
  `return_data` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '返回的数据',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2453 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_log
-- ----------------------------

-- ----------------------------
-- Table structure for tb_message
-- ----------------------------
DROP TABLE IF EXISTS `tb_message`;
CREATE TABLE `tb_message`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `access_ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '访问者ip',
  `message_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '留言内容',
  `message_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '留言时间',
  `qq` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '留言QQ',
  `qq_avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'QQ头像url',
  `qq_nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'QQ昵称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 120 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_message
-- ----------------------------
INSERT INTO `tb_message` VALUES (1, '127.0.0.1', '您好呀，Lucky-SIX', '2022年07月18日 12时51分00秒', '321395678', 'https://q2.qlogo.cn/headimg_dl?spec=100&dst_uin=321395678', '丶幸运六');
INSERT INTO `tb_message` VALUES (117, '127.0.0.1', '你好呀', '2022年07月18日 19时51分28秒', '1503371032', 'https://q2.qlogo.cn/headimg_dl?spec=100&dst_uin=1503371032', '游戏人生');
INSERT INTO `tb_message` VALUES (119, '127.0.0.1', '哈哈', '2022年07月19日 12时01分31秒', '123456', 'https://q2.qlogo.cn/headimg_dl?spec=100&dst_uin=123456', '腾讯视频');

-- ----------------------------
-- Table structure for tb_timeline
-- ----------------------------
DROP TABLE IF EXISTS `tb_timeline`;
CREATE TABLE `tb_timeline`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容',
  `create_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '添加时间',
  `nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_timeline
-- ----------------------------
INSERT INTO `tb_timeline` VALUES (25, '需求分析~O(∩_∩)O', '07月10日', 'Lucky-SIX');
INSERT INTO `tb_timeline` VALUES (26, '原型设计~O(∩_∩)O', '07月11日', 'Lucky-SIX');
INSERT INTO `tb_timeline` VALUES (27, '前置准备~O(∩_∩)O', '07月11日', 'Lucky-SIX');
INSERT INTO `tb_timeline` VALUES (28, '环境搭建~O(∩_∩)O', '07月12日', 'Lucky-SIX');
INSERT INTO `tb_timeline` VALUES (29, '开发阶段~O(∩_∩)O', '07月13日', 'Lucky-SIX');
INSERT INTO `tb_timeline` VALUES (30, '测试阶段~O(∩_∩)O', '07月18日', 'Lucky-SIX');
INSERT INTO `tb_timeline` VALUES (31, '完工整理~O(∩_∩)O', '07月19日', 'Lucky-SIX');
INSERT INTO `tb_timeline` VALUES (32, '博客正式上线~O(∩_∩)O', '07月20日', 'Lucky-SIX');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, 'admin', '7607a99c41266678edc24ef432684553', 'Lucky-SIX', 'https://img2.baidu.com/it/u=1458535318,1641608122&fm=253&fmt=auto&app=138&f=JPEG?w=224&h=224');

SET FOREIGN_KEY_CHECKS = 1;
