package week04;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author Kelvin Chen
 * @date 2021-07-20 23:36:42
 */
public class Work10 {
    public static void main(String[] args) {

        long start=System.currentTimeMillis();

        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(Work10::sum);

        try {
            System.out.println("异步计算结果为："+ integerCompletableFuture.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

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
