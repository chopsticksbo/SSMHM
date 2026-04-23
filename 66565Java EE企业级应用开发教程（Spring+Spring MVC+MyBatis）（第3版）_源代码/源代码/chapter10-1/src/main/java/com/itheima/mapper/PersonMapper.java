package com.itheima.mapper;

import com.itheima.entity.IDCard;
import com.itheima.entity.Person;
import org.apache.ibatis.annotations.*;

public interface PersonMapper {
    @Select("SELECT * FROM idcard WHERE cardId = #{cardId}")
    IDCard getIDCardByCardId(@Param("cardId") int cardId);
    @Select("SELECT p.id, p.name, i.cardId, i.cardNumber " +
            "FROM person p " +
            "LEFT JOIN idcard i ON p.idCardId = i.cardId " +
            "WHERE p.id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "idCard", column = "cardId",
                    javaType = IDCard.class, one = @One(select = "com.itheima.mapper.PersonMapper.getIDCardByCardId"))
    })
    Person getPersonById(@Param("id") int id);

}
