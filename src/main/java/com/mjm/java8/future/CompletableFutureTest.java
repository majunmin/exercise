package com.mjm.java8.future;

import org.apache.commons.lang3.RandomUtils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

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
        testSupplyAsync();
//        CompletableFuture.supplyAsync(() -> {
//            System.out.println("hello Wprld!");
//            try {
//                TimeUnit.SECONDS.sleep(10L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "Hello";
//        }).thenAccept(str-> System.out.println(str));
//
//        TimeUnit.SECONDS.sleep(100);
    }


    public static void testSupplyAsync(){
        CompletableFuture<Double> completableFuture = CompletableFuture.supplyAsync(CompletableFutureTest::calculatePrice);
        try {
            System.out.println(completableFuture.get(10, TimeUnit.SECONDS));
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }
    }

    public static double calculatePrice(){
        try {
            TimeUnit.SECONDS.sleep(RandomUtils.nextInt(4, 10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return RandomUtils.nextInt(4, 100) * 0.01;
    }
}
