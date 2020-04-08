package com.mjm.classs.reflect;

import java.lang.reflect.Field;

/**
 * 一句话功能简述 </br>
 * <p>
 * |方法返回值    |	方法名称	                 |方法说明|
 * | ----  | ---- | ---- |
 * |Field	 |getDeclaredField(String name)	 |获取指定name名称的(包含private修饰的)字段，不包括继承的字段 |
 * |Field[]	 |getDeclaredField()	         |获取Class对象所表示的类或接口的所有(包含private修饰的)字段,不包括继承的字段 |
 * |Field	 |getField(String name)	         |获取指定name名称、具有public修饰的字段，包含继承字段 |
 * |Field[]	 |getField()	                 |获取修饰符为public的字段，包含继承字段 |
 *
 * @author majunmin
 * @description
 * @datetime 2020/1/21 10:52 上午
 * @since
 */
public class FieldTest {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class<?> clazz = Class.forName("com.mjm.classs.reflect.User");
        Field[] fields = clazz.getFields();
        Field[] declaredFields = clazz.getDeclaredFields();
        Field name = clazz.getDeclaredField("name");
    }
}
