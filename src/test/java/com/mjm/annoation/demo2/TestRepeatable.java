package com.mjm.annoation.demo2;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2019-01-31 17:05
 * @since
 */
public class TestRepeatable {

    public static void main(String[] args) {

        Class<?> demo2Clazz = Demo2.class;

        FilterPath[] filterPaths = demo2Clazz.getAnnotationsByType(FilterPath.class);
        FilterPath[] declaredFilterPaths = demo2Clazz.getDeclaredAnnotationsByType(FilterPath.class);

        System.out.println("getAnnotationsByType");
        for (FilterPath filterPath : filterPaths) {
            System.out.println(filterPath.value());
        }

        System.out.println("getDeclaredAnnotationsByType");
        for (FilterPath filterPath : declaredFilterPaths) {
            System.out.println(filterPath.value());
        }
    }
}
