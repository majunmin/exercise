package com.mjm.type;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2020/2/29 10:31 上午
 * @since
 */
public class ParameterizedTypeDemo {

    //是ParameterizedType
    private HashMap<String, Object> map;
    private HashSet<String> set;
    private List<String> list;
    private Class<?> clz;

    //不是ParameterizedType
    private Integer i;
    private String str;


    public static void main(String[] args) {
        getParameterizedTypeWithName("map");
        getParameterizedTypeWithName("set");
        getParameterizedTypeWithName("str");
    }

    public static void printParameterizedType() {
        Field[] declaredFields = ParameterizedTypeDemo.class.getDeclaredFields();
        //打印是否是ParameterizedType类型
        Stream.of(declaredFields).forEach(field -> {
            System.out.println("FieldName:  " + field.getName() + " instanceof ParameterizedType is : " +
                    (field.getGenericType() instanceof ParameterizedType));
        });
    }

    private static void getParameterizedTypeWithName(String name) {
        System.out.println("=============== " + name + " ===============");
        Field field;
        try {
            //利用反射得到TestParameterizedTypeBean类中的所有变量
            field = ParameterizedTypeDemo.class.getDeclaredField(name);
            field.setAccessible(true);

            Type type = field.getGenericType();
            if (type instanceof ParameterizedType) {
                System.out.println("--- getActualTypeArguments() ---");
                for (Type param : ((ParameterizedType) type).getActualTypeArguments()) {
                    //打印实际参数类型
                    System.out.println(param.toString());
                }
                //打印所在的父类的类型
                System.out.println("---getOwnerType() ---\n" + ((ParameterizedType) type).getOwnerType());
                //打印其本身的类型
                System.out.println("---getRawType()---\n" + ((ParameterizedType) type).getRawType());
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
