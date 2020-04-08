package com.mjm.annoation.demo;

import lombok.Data;

import java.io.Serializable;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2019-01-31 15:30
 * @since
 */
@DBTable(name = "member")
@Data
public class Member implements Serializable {

    @SqlInteger(name = "id", constraint = @Constraints(primaryKey = true))
    private Integer id;

    @SqlString(name = "name", value = 30)
    private String name;

    @SqlInteger(name = "age")
    private Integer age;

    @SqlString(name = "description", value = 200, constraint = @Constraints(allowNull = true))
    private String description;
}
