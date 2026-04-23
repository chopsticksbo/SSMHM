
import com.itheima.entity.*;
import com.itheima.mapper.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.io.Reader;

public class MapperTest {
    private SqlSession createSqlSession() {
        try {
            //读取mybatis-config.xml文件内容到Reader对象中
            Reader reader =
               Resources.getResourceAsReader("mybatis-config.xml");
            //创建SqlSessionFactory类的实例
            SqlSessionFactory sqlMapper =
                new SqlSessionFactoryBuilder().build(reader);
            //创建SqlSession对象
            SqlSession session = sqlMapper.openSession();
            return session;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Test
    public void manyToManyTest() {
        //获取SqlSession对象
        SqlSession session =this.createSqlSession();
        //获取StudentMapper对象
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        //查询学生信息
        Student student = mapper.findById(1);
        System.out.println("----------学生对应的课程信息--------------");
        System.out.println(student);
        //获取CourseMapper对象
        CourseMapper courseMapper = session.getMapper(CourseMapper.class);
        //查询课程信息
        Course course = courseMapper.findById(2);
        System.out.println("----------课程对应的学生信息--------------");
        System.out.println(course);
    }
}