package com.mjm.annoation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2019-01-31 14:38
 * @since
 */
public class AnnoationDemo extends A{

    /**
     * Deprecated   标记类或者方法 过期 过时
     * SuppressWarnings
     *
     * deprecation：使用了不赞成使用的类或方法时的警告；
     * unchecked：执行了未检查的转换时的警告，例如当使用集合时没有用泛型 (Generics) 来指定集合保存的类型;
     * fallthrough：当 Switch 程序块直接通往下一种情况而没有 Break 时的警告;
     * path：在类路径、源文件路径等中有不存在的路径时的警告;
     * serial：当在可序列化的类上缺少 serialVersionUID 定义时的警告;
     * finally：任何 finally 子句不能正常完成时的警告;
     * all：关于以上所有情况的警告。
     */
    @Deprecated
    @SuppressWarnings("uncheck")
    public void testA(){

    }

    public static void main(String[] args) {
        Class<?> clazz = AnnoationDemo.class;

        /**
         * 返回指定类型的注解 没有再返回 null
         */
        DocumentA annotation = clazz.getAnnotation(DocumentA.class);
        System.out.println("A : " + annotation);

        // 取该元素上的所有注解，包含从父类继承(@Inherited)
        Annotation[] annotations = clazz.getAnnotations();

        // 取该元素上的所有注解，不包含从父类继承(@Inherited)
        Annotation[] declaredAnnotations = clazz.getDeclaredAnnotations();

        //判断注解DocumentA是否在该元素上
        boolean flag = clazz.isAnnotationPresent(DocumentA.class);


    }
}
