package com.mjm;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2019/12/18 3:44 下午
 * @since
 */
public class SynchronizedTest {

    public static void main(String[] args) {

        System.out.println(Integer.valueOf(127) == Integer.valueOf(127));
//        IntStream.rangeClosed(1, 100).forEach(SynchronizedTest::printLv);
//
//
//        HashMap<String, String> stringStringHashMap = new HashMap<>();
//        List<CacheTest.User> list = new ArrayList<>();
//        list.add(new CacheTest.User("pp"));
//        list.add(new CacheTest.User("ppd"));
//        list.add(new CacheTest.User("ppd"));
//        list.add(new CacheTest.User("hucun"));
//
//        Map<String, Set<String>> collect = list.stream().collect(Collectors.groupingBy(CacheTest.User::getName,
//                Collectors.mapping(CacheTest.User::getName, Collectors.toSet())));
    }

    public static synchronized void printLv(int i){
        new Thread(() ->{
            System.out.println(i);
        }).start();
    }


}
