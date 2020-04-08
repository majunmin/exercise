package com.mjm;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2019-02-14 17:20
 * @since
 */
public class JavaTest {

    public static String str = "aa";

    public static void main(String[] args) {
        String a = "ttsdfffffffffffffffffffffff";
        for (int i = 0; i < 1000_000_000; ++i) {
            str = a + i;
        }
    }
}
