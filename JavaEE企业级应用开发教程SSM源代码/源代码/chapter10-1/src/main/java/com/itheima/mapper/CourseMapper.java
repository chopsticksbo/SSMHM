package com.itheima.mapper;

import com.itheima.entity.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface CourseMapper {
    @Select("SELECT * FROM course WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "students", javaType = List.class, column = "id",
                    many = @Many(select =
                            "com.itheima.mapper.StudentMapper.findByCourseId"))
    })
    Course findById(int id);

    @Select("SELECT * FROM course WHERE id IN (" +
            "SELECT course_id FROM student_course WHERE student_id = #{studentId})")
    List<Course> findByStudentId(int studentId);
}