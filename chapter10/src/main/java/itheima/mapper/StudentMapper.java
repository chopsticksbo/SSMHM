package itheima.mapper;

import itheima.entity.Student;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {
    @Select("select * from student where id=#{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "books", javaType = List.class,column = "id",many = @Many(select = "itheima.mapper.BookMapper.selectBookById"))
    })
    Student findById(Integer id);
    @Select("select * from student where id in ("+"select student_id from book_student where book_id=#{bookId})")
    List<Student> findByBookId(Integer bookId);

}
