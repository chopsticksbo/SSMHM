package itheima.mapper;

import itheima.entity.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BookMapper {
    @Select("select * from book where id = #{id} and name = #{name}")
    Book queryByIdAndName(Book book);
    @Select("select * from book order by #{sortType}")
    List<Book> findBooksWithSort(String sortType);
    @Select("select * from book where id in (#{ids})")
    List<Book> findBooksByIds(Integer[] ids);
    @Update("update book set price = #{price} where id = #{id}")
    int updateBook(Book book);
    @Insert("insert into book (id, name, price) values (#{id}, #{name}, #{price})")
    void insertBook(Book book);

    @Select("select * from book where id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "price", javaType = Double.class,column = "price")
    })
    Book findById(Integer id);
}