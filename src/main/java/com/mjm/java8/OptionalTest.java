package com.mjm.java8;

import java.util.Optional;

/**
 * 一句话功能简述 </br>
 *
 * Optional.of()或者Optional.ofNullable(): 创建Optional对象，差别在于of不允许参数是null，而ofNullable则无限制。
 * Optional.empty()：所有null包装成的Optional对象：
 *
 * @author majunmin
 * @description
 * @datetime 2019-07-18 21:05
 * @since
 */
public class OptionalTest {

    public static void main(String[] args) {
        Optional<Integer> o1 = Optional.ofNullable(null);
        Optional<Integer> o2 = Optional.ofNullable(null);
        Optional<Integer> o3 = Optional.<Integer>empty();
        // true
        System.out.println(o1 == o2);
        // true
        System.out.println(o1 == o3);

        System.out.println(o1.isPresent());
        System.out.println(o3.isPresent());

        Optional<Integer> optional1 = Optional.ofNullable(1);
        Optional<Integer> optional2 = Optional.ofNullable(null);

        Optional<String> str1Optional = optional1.map((a) -> "key" + a);
        Optional<String> str2Optional = optional2.map((a) -> "key" + a);

        System.out.println(str1Optional.get());// key1
        System.out.println(str2Optional.isPresent());// false
    }
}
