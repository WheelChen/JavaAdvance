package week04;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Kelvin Chen
 * @date 2021-07-18 12:09:12
 */
public class Work03 {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        Semaphore semaphore = new Semaphore(0);

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        AtomicInteger result = new AtomicInteger();
        executorService.submit(() -> {
            result.set(sum());
            semaphore.release();
        });

        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("异步计算结果为：" + result);

        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

        executorService.shutdown();
    }

    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if (a < 2)
            return 1;
        return fibo(a - 1) + fibo(a - 2);
    }
}
