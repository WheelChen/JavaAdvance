package com.example.redisdemo.controller;

import com.example.redisdemo.entity.Order;
import com.example.redisdemo.redis.mq.RedisOrderMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Kelvin Chen
 * @date 2021-09-12 12:28:48
 */
@RestController
public class TestController {

    @Autowired
    private RedisOrderMessagePublisher redisOrderMessagePublisher;

    @GetMapping("/createOrder/{id}")
    public Boolean test(@PathVariable("id") Long id) {
        Order order = new Order();
        order.setOrderId(id);
        redisOrderMessagePublisher.publish(order);
        return true;
    }
}
