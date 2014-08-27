#普通用户表，这里的id作为其他表的关联主键
CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `uname` varchar(64) NOT NULL DEFAULT '' comment '用户名，可用于登录',
  `mobile` varchar(32) NOT NULL DEFAULT '',
  `email` varchar(64) NOT NULL DEFAULT '',
  `name` varchar(64) NOT NULL DEFAULT '',
  `sex` tinyint(4) unsigned NOT NULL DEFAULT '0',
  `IDNumber` varchar(32) NOT NULL DEFAULT '',
  `portrait` varchar(256) NOT NULL DEFAULT '',
  `birthday` varchar(32) NOT NULL DEFAULT '',
  `originProvince` varchar(32) NOT NULL DEFAULT '',
  `originCity` varchar(32) NOT NULL DEFAULT '',
  `type` tinyint(4) NOT NULL DEFAULT '0' comment '用户类型；0=学生；1=教师；2=普通职工；3=普通用户',
  `isDeleted` tinyint(4) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#认证表
CREATE TABLE `userSecure` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL DEFAULT '0',
  `mobile` varchar(32) NOT NULL DEFAULT '',
  `email` varchar(64) NOT NULL DEFAULT '',
  `uname` varchar(64) NOT NULL DEFAULT '',
  `studentId` varchar(32) NOT NULL DEFAULT '',
  `passwdMd5` varchar(128) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `I_uid` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `studentInfo` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL DEFAULT '0',
  `studentId` varchar(32) NOT NULL DEFAULT '',
  `examId` varchar(64) DEFAULT NULL,
  `college` varchar(32) NOT NULL DEFAULT '',
  `major` varchar(32) NOT NULL DEFAULT '',
  `grade` varchar(32) NOT NULL DEFAULT '',
  `class` varchar(32) NOT NULL DEFAULT '',
  `apartment` varchar(32) NOT NULL DEFAULT '',
  `dorm` varchar(32) NOT NULL DEFAULT '',
  `archiveId` varchar(64) NOT NULL DEFAULT '',
  `isDeleted` tinyint(4) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `I_uid` (`uid`),
  UNIQUE KEY `I_studentId` (`studentId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8