package com.mjm.classs.reflect;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2020/1/21 10:20 上午
 * @since
 */
public class User {

    private String name;
    private String description;
    private Integer age;

    public User(){}
    public User(String name){
        this.name = name;
    }
    private User(String name, String description, Integer age){
        this.name = name;
        this.description = description;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private Integer incAge(){
        return ++age;
    }
}
