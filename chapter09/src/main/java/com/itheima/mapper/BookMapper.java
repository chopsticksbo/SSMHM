package com.itheima.mapper;

import com.itheima.entity.Book;

import java.util.List;

public interface BookMapper {


    Book queryByIdAndName(Book book);

    List<Book> findBooksWithSort(String sortType);



    List<Book> findBooksByIds(Integer[] ids);
    void updateBook(Book book);
}
