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
    void threadUnSafeTest();

    /**
     * 线程安全测试
     */
    void threadSafeTest();
}
