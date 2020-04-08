package com.mjm.jvm;

/**
 * intern() </br>
 *
 * jdk1.6以前：
 * intern() 会将首次遇到的 字符串实例复制到永久代中，返回的也是永久带中这个字符串实例的引用，而StringBuilder 创建的字符串在堆中
 *
 * jdk 1.7以后:
 * intern()不会再复制实例,只是在常量池中记录首次出现的实例引用,
 *
 * @author majunmin
 * @description
 * @datetime 2019/10/13 1:00 下午
 * @since
 */
public class RuntimeConstantPoolOOM2 {

    public static void main(String[] args) {
        /**
         * 计算机软件 首次出现， 放入常量池中， 所以  StringBuilder中的字符串 与 intern() 返回的引用是同一个
         */
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1 == str1.intern());

        /**
         * 而 java 并非首次出现
         */
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2 == str2.intern());
    }
}
