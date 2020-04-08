package com.mjm.proxy.cglib;

import net.sf.cglib.core.DebuggingClassWriter;

/**
 * cglib 采用字节码技术实现动态代理功能，其原理是通过字节码技术为目标类生成一个子类， 并在该子类中采用方法拦截的方式拦截所有父类方法的调用，从而实现代理的功能。
 * 因为 cglib 使用 生成子类的方式实现动态代理，所以无法代理 final 关键宇修饰的方法。
 * cglib 与 JDK 动态 代理之间可以相互补充:
 *     在目标类实现接口时，使用 JDK 动态代理创建代理对象，但当目标类没有实现接口时，使用 cglib 实现动态代理的功能。
 * 在 Spring, MyBatis 等多种开源框架中，都可以看到 JDK 动态代理与 cglib 结合使用的场景。
 *
 * @author majunmin
 * @description
 * @datetime 2019-08-23 17:20
 * @since
 */
public class CglibProxyTest {

    public static void main(String[] args) {

        // 添加如下代码，获取代理类源文件
        String path = CGLibProxy.class.getResource(".").getPath();
        System.out.println(path);
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, path);
        //-------------------------------------------------

        SuperMan superMan = new SuperMan();
        CGLibProxy cgLibProxy = new CGLibProxy();
        Object obj = cgLibProxy.bind(superMan);
        System.out.println(obj.getClass());
        SuperMan man = (SuperMan)obj;
        man.fly();
    }
}
