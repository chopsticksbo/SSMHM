import com.itheima.Example.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import java.io.InputStream;

public class UserTest {
    @Test
    public void userFindByIdTest() {
        SqlSession session = null;
        try {
            // 使用ClassLoader加载mybatis-config.xml文件
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("mapper/mybatis-config.xml");
            if (inputStream == null) {
                System.err.println("配置文件mybatis-config.xml未找到");
                return;
            }
            
            // 创建SqlSessionFactory类的实例
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            
            // 创建SqlSession对象
            session = sqlSessionFactory.openSession();
            
            // 传入参数查询，返回结果
            User user = session.selectOne("findById", 1);
            
            // 输出结果
            System.out.println("查询结果: " + user);
            
        } catch (Exception e) {
            // 打印异常信息
            System.err.println("查询用户失败: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // 关闭会话
            if (session != null) {
                session.close();
            }
        }
    }
}