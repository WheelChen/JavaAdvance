package com.example.redisdemo.redis.mq;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Kelvin Chen
 * @date 2021-09-21 11:19:34
 */
@Service
public class RedisMessageSubscriber implements MessageListener {

    public static List<String> messageList = new ArrayList<String>();

    @Override
    public void onMessage(Message message, byte[] pattern) {
        messageList.add(message.toString());
        System.out.println("Message received: " + message.toString());
    }
}
