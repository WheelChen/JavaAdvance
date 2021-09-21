package com.example.redisdemo.service.impl;

import com.example.redisdemo.entity.Order;
import com.example.redisdemo.redis.mq.RedisOrderMessagePublisher;
import com.example.redisdemo.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author Kelvin Chen
 * @date 2021-09-12 15:55:39
 */
@Slf4j
@Service
public class TestServiceImpl implements TestService {

    public static Integer a = 0;

    /**
     * 活动库存前缀
     */
    public static final String ACTIVITY_STOCK_PREFIX ="ACTIVITY_STOCK";

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private RedisOrderMessagePublisher redisOrderMessagePublisher;



    /**
     * 模拟从DB中获取数据
     * @return
     */
    @Override
    public Integer getFromDB() {
        return a;
    }


    @Override
    public void threadUnSafeAdd() {
        for (int i = 0; i < 1000; i++) {
            a = a + 1;
        }
    }

    /**
     * 创建秒杀活动
     *
     * @param activityId 秒杀活动id
     */
    @Override
    public void createSeckillStock(Long activityId, Integer stockNum) {
        String activityStockKey = generateActivityStockKey(activityId);
        redisTemplate.opsForValue().set(activityStockKey, stockNum);
        log.info("创建活动id {} 库存 {}", activityId, stockNum);
    }

    @Override
    public Boolean generateSeckillOrder(Long activityId) {
        String activityStockKey = generateActivityStockKey(activityId);

        Long stockNum = redisTemplate.opsForValue().decrement(activityStockKey);

        if (Objects.isNull(stockNum) || stockNum.compareTo(0L) < 0) {
            return false;
        }
        return true;
    }

    /**
     * 生成活动库存KEY
     *
     * @param activityId 活动id
     * @return
     */
    public static String generateActivityStockKey(Long activityId) {
        String stockKey = ACTIVITY_STOCK_PREFIX + ":" + activityId;
        return stockKey;
    }
}
