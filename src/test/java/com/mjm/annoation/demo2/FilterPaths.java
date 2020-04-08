package com.mjm.annoation.demo2;

import java.lang.annotation.*;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2019-01-31 17:02
 * @since
 */
@Inherited
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface FilterPaths {

    FilterPath[] value();
}
