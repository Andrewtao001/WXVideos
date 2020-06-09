/*
Navicat MySQL Data Transfer

Source Server         : 快速RDS服务器
Source Server Version : 80016
Source Host           : rm-wz9o64z1r8754r972so.mysql.rds.aliyuncs.com:3306
Source Database       : lnsfwx-videos-dev

Target Server Type    : MYSQL
Target Server Version : 80016
File Encoding         : 65001

Date: 2020-05-10 08:07:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `bgm`
-- ----------------------------
DROP TABLE IF EXISTS `bgm`;
CREATE TABLE `bgm` (
  `id` varchar(64) NOT NULL COMMENT '背景音乐表的id',
  `author` varchar(255) NOT NULL COMMENT '配乐的作者',
  `name` varchar(255) NOT NULL COMMENT '配乐名字',
  `path` varchar(255) NOT NULL COMMENT '配乐的路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='背景音乐表';

-- ----------------------------
-- Records of bgm
-- ----------------------------
INSERT INTO `bgm` VALUES ('1', 'July Tun', '清新的小女孩', '/music/girls.mp3');
INSERT INTO `bgm` VALUES ('1805290R3WTDMT9P', '格子兮', '秋殇别恋', '/music/格子兮-秋殇别恋.mp3');
INSERT INTO `bgm` VALUES ('180530DXKK4YYGTC', '李晓杰', '朋友的酒', 'G:\\李晓杰 - 朋友的酒.flac');

-- ----------------------------
-- Table structure for `comments`
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments` (
  `id` varchar(20) NOT NULL COMMENT '用户留言表id',
  `father_comment_id` varchar(20) DEFAULT NULL COMMENT '回复其他用户留言时其他用户留言表的id',
  `to_user_id` varchar(20) DEFAULT NULL COMMENT '留言的用户id',
  `video_id` varchar(20) NOT NULL COMMENT '留言的视频id',
  `from_user_id` varchar(20) NOT NULL COMMENT '回复其他用户留言时其他用户的用户id',
  `comment` text NOT NULL COMMENT '评论内容',
  `create_time` datetime NOT NULL COMMENT '留言日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT=' 用户留言表';

-- ----------------------------
-- Records of comments
-- ----------------------------
INSERT INTO `comments` VALUES ('20051050GDBWM98H', 'undefined', 'undefined', '2005104H1A046894', '20051042XT0F7DKP', '哈哈，这是图书馆吗？', '2020-05-10 07:02:01');
INSERT INTO `comments` VALUES ('20051050HCZYFRAW', 'undefined', 'undefined', '2005104H1A046894', '20051042XT0F7DKP', '啦啦啦啦', '2020-05-10 07:02:07');
INSERT INTO `comments` VALUES ('20051050KBCSYK40', 'undefined', 'undefined', '2005104H1A046894', '20051042XT0F7DKP', '有人吗？', '2020-05-10 07:02:13');
INSERT INTO `comments` VALUES ('20051050MKK717HH', 'undefined', 'undefined', '2005104H1A046894', '20051042XT0F7DKP', '朋友们', '2020-05-10 07:02:21');
INSERT INTO `comments` VALUES ('200510516GDGKRYW', '20051050MKK717HH', '20051042XT0F7DKP', '2005104H1A046894', '20051044PA4PWYRP', '当然有啦', '2020-05-10 07:04:03');
INSERT INTO `comments` VALUES ('200510517BCZ7FK4', '200510516GDGKRYW', '20051044PA4PWYRP', '2005104H1A046894', '20051044PA4PWYRP', '哈哈哈', '2020-05-10 07:04:09');
INSERT INTO `comments` VALUES ('2005105184RSSPPH', '20051050MKK717HH', '20051042XT0F7DKP', '2005104H1A046894', '20051044PA4PWYRP', '啦啦啦', '2020-05-10 07:04:14');
INSERT INTO `comments` VALUES ('20051054XTYP14M8', '2005105184RSSPPH', '20051044PA4PWYRP', '2005104H1A046894', '20051044BPXB96Y8', '有空一起去学习呀', '2020-05-10 07:15:08');
INSERT INTO `comments` VALUES ('200510550F2W5BF8', '20051050KBCSYK40', '20051042XT0F7DKP', '2005104H1A046894', '20051044BPXB96Y8', '当然有呀', '2020-05-10 07:15:25');
INSERT INTO `comments` VALUES ('20051055B5K9HXS8', '200510550F2W5BF8', '20051044BPXB96Y8', '2005104H1A046894', '2005104235ZWBK68', '我现在就在图书馆', '2020-05-10 07:16:34');
INSERT INTO `comments` VALUES ('20051055D407MYK4', '20051050KBCSYK40', '20051042XT0F7DKP', '2005104H1A046894', '2005104235ZWBK68', '当然有人呀', '2020-05-10 07:16:46');

-- ----------------------------
-- Table structure for `identity_users`
-- ----------------------------
DROP TABLE IF EXISTS `identity_users`;
CREATE TABLE `identity_users` (
  `id` varchar(64) NOT NULL COMMENT '用户身份核对表id',
  `user_id` varchar(20) NOT NULL COMMENT '用户id',
  `question1` varchar(64) DEFAULT NULL COMMENT '问题一',
  `question2` varchar(64) DEFAULT NULL COMMENT '问题二',
  `question3` varchar(64) DEFAULT NULL COMMENT '问题三',
  `answer1` varchar(64) DEFAULT NULL COMMENT '答案一',
  `answer2` varchar(64) DEFAULT NULL COMMENT '答案二',
  `answer3` varchar(64) DEFAULT NULL COMMENT '答案三',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户身份核对表';

-- ----------------------------
-- Records of identity_users
-- ----------------------------
INSERT INTO `identity_users` VALUES ('20051042T68H18H0', '2005104235ZWBK68', '你的母亲的姓名', '你的父亲的姓名', '你的哥哥的姓名', '陈会品', '林得法', '陈生');
INSERT INTO `identity_users` VALUES ('20051043B7Z76HDP', '20051042XT0F7DKP', '你的母亲的姓名', '你的父亲的姓名', '你的哥哥的姓名', '陈会品', '张佳丽', '陈生3');
INSERT INTO `identity_users` VALUES ('20051044M854H6FW', '20051044BPXB96Y8', '最难忘的节日', '纪念日', 'abc后面', '中秋节', '19980612', '123');
INSERT INTO `identity_users` VALUES ('200510450NXB75D4', '20051044PA4PWYRP', '最难忘的节日', '纪念日', '生日', 'duanwu', '199305', '19980612');
INSERT INTO `identity_users` VALUES ('2005104598CFC9D4', '2005104523R2P4X4', '父亲的生日', '母亲的生日', '我的生日', '0612', '0312', '1211');
INSERT INTO `identity_users` VALUES ('20051045KZ8H4TTC', '20051045C117DYW0', '父亲的生日', '母亲的生日', '我的生日', '0512', '19980612', '0617');
INSERT INTO `identity_users` VALUES ('200510465WGNN3TC', '2005104617R1XRYW', '父亲生日', '母亲生日', '我的生日', '0312', '0518', '0116');
INSERT INTO `identity_users` VALUES ('20051046AMFA939P', '200510467C737R40', '中秋节', '母亲的生日', '我的生日', '中秋节', '1106', '0228');
INSERT INTO `identity_users` VALUES ('20051046HW55DK1P', '20051046CN5WNXP0', '春节', '母亲节', '父亲节', 'cun', 'mqj', 'fqj');
INSERT INTO `identity_users` VALUES ('20051046TNTM24PH', '20051046NRSGWXS8', '32182', '19980612', '321', '321885', '19980612', '123');
INSERT INTO `identity_users` VALUES ('20051049H7289WX4', '20051049CGBZC940', '3211', '2864', '吴丹', '3211', '4639', 'shida');
INSERT INTO `identity_users` VALUES ('20051049ZAYTHK8H', '20051049S7BDN5S8', '3218', '6435', '8964', '884946', '6435', '8964');
INSERT INTO `identity_users` VALUES ('2005104A6S9S6WM8', '2005104A2DTMBDYW', '3212', '8842', '我的名字', 'ew', '321', 'Andrew');

-- ----------------------------
-- Table structure for `punish_users`
-- ----------------------------
DROP TABLE IF EXISTS `punish_users`;
CREATE TABLE `punish_users` (
  `id` varchar(64) NOT NULL COMMENT '用户封禁表id',
  `user_id` varchar(64) NOT NULL COMMENT '用户id',
  `violation` int(4) DEFAULT NULL COMMENT '封禁天数',
  `start_time` datetime DEFAULT NULL COMMENT '封禁开始时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户封禁表';

-- ----------------------------
-- Records of punish_users
-- ----------------------------

-- ----------------------------
-- Table structure for `qrtz_blob_triggers`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_blob_triggers`;
CREATE TABLE `qrtz_blob_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `BLOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `SCHED_NAME` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_blob_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for `qrtz_calendars`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_calendars`;
CREATE TABLE `qrtz_calendars` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `CALENDAR_NAME` varchar(200) NOT NULL,
  `CALENDAR` blob NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`CALENDAR_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_calendars
-- ----------------------------

-- ----------------------------
-- Table structure for `qrtz_cron_triggers`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_cron_triggers`;
CREATE TABLE `qrtz_cron_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `CRON_EXPRESSION` varchar(120) NOT NULL,
  `TIME_ZONE_ID` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_cron_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_cron_triggers
-- ----------------------------
INSERT INTO `qrtz_cron_triggers` VALUES ('RenrenScheduler', 'TASK_1', 'DEFAULT', '0 0/30 * * * ?', 'Asia/Shanghai');

-- ----------------------------
-- Table structure for `qrtz_fired_triggers`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_fired_triggers`;
CREATE TABLE `qrtz_fired_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `ENTRY_ID` varchar(95) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `FIRED_TIME` bigint(13) NOT NULL,
  `SCHED_TIME` bigint(13) NOT NULL,
  `PRIORITY` int(11) NOT NULL,
  `STATE` varchar(16) NOT NULL,
  `JOB_NAME` varchar(200) DEFAULT NULL,
  `JOB_GROUP` varchar(200) DEFAULT NULL,
  `IS_NONCONCURRENT` varchar(1) DEFAULT NULL,
  `REQUESTS_RECOVERY` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`ENTRY_ID`),
  KEY `IDX_QRTZ_FT_TRIG_INST_NAME` (`SCHED_NAME`,`INSTANCE_NAME`),
  KEY `IDX_QRTZ_FT_INST_JOB_REQ_RCVRY` (`SCHED_NAME`,`INSTANCE_NAME`,`REQUESTS_RECOVERY`),
  KEY `IDX_QRTZ_FT_J_G` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_FT_JG` (`SCHED_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_FT_T_G` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_FT_TG` (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_fired_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for `qrtz_job_details`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_job_details`;
CREATE TABLE `qrtz_job_details` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `JOB_CLASS_NAME` varchar(250) NOT NULL,
  `IS_DURABLE` varchar(1) NOT NULL,
  `IS_NONCONCURRENT` varchar(1) NOT NULL,
  `IS_UPDATE_DATA` varchar(1) NOT NULL,
  `REQUESTS_RECOVERY` varchar(1) NOT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_J_REQ_RECOVERY` (`SCHED_NAME`,`REQUESTS_RECOVERY`),
  KEY `IDX_QRTZ_J_GRP` (`SCHED_NAME`,`JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_job_details
-- ----------------------------
INSERT INTO `qrtz_job_details` VALUES ('RenrenScheduler', 'TASK_1', 'DEFAULT', null, 'io.renren.modules.job.utils.ScheduleJob', '0', '0', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000D4A4F425F504152414D5F4B45597372002E696F2E72656E72656E2E6D6F64756C65732E6A6F622E656E746974792E5363686564756C654A6F62456E7469747900000000000000010200074C00086265616E4E616D657400124C6A6176612F6C616E672F537472696E673B4C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C000E63726F6E45787072657373696F6E71007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C0006706172616D7371007E00094C000672656D61726B71007E00094C00067374617475737400134C6A6176612F6C616E672F496E74656765723B7870740008746573745461736B7372000E6A6176612E7574696C2E44617465686A81014B5974190300007870770800000171FE91B4707874000E3020302F3330202A202A202A203F7372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B0200007870000000000000000174000672656E72656E74000CE58F82E695B0E6B58BE8AF95737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C75657871007E0013000000007800);

-- ----------------------------
-- Table structure for `qrtz_locks`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_locks`;
CREATE TABLE `qrtz_locks` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `LOCK_NAME` varchar(40) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`LOCK_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_locks
-- ----------------------------
INSERT INTO `qrtz_locks` VALUES ('RenrenScheduler', 'STATE_ACCESS');
INSERT INTO `qrtz_locks` VALUES ('RenrenScheduler', 'TRIGGER_ACCESS');

-- ----------------------------
-- Table structure for `qrtz_paused_trigger_grps`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;
CREATE TABLE `qrtz_paused_trigger_grps` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_paused_trigger_grps
-- ----------------------------

-- ----------------------------
-- Table structure for `qrtz_scheduler_state`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_scheduler_state`;
CREATE TABLE `qrtz_scheduler_state` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `LAST_CHECKIN_TIME` bigint(13) NOT NULL,
  `CHECKIN_INTERVAL` bigint(13) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`INSTANCE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_scheduler_state
-- ----------------------------
INSERT INTO `qrtz_scheduler_state` VALUES ('RenrenScheduler', 'Andrewtao-Laptop1589067114848', '1589069235435', '15000');
INSERT INTO `qrtz_scheduler_state` VALUES ('RenrenScheduler', 'iZnpz79y3w3d2jZ1589029602141', '1589069223661', '15000');

-- ----------------------------
-- Table structure for `qrtz_simple_triggers`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simple_triggers`;
CREATE TABLE `qrtz_simple_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `REPEAT_COUNT` bigint(7) NOT NULL,
  `REPEAT_INTERVAL` bigint(12) NOT NULL,
  `TIMES_TRIGGERED` bigint(10) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_simple_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_simple_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for `qrtz_simprop_triggers`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simprop_triggers`;
CREATE TABLE `qrtz_simprop_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `STR_PROP_1` varchar(512) DEFAULT NULL,
  `STR_PROP_2` varchar(512) DEFAULT NULL,
  `STR_PROP_3` varchar(512) DEFAULT NULL,
  `INT_PROP_1` int(11) DEFAULT NULL,
  `INT_PROP_2` int(11) DEFAULT NULL,
  `LONG_PROP_1` bigint(20) DEFAULT NULL,
  `LONG_PROP_2` bigint(20) DEFAULT NULL,
  `DEC_PROP_1` decimal(13,4) DEFAULT NULL,
  `DEC_PROP_2` decimal(13,4) DEFAULT NULL,
  `BOOL_PROP_1` varchar(1) DEFAULT NULL,
  `BOOL_PROP_2` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_simprop_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_simprop_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for `qrtz_triggers`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_triggers`;
CREATE TABLE `qrtz_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `NEXT_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PREV_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PRIORITY` int(11) DEFAULT NULL,
  `TRIGGER_STATE` varchar(16) NOT NULL,
  `TRIGGER_TYPE` varchar(8) NOT NULL,
  `START_TIME` bigint(13) NOT NULL,
  `END_TIME` bigint(13) DEFAULT NULL,
  `CALENDAR_NAME` varchar(200) DEFAULT NULL,
  `MISFIRE_INSTR` smallint(2) DEFAULT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_T_J` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_T_JG` (`SCHED_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_T_C` (`SCHED_NAME`,`CALENDAR_NAME`),
  KEY `IDX_QRTZ_T_G` (`SCHED_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_T_STATE` (`SCHED_NAME`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_N_STATE` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_N_G_STATE` (`SCHED_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_NEXT_FIRE_TIME` (`SCHED_NAME`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_ST` (`SCHED_NAME`,`TRIGGER_STATE`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_ST_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_NFT_ST_MISFIRE_GRP` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  CONSTRAINT `qrtz_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) REFERENCES `qrtz_job_details` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_triggers
-- ----------------------------
INSERT INTO `qrtz_triggers` VALUES ('RenrenScheduler', 'TASK_1', 'DEFAULT', 'TASK_1', 'DEFAULT', null, '1589070600000', '1589068800000', '5', 'WAITING', 'CRON', '1589067115000', '0', null, '2', '');

-- ----------------------------
-- Table structure for `schedule_job`
-- ----------------------------
DROP TABLE IF EXISTS `schedule_job`;
CREATE TABLE `schedule_job` (
  `job_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务id',
  `bean_name` varchar(200) DEFAULT NULL COMMENT 'spring bean名称',
  `params` varchar(2000) DEFAULT NULL COMMENT '参数',
  `cron_expression` varchar(100) DEFAULT NULL COMMENT 'cron表达式',
  `status` tinyint(4) DEFAULT NULL COMMENT '任务状态  0：正常  1：暂停',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`job_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='定时任务';

-- ----------------------------
-- Records of schedule_job
-- ----------------------------
INSERT INTO `schedule_job` VALUES ('1', 'testTask', 'renren', '0 0/30 * * * ?', '0', '参数测试', '2020-05-10 07:31:34');

-- ----------------------------
-- Table structure for `schedule_job_log`
-- ----------------------------
DROP TABLE IF EXISTS `schedule_job_log`;
CREATE TABLE `schedule_job_log` (
  `log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务日志id',
  `job_id` bigint(20) NOT NULL COMMENT '任务id',
  `bean_name` varchar(200) DEFAULT NULL COMMENT 'spring bean名称',
  `params` varchar(2000) DEFAULT NULL COMMENT '参数',
  `status` tinyint(4) NOT NULL COMMENT '任务状态    0：成功    1：失败',
  `error` varchar(2000) DEFAULT NULL COMMENT '失败信息',
  `times` int(11) NOT NULL COMMENT '耗时(单位：毫秒)',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`log_id`),
  KEY `job_id` (`job_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='定时任务日志';

-- ----------------------------
-- Records of schedule_job_log
-- ----------------------------
INSERT INTO `schedule_job_log` VALUES ('1', '1', 'testTask', 'renren', '0', null, '1', '2020-05-09 19:00:00');

-- ----------------------------
-- Table structure for `search_records`
-- ----------------------------
DROP TABLE IF EXISTS `search_records`;
CREATE TABLE `search_records` (
  `id` varchar(64) NOT NULL COMMENT '热搜表的id',
  `content` varchar(255) NOT NULL COMMENT '热搜的内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='热搜表';

-- ----------------------------
-- Records of search_records
-- ----------------------------
INSERT INTO `search_records` VALUES ('20051053PW6HP6W0', '毕业');
INSERT INTO `search_records` VALUES ('20051053SC7FCDAW', '毕业');
INSERT INTO `search_records` VALUES ('20051053WGF8SAY8', '哈哈哈');
INSERT INTO `search_records` VALUES ('20051054GW30D5KP', '风景');
INSERT INTO `search_records` VALUES ('20051054T55R186W', '图书');
INSERT INTO `search_records` VALUES ('200510559G7P4ARP', '图书馆');

-- ----------------------------
-- Table structure for `sys_captcha`
-- ----------------------------
DROP TABLE IF EXISTS `sys_captcha`;
CREATE TABLE `sys_captcha` (
  `uuid` char(36) NOT NULL COMMENT 'uuid',
  `code` varchar(6) NOT NULL COMMENT '验证码',
  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统验证码';

-- ----------------------------
-- Records of sys_captcha
-- ----------------------------
INSERT INTO `sys_captcha` VALUES ('8fc81b24-8625-4666-85b4-5139a2a2a7e8', 'n2y5e', '2020-05-09 18:39:31');
INSERT INTO `sys_captcha` VALUES ('9a9ed3fb-5400-457c-8d30-66006fda3121', 'ebcpg', '2020-05-09 19:11:10');
INSERT INTO `sys_captcha` VALUES ('b7aef4d4-db9a-456f-8e12-7aa5de39a211', 'dmnmp', '2020-05-09 18:57:35');

-- ----------------------------
-- Table structure for `sys_config`
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `param_key` varchar(50) DEFAULT NULL COMMENT 'key',
  `param_value` varchar(2000) DEFAULT NULL COMMENT 'value',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态   0：隐藏   1：显示',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `param_key` (`param_key`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统配置信息表';

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES ('1', 'CLOUD_STORAGE_CONFIG_KEY', '{\"aliyunAccessKeyId\":\"\",\"aliyunAccessKeySecret\":\"\",\"aliyunBucketName\":\"\",\"aliyunDomain\":\"\",\"aliyunEndPoint\":\"\",\"aliyunPrefix\":\"\",\"qcloudBucketName\":\"\",\"qcloudDomain\":\"\",\"qcloudPrefix\":\"\",\"qcloudSecretId\":\"\",\"qcloudSecretKey\":\"\",\"qiniuAccessKey\":\"NrgMfABZxWLo5B-YYSjoE8-AZ1EISdi1Z3ubLOeZ\",\"qiniuBucketName\":\"ios-app\",\"qiniuDomain\":\"http://7xqbwh.dl1.z0.glb.clouddn.com\",\"qiniuPrefix\":\"upload\",\"qiniuSecretKey\":\"uIwJHevMRWU0VLxFvgy0tAcOdGqasdtVlJkdy6vV\",\"type\":1}', '0', '云存储配置信息');

-- ----------------------------
-- Table structure for `sys_log`
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) DEFAULT NULL COMMENT '用户操作',
  `method` varchar(200) DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) DEFAULT NULL COMMENT '请求参数',
  `time` bigint(20) NOT NULL COMMENT '执行时长(毫秒)',
  `ip` varchar(64) DEFAULT NULL COMMENT 'IP地址',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统日志';

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('1', 'admin', '保存用户', 'io.renren.modules.sys.controller.SysUserController.save()', '[{\"userId\":2,\"username\":\"andrewtao\",\"password\":\"0f4ac5ed8fd7f1b7d5dd4e285a444913ffac6b12322da2024c84decb8ce862d9\",\"salt\":\"7WqvUTHSGj2QJUdaJjzX\",\"email\":\"1044973286@qq.com\",\"mobile\":\"15767625900\",\"status\":1,\"roleIdList\":[],\"createUserId\":1,\"createTime\":\"May 10, 2020 7:42:18 AM\"}]', '254', '0:0:0:0:0:0:0:1', '2020-05-09 18:42:18');
INSERT INTO `sys_log` VALUES ('2', 'admin', '保存角色', 'io.renren.modules.sys.controller.SysRoleController.save()', '[{\"roleId\":1,\"roleName\":\"一级管理员拥有所有的权限\",\"remark\":\"一级管理员拥有所有的权限\",\"createUserId\":1,\"menuIdList\":[1,2,15,16,17,18,3,19,20,21,22,4,23,24,25,26,5,6,7,8,9,10,11,12,13,14,27,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,-666666],\"createTime\":\"May 10, 2020 7:42:42 AM\"}]', '1793', '0:0:0:0:0:0:0:1', '2020-05-09 18:42:44');
INSERT INTO `sys_log` VALUES ('3', 'admin', '保存角色', 'io.renren.modules.sys.controller.SysRoleController.save()', '[{\"roleId\":2,\"roleName\":\"拥有用户留言管理权限的二级管理员\",\"remark\":\"拥有用户留言管理权限的二级管理员\",\"createUserId\":1,\"menuIdList\":[36,37,38,39,40,-666666,1],\"createTime\":\"May 10, 2020 7:43:37 AM\"}]', '219', '0:0:0:0:0:0:0:1', '2020-05-09 18:43:38');
INSERT INTO `sys_log` VALUES ('4', 'admin', '保存角色', 'io.renren.modules.sys.controller.SysRoleController.save()', '[{\"roleId\":3,\"roleName\":\"拥有上传bgm权限的二级管理员\",\"remark\":\"拥有上传bgm权限的二级管理员\",\"createUserId\":1,\"menuIdList\":[31,32,33,34,35,-666666,1],\"createTime\":\"May 10, 2020 7:44:54 AM\"}]', '220', '0:0:0:0:0:0:0:1', '2020-05-09 18:44:55');
INSERT INTO `sys_log` VALUES ('5', 'admin', '保存角色', 'io.renren.modules.sys.controller.SysRoleController.save()', '[{\"roleId\":4,\"roleName\":\"拥有视频封禁权限的二级管理员\",\"remark\":\"拥有视频封禁权限的二级管理员\",\"createUserId\":1,\"menuIdList\":[46,47,48,49,50,71,72,73,74,75,76,77,78,79,80,-666666,1],\"createTime\":\"May 10, 2020 7:46:04 AM\"}]', '442', '0:0:0:0:0:0:0:1', '2020-05-09 18:46:04');
INSERT INTO `sys_log` VALUES ('6', 'admin', '保存用户', 'io.renren.modules.sys.controller.SysUserController.save()', '[{\"userId\":3,\"username\":\"gliytaoya\",\"password\":\"0df41b3d12427caa7adcd16c48bcc1b2e9729574392c716177b9fd07f1d6a214\",\"salt\":\"1OOAEnBXuhsPs8WrRlBX\",\"email\":\"1044973286@qq.com\",\"mobile\":\"15767625900\",\"status\":1,\"roleIdList\":[1],\"createUserId\":1,\"createTime\":\"May 10, 2020 7:47:29 AM\"}]', '97', '0:0:0:0:0:0:0:1', '2020-05-09 18:47:29');
INSERT INTO `sys_log` VALUES ('7', 'admin', '修改用户', 'io.renren.modules.sys.controller.SysUserController.update()', '[{\"userId\":2,\"username\":\"andrewtao\",\"password\":\"a48482c1f3349ba4b7273c96a4378d8cc64ba748dd9c35c6b47d9a94933d5e8f\",\"salt\":\"7WqvUTHSGj2QJUdaJjzX\",\"email\":\"1044973286@qq.com\",\"mobile\":\"15767625900\",\"status\":1,\"roleIdList\":[],\"createUserId\":1}]', '79', '0:0:0:0:0:0:0:1', '2020-05-09 18:48:11');
INSERT INTO `sys_log` VALUES ('8', 'admin', '保存用户', 'io.renren.modules.sys.controller.SysUserController.save()', '[{\"userId\":4,\"username\":\"lalal111\",\"password\":\"2ccfced6333f8ebf79495fc1cf3ee28834df8043bbedd3987b3b88389c1cbe93\",\"salt\":\"dzuE8c6RZRh1acQOIpXY\",\"email\":\"1044973286@qq.com\",\"mobile\":\"13640495710\",\"status\":1,\"roleIdList\":[2],\"createUserId\":1,\"createTime\":\"May 10, 2020 7:49:08 AM\"}]', '97', '0:0:0:0:0:0:0:1', '2020-05-09 18:49:08');
INSERT INTO `sys_log` VALUES ('9', 'admin', '修改用户', 'io.renren.modules.sys.controller.SysUserController.update()', '[{\"userId\":4,\"username\":\"lalal111\",\"password\":\"2ccfced6333f8ebf79495fc1cf3ee28834df8043bbedd3987b3b88389c1cbe93\",\"salt\":\"dzuE8c6RZRh1acQOIpXY\",\"email\":\"1044973286@qq.com\",\"mobile\":\"13640495710\",\"status\":1,\"roleIdList\":[2],\"createUserId\":1}]', '96', '0:0:0:0:0:0:0:1', '2020-05-09 18:49:34');
INSERT INTO `sys_log` VALUES ('10', 'admin', '保存用户', 'io.renren.modules.sys.controller.SysUserController.save()', '[{\"userId\":5,\"username\":\"kaya7772\",\"password\":\"c32cc6803ce51eaa73c4258ed27a0ffab00365af6492aa32b94f99189576661a\",\"salt\":\"xxYH442VonYPraBi5KOm\",\"email\":\"13640495710@qq.com\",\"mobile\":\"15768268900\",\"status\":1,\"roleIdList\":[4],\"createUserId\":1,\"createTime\":\"May 10, 2020 7:50:50 AM\"}]', '96', '0:0:0:0:0:0:0:1', '2020-05-09 18:50:51');
INSERT INTO `sys_log` VALUES ('11', 'admin', '保存用户', 'io.renren.modules.sys.controller.SysUserController.save()', '[{\"userId\":6,\"username\":\"ss1111\",\"password\":\"3df74da7dd44d070b7943c74c4e933c65dab6b19e596e0b420974441b4c59482\",\"salt\":\"qJ8w3OTHNKwlBNJJnXvz\",\"email\":\"15767625@qq.com\",\"mobile\":\"15816094062\",\"status\":0,\"roleIdList\":[4],\"createUserId\":1,\"createTime\":\"May 10, 2020 7:51:13 AM\"}]', '100', '0:0:0:0:0:0:0:1', '2020-05-09 18:51:14');
INSERT INTO `sys_log` VALUES ('12', 'admin', '修改用户', 'io.renren.modules.sys.controller.SysUserController.update()', '[{\"userId\":6,\"username\":\"ss1111\",\"password\":\"3df74da7dd44d070b7943c74c4e933c65dab6b19e596e0b420974441b4c59482\",\"salt\":\"qJ8w3OTHNKwlBNJJnXvz\",\"email\":\"15767625@qq.com\",\"mobile\":\"15816094062\",\"status\":0,\"roleIdList\":[4],\"createUserId\":1}]', '104', '0:0:0:0:0:0:0:1', '2020-05-09 18:51:25');
INSERT INTO `sys_log` VALUES ('13', 'admin', '修改角色', 'io.renren.modules.sys.controller.SysRoleController.update()', '[{\"roleId\":3,\"roleName\":\"拥有上传bgm权限的二级管理员\",\"remark\":\"拥有上传bgm权限的二级管理员\",\"createUserId\":1,\"menuIdList\":[4,23,24,25,26,5,6,7,8,9,10,11,12,13,14,27,29,31,32,33,34,35,-666666,1]}]', '503', '0:0:0:0:0:0:0:1', '2020-05-09 18:53:46');
INSERT INTO `sys_log` VALUES ('14', 'admin', '修改角色', 'io.renren.modules.sys.controller.SysRoleController.update()', '[{\"roleId\":3,\"roleName\":\"拥有上传bgm权限的二级管理员\",\"remark\":\"拥有上传bgm权限的二级管理员\",\"createUserId\":1,\"menuIdList\":[2,15,16,17,18,3,19,20,21,22,4,23,24,25,26,5,6,7,8,9,10,11,12,13,14,27,29,30,31,32,33,34,35,-666666,1]}]', '806', '0:0:0:0:0:0:0:1', '2020-05-09 18:54:34');
INSERT INTO `sys_log` VALUES ('15', 'admin', '保存菜单', 'io.renren.modules.sys.controller.SysMenuController.save()', '[{\"menuId\":81,\"parentId\":0,\"name\":\"二级管理员使用\",\"url\":\"\",\"perms\":\"\",\"type\":0,\"icon\":\"suoding\",\"orderNum\":0}]', '36', '0:0:0:0:0:0:0:1', '2020-05-09 18:57:08');
INSERT INTO `sys_log` VALUES ('16', 'admin', '修改用户', 'io.renren.modules.sys.controller.SysUserController.update()', '[{\"userId\":2,\"username\":\"andrewtao\",\"password\":\"a48482c1f3349ba4b7273c96a4378d8cc64ba748dd9c35c6b47d9a94933d5e8f\",\"salt\":\"7WqvUTHSGj2QJUdaJjzX\",\"email\":\"1044973286@qq.com\",\"mobile\":\"15767625900\",\"status\":1,\"roleIdList\":[3],\"createUserId\":1}]', '109', '0:0:0:0:0:0:0:1', '2020-05-09 18:59:44');
INSERT INTO `sys_log` VALUES ('17', 'admin', '修改角色', 'io.renren.modules.sys.controller.SysRoleController.update()', '[{\"roleId\":3,\"roleName\":\"拥有上传bgm权限的二级管理员\",\"remark\":\"拥有上传bgm权限的二级管理员\",\"createUserId\":1,\"menuIdList\":[31,32,33,34,35,-666666,1]}]', '320', '0:0:0:0:0:0:0:1', '2020-05-09 19:02:46');
INSERT INTO `sys_log` VALUES ('18', 'admin', '删除菜单', 'io.renren.modules.sys.controller.SysMenuController.delete()', '[81]', '108', '0:0:0:0:0:0:0:1', '2020-05-09 19:02:54');

-- ----------------------------
-- Table structure for `sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(11) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='菜单管理';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '0', '系统管理', null, null, '0', 'system', '0');
INSERT INTO `sys_menu` VALUES ('2', '1', '管理员列表', 'sys/user', null, '1', 'admin', '1');
INSERT INTO `sys_menu` VALUES ('3', '1', '角色管理', 'sys/role', null, '1', 'role', '2');
INSERT INTO `sys_menu` VALUES ('4', '1', '菜单管理', 'sys/menu', null, '1', 'menu', '3');
INSERT INTO `sys_menu` VALUES ('5', '1', 'SQL监控', 'http://localhost:8080/renren-fast/druid/sql.html', null, '1', 'sql', '4');
INSERT INTO `sys_menu` VALUES ('6', '1', '定时任务', 'job/schedule', null, '1', 'job', '5');
INSERT INTO `sys_menu` VALUES ('7', '6', '查看', null, 'sys:schedule:list,sys:schedule:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('8', '6', '新增', null, 'sys:schedule:save', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('9', '6', '修改', null, 'sys:schedule:update', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('10', '6', '删除', null, 'sys:schedule:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('11', '6', '暂停', null, 'sys:schedule:pause', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('12', '6', '恢复', null, 'sys:schedule:resume', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('13', '6', '立即执行', null, 'sys:schedule:run', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('14', '6', '日志列表', null, 'sys:schedule:log', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('15', '2', '查看', null, 'sys:user:list,sys:user:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('16', '2', '新增', null, 'sys:user:save,sys:role:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('17', '2', '修改', null, 'sys:user:update,sys:role:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('18', '2', '删除', null, 'sys:user:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('19', '3', '查看', null, 'sys:role:list,sys:role:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('20', '3', '新增', null, 'sys:role:save,sys:menu:list', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('21', '3', '修改', null, 'sys:role:update,sys:menu:list', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('22', '3', '删除', null, 'sys:role:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('23', '4', '查看', null, 'sys:menu:list,sys:menu:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('24', '4', '新增', null, 'sys:menu:save,sys:menu:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('25', '4', '修改', null, 'sys:menu:update,sys:menu:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('26', '4', '删除', null, 'sys:menu:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('27', '1', '参数管理', 'sys/config', 'sys:config:list,sys:config:info,sys:config:save,sys:config:update,sys:config:delete', '1', 'config', '6');
INSERT INTO `sys_menu` VALUES ('29', '1', '系统日志', 'sys/log', 'sys:log:list', '1', 'log', '7');
INSERT INTO `sys_menu` VALUES ('30', '1', '文件上传', 'oss/oss', 'sys:oss:all', '1', 'oss', '6');
INSERT INTO `sys_menu` VALUES ('31', '1', '背景音乐表', 'generator/bgm', null, '1', 'config', '6');
INSERT INTO `sys_menu` VALUES ('32', '31', '查看', null, 'generator:bgm:list,generator:bgm:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('33', '31', '新增', null, 'generator:bgm:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('34', '31', '修改', null, 'generator:bgm:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('35', '31', '删除', null, 'generator:bgm:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('36', '1', ' 用户留言表', 'generator/comments', null, '1', 'config', '6');
INSERT INTO `sys_menu` VALUES ('37', '36', '查看', null, 'generator:comments:list,generator:comments:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('38', '36', '新增', null, 'generator:comments:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('39', '36', '修改', null, 'generator:comments:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('40', '36', '删除', null, 'generator:comments:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('41', '1', '用户身份核对表', 'generator/identityusers', null, '1', 'config', '6');
INSERT INTO `sys_menu` VALUES ('42', '41', '查看', null, 'generator:identityusers:list,generator:identityusers:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('43', '41', '新增', null, 'generator:identityusers:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('44', '41', '修改', null, 'generator:identityusers:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('45', '41', '删除', null, 'generator:identityusers:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('46', '1', '用户封禁表', 'generator/punishusers', null, '1', 'config', '6');
INSERT INTO `sys_menu` VALUES ('47', '46', '查看', null, 'generator:punishusers:list,generator:punishusers:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('48', '46', '新增', null, 'generator:punishusers:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('49', '46', '修改', null, 'generator:punishusers:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('50', '46', '删除', null, 'generator:punishusers:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('51', '1', '热搜表', 'generator/searchrecords', null, '1', 'config', '6');
INSERT INTO `sys_menu` VALUES ('52', '51', '查看', null, 'generator:searchrecords:list,generator:searchrecords:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('53', '51', '新增', null, 'generator:searchrecords:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('54', '51', '修改', null, 'generator:searchrecords:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('55', '51', '删除', null, 'generator:searchrecords:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('56', '1', '用户表\r\n', 'generator/users', null, '1', 'config', '6');
INSERT INTO `sys_menu` VALUES ('57', '56', '查看', null, 'generator:users:list,generator:users:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('58', '56', '新增', null, 'generator:users:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('59', '56', '修改', null, 'generator:users:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('60', '56', '删除', null, 'generator:users:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('61', '1', '用户粉丝表', 'generator/usersfans', null, '1', 'config', '6');
INSERT INTO `sys_menu` VALUES ('62', '61', '查看', null, 'generator:usersfans:list,generator:usersfans:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('63', '61', '新增', null, 'generator:usersfans:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('64', '61', '修改', null, 'generator:usersfans:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('65', '61', '删除', null, 'generator:usersfans:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('66', '1', '用户视频关联表', 'generator/userslikevideos', null, '1', 'config', '6');
INSERT INTO `sys_menu` VALUES ('67', '66', '查看', null, 'generator:userslikevideos:list,generator:userslikevideos:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('68', '66', '新增', null, 'generator:userslikevideos:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('69', '66', '修改', null, 'generator:userslikevideos:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('70', '66', '删除', null, 'generator:userslikevideos:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('71', '1', '用户举报表', 'generator/usersreport', null, '1', 'config', '6');
INSERT INTO `sys_menu` VALUES ('72', '71', '查看', null, 'generator:usersreport:list,generator:usersreport:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('73', '71', '新增', null, 'generator:usersreport:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('74', '71', '修改', null, 'generator:usersreport:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('75', '71', '删除', null, 'generator:usersreport:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('76', '1', '视频表', 'generator/videos', null, '1', 'config', '6');
INSERT INTO `sys_menu` VALUES ('77', '76', '查看', null, 'generator:videos:list,generator:videos:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('78', '76', '新增', null, 'generator:videos:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('79', '76', '修改', null, 'generator:videos:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('80', '76', '删除', null, 'generator:videos:delete', '2', null, '6');

-- ----------------------------
-- Table structure for `sys_oss`
-- ----------------------------
DROP TABLE IF EXISTS `sys_oss`;
CREATE TABLE `sys_oss` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(200) DEFAULT NULL COMMENT 'URL地址',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='文件上传';

-- ----------------------------
-- Records of sys_oss
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '一级管理员拥有所有的权限', '一级管理员拥有所有的权限', '1', '2020-05-09 18:42:43');
INSERT INTO `sys_role` VALUES ('2', '拥有用户留言管理权限的二级管理员', '拥有用户留言管理权限的二级管理员', '1', '2020-05-09 18:43:38');
INSERT INTO `sys_role` VALUES ('3', '拥有上传bgm权限的二级管理员', '拥有上传bgm权限的二级管理员', '1', '2020-05-09 18:44:55');
INSERT INTO `sys_role` VALUES ('4', '拥有视频封禁权限的二级管理员', '拥有视频封禁权限的二级管理员', '1', '2020-05-09 18:46:04');

-- ----------------------------
-- Table structure for `sys_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=178 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色与菜单对应关系';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('1', '1', '1');
INSERT INTO `sys_role_menu` VALUES ('2', '1', '2');
INSERT INTO `sys_role_menu` VALUES ('3', '1', '15');
INSERT INTO `sys_role_menu` VALUES ('4', '1', '16');
INSERT INTO `sys_role_menu` VALUES ('5', '1', '17');
INSERT INTO `sys_role_menu` VALUES ('6', '1', '18');
INSERT INTO `sys_role_menu` VALUES ('7', '1', '3');
INSERT INTO `sys_role_menu` VALUES ('8', '1', '19');
INSERT INTO `sys_role_menu` VALUES ('9', '1', '20');
INSERT INTO `sys_role_menu` VALUES ('10', '1', '21');
INSERT INTO `sys_role_menu` VALUES ('11', '1', '22');
INSERT INTO `sys_role_menu` VALUES ('12', '1', '4');
INSERT INTO `sys_role_menu` VALUES ('13', '1', '23');
INSERT INTO `sys_role_menu` VALUES ('14', '1', '24');
INSERT INTO `sys_role_menu` VALUES ('15', '1', '25');
INSERT INTO `sys_role_menu` VALUES ('16', '1', '26');
INSERT INTO `sys_role_menu` VALUES ('17', '1', '5');
INSERT INTO `sys_role_menu` VALUES ('18', '1', '6');
INSERT INTO `sys_role_menu` VALUES ('19', '1', '7');
INSERT INTO `sys_role_menu` VALUES ('20', '1', '8');
INSERT INTO `sys_role_menu` VALUES ('21', '1', '9');
INSERT INTO `sys_role_menu` VALUES ('22', '1', '10');
INSERT INTO `sys_role_menu` VALUES ('23', '1', '11');
INSERT INTO `sys_role_menu` VALUES ('24', '1', '12');
INSERT INTO `sys_role_menu` VALUES ('25', '1', '13');
INSERT INTO `sys_role_menu` VALUES ('26', '1', '14');
INSERT INTO `sys_role_menu` VALUES ('27', '1', '27');
INSERT INTO `sys_role_menu` VALUES ('28', '1', '29');
INSERT INTO `sys_role_menu` VALUES ('29', '1', '30');
INSERT INTO `sys_role_menu` VALUES ('30', '1', '31');
INSERT INTO `sys_role_menu` VALUES ('31', '1', '32');
INSERT INTO `sys_role_menu` VALUES ('32', '1', '33');
INSERT INTO `sys_role_menu` VALUES ('33', '1', '34');
INSERT INTO `sys_role_menu` VALUES ('34', '1', '35');
INSERT INTO `sys_role_menu` VALUES ('35', '1', '36');
INSERT INTO `sys_role_menu` VALUES ('36', '1', '37');
INSERT INTO `sys_role_menu` VALUES ('37', '1', '38');
INSERT INTO `sys_role_menu` VALUES ('38', '1', '39');
INSERT INTO `sys_role_menu` VALUES ('39', '1', '40');
INSERT INTO `sys_role_menu` VALUES ('40', '1', '41');
INSERT INTO `sys_role_menu` VALUES ('41', '1', '42');
INSERT INTO `sys_role_menu` VALUES ('42', '1', '43');
INSERT INTO `sys_role_menu` VALUES ('43', '1', '44');
INSERT INTO `sys_role_menu` VALUES ('44', '1', '45');
INSERT INTO `sys_role_menu` VALUES ('45', '1', '46');
INSERT INTO `sys_role_menu` VALUES ('46', '1', '47');
INSERT INTO `sys_role_menu` VALUES ('47', '1', '48');
INSERT INTO `sys_role_menu` VALUES ('48', '1', '49');
INSERT INTO `sys_role_menu` VALUES ('49', '1', '50');
INSERT INTO `sys_role_menu` VALUES ('50', '1', '51');
INSERT INTO `sys_role_menu` VALUES ('51', '1', '52');
INSERT INTO `sys_role_menu` VALUES ('52', '1', '53');
INSERT INTO `sys_role_menu` VALUES ('53', '1', '54');
INSERT INTO `sys_role_menu` VALUES ('54', '1', '55');
INSERT INTO `sys_role_menu` VALUES ('55', '1', '56');
INSERT INTO `sys_role_menu` VALUES ('56', '1', '57');
INSERT INTO `sys_role_menu` VALUES ('57', '1', '58');
INSERT INTO `sys_role_menu` VALUES ('58', '1', '59');
INSERT INTO `sys_role_menu` VALUES ('59', '1', '60');
INSERT INTO `sys_role_menu` VALUES ('60', '1', '61');
INSERT INTO `sys_role_menu` VALUES ('61', '1', '62');
INSERT INTO `sys_role_menu` VALUES ('62', '1', '63');
INSERT INTO `sys_role_menu` VALUES ('63', '1', '64');
INSERT INTO `sys_role_menu` VALUES ('64', '1', '65');
INSERT INTO `sys_role_menu` VALUES ('65', '1', '66');
INSERT INTO `sys_role_menu` VALUES ('66', '1', '67');
INSERT INTO `sys_role_menu` VALUES ('67', '1', '68');
INSERT INTO `sys_role_menu` VALUES ('68', '1', '69');
INSERT INTO `sys_role_menu` VALUES ('69', '1', '70');
INSERT INTO `sys_role_menu` VALUES ('70', '1', '71');
INSERT INTO `sys_role_menu` VALUES ('71', '1', '72');
INSERT INTO `sys_role_menu` VALUES ('72', '1', '73');
INSERT INTO `sys_role_menu` VALUES ('73', '1', '74');
INSERT INTO `sys_role_menu` VALUES ('74', '1', '75');
INSERT INTO `sys_role_menu` VALUES ('75', '1', '76');
INSERT INTO `sys_role_menu` VALUES ('76', '1', '77');
INSERT INTO `sys_role_menu` VALUES ('77', '1', '78');
INSERT INTO `sys_role_menu` VALUES ('78', '1', '79');
INSERT INTO `sys_role_menu` VALUES ('79', '1', '80');
INSERT INTO `sys_role_menu` VALUES ('80', '1', '-666666');
INSERT INTO `sys_role_menu` VALUES ('81', '2', '36');
INSERT INTO `sys_role_menu` VALUES ('82', '2', '37');
INSERT INTO `sys_role_menu` VALUES ('83', '2', '38');
INSERT INTO `sys_role_menu` VALUES ('84', '2', '39');
INSERT INTO `sys_role_menu` VALUES ('85', '2', '40');
INSERT INTO `sys_role_menu` VALUES ('86', '2', '-666666');
INSERT INTO `sys_role_menu` VALUES ('87', '2', '1');
INSERT INTO `sys_role_menu` VALUES ('95', '4', '46');
INSERT INTO `sys_role_menu` VALUES ('96', '4', '47');
INSERT INTO `sys_role_menu` VALUES ('97', '4', '48');
INSERT INTO `sys_role_menu` VALUES ('98', '4', '49');
INSERT INTO `sys_role_menu` VALUES ('99', '4', '50');
INSERT INTO `sys_role_menu` VALUES ('100', '4', '71');
INSERT INTO `sys_role_menu` VALUES ('101', '4', '72');
INSERT INTO `sys_role_menu` VALUES ('102', '4', '73');
INSERT INTO `sys_role_menu` VALUES ('103', '4', '74');
INSERT INTO `sys_role_menu` VALUES ('104', '4', '75');
INSERT INTO `sys_role_menu` VALUES ('105', '4', '76');
INSERT INTO `sys_role_menu` VALUES ('106', '4', '77');
INSERT INTO `sys_role_menu` VALUES ('107', '4', '78');
INSERT INTO `sys_role_menu` VALUES ('108', '4', '79');
INSERT INTO `sys_role_menu` VALUES ('109', '4', '80');
INSERT INTO `sys_role_menu` VALUES ('110', '4', '-666666');
INSERT INTO `sys_role_menu` VALUES ('111', '4', '1');
INSERT INTO `sys_role_menu` VALUES ('171', '3', '31');
INSERT INTO `sys_role_menu` VALUES ('172', '3', '32');
INSERT INTO `sys_role_menu` VALUES ('173', '3', '33');
INSERT INTO `sys_role_menu` VALUES ('174', '3', '34');
INSERT INTO `sys_role_menu` VALUES ('175', '3', '35');
INSERT INTO `sys_role_menu` VALUES ('176', '3', '-666666');
INSERT INTO `sys_role_menu` VALUES ('177', '3', '1');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `salt` varchar(20) DEFAULT NULL COMMENT '盐',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '9ec9750e709431dad22365cabc5c625482e574c74adaebba7dd02f1129e4ce1d', 'YzcmCZNvbXocrsz9dm8e', 'root@renren.io', '13612345678', '1', '1', '2016-11-11 11:11:11');
INSERT INTO `sys_user` VALUES ('2', 'andrewtao', 'a48482c1f3349ba4b7273c96a4378d8cc64ba748dd9c35c6b47d9a94933d5e8f', '7WqvUTHSGj2QJUdaJjzX', '1044973286@qq.com', '15767625900', '1', '1', '2020-05-09 18:42:18');
INSERT INTO `sys_user` VALUES ('3', 'gliytaoya', '0df41b3d12427caa7adcd16c48bcc1b2e9729574392c716177b9fd07f1d6a214', '1OOAEnBXuhsPs8WrRlBX', '1044973286@qq.com', '15767625900', '1', '1', '2020-05-09 18:47:29');
INSERT INTO `sys_user` VALUES ('4', 'lalal111', '2ccfced6333f8ebf79495fc1cf3ee28834df8043bbedd3987b3b88389c1cbe93', 'dzuE8c6RZRh1acQOIpXY', '1044973286@qq.com', '13640495710', '1', '1', '2020-05-09 18:49:08');
INSERT INTO `sys_user` VALUES ('5', 'kaya7772', 'c32cc6803ce51eaa73c4258ed27a0ffab00365af6492aa32b94f99189576661a', 'xxYH442VonYPraBi5KOm', '13640495710@qq.com', '15768268900', '1', '1', '2020-05-09 18:50:51');
INSERT INTO `sys_user` VALUES ('6', 'ss1111', '3df74da7dd44d070b7943c74c4e933c65dab6b19e596e0b420974441b4c59482', 'qJ8w3OTHNKwlBNJJnXvz', '15767625@qq.com', '15816094062', '0', '1', '2020-05-09 18:51:13');

-- ----------------------------
-- Table structure for `sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户与角色对应关系';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '3', '1');
INSERT INTO `sys_user_role` VALUES ('3', '4', '2');
INSERT INTO `sys_user_role` VALUES ('4', '5', '4');
INSERT INTO `sys_user_role` VALUES ('6', '6', '4');
INSERT INTO `sys_user_role` VALUES ('7', '2', '3');

-- ----------------------------
-- Table structure for `sys_user_token`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_token`;
CREATE TABLE `sys_user_token` (
  `user_id` bigint(20) NOT NULL,
  `token` varchar(100) NOT NULL COMMENT 'token',
  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `token` (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统用户Token';

-- ----------------------------
-- Records of sys_user_token
-- ----------------------------
INSERT INTO `sys_user_token` VALUES ('1', 'e20c63c6130d3afaec82c08775ff2d8a', '2020-05-10 07:02:29', '2020-05-09 19:02:29');
INSERT INTO `sys_user_token` VALUES ('2', '8e3c093a4d2fbe5611d0987309765f5c', '2020-05-10 07:03:18', '2020-05-09 19:03:18');
INSERT INTO `sys_user_token` VALUES ('3', '874f575db0c7f80aa1a8b262212a856d', '2020-05-10 06:51:56', '2020-05-09 18:51:56');
INSERT INTO `sys_user_token` VALUES ('4', 'df6a5be918db8091518f2a3b7083ec20', '2020-05-10 07:00:57', '2020-05-09 19:00:57');
INSERT INTO `sys_user_token` VALUES ('5', '7c4488b02d50c8bd9a4f316fac62fb89', '2020-05-10 07:01:33', '2020-05-09 19:01:33');

-- ----------------------------
-- Table structure for `tb_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `mobile` varchar(20) NOT NULL COMMENT '手机号',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户';

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'mark', '13612345678', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', '2017-03-23 22:37:41');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` varchar(64) NOT NULL COMMENT '用户id',
  `username` varchar(20) NOT NULL COMMENT '用户账号',
  `password` varchar(64) NOT NULL COMMENT '用户密码',
  `face_image` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `nickname` varchar(20) NOT NULL COMMENT '昵称',
  `fans_counts` int(11) DEFAULT '0' COMMENT '粉丝人数',
  `follow_counts` int(11) DEFAULT '0' COMMENT '关注人数',
  `user_status` int(1) unsigned zerofill DEFAULT NULL COMMENT '用户状态',
  `receive_like_counts` int(11) DEFAULT '0' COMMENT '用户接受到的赞美的数量',
  `user_hidden` int(1) unsigned zerofill DEFAULT NULL COMMENT '用户隐私',
  `user_faces` varchar(255) DEFAULT NULL COMMENT '学生证照片',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表\r\n';

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('2005104235ZWBK68', '1044973286', 'SELvzLYRpRl9k1Ssrr3jlQ==', '/image/2b6b8df8fde3fac763e904893e416cda.jpeg', '1044973286', '0', '4', '1', '16', '0', '/2005104235ZWBK68/userFaces/wxbc42d511c79df868.o6zAJs9FMEaJMHpLzaPEufhvueww.jM8FkTzHgGQs110fa351c9e94d3cb44a79af6621c5ce.png');
INSERT INTO `users` VALUES ('20051042XT0F7DKP', '593218286', 'sn+XdyEzFKknBv+n5wNLLA==', '/image/79cf6dc6ed924b8ab9cf77a6e2c8eed9.jpeg', '593218286', '2', '0', '1', '7', '0', '/20051042XT0F7DKP/userFaces/wxbc42d511c79df868.o6zAJs9FMEaJMHpLzaPEufhvueww.gKG5gHqOAOAp48ac8fdd9598d7b7080a6b6d276e8fb7.png');
INSERT INTO `users` VALUES ('20051044BPXB96Y8', 'qq159874', 'QbRfpBSukO25BIQmsSg8uw==', '/image/84dac3b12913d66516c21f0c3001080f.jpg', 'qq159874', '0', '0', '1', '1', '0', '/20051044BPXB96Y8/userFaces/wxbc42d511c79df868.o6zAJs9FMEaJMHpLzaPEufhvueww.kP6l5EQGal0p098e7e4a4c8ab85d5d97913460468130.jpg');
INSERT INTO `users` VALUES ('20051044PA4PWYRP', '13702378', 'ZLDNtSL1W1VDUmpeqD4L9w==', '/image/405df558c12c60ec442bf4ba84eba6b2.jpg', '13702378', '1', '1', '1', '5', '0', '/20051044PA4PWYRP/userFaces/wxbc42d511c79df868.o6zAJs9FMEaJMHpLzaPEufhvueww.7OnXAv86Sbzm15f6b0c5e32f83a4c3e11f14c9a3a8d3.jpg');
INSERT INTO `users` VALUES ('2005104523R2P4X4', '59874123', 'z90dzaxm7uOeTAKUuf22IQ==', '/image/405df558c12c60ec442bf4ba84eba6b2.jpg', '59874123', '0', '0', '1', '0', '0', '/2005104523R2P4X4/userFaces/wxbc42d511c79df868.o6zAJs9FMEaJMHpLzaPEufhvueww.5miDpvO9Lq0U8ae790b90dd225c43f493e912589b02e.jpg');
INSERT INTO `users` VALUES ('20051045C117DYW0', '598741223', 'K3secG/L0tg2z0qiqWWWUg==', '/20051045C117DYW0/image/wxbc42d511c79df868.o6zAJs9FMEaJMHpLzaPEufhvueww.bVXrdG16NsN66a63a6f83ca3ebb44e3de55fab57edf2.jpg', '598741223', '0', '0', '1', '0', '0', '/20051045C117DYW0/userFaces/wxbc42d511c79df868.o6zAJs9FMEaJMHpLzaPEufhvueww.lfIBvKH2Txsk91e3a19ef38c35faa81620094d0669ad.jpg');
INSERT INTO `users` VALUES ('2005104617R1XRYW', 'qq15715764', 'RkObhsaOVAeX74aBWp/H2w==', '/image/8813a574213221340c354a756cd0b4f0.jpg', 'qq15715764', '0', '0', '1', '0', '0', '/2005104617R1XRYW/userFaces/wxbc42d511c79df868.o6zAJs9FMEaJMHpLzaPEufhvueww.5Oz0GYwG678dda7e2d4774ad20ab3ceba7490ed5018d.jpg');
INSERT INTO `users` VALUES ('200510467C737R40', '5698745', 'rxRS0DmYQjmrma5gtyPCwg==', '/image/22611e2300e66f185cf7eb1efbded6e7.jpg', '5698745', '1', '0', '1', '6', '0', '/200510467C737R40/userFaces/wxbc42d511c79df868.o6zAJs9FMEaJMHpLzaPEufhvueww.TG7IoH6xSn3m5de6455cf33ade0eaa9d4cb8d22a4e39.png');
INSERT INTO `users` VALUES ('20051046CN5WNXP0', 'ta12368', 'O0iWizjdckgziHUMxRGv4g==', '/image/51532e0ad12ba58b291ac92c4679cfcf.jpg', 'ta12368', '0', '0', '1', '0', '0', '/20051046CN5WNXP0/userFaces/wxbc42d511c79df868.o6zAJs9FMEaJMHpLzaPEufhvueww.CL9GQjEI7m8ec01fe8978e7829d0f63bb1dcdf4c468f.jpg');
INSERT INTO `users` VALUES ('20051046NRSGWXS8', 'ewqie1235', 'i6Rn3ErR2v7WBCcgy5mAkQ==', '/image/92454f32cf0a01dadab0ff2f959f559f.jpg', 'ewqie1235', '0', '0', '1', '0', '0', '/20051046NRSGWXS8/userFaces/wxbc42d511c79df868.o6zAJs9FMEaJMHpLzaPEufhvueww.FhYAHawwY3FMd7550ca8c2657fe4b7f7a78aae0711d5.jpg');
INSERT INTO `users` VALUES ('20051049CGBZC940', 'bikaqiu2321', 'gf4vH2mNZwnXsk0m3NbB4A==', '/image/a552d6ae14cd0ef8c22c15a1e5f7fa75.jpg', 'bikaqiu2321', '1', '0', '1', '0', '0', '/20051049CGBZC940/userFaces/wxbc42d511c79df868.o6zAJs9FMEaJMHpLzaPEufhvueww.naszrDRembeWd7550ca8c2657fe4b7f7a78aae0711d5.jpg');
INSERT INTO `users` VALUES ('20051049S7BDN5S8', '884946', 'gfWZMJWHFTA07DLjwu59yg==', '/image/fc67834d20507385d5cb9beb08c74080.jpg', '884946', '0', '0', '1', '0', '0', '/20051049S7BDN5S8/userFaces/wxbc42d511c79df868.o6zAJs9FMEaJMHpLzaPEufhvueww.nPUSDuOf7jkF100c6574c41189cc86ce86ab3c5a0bee.jpg');
INSERT INTO `users` VALUES ('2005104A2DTMBDYW', '846841', 'nlgXC6T7wt8nWsiXUr4kAw==', '/image/ff86e0b8e9ff4ed01677c45208118a1b.jpg', '846841', '0', '0', '2', '0', '0', '/2005104A2DTMBDYW/userFaces/wxbc42d511c79df868.o6zAJs9FMEaJMHpLzaPEufhvueww.4YdURVpOxIBpbb3890da4a743a14b6adf9dccbd26b6f.jpg');

-- ----------------------------
-- Table structure for `users_fans`
-- ----------------------------
DROP TABLE IF EXISTS `users_fans`;
CREATE TABLE `users_fans` (
  `id` varchar(64) NOT NULL COMMENT '用户粉丝表id',
  `user_id` varchar(64) NOT NULL COMMENT '用户id',
  `fan_id` varchar(64) NOT NULL COMMENT '粉丝id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id` (`user_id`,`fan_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户粉丝表';

-- ----------------------------
-- Records of users_fans
-- ----------------------------
INSERT INTO `users_fans` VALUES ('200510556FNTWWDP', '20051042XT0F7DKP', '2005104235ZWBK68');
INSERT INTO `users_fans` VALUES ('2005105191WG8HM8', '20051042XT0F7DKP', '20051044PA4PWYRP');
INSERT INTO `users_fans` VALUES ('2005104XXMG4A9YW', '20051044PA4PWYRP', '2005104235ZWBK68');
INSERT INTO `users_fans` VALUES ('2005104X6ZCGBB0H', '200510467C737R40', '2005104235ZWBK68');
INSERT INTO `users_fans` VALUES ('2005104XN2ZHR680', '20051049CGBZC940', '2005104235ZWBK68');

-- ----------------------------
-- Table structure for `users_like_videos`
-- ----------------------------
DROP TABLE IF EXISTS `users_like_videos`;
CREATE TABLE `users_like_videos` (
  `id` varchar(64) NOT NULL COMMENT '用户视频关联表id',
  `user_id` varchar(64) NOT NULL COMMENT '用户id',
  `video_id` varchar(64) NOT NULL COMMENT '视频id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_video_rel` (`user_id`,`video_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户视频关联表';

-- ----------------------------
-- Records of users_like_videos
-- ----------------------------
INSERT INTO `users_like_videos` VALUES ('2005104YW1T2WACH', '2005104235ZWBK68', '2005104BDTMRKH28');
INSERT INTO `users_like_videos` VALUES ('2005104YT5S686FW', '2005104235ZWBK68', '2005104CKWA1GR40');
INSERT INTO `users_like_videos` VALUES ('2005104XHR5FWWSW', '2005104235ZWBK68', '2005104F7BXCWP6W');
INSERT INTO `users_like_videos` VALUES ('2005104Y22TBZC94', '2005104235ZWBK68', '2005104FH5MXRKP0');
INSERT INTO `users_like_videos` VALUES ('2005104YRCKFFC6W', '2005104235ZWBK68', '2005104FW3GM2G54');
INSERT INTO `users_like_videos` VALUES ('2005104XDZTSZDYW', '2005104235ZWBK68', '2005104G58WKHZ2W');
INSERT INTO `users_like_videos` VALUES ('2005104XM8HMD680', '2005104235ZWBK68', '2005104GDC4CNCM8');
INSERT INTO `users_like_videos` VALUES ('2005104Y0ZMNW8SW', '2005104235ZWBK68', '2005104H1A046894');
INSERT INTO `users_like_videos` VALUES ('2005104XB9T5RP94', '2005104235ZWBK68', '2005104MFN223ZMW');
INSERT INTO `users_like_videos` VALUES ('2005104XZ3YTFY80', '2005104235ZWBK68', '2005104MTA11R8H0');
INSERT INTO `users_like_videos` VALUES ('2005104XX7C1R77C', '2005104235ZWBK68', '2005104PKS3WKRKP');
INSERT INTO `users_like_videos` VALUES ('2005104XAB1C7Y14', '2005104235ZWBK68', '2005104RFWK8HPX4');
INSERT INTO `users_like_videos` VALUES ('2005104XCYKGZW28', '2005104235ZWBK68', '2005104RY4708XD4');
INSERT INTO `users_like_videos` VALUES ('2005104X62DHN25P', '2005104235ZWBK68', '2005104S5B9NBH6W');
INSERT INTO `users_like_videos` VALUES ('2005104X5F47RPZC', '2005104235ZWBK68', '2005104SK971R0PH');
INSERT INTO `users_like_videos` VALUES ('2005104X4R3TM9KP', '2005104235ZWBK68', '2005104TA3ZSAFFW');
INSERT INTO `users_like_videos` VALUES ('200510507MSXF4PH', '20051042XT0F7DKP', '2005104FH5MXRKP0');
INSERT INTO `users_like_videos` VALUES ('2005104ZBXB5AP28', '20051042XT0F7DKP', '2005104G58WKHZ2W');
INSERT INTO `users_like_videos` VALUES ('2005104ZB2PCPH00', '20051042XT0F7DKP', '2005104H1A046894');
INSERT INTO `users_like_videos` VALUES ('2005104ZA8PDFHDP', '20051042XT0F7DKP', '2005104M1PR6TMW0');
INSERT INTO `users_like_videos` VALUES ('200510501YW82WZC', '20051042XT0F7DKP', '2005104RMR5CAPBC');
INSERT INTO `users_like_videos` VALUES ('2005104ZF4P4NG7C', '20051042XT0F7DKP', '2005104S5B9NBH6W');
INSERT INTO `users_like_videos` VALUES ('2005104ZD1FYY800', '20051042XT0F7DKP', '2005104SK971R0PH');
INSERT INTO `users_like_videos` VALUES ('20051054TS9DPS5P', '20051044BPXB96Y8', '2005104H1A046894');
INSERT INTO `users_like_videos` VALUES ('20051051ND5CMY80', '20051044PA4PWYRP', '2005104FH5MXRKP0');
INSERT INTO `users_like_videos` VALUES ('20051051C5P198X4', '20051044PA4PWYRP', '2005104H1A046894');
INSERT INTO `users_like_videos` VALUES ('20051051HKDCN8PH', '20051044PA4PWYRP', '2005104NR5KHXBTC');
INSERT INTO `users_like_videos` VALUES ('20051051DA49P6FW', '20051044PA4PWYRP', '2005104PKS3WKRKP');
INSERT INTO `users_like_videos` VALUES ('20051051GSARMWM8', '20051044PA4PWYRP', '2005104S5B9NBH6W');
INSERT INTO `users_like_videos` VALUES ('200510529KK178PH', '200510467C737R40', '2005104BDTMRKH28');
INSERT INTO `users_like_videos` VALUES ('20051053X0PWBTR4', '200510467C737R40', '2005104FW3GM2G54');
INSERT INTO `users_like_videos` VALUES ('200510526FZ4XTHH', '200510467C737R40', '2005104KR8CH139P');
INSERT INTO `users_like_videos` VALUES ('200510522RAKNW28', '200510467C737R40', '2005104RY4708XD4');
INSERT INTO `users_like_videos` VALUES ('20051053RCWN7ZMW', '200510467C737R40', '2005104S5B9NBH6W');
INSERT INTO `users_like_videos` VALUES ('200510523F1GNM5P', '200510467C737R40', '2005104TA3ZSAFFW');

-- ----------------------------
-- Table structure for `users_report`
-- ----------------------------
DROP TABLE IF EXISTS `users_report`;
CREATE TABLE `users_report` (
  `id` varchar(64) NOT NULL COMMENT '用户举报表id',
  `deal_user_id` varchar(64) NOT NULL COMMENT '被举报的用户id',
  `deal_video_id` varchar(64) NOT NULL COMMENT '被举报的视频id',
  `title` varchar(128) NOT NULL COMMENT '举报标题',
  `content` varchar(255) DEFAULT NULL COMMENT '举报内容',
  `userid` varchar(64) NOT NULL COMMENT '举报者的id',
  `create_date` datetime NOT NULL COMMENT '举报日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户举报表';

-- ----------------------------
-- Records of users_report
-- ----------------------------
INSERT INTO `users_report` VALUES ('20051056224F7W28', '200510467C737R40', '2005104TA3ZSAFFW', '违法违纪', '赌博', '2005104235ZWBK68', '2020-05-10 07:18:35');
INSERT INTO `users_report` VALUES ('20051056HTY7C3XP', '200510467C737R40', '2005104TA3ZSAFFW', '其它原因', '赌博行为', '20051042XT0F7DKP', '2020-05-10 07:20:10');

-- ----------------------------
-- Table structure for `videos`
-- ----------------------------
DROP TABLE IF EXISTS `videos`;
CREATE TABLE `videos` (
  `id` varchar(64) NOT NULL COMMENT '视频表id',
  `user_id` varchar(64) NOT NULL COMMENT '发布视频用户id',
  `audio_id` varchar(64) DEFAULT NULL COMMENT '音频id',
  `video_desc` varchar(128) DEFAULT NULL COMMENT '用户输入的视频内容',
  `video_path` varchar(255) NOT NULL COMMENT '视频上传路径',
  `video_seconds` float(6,2) DEFAULT NULL COMMENT '视频播放秒数',
  `video_width` int(6) DEFAULT NULL COMMENT '视频的宽',
  `video_height` int(6) DEFAULT NULL COMMENT '视频的高',
  `cover_path` varchar(255) DEFAULT NULL COMMENT '视频封面路径',
  `like_counts` bigint(20) NOT NULL DEFAULT '0' COMMENT '视频获得喜欢的数量',
  `status` int(1) NOT NULL COMMENT '视频状态',
  `create_time` datetime NOT NULL COMMENT '视频发布日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='视频表';

-- ----------------------------
-- Records of videos
-- ----------------------------
INSERT INTO `videos` VALUES ('2005104BDTMRKH28', '2005104235ZWBK68', '', '', '/2005104235ZWBK68/video/0ed9fe0e-cbab-493b-97e3-4674909fb8fc.mp4', '27.43', '576', '1024', '/2005104235ZWBK68/video/ee0e0db7-caf1-42c2-a345-06eb8e3acb54.jpg', '2', '1', '2020-05-10 06:10:48');
INSERT INTO `videos` VALUES ('2005104CKWA1GR40', '2005104235ZWBK68', '', '嘻嘻', '/2005104235ZWBK68/video/80b23238-e433-4ceb-add1-f5632323fb2f.mp4', '87.60', '1280', '720', '/2005104235ZWBK68/video/6b5a8490-b142-413e-8478-d43b032a14a2.jpg', '1', '1', '2020-05-10 06:14:14');
INSERT INTO `videos` VALUES ('2005104F7BXCWP6W', '2005104235ZWBK68', '', '真好玩', '/2005104235ZWBK68/video/9ae77396-9ab6-45fb-8cbc-fa561d8ffb50.mp4', '17.67', '576', '1024', '/2005104235ZWBK68/video/f21b9e05-8339-4335-9781-f2aedc3909ab.jpg', '1', '1', '2020-05-10 06:19:07');
INSERT INTO `videos` VALUES ('2005104FH5MXRKP0', '2005104235ZWBK68', '', '美好的一天', '/2005104235ZWBK68/video/6583cc78-0dc2-45f8-b55d-31b2c9d59518.mp4', '38.08', '1280', '720', '/2005104235ZWBK68/video/e037787e-ad7f-4902-a337-6479d6ad593e.jpg', '3', '1', '2020-05-10 06:20:03');
INSERT INTO `videos` VALUES ('2005104FW3GM2G54', '2005104235ZWBK68', '', '哈哈哈', '/2005104235ZWBK68/video/3fcdbd5d-f6c4-4fce-9c02-15278844cea8.mp4', '14.49', '1024', '576', '/2005104235ZWBK68/video/732838a4-d462-48db-b8c9-a3f2c9689b4d.jpg', '2', '1', '2020-05-10 06:20:54');
INSERT INTO `videos` VALUES ('2005104G58WKHZ2W', '20051042XT0F7DKP', '', '学校真好', '/20051042XT0F7DKP/video/1146d2e4-adee-461a-b6e7-0ae32828ebf9.mp4', '15.07', '960', '544', '/20051042XT0F7DKP/video/0396ce34-90b2-4d3c-9179-36aaca4fba49.jpg', '2', '1', '2020-05-10 06:21:53');
INSERT INTO `videos` VALUES ('2005104GDC4CNCM8', '20051042XT0F7DKP', '', '美丽呀', '/20051042XT0F7DKP/video/af85365d-1d40-40e7-aa56-b64a6fe6dc8d.mp4', '21.36', '1024', '576', '/20051042XT0F7DKP/video/62c22ddf-0eb0-4253-9a85-3acbfcb02d5f.jpg', '1', '1', '2020-05-10 06:22:45');
INSERT INTO `videos` VALUES ('2005104H1A046894', '20051042XT0F7DKP', '', '图书馆学习中', '/20051042XT0F7DKP/video/796fa4c9-43f2-418a-98ea-11840b9de725.mp4', '121.33', '1280', '720', '/20051042XT0F7DKP/video/430fb6e3-c3d6-4137-b6a8-d2d7d82808bc.jpg', '4', '1', '2020-05-10 06:24:28');
INSERT INTO `videos` VALUES ('2005104KR8CH139P', '20051042XT0F7DKP', '', '多彩人生', '/20051042XT0F7DKP/video/10113413-1560-444f-a64a-5762483040c9.mp4', '155.10', '1280', '720', '/20051042XT0F7DKP/video/deb2d894-01c5-4fbd-b93e-9957b2573ed5.jpg', '1', '1', '2020-05-10 06:29:36');
INSERT INTO `videos` VALUES ('2005104M1PR6TMW0', '20051042XT0F7DKP', '', '毕业', '/20051042XT0F7DKP/video/cde2608e-5147-4077-b3bf-fe46e7c7ded4.mp4', '31.90', '1024', '576', '/20051042XT0F7DKP/video/cc44f375-68ed-465d-9eae-be3a3e5e658c.jpg', '1', '1', '2020-05-10 06:30:31');
INSERT INTO `videos` VALUES ('2005104MFN223ZMW', '20051044BPXB96Y8', '', '宣传片', '/20051044BPXB96Y8/video/4f6894ad-b5e4-4f87-ad14-4d1e74187d25.mp4', '55.91', '1280', '720', '/20051044BPXB96Y8/video/ac459749-4a64-4220-85f0-7c19aeef7f55.jpg', '1', '1', '2020-05-10 06:31:54');
INSERT INTO `videos` VALUES ('2005104MTA11R8H0', '20051044BPXB96Y8', '', '学校道路', '/20051044BPXB96Y8/video/ee7fe7ee-aaab-495a-b918-f4ab2423fe89.mp4', '40.38', '576', '1024', '/20051044BPXB96Y8/video/f7515a57-c2d5-41a6-ab1c-e035c4f8639b.jpg', '1', '1', '2020-05-10 06:32:50');
INSERT INTO `videos` VALUES ('2005104NR5KHXBTC', '20051044PA4PWYRP', '', '篮球采访', '/20051044PA4PWYRP/video/6fa48909-dfaa-4450-b14d-ea25232ed682.mp4', '191.45', '1280', '720', '/20051044PA4PWYRP/video/79ba42f0-5bc6-4032-ba28-ea1860a207d6.jpg', '1', '1', '2020-05-10 06:35:36');
INSERT INTO `videos` VALUES ('2005104PKS3WKRKP', '20051044PA4PWYRP', '', '音乐会', '/20051044PA4PWYRP/video/3588a76a-34ef-4a3c-b8a2-6e7297cd84c3.mp4', '45.09', '1280', '720', '/20051044PA4PWYRP/video/36e59d62-bf77-4969-8121-2b41edef8b51.jpg', '2', '1', '2020-05-10 06:38:14');
INSERT INTO `videos` VALUES ('2005104RFWK8HPX4', '2005104617R1XRYW', '', '哈哈', '/2005104617R1XRYW/video/d3e0f9ba-c716-4864-b0ba-18239166873a.mp4', '12.45', '544', '960', '/2005104617R1XRYW/video/b864dc9b-b793-4b13-aa50-7ff966472ef3.jpg', '1', '1', '2020-05-10 06:40:56');
INSERT INTO `videos` VALUES ('2005104RMR5CAPBC', '2005104617R1XRYW', '', '', '/2005104617R1XRYW/video/9348533f-f5cd-4a4f-a82f-95df20a58fde.mp4', '14.37', '1024', '576', '/2005104617R1XRYW/video/7d0043c3-a912-463c-a716-7d5ecb6107e2.jpg', '1', '1', '2020-05-10 06:41:21');
INSERT INTO `videos` VALUES ('2005104RY4708XD4', '200510467C737R40', '', '', '/200510467C737R40/video/0ebdd12e-6bd5-4ca2-90d0-19631802b1fe.mp4', '14.00', '576', '1024', '/200510467C737R40/video/ce301ef2-b257-4d82-9336-c6680b2d2036.jpg', '2', '1', '2020-05-10 06:42:08');
INSERT INTO `videos` VALUES ('2005104S5B9NBH6W', '200510467C737R40', '', '毕业了', '/200510467C737R40/video/04a2791c-7101-436e-8a78-a3852931469e.mp4', '10.80', '1280', '720', '/200510467C737R40/video/53b02d9b-41eb-446d-ad24-6b46548576b4.jpg', '4', '1', '2020-05-10 06:42:55');
INSERT INTO `videos` VALUES ('2005104SK971R0PH', '20051049CGBZC940', '', '啦啦啦', '/20051049CGBZC940/video/e2819ec6-7ee9-4fe3-9707-8847d78c9f34.mp4', '44.13', '1024', '576', '/20051049CGBZC940/video/7cdb3ccf-7398-40f3-bbf0-b01462675e43.jpg', '2', '1', '2020-05-10 06:44:12');
INSERT INTO `videos` VALUES ('2005104TA3ZSAFFW', '200510467C737R40', '', '赌博呀', '/200510467C737R40/video/b525cebe-bfe0-4da5-9870-7714e5ff3dec.mp4', '82.01', '720', '1280', '/200510467C737R40/video/e98f4192-8375-40b6-bc72-0e80386f6575.jpg', '2', '1', '2020-05-10 06:46:25');
DROP TRIGGER IF EXISTS `insert_user_status_trigger`;
DELIMITER ;;
CREATE TRIGGER `insert_user_status_trigger` AFTER INSERT ON `punish_users` FOR EACH ROW BEGIN
	UPDATE users    SET  user_status = 2 WHERE id = new.user_id;
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `delete_user_status_trigger`;
DELIMITER ;;
CREATE TRIGGER `delete_user_status_trigger` AFTER DELETE ON `punish_users` FOR EACH ROW BEGIN
	UPDATE users    SET  user_status = 1 WHERE id = OLD.user_id;
END
;;
DELIMITER ;
