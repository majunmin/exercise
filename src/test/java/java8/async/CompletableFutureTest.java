package java8.async;

import com.sun.xml.internal.ws.util.CompletedFuture;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2019-02-13 16:07
 * @since
 */
public class CompletableFutureTest {

    @Test
    public void test1() {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        Future<Integer> future = pool.submit(() -> {

            TimeUnit.SECONDS.sleep(10);

            return 100;
        });

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("binbin");
    }

    @Test
    public void test2() throws ExecutionException, InterruptedException, TimeoutException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 100;
        });
        System.out.println(future.get(1L, TimeUnit.SECONDS));

        System.out.println("pingping");
    }
}
