package com.mjm.lock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 作者 E-mail:
 * @version 创建时间：2015-10-23 下午01:47:03 类说明
 */
public class TestLock {

    public void test() throws Exception {

        List<String> list = Arrays.asList("480p", "1080p", "240p");
        list.stream().min(Comparator.comparing(str -> Integer.parseInt(str.substring(0, str.length() - 1)))).ifPresent(System.out::println);
//        final Lock lock = new ReentrantLock();
//        lock.lock();
//
//
//        Thread t1 = new Thread(() -> {
//            try {
//                lock.lockInterruptibly();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + " interrupted.");
//        }, "child thread -1");
//
//        t1.start();
//        Thread.sleep(1000);
//
//        t1.interrupt();
//
//        Thread.sleep(1000000);
    }

    public static void main(String[] args) throws Exception {
        new TestLock().test();
    }
}