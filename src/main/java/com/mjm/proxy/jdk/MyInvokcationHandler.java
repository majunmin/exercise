package com.mjm.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * jdk 动态代理 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2019-08-23 17:44
 * @since
 */
public class MyInvokcationHandler implements InvocationHandler {

    private Object target;

    public MyInvokcationHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before: ++++++++++++=");
        Object res = method.invoke(target, args);
        System.out.println("after: ++++++++++++=");
        return res;
    }
}
