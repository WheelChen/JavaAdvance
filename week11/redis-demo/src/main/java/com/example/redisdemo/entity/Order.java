package com.example.redisdemo.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author duruo.cy
 * @description
 * @date 2021/9/17 12:19 PM
 */
@NoArgsConstructor
@Data
public class Order implements Serializable {
    /**
     * 订单id
     */
    private Long orderId;
}
