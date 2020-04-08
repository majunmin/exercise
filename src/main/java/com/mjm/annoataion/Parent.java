package com.mjm.annoataion;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2019-07-22 15:29
 * @since
 */
@MyAnnoation("Parent")
public abstract class Parent {

    @MyAnnoation("name")
    private String name;

    @MyAnnoation("age")
    private Integer age;

    @MyAnnoation("method sayHello()")
    public void sayHello(){
        System.out.println("HelloWorld");
    }

    @MyAnnoation("abstract method sayHello()")
    public abstract void testAbstractMethod();

}
