package com.mjm.proxy.jdk;

import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * jdk 动态代理 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2019-08-23 17:46
 * @since
 */
public class JdkProxyTest {

    public static void main(String[] args) {

//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
//        Hello hello = new Hello();
//
//        Object proxyInstance = Proxy.newProxyInstance(IHello.class.getClassLoader(),
//                hello.getClass().getInterfaces(),
//                new MyInvokcationHandler(hello));
//
//        IHello helloProxy = (IHello)proxyInstance;
//        helloProxy.sayHello();


        byte[] aaas = ProxyGenerator.generateProxyClass("aaa", new Class[]{IHello.class});
        try {
            FileOutputStream fos = new FileOutputStream("./aaa.class");
            fos.write(aaas);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
