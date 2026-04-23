
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
    public void selectTest() {
        //获取SqlSession对象
        SqlSession session =this.createSqlSession();
        //获取UserMapper对象
        UserMapper mapper = session.getMapper(UserMapper.class);
        //查询用户信息
        User user = mapper.findById(2);
        System.out.println(user);
    }
    @Test
    public void insertTest() {
        //获取SqlSession对象
        SqlSession session =this.createSqlSession();
        //获取UserMapper对象
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("王五");
        //插入用户信息
         mapper.insertUser(user);
         session.commit();
        System.out.println(user);
    }
    @Test
    public void updateUser() {
        //获取SqlSession对象
        SqlSession session =this.createSqlSession();
        //获取UserMapper对象
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User();
        user.setId(4);
        user.setUsername("王老五");
        //更新用户信息
        mapper.updateUser(user);
        session.commit();
        User u = mapper.findById(4);
        System.out.println(u);
    }
    @Test
    public void deleteTest() {
        //获取SqlSession对象
        SqlSession session =this.createSqlSession();
        //获取UserMapper对象
        UserMapper mapper = session.getMapper(UserMapper.class);
        //删除用户信息
        mapper.deleteUserById(4);
        session.commit();
        User user = mapper.findById(4);
        System.out.println(user);
    }
    @Test
    public void associationTest() {
        //获取SqlSession对象
        SqlSession session =this.createSqlSession();
        //获取PersonMapper对象
        PersonMapper mapper = session.getMapper(PersonMapper.class);
        //查询人员信息
        Person person = mapper.getPersonById(1);
        System.out.println(person);
    }
    @Test
    public void collectionTest() {
        //获取SqlSession对象
        SqlSession session =this.createSqlSession();
        //获取MemberMapper对象
        MemberMapper mapper = session.getMapper(MemberMapper.class);
        //查询会员信息
        Member member = mapper.getMemberWithOrders(1);
        System.out.println(member);
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