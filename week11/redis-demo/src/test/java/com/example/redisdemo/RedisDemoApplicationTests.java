package com.example.redisdemo;

import com.example.redisdemo.service.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RedisDemoApplicationTests {

    @Autowired
    private TestService testService;

    /**
     * 线程不安全测试
     */
    @Test
    void threadUnSafeTest() {
        new ConcurrentTest().begin(10 ,
                () -> testService.threadUnSafeTest(),
                () -> System.out.println(testService.getFromDB()));
    }

    @Test
    void threadSafeTest() {
        new ConcurrentTest().begin(10 ,
                () -> testService.threadSafeTest(),
                () -> System.out.println(testService.getFromDB()));
    }



}
