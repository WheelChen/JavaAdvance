package com.example.redisdemo.redis.mq;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

/**
 * @author Kelvin Chen
 * @date 2021-09-21 11:12:34
 */
@Configuration
public class RedisMessageConfig {

    @Bean
    MessageListenerAdapter messageListener() {
        return new MessageListenerAdapter(new RedisMessageSubscriber());
    }

    @Bean
    MessageListenerAdapter orderMessageListener() {
        return new MessageListenerAdapter(new RedisOrderMessageSubscriber());
    }


    @Bean
    ChannelTopic orderTopic() {
        return new ChannelTopic("OrderMessageQueue");
    }

    @Bean
    RedisMessageListenerContainer redisMessageListenerContainer(RedisConnectionFactory redisConnectionFactory) {
        RedisMessageListenerContainer container
                = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory);
//        container.addMessageListener(messageListener(), orderTopic());
        container.addMessageListener(orderMessageListener(), orderTopic());
        return container;
    }
}
