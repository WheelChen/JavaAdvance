package com.example.multidb.auto.entity;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;



/**
 *
 * @author Kelvin Chen
 * @date 2021-08-08 23:56:41
 */

/**
 * 商品sku表
 */
@Data
public class PdSku {
    /**
     * 自增主键
     */
    private Integer id;

    /**
     * 商品名
     */
    private String name;

    private Long spuId;

    private Long skuId;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * sku最新快照码
     */
    private String skuSnapCode;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 0-无效 1-有效
     */
    private Byte isDelete;
}