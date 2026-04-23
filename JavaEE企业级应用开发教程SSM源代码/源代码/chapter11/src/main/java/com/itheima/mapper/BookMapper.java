package com.itheima.mapper;

import com.ithema.entity.Book;

public interface BookMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Book row);

    int insertSelective(Book row);

    Book selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Book row);

    int updateByPrimaryKey(Book row);
}