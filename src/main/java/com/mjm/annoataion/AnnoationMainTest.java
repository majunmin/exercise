package com.mjm.annoataion;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2019-07-22 15:36
 * @since
 */
public class AnnoationMainTest {
    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException {
        Class<Children> clazz = Children.class;

        Method sayHello = clazz.getMethod("sayHello", new Class[0]);
        sayHello.setAccessible(true);
        System.out.println(sayHello.getDeclaredAnnotations());

        Method testAbstractMethod = clazz.getMethod("testAbstractMethod", new Class[0]);
        testAbstractMethod.setAccessible(true);
        System.out.println(testAbstractMethod.getDeclaredAnnotations());

//        Field name = clazz.getDeclaredField("name");
//        name.setAccessible(true);
//        System.out.println(name.getDeclaredAnnotations());

        System.out.println(clazz.getDeclaredAnnotations());
    }
}
