package com.mjm.proxy.jdk;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2019-08-23 17:43
 * @since
 */
public class Hello implements IHello {
    @Override
    public void sayHello() {
        System.out.println("hello world!");
    }
}
