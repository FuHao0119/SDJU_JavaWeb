CREATE TABLE tb_fans (
    `fan_id` INT AUTO_INCREMENT COMMENT '粉丝的唯一标识，自增主键',
    `fan_name` VARCHAR(255) NOT NULL COMMENT '粉丝的姓名',
    `gender` varchar(20) NOT NULL COMMENT '粉丝的性别',    
    `email` VARCHAR(255) COMMENT '粉丝的邮箱地址，唯一约束',
    `reg_date` DATETIME COMMENT '粉丝注册日期',
    PRIMARY KEY(`fan_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT '粉丝基础信息表';