package com.mjm.mapstruct.mapper;

import com.mjm.mapstruct.model.Person;
import com.mjm.mapstruct.model.PersonVo;
import com.mjm.mapstruct.util.MapStructUtils;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Stream;

@Mapper(uses = MapStructUtils.class)
public interface Person2PersonVoMapper {

    Person2PersonVoMapper MAPPER = Mappers.getMapper(Person2PersonVoMapper.class);

    /**
     * po 转 vo
     *
     * @param person
     * @return
     */
    @Mappings({
            @Mapping(source = "birthdate", target = "birth"),//属性名不一致映射
//            @Mapping(target = "birthformat", expression = "java(org.apache.commons.lang3.time.DateFormatUtils.format(person.getBirthdate(),\"yyyy-MM-dd HH:mm:ss\"))"),//自定义属性通过java代码映射
            @Mapping(source = "birthdate", target = "birthformat", dateFormat = "yyyy-MM-dd HH:mm:ss"),//自定义属性通过java代码映射

    })
    PersonVo personToPersonVo(Person person);

    /**
     * vo转po
     *
     * @param personVo
     * @return
     */
    @InheritInverseConfiguration(name = "personToPersonVo")
    Person personVoToPerson(PersonVo personVo);

    /**
     * vo 更新 po
     *
     * @param personVo
     * @param person
     */
    @Mappings({
            @Mapping(target = "birthdate", source = "birth")
    })
    void updatePersonVo(PersonVo personVo, @MappingTarget Person person);

    @InheritInverseConfiguration(name = "updatePersonVo")
    void updatePerson(Person person, @MappingTarget PersonVo personVo);

    List<PersonVo> personToPersonVos(List<Person> list);

    /**
     * 使用stream
     */
    List<PersonVo> personToPersonVos(Stream<Person> stream);
}
