package com.example.redisdemo.redis.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Component;

/**
 * @author Kelvin Chen
 * @date 2021-09-21 12:16:32
 */
@Component
public class RedisOrderMessagePublisher implements MessagePublisher{

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private ChannelTopic orderTopic;

    /**
     * 推送消息
     *
     * @param message Order
     */
    @Override
    public void publish(Object message) {
        redisTemplate.convertAndSend(orderTopic.getTopic(), message);
    }
}
