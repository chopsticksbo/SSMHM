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
            System.out.println("hhhhh");
            //            关闭会话对象
            sqlSession.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
