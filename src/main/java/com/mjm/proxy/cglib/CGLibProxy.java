package com.mjm.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2019-08-23 17:27
 * @since
 */
public class CGLibProxy implements MethodInterceptor {

    private Object target;

    public Object bind(Object obj){
        this.target = obj;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(obj.getClass()); // 指定生成代理类的 父类
        enhancer.setCallback(this); // 设置 Callback 对象
        return enhancer.create(); // 通过字节码技术动态创建子类实例
    }


    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        Object obj = null;

        System.out.println("before: test--------");
        obj = method.invoke(target, args);
        System.out.println("after: test--------");
        return obj;
    }
}
