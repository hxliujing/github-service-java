USE  tcc_java_order;
CREATE TABLE tcc_java_order.`tcc_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) NOT NULL COMMENT '支付方式,	1wap,2app',
  `order_sn` VARCHAR(50) NOT NULL COMMENT '订单编号',
  `order_status` VARCHAR(10) NOT NULL COMMENT '状态',
  `account_id` int(11) NOT NULL COMMENT 'union 账户ID',
  `amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '订单金额',
  `is_del` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0-正常，1-删除',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_account_id_type` (`account_id`,`type`) USING BTREE,
  KEY `idx_order_sn` (`order_sn`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='订单表';

USE  tcc_java_account;
CREATE TABLE tcc_java_account.`tcc_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) NOT NULL COMMENT '账户类型,	1wap,2app',
  `amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '账户余额',
  `is_del` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0-正常，1-删除',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='账户表';