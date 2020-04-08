package com.mjm.classs.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 构造函数 使用  </br>
 *
 * forName()
 * getConstructor(Class<?>... parameterTypes)  返回指定参数类型、具有public访问权限的构造函数对象
 * getConstructor()                            返回指所有具有public访问权限的构造函数对象
 * getDeclaredConstructor(Class<?>... parameterTypes) 返回指定参数类型、所有声明的（包括private）构造函数对象
 * getDeclaredConstructor()                    返回所有声明的（包括private）构造函数对象
 * newInstance()
 *
 * @author majunmin
 * @description
 * @datetime 2020/1/21 10:22 上午
 * @since
 */
public class ConstructorTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clazz = Class.forName("com.mjm.classs.reflect.User");
        // 获取所有的 Constructor 包括 privae
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            if (declaredConstructor.getParameterCount() == 3){
                /**
                 * private() 必须设置可访问， 暴力破解
                 */
                declaredConstructor.setAccessible(true);
                Object o = declaredConstructor.newInstance("mjj", "people", 30);
            }
        }
    }
}
