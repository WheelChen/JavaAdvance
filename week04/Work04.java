package week04;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Kelvin Chen
 * @date 2021-07-18 12:36:26
 */
public class Work04 {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        AtomicInteger result = new AtomicInteger();
        Thread t = new Thread(() -> result.set(sum()));
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("异步计算结果为：" + result);

        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
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
