package week04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Kelvin Chen
 * @date 2021-07-18 20:31:59
 */
public class Work07 {
    public volatile int result;
    public synchronized void waiting() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized int work() {
        try {
            return sum();
        } finally {
            notifyAll();
        }
    }
    public static void main(String[] args) {

        long start=System.currentTimeMillis();
        Work07 work07 = new Work07();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> {
            work07.result = work07.work();
        });

        work07.waiting();

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+work07.result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // 然后退出main线程
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
