package week04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Kelvin Chen
 * @date 2021-07-18 17:35:58
 */
public class Work06 {
    private static final Lock lock = new ReentrantLock();
    private static final Condition isFinished = lock.newCondition();
    private static volatile int result;

    public static void main(String[] args) {

        long start=System.currentTimeMillis();

        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> {
            lock.lock();
            try {
                result = sum();
                isFinished.signalAll();
            } finally {
                lock.unlock();
            }
        });

        lock.lock();
        try {
            isFinished.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        executorService.shutdown();
    }

    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }
}
