package com.mjm.type;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.List;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2020/2/29 10:56 上午
 * @since
 */
public class TypeVariableTest<T extends Number & Serializable, V> {

    T key;

    // TypeVariable
    V value;

    // GenericArrayType V[]-> V TypeVariable 两种混合起来了
    private V[] values;

    public static void main(String[] args) {

        Field[] declaredFields = TypeVariableTest.class.getDeclaredFields();
        Arrays.stream(declaredFields).forEach(field -> {
            System.out.println("=================" + field.getName() + "===========");
            if (field.getGenericType() instanceof TypeVariable) {
                //输出上边界
                System.out.println("====getBounds()  = " + ((TypeVariable)field.getGenericType()).getBounds());
                //输出名称
                System.out.println("====getName()   = " + ((TypeVariable)field.getGenericType()).getName());
                //输出所在的类的类型
                System.out.println("====getGenericDeclaration()   = " + ((TypeVariable)field.getGenericType()).getGenericDeclaration());
            }
        });
    }
}

