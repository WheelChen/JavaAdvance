package com.example.redisdemo.service;

/**
 * @author Kelvin Chen
 * @date 2021-09-12 15:51:49
 */
public interface TestService {

    Integer getFromDB();

    /**
     * 线程不安全测试
     */
    void threadUnSafeAdd();


    /**
     * 创建秒杀活动库存缓存
     *
     * @param activityId 秒杀活动id
     */
    void createSeckillStock(Long activityId, Integer stockNum);

    /**
     * 创建秒杀订单
     *
     * @param activityId
     * @return
     */
    Boolean generateSeckillOrder(Long activityId);
}
