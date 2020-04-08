package com.mjm.annoataion;

import java.lang.annotation.*;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2019-07-22 15:32
 * @since
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.TYPE})
public @interface MyAnnoation {

    String value() default "";
}
