package com.example.redisdemo.redis.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Component;

/**
 * @author Kelvin Chen
 * @date 2021-09-21 11:16:16
 */
@Component
public class RedisMessagePublisher implements MessagePublisher{
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private ChannelTopic orderTopic;

    /**
     * 推送消息
     *
     * @param message
     */
    @Override
    public void publish(Object message) {
        redisTemplate.convertAndSend(orderTopic.getTopic(), message);
    }
}
