CREATE TABLE `tb_channel` (
  `id` int(11) NOT NULL,
  `channelName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8



CREATE TABLE `tb_criticism` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text,
  `employee_id` int(11) DEFAULT NULL,
  `critisism_time` datetime DEFAULT NULL,
  `message_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `criticism_employee_id` (`employee_id`),
  KEY `criticism_message_id` (`message_id`),
  CONSTRAINT `criticism_employee_id` FOREIGN KEY (`employee_id`) REFERENCES `tb_employee` (`id`),
  CONSTRAINT `criticism_message_id` FOREIGN KEY (`message_id`) REFERENCES `tb_message` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8


CREATE TABLE `tb_employee` (
  `id` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `sex` bit(1) DEFAULT NULL,
  `birth` date DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `addrss` varchar(100) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `isLeader` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8


CREATE TABLE `tb_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `content` text,
  `employee_id` int(11) DEFAULT NULL,
  `publish_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `employee_id` (`employee_id`),
  CONSTRAINT `employee_id` FOREIGN KEY (`employee_id`) REFERENCES `tb_employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8



CREATE TABLE `tb_reply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text,
  `employee_id` int(11) DEFAULT NULL,
  `reply_time` datetime DEFAULT NULL,
  `message_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `reply_employee_id` (`employee_id`),
  KEY `reply_message_id` (`message_id`),
  CONSTRAINT `reply_employee_id` FOREIGN KEY (`employee_id`) REFERENCES `tb_employee` (`id`),
  CONSTRAINT `reply_message_id` FOREIGN KEY (`message_id`) REFERENCES `tb_message` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8


CREATE TABLE `tb_student` (
  `student_id` varchar(100) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  `student_name` varchar(100) DEFAULT NULL,
  `result` int(11) DEFAULT NULL,
  `sclass` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8


CREATE TABLE `tb_subject` (
  `subject_id` int(11) NOT NULL,
  `subject_title` varchar(100) DEFAULT NULL,
  `subject_option_a` varchar(100) DEFAULT NULL,
  `subject_option_b` varchar(100) DEFAULT NULL,
  `subject_option_c` varchar(100) DEFAULT NULL,
  `subject_option_d` varchar(100) DEFAULT NULL,
  `subject_answer` varchar(1000) DEFAULT NULL,
  `subject_parse` text,
  PRIMARY KEY (`subject_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8


CREATE TABLE `tb_teacher` (
  `teacherID` varchar(100) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`teacherID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8


CREATE TABLE `tb_vote` (
  `voteID` int(11) NOT NULL AUTO_INCREMENT,
  `voteName` varchar(100) DEFAULT NULL,
  `channelID` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`voteID`),
  KEY `vote_channel_id` (`channelID`),
  CONSTRAINT `vote_channel_id` FOREIGN KEY (`channelID`) REFERENCES `tb_channel` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8


CREATE TABLE `tb_voteoption` (
  `voteOptionID` int(11) NOT NULL AUTO_INCREMENT,
  `voteID` int(11) DEFAULT NULL,
  `voteOptionName` varchar(100) DEFAULT NULL,
  `ticketNum` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`voteOptionID`),
  KEY `vote_option_vote_id` (`voteID`),
  CONSTRAINT `vote_option_vote_id` FOREIGN KEY (`voteID`) REFERENCES `tb_vote` (`voteID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8