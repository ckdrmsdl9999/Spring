# Spring


mysql입니다.

CREATE TABLE `user_info` (
`id` varchar(20) NOT NULL,
`pwd` varchar(45) NOT NULL,
`name` varchar(50) NOT NULL,
`email` varchar(50)             ,
`birth` varchar(50)              ,
`sns` varchar(20)                ,
`reg_date` datetime DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
