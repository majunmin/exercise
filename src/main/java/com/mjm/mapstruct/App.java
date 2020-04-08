package com.mjm.mapstruct;

import com.mjm.mapstruct.mapper.Person2PersonVoMapper;
import com.mjm.mapstruct.model.Person;
import com.mjm.mapstruct.model.PersonVo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author majunmin
 * @description
 * @datetime 2020/4/1 6:06 下午
 * @since
 */
public class App {

    public static void main(String[] args) {
        convert();
        convertList();
        convertReverse();
        updateVo();

    }

    private static void updateVo() {
        Person person = new Person("wayne", 12, new Date(), 12f);
        PersonVo personVo = Person2PersonVoMapper.MAPPER.personToPersonVo(person);
        //Person person2=new Person("handsome wayne",92,new Date(new Date().getTime()+9800000),92f);
        personVo.setName("handsome wayne");
        personVo.setAge(92);
        personVo.setBirth(new Date(System.currentTimeMillis() + 9800000));
        Person2PersonVoMapper.MAPPER.updatePersonVo(personVo, person);

        System.out.println(person);
    }

    private static void convertReverse() {
        Person person = new Person("wayne", 12, new Date(), 12.1231231f);
        PersonVo personVo = Person2PersonVoMapper.MAPPER.personToPersonVo(person);
        System.out.println(personVo);
        //Inverse 反转
        personVo.setBirthformat("2017-05-28 19:59:27");
        personVo.setBirth(new Date(System.currentTimeMillis() + 3600_000L));
        Person person1 = Person2PersonVoMapper.MAPPER.personVoToPerson(personVo);
        System.out.println(person1);
    }

    private static void convertList() {
        Person person = new Person("wayne", 12, new Date(), 12f);
        Person person2 = new Person("wayne2", 13, new Date(System.currentTimeMillis() + 3600L), 13f);
        Person person3 = new Person("wayne3", 14, new Date(System.currentTimeMillis() + 3600L), 14f);
        Person person4 = new Person("wayne4", 15, new Date(System.currentTimeMillis() + 3600L), 15f);
        List<Person> list = new ArrayList();
        list.add(person);
        list.add(person2);
        list.add(person3);
        list.add(person4);
        List<PersonVo> personVos = Person2PersonVoMapper.MAPPER.personToPersonVos(list);

    }

    private static void convert() {
        Person person = new Person("wayne", 12, new Date(), 12f);
        PersonVo personVo = Person2PersonVoMapper.MAPPER.personToPersonVo(person);
        System.out.println(personVo);
    }
}
