package com.mjm.future;

import com.sun.xml.internal.ws.util.CompletedFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2020/2/5 3:08 下午
 * @since
 */
public class CompletableFutureTest {

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.supplyAsync(() -> {
//            System.out.println("hello Wprld!");
            try {
                TimeUnit.SECONDS.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello";
        }).thenAccept(str-> System.out.println(str));

        TimeUnit.SECONDS.sleep(100);
    }
}
