package week04;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author Kelvin Chen
 * @date 2021-07-17 18:01:36
 */
public class Work02 {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        FutureTask<Integer> task = new FutureTask<>(Work02::sum);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(task);

        try {
            System.out.println("异步计算结果为：" + task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

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
