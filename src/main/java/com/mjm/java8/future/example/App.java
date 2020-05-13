package com.mjm.java8.future.example;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @author majunmin
 * @description
 * @datetime 2020/5/12 5:37 下午
 * @since
 */
public class App {

    private static final List<Shop> shops = Arrays.asList(new Shop("全时"),
            new Shop("便利峰"),
            new Shop("Bst Price"));

    public static void main(String[] args) {

        Instant start = Instant.now();
        findPrices("niunai");
        Instant end = Instant.now();
        System.out.println("cost Time " + Duration.between(start, end).toMillis() + "ms");
    }

    public static List<String> findPrices(String product){
//        return shops.stream().parallel()
//                .map(shop -> shop.getPrice(product))
//                .map(Quote::parse)
//                .map(Discount::applyDiscount)
//                .collect(Collectors.toList());

        List<CompletableFuture<String>> completableFutures = shops.stream().parallel()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice(product))) // 异步执行
                .map(future -> future.thenApply(Quote::parse))  // 结果转换 同步
                .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote)))) // 异步执行
//                .map(future  ->  future.thenApply(Discount::applyDiscount))
                .collect(Collectors.toList());

        return completableFutures.stream()
                .map(CompletableFuture::join) // 等􏱛流中的所有Future􏱎行 􏲣􏶮，并提取􏶯自的􏲄􏲅􏲆
                .collect(Collectors.toList());

    }
}
