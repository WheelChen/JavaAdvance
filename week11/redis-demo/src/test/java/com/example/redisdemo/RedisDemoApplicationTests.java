package com.example.redisdemo;

import com.example.redisdemo.entity.Order;
import com.example.redisdemo.redis.RedisTemplateClient;
import com.example.redisdemo.redis.mq.RedisOrderMessagePublisher;
import com.example.redisdemo.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
@SpringBootTest(classes = RedisDemoApplication.class)
class RedisDemoApplicationTests {

    @Autowired
    private RedisOrderMessagePublisher redisOrderMessagePublisher;

    @Autowired
    private TestService testService;

    @Autowired
    private RedisTemplateClient redisTemplateClient;




    /**
     * 线程不安全测试
     */
    @Test
    void threadUnSafeTest() {
        new ConcurrentTest().begin(10 ,
                () -> testService.threadUnSafeAdd(),
                () -> System.out.println(testService.getFromDB()));

        Assertions.assertEquals(0, testService.getFromDB() % 1000);
    }

    /**
     * 分布式锁测试
     */
    @Test
    void threadSafeTest() {
        String requestId = "1";
        String LOCK_KEY = "LOCK";

        new ConcurrentTest().begin(10 ,
                () -> {
                    Boolean lock = redisTemplateClient.acquireLock(LOCK_KEY, requestId, 100, TimeUnit.SECONDS);
                    if (Boolean.FALSE.equals(lock)) {
                        return;
                    }
                    try {
                        testService.threadUnSafeAdd();
                    } finally {
                        redisTemplateClient.releaseLock(LOCK_KEY, requestId);
                    }
                },
                () -> {
                    Assertions.assertEquals(0, testService.getFromDB() % 1000);
                });
    }

    /**
     * 分布式计数器 测试
     */
    @RepeatedTest(1)
    void distributedCounterTest() {
        Long activityId = System.currentTimeMillis();
        Integer stockNum = ThreadLocalRandom.current().nextInt(1000) + 1;


        testService.createSeckillStock(activityId, stockNum);
        AtomicInteger cnt = new AtomicInteger();

        new ConcurrentTest().begin(stockNum * 2 ,
                () -> {
                    Boolean result = testService.generateSeckillOrder(activityId);
                    if (result) {
                        cnt.incrementAndGet();
                    }
                },
                () -> Assertions.assertEquals(stockNum, cnt.get()));
    }


    /**
     * Redis Pub/Sub 订单异步处理
     */
    @Test
    void pubSubOrderTest() {
        Order order = new Order();
        order.setOrderId(System.currentTimeMillis());
        redisOrderMessagePublisher.publish(order);
    }

}
