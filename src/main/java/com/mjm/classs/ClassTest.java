package com.mjm.classs;

/**
 * class 类型判断 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2020/1/21 9:49 上午
 * @since
 */
public class ClassTest {

    public static void main(String[] args) {
        instanceTest(new Parent());
        instanceTest(new Child());
    }

    private static void instanceTest(Object object) {
        Class objType = object.getClass();
        System.out.println("=========Type object: " + objType);
        System.out.println("object instanceof Parent: " + (object instanceof Parent));
        System.out.println("object instanceof Child: " + (object instanceof Child));
        System.out.println("Parent.class.isAssignableFrom(objType): " + (Parent.class.isAssignableFrom(objType)));
        System.out.println("Child.class.isAssignableFrom(objType): " + (Child.class.isAssignableFrom(objType)));
        System.out.println("Parent.class.isInstance(objType): " + (Parent.class.isInstance(object)));
        System.out.println("Child.class.isInstance(objType): " + (Child.class.isInstance(object)));

    }
}
