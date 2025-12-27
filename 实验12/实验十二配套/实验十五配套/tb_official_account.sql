CREATE TABLE tb_official_account (
    `account_id` INT AUTO_INCREMENT COMMENT '自增主键',
    `name` VARCHAR(255) NOT NULL,
    `type` VARCHAR(20) NOT NULL COMMENT '1:服务号; 0:订阅号',
    `category` VARCHAR(255) NOT NULL COMMENT '类别，如健康、出行、汽车、教育等',
    `description` TEXT COMMENT '公众号简介',
    PRIMARY KEY(`account_id`)   
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT '公众号基础信息表';