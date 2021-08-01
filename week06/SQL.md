
```sql
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='订单基础表';

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

```