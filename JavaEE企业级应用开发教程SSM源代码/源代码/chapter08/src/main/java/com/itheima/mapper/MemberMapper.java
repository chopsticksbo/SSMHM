package com.itheima.mapper;

import com.itheima.entity.Member;

public interface MemberMapper {
    Member getMemberWithOrders(int id);
}
