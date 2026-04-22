package com.itheima.mapper;

import com.itheima.entity.Book;

public interface BookMapper {
    Book queryByIdAndName(Book book);
}
