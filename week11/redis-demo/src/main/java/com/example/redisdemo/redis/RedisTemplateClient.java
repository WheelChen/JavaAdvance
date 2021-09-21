package com.example.redisdemo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

/**
 * @author Kelvin Chen
 * @date 2021-09-16 23:22:53
 */
@Component
public class RedisTemplateClient {
    @Autowired
    private RedisTemplate<String, Object> restTemplate;


    /**
     * 获取分布式锁
     *
     * @param key
     * @param requestId
     * @param timeout
     * @param unit
     * @return
     */
    public Boolean acquireLock(String key, String requestId, long timeout, TimeUnit unit) {
        return restTemplate.opsForValue().setIfAbsent(key, requestId, timeout, unit);
    }

    /**
     * 解锁分布式锁
     * @param key
     * @param requestId
     * @return
     */
    public Boolean releaseLock(String key, String requestId) {
        String scriptSource = "if redis.call('get', KEYS[1]) == ARGV[1] " +
                "then return 1 == redis.call('del', KEYS[1])" +
                "else return false"
                + " end";
        RedisScript<Boolean> script = RedisScript.of(scriptSource, Boolean.class);
        return restTemplate.execute(script, Collections.singletonList(key), requestId);
    }

    public void set(String key, String value) {
        restTemplate.boundValueOps(key).set(value);
    }

}
