package com.mjm.map;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2019-01-29 18:35
 * @since
 */
public class ConcurrentHashMapCacheTest {

    private final ConcurrentHashMap<String, String> cache = new ConcurrentHashMap<>();

    public void putCache(String key, String threadName){
        cache.put(key, threadName);
    }

    public String getCache(String keyVal, String threadName){
        String value = cache.get(keyVal);
        if (value == null){
            return cache.put(keyVal, threadName);
        }
        return threadName;
    }

    public static void main(String[] args) {
        ConcurrentHashMapCacheTest concurrentHashMapCache = new ConcurrentHashMapCacheTest();

        ExecutorService pool = Executors.newFixedThreadPool(5);

        pool.submit(() ->{
            System.out.println("Thread " + Thread.currentThread().getName() + " start!");
            String val = concurrentHashMapCache.getCache("key", Thread.currentThread().getName());
            System.out.println(val);
            System.out.println("Thread " + Thread.currentThread().getName() + " end!");
        });

        pool.submit(() ->{
            System.out.println("Thread " + Thread.currentThread().getName() + " start!");
            String val = concurrentHashMapCache.getCache("key", Thread.currentThread().getName());
            System.out.println(val);
            System.out.println("Thread " + Thread.currentThread().getName() + " end!");
        });

        pool.submit(() ->{
            System.out.println("Thread " + Thread.currentThread().getName() + " start!");
            String val = concurrentHashMapCache.getCache("key", Thread.currentThread().getName());
            System.out.println(val);
            System.out.println("Thread " + Thread.currentThread().getName() + " end!");
        });

        pool.submit(() ->{
            System.out.println("Thread " + Thread.currentThread().getName() + " start!");
            String val = concurrentHashMapCache.getCache("key", Thread.currentThread().getName());
            System.out.println(val);
            System.out.println("Thread " + Thread.currentThread().getName() + " end!");
        });

        pool.shutdown();
    }
}
