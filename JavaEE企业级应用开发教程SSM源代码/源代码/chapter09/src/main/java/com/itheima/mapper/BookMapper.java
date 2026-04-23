package com.itheima.mapper;

import com.itheima.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BookMapper {
    //根据传入的id和名称信息查询对应图书
    Book queryByIdAndName(Book book);
 List<Book> findBooksWithSort(String sortType);
    List<Book> findBooksByIds(Integer[] ids);
    void batchInsertBooks(List<Book> books);
    List<Book> queryByConditions(@Param("conditions")Map<String, String> conditions);
    void updateBook(Book book);

}
