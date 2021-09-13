package com.example.redisdemo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Kelvin Chen
 * @date 2021-09-12 16:59:05
 */
public class ConcurrentTest {
    /**
     * 多线程测试用例
     * @param threadCount 开启线程数
     * @param run 线程执行方法
     * @param finish 线程全部执行结束后运行方法
     */
    public void begin(int threadCount,Run run,Finish finish){
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(threadCount);
        for (int i = 0; i < threadCount; i++) {
            fixedThreadPool.execute(()->{
                try {
                    countDownLatch.await();
                    run.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        countDownLatch.countDown();
        fixedThreadPool.shutdown();
        while (!fixedThreadPool.isTerminated()){ }
        finish.finish();
    }
}
