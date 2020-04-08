package com.mjm.annoation;

import java.lang.ref.Reference;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2019-01-31 14:48
 * @since
 */
public @interface AnnoationElementDemo {

    enum Status {FIXED, NORMAL}

    Status status() default Status.FIXED;

    boolean supportA() default false;

    String name() default "";

    Class<?> testCase() default Void.class;

    long[] value();

}
