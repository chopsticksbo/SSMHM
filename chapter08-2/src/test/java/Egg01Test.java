import com.itheima.Example.entity.User;
import com.itheima.Example.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class Egg01Test {

    @Test
    public void testDBPool(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mapper/mybatis-config.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
//            一个数据库创建一个SqlSessionFactory对象，不需要每次创建SqlSession对象都重新创建
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream, "development");
//            会话1
            SqlSession sqlSession = sqlSessionFactory.openSession();
            User result = sqlSession.selectOne("com.itheima.Example.mapper.UserMapper.findById", 1);
            System.out.println(result);
            sqlSession.close();

//            会话2
            SqlSession sqlSession2 = sqlSessionFactory.openSession();
            User result2 = sqlSession2.selectOne("com.itheima.Example.mapper.UserMapper.findById", 1);
            System.out.println(result2);
            //            关闭会话对象
            sqlSession2.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


           }

    @Test
    public void testEgg01(){
        try {
//           getResourceAsStream: 从类路径下加载资源,并将其转换为InputStream对象
//            参数1: 资源路径，格式为: mapper/文件名.xml
            InputStream inputStream = Resources.getResourceAsStream("mapper/mybatis-config.xml");
//            build函数参数1: 输入流对象
//            参数2: 为mybatis中指定开发环境id
            SqlSessionFactory sqlSessionFactory =
                    new SqlSessionFactoryBuilder().build(inputStream, "development");
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //            调用sqlSession对象的selectOne()方法,执行查询操作句
            User result = sqlSession.selectOne("com.itheima.Example.mapper.UserMapper.findById", 1);
            System.out.println(result);
            System.out.println("hhhhh111111");
            //            关闭会话对象
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
