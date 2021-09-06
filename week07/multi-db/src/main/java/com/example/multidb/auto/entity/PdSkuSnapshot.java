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
 * 商品sku快照表
 */
@Data
public class PdSkuSnapshot {
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
     * sku 快照码
     */
    private String skuSnapCode;

    /**
     * spu快照码
     */
    private String spuSnapCode;

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