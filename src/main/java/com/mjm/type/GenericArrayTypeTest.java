package com.mjm.type;

import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.util.Arrays;
import java.util.List;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2020/2/29 11:17 上午
 * @since
 */
public class GenericArrayTypeTest<T> {

    //泛型数组类型
    private T[] value;
    private List<String>[] list;


    public static void main(String[] args) {

        Field[] declaredFields = GenericArrayTypeTest.class.getDeclaredFields();
        Arrays.stream(declaredFields).forEach(field -> {
            if (field.getGenericType() instanceof GenericArrayType){
                if (field.getGenericType() instanceof GenericArrayType){
                    //如果是GenericArrayType，则输出当前泛型类型
                    System.out.println("Field: "
                            + field.getName()
                            + "; getGenericComponentType(): "
                            + (((GenericArrayType) field.getGenericType()).getGenericComponentType()));
                }
                /**
                 * result
                 * Field: value; getGenericComponentType(): T
                 * Field: list; getGenericComponentType(): java.util.List<java.lang.String>
                 */
            }
        });

    }
}
