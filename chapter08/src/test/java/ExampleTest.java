import com.itheima.Example.entity.Student;
import com.itheima.Example.entity.User;
import com.itheima.Example.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExampleTest {
//    根据id查询单条用户信息
    @Test
    public void testFindById() {
        try {
            Reader reader = Resources.getResourceAsReader("mapper/mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

            SqlSession session = sqlSessionFactory.openSession();

            User user = session.selectOne("com.itheima.Example.mapper.UserMapper.findById", 1);
            System.out.println(user);

//            如果执行插入删除操作，需要手动提交事务
//            session.commit();
//            如果执行查询操作，不需要手动提交事务
            session.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
//    根据id查询多条用户信息，使用工具类
    @Test
    public void testFindByIds() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        List<User> users = sqlSession.selectList("findByIds", Arrays.asList(1, 2, 3));
        System.out.println(users);
        sqlSession.commit();
        sqlSession.close();
    }


//    测试插入操作
    @Test
    public void wanzhengMybatis() {
        Reader reader = null;
        SqlSession sqlSession = null;
        try {
            reader = Resources.getResourceAsReader("mapper/mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

            sqlSession = sqlSessionFactory.openSession();
            int count = sqlSession.insert("insert", new User(107, "张三"));
            System.out.println("插入成功，影响行数：" + count);
            sqlSession.commit();
        } catch (Exception e) {
            if(sqlSession != null){
                sqlSession.rollback();
            }
            e.printStackTrace();
        }finally {
            if(sqlSession != null){
                sqlSession.close();
            }
        }
    }
    // 使用工具类插入单条数据
    @Test
    public void testInsertCar(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        // 执行SQL
        int count = sqlSession.insert("insert", "tom");
//        int count = sqlSession.insert("insert", new User(108, "李四"));
        System.out.println("插入了几条记录:" + count);
        sqlSession.commit();
        sqlSession.close();
    }
    //    使用工具类插入多条数据
    @Test
    public void testInsertBatch(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        // 执行SQL
        List<User> users = Arrays.asList(
                new User(109, "张三"),
                new User(110, "李四")
        );
        int count = sqlSession.insert("insertBatch", users);
        System.out.println("插入了几条记录:" + count);
        sqlSession.commit();
        sqlSession.close();
    }

//    使用map增加数据
    @Test
    public void testInsertMap(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Map<String, Object> map = new HashMap<>();
        map.put("username", "jack");
        // 执行SQL
        int count = sqlSession.insert("insert", map);
        System.out.println("插入了几条记录:" + count);
        sqlSession.commit();
        sqlSession.close();
    }

//    删除单条数据
    @Test
    public void testDelete(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        int count = sqlSession.delete("delete", 108);
        System.out.println("删除了几条记录:" + count);
        sqlSession.commit();
        sqlSession.close();
    }
    //    删除多条数据，每个sql语句都需要写一个Mapper配置文件
    @Test
    public void testDeleteBatch(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        int count = sqlSession.delete("deleteBatch", new int[]{109, 110});
        System.out.println("删除了几条记录:" + count);
        sqlSession.commit();
        sqlSession.close();
    }
//    修改单条数据
    @Test
    public void testUpdate(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        int count = sqlSession.update("update", new User(114, "李四"));
        System.out.println("修改了几条记录:" + count);
        sqlSession.commit();
        sqlSession.close();
    }
//    修改多条数据
    @Test
    public void testUpdateBatch(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        int count = sqlSession.update("updateBatch", Arrays.asList(
                new User(114, "james"),
                new User(115, "james")
        ));
        System.out.println("修改了几条记录:" + count);
        sqlSession.commit();
        sqlSession.close();
    }

//    namespace属性,查询所有学生信息，用户信息
    @Test
    public void testNamespace(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        List<Student> students = sqlSession.selectList(
                "com.itheima.Example.mapper.StudentMapper.selectAll");
//        查询所有学生信息
        System.out.println(students);
//        查询所有用户信息
        List<User> users = sqlSession.selectList(
                "com.itheima.Example.mapper.UserMapper.selectAll");
        System.out.println(users);
        sqlSession.commit();
        sqlSession.close();
    }

}