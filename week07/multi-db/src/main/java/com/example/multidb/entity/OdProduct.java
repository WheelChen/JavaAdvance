package com.example.multidb.entity;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;



/**
 *
 * @author Kelvin Chen
 * @date 2021-08-08 23:56:41
 */

/**
 * 订单商品表
 */
@Data
public class OdProduct {
    private Integer id;

    /**
     * 订单id
     */
    private Long orderId;

    private Long spuId;

    private Long skuId;

    /**
     * sku 快照码
     */
    private String skuSnapCode;

    /**
     * 订单总金额
     */
    private BigDecimal price;

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