package com.example.redisdemo.redis.mq;

import com.example.redisdemo.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;

/**
 * @author Kelvin Chen
 * @date 2021-09-21 12:33:22
 */
@Slf4j
@Component
public class RedisOrderMessageSubscriber implements MessageListener {

    private final GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();


    /**
     * Callback for processing received objects through Redis.
     *
     * @param message message must not be {@literal null}.
     * @param pattern pattern matching the channel (if specified) - can be {@literal null}.
     */
    @Override
    public void onMessage(Message message, byte[] pattern) {
        Order order = genericJackson2JsonRedisSerializer.deserialize(message.getBody(), Order.class);
        log.info("消费订单 {}", order.toString());
    }
}
