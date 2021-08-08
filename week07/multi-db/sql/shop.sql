DROP TABLE IF EXISTS `mb_address`;
CREATE TABLE `mb_address` (
  `id` int NOT NULL,
  `address_id` bigint NOT NULL COMMENT '地址id',
  `user_id` bigint NOT NULL COMMENT '用户id',
  `mobile` varchar(32) DEFAULT NULL COMMENT '手机号',
  `country_name` varchar(32) DEFAULT NULL COMMENT '国家名称',
  `country_code` int DEFAULT NULL COMMENT '国家简码',
  `province_name` varchar(32) DEFAULT NULL COMMENT '省名称',
  `province_code` int DEFAULT NULL COMMENT '省编码',
  `city_name` varchar(32) DEFAULT NULL COMMENT '市名称',
  `city_code` int DEFAULT NULL COMMENT '市编码',
  `detail_adress` varchar(1024) DEFAULT NULL COMMENT '详细地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `mb_user`;
CREATE TABLE `mb_user` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `user_id` bigint NOT NULL COMMENT '用户id',
  `user_name` varchar(128) NOT NULL COMMENT '用户名',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_delete` tinyint DEFAULT NULL COMMENT '0-无效 1-有效',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';

DROP TABLE IF EXISTS `od_base`;
CREATE TABLE `od_base` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_id` bigint DEFAULT NULL COMMENT '订单id',
  `order_amount` decimal(18,4) DEFAULT NULL COMMENT '订单总金额',
  `remark` varchar(1024) DEFAULT NULL COMMENT '订单备注',
  `freight` decimal(10,4) DEFAULT NULL COMMENT '运费金额',
  `user_id` bigint NOT NULL COMMENT '用户id',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_delete` tinyint DEFAULT NULL COMMENT '0-无效 1-有效',
  `order_status` tinyint DEFAULT NULL COMMENT '订单状态 1-待支付 2-待发货 3-待收货 4-已完成 5-已取消',
  `address_id` bigint NOT NULL COMMENT '地址id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='订单基础表';

DROP TABLE IF EXISTS `od_product`;
CREATE TABLE `od_product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_id` bigint NOT NULL COMMENT '订单id',
  `spu_id` bigint NOT NULL,
  `sku_id` bigint NOT NULL,
  `sku_snap_code` varchar(256) DEFAULT NULL COMMENT 'sku 快照码',
  `price` decimal(18,4) DEFAULT NULL COMMENT '订单总金额',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_delete` tinyint DEFAULT NULL COMMENT '0-无效 1-有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='订单商品表';

DROP TABLE IF EXISTS `pd_sku`;
CREATE TABLE `pd_sku` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `name` varchar(256) NOT NULL COMMENT '商品名',
  `spu_id` bigint NOT NULL,
  `sku_id` bigint NOT NULL,
  `price` decimal(18,4) DEFAULT NULL COMMENT '商品价格',
  `sku_snap_code` varchar(256) NOT NULL COMMENT 'sku最新快照码',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_delete` tinyint DEFAULT NULL COMMENT '0-无效 1-有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='商品sku表';

DROP TABLE IF EXISTS `pd_sku_snapshot`;
CREATE TABLE `pd_sku_snapshot` (
  `id` int NOT NULL COMMENT '自增主键',
  `name` varchar(256) DEFAULT 'utf8mb4_0900_ai_ci' COMMENT '商品名',
  `spu_id` bigint NOT NULL,
  `sku_id` bigint DEFAULT NULL,
  `price` decimal(18,4) DEFAULT NULL COMMENT '商品价格',
  `sku_snap_code` varchar(256) DEFAULT NULL COMMENT 'sku 快照码',
  `spu_snap_code` varchar(256) NOT NULL COMMENT 'spu快照码',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_delete` tinyint DEFAULT NULL COMMENT '0-无效 1-有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='商品sku快照表';

DROP TABLE IF EXISTS `pd_spu`;
CREATE TABLE `pd_spu` (
  `id` int NOT NULL AUTO_INCREMENT,
  `spu_id` bigint NOT NULL,
  `name` varchar(256) NOT NULL COMMENT '商品名',
  `picture_url` varchar(4096) DEFAULT NULL COMMENT '商品图片地址',
  `description` varchar(4096) DEFAULT NULL COMMENT '商品描述',
  `spu_snap_code` varchar(256) NOT NULL COMMENT 'spu最新快照码',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_delete` tinyint DEFAULT NULL COMMENT '0-无效 1-有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='商品spu表';

DROP TABLE IF EXISTS `pd_spu_snapshot`;
CREATE TABLE `pd_spu_snapshot` (
  `id` int NOT NULL,
  `spu_id` bigint DEFAULT NULL,
  `name` varchar(256) DEFAULT '' COMMENT '商品名',
  `picture_url` varchar(4096) DEFAULT '' COMMENT '商品图片地址',
  `description` varchar(4096) DEFAULT '' COMMENT '商品描述',
  `spu_snap_code` varchar(256) DEFAULT '' COMMENT 'spu快照码',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_delete` tinyint DEFAULT NULL COMMENT '0-无效 1-有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='商品spu快照表';
