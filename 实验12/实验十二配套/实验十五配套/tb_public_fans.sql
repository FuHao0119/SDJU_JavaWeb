CREATE TABLE tb_public_fans (
    `pfl_id` INT AUTO_INCREMENT COMMENT '自增主键',
    `public_id` INT,
    `fan_id` INT,
    `is_subscribed` TINYINT(1) DEFAULT 1,
    PRIMARY KEY (`pfl_id`),
    UNIQUE KEY (`fan_id`, `public_id`)  COMMENT '确保每个粉丝在每个公众号下只记录一次'
)  ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT '公众号粉丝列表';