package com.example.redisdemo.redis.mq;

/**
 * @author Kelvin Chen
 * @date 2021-09-21 11:11:15
 */
public interface MessagePublisher {
    /**
     * 推送消息
     * @param message
     */
    void publish(Object message);
}
