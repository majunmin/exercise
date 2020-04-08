package com.mjm.mapstruct.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author majunmin
 * @description
 * @datetime 2020/4/1 6:06 下午
 * @since
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String name;
    private Integer age;
    private Date birthdate;
    private float wallet;
}
