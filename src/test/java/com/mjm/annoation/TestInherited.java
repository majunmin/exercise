package com.mjm.annoation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Inherited;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2019-01-31 15:09
 * @since
 */
public class TestInherited {

    public static void main(String[] args) {
        A a = new B();
        Annotation[] annotations = a.getClass().getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }
}


@DocumentA
class A {}

class B extends A{}
