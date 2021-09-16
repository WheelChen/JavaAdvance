package com.example.redisdemo.service.impl;

import com.example.redisdemo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author Kelvin Chen
 * @date 2021-09-12 15:55:39
 */
@Service
public class TestServiceImpl implements TestService {

    public static Integer a = 0;


    @Autowired
    private RedisTemplate<Object, Object> restTemplate;


    /**
     * 模拟从DB中获取数据
     * @return
     */
    @Override
    public Integer getFromDB() {
        return a;
    }


    @Override
    public void threadUnSafeTest() {
        for (int i = 0; i < 100; i++) {
            a = a + 1;
        }
        System.out.println("Value is " + a.toString());
    }


    @Override
    public void threadSafeTest() {
        Boolean lock = restTemplate.opsForValue().setIfAbsent("lock", 1, 1, TimeUnit.SECONDS);
        if (!lock) {
            return;
        }
        try {
            for (int i = 0; i < 1000; i++) {
                a = a + 1;
            }
            System.out.println("Value is " + a.toString());
        } finally {
            restTemplate.delete("lock");
        }

    }
}
