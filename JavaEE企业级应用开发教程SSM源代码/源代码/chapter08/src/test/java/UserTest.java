
import com.itheima.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.io.Reader;

public class UserTest {
    @Test
    public void userFindByIdTest() {
        try {
            //读取mybatis-config.xml文件内容到Reader对象中
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            //创建SqlSessionFactory类的实例
            SqlSessionFactory sqlMapper = new
                    SqlSessionFactoryBuilder().build(reader);
            //创建SqlSession对象
            SqlSession session = sqlMapper.openSession();
/*            //传入参数查询，返回结果
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = mapper.getUserWithDepartment(1);*/

              User user = session.selectOne("findById", 1);
            //输出结果
            System.out.println(user);
            //关闭会话
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}