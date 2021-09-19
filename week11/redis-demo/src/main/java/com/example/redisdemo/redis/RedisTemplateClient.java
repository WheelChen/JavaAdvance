package com.example.redisdemo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author duruo.cy
 * @description
 * @date 2021/9/17 12:25 PM
 */
@Component
public class RedisTemplateClient {
    @Autowired
    private RedisTemplate<Object, Object> restTemplate;


}
