CREATE TABLE tb_fan_subscriptions (
    `fs_id` INT AUTO_INCREMENT COMMENT '自增主键',
    `fan_id` INT,
    `public_id` INT,
    `subscription_date` DATETIME DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`fs_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT '粉丝关注列表';