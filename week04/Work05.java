package week04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Kelvin Chen
 * @date 2021-07-18 16:19:44
 */
public class Work05 {
    private static volatile boolean flag = false;

    public static void main(String[] args) {

        long start=System.currentTimeMillis();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        AtomicInteger result = new AtomicInteger();
        executorService.submit(() -> {
            result.set(sum());
            flag = true;
        });

        // 等待子线程完成
        while (!flag) {}
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
