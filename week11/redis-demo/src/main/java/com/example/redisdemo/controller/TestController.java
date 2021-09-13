package com.example.redisdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * @author Kelvin Chen
 * @date 2021-09-12 12:28:48
 */
@RestController
public class TestController {
    static Integer a = 0;


    @GetMapping("/test")
    public String test() {
        a++;
        System.out.println("get Lock " + a);
        return a.toString();
    }
}
