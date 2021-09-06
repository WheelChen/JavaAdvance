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
 * 订单基础表
 */
@Data
public class OdBase {
    private Integer id;

    /**
     * 订单id
     */
    private Long orderId;

    /**
     * 订单总金额
     */
    private BigDecimal orderAmount;

    /**
     * 订单备注
     */
    private String remark;

    /**
     * 运费金额
     */
    private BigDecimal freight;

    /**
     * 用户id
     */
    private Long userId;

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

    /**
     * 订单状态 1-待支付 2-待发货 3-待收货 4-已完成 5-已取消
     */
    private Byte orderStatus;

    /**
     * 地址id
     */
    private Long addressId;
}