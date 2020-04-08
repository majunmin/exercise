package com.mjm.classs.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2020/1/21 10:57 上午
 * @since
 */
public class MethodTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> clazz = Class.forName("com.mjm.classs.reflect.User");
        Method[] methods = clazz.getMethods();
        Method[] declaredMethods = clazz.getDeclaredMethods();

        User user = (User)clazz.newInstance();
        user.setAge(18);
        Method incAge = clazz.getDeclaredMethod("incAge");
        incAge.setAccessible(true);
        Class<?> returnType = incAge.getReturnType();
        Object invoke = incAge.invoke(user);
        System.out.println(returnType.cast(invoke   ));
    }
}
