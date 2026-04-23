package com.itheima.mapper;

import com.itheima.entity.Member;
import com.itheima.entity.Order;
import org.apache.ibatis.annotations.*;
import java.util.List;

public interface MemberMapper {
    @Select("SELECT id, memberId, orderNumber FROM `order` " +
            "WHERE memberId = #{memberId}")
    List<Order> selectOrdersByMemberId(@Param("memberId") int memberId);
    @Select("SELECT id, name FROM member WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "orders", column = "id",
                    javaType = List.class,
                    many = @Many(
                            select = "com.itheima.mapper.MemberMapper.selectOrdersByMemberId"))
    })
    Member getMemberWithOrders(@Param("id") int id);
}
