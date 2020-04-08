package com.mjm;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2019/12/23 10:24 下午
 * @since
 */
public class LinkedHashMapTest {

    public static void main(String[] args) {
//        LinkedHashMap<String, Object> hashMap = new LinkedHashMap<String, Object>(16, 0.75f, true){
//            @Override
//            protected boolean removeEldestEntry(Map.Entry eldest) {
//                System.out.println("remove key-> "+ eldest.getKey() + ", value-> " + eldest.getValue());
//
//                return this.size() > 16;
//            }
//        };
//        for (int i = 0; i < 17; i++) {
//            hashMap.put(i + "", "i" + i);
//        }
//        System.out.println(hashMap.size());
//
//        hashMap.get("10");
//
//        System.out.println(hashMap.size());
        int tmp = 10;
        int i = 1;
        for (; i < 4; ++i) {
            tmp = tmp + 2 * i;
            Integer times = i;
            System.out.println("times: " + times);
            System.out.println("tmp: " + tmp);
        }

    }
}
