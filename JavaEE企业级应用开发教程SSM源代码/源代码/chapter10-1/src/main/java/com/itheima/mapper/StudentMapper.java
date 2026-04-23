package com.itheima.mapper;


import com.itheima.entity.Student;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import java.util.List;

public interface StudentMapper {
    @Select("SELECT * FROM student WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "courses", javaType = List.class, column = "id",
                    many = @Many(select =
                            "com.itheima.mapper.CourseMapper.findByStudentId"))
    })
    Student findById(int id);
    @Select("SELECT * FROM student WHERE id IN (" +
            "SELECT student_id FROM student_course WHERE course_id = #{courseId})")
    List<Student> findByCourseId(int courseId);
}