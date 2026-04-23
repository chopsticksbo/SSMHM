
import com.itheima.mapper.BookMapper;
import com.ithema.entity.Book;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.io.Reader;
public class CacheTest {
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
    public void L1CacheTest() {
        //获取SqlSession对象
        SqlSession session =this.createSqlSession();
        //获取BookMapper对象
        BookMapper mapper = session.getMapper(BookMapper.class);
        //查询图书信息
        Book book = mapper.selectByPrimaryKey(1);
        System.out.println("id："+book.getId()+"；name："+book.getName()+"；price："+book.getPrice());
        //删除图书信息
        mapper.deleteByPrimaryKey(6);
        session.commit();
        //查询图书信息
        book = mapper.selectByPrimaryKey(1);
        System.out.println("id："+book.getId()+"；name："+book.getName()+"；price："+book.getPrice());
    }
    @Test
    public void L2CacheTest() throws IOException {
        Reader reader =
                Resources.getResourceAsReader("mybatis-config.xml");
        //创建SqlSessionFactory类的实例
        SqlSessionFactory sqlMapper =
                new SqlSessionFactoryBuilder().build(reader);
        //创建SqlSession对象
        SqlSession session01 = sqlMapper.openSession();
        SqlSession session02 = sqlMapper.openSession();
        SqlSession session03 = sqlMapper.openSession();
        //获取BookMapper对象
        BookMapper mapper01 = session01.getMapper(BookMapper.class);
        //查询图书信息
        Book book01 = mapper01.selectByPrimaryKey(1);
        System.out.println("id："+book01.getId()+"；name："+book01.getName()+"；price："+book01.getPrice());
        session01.close();
        //获取BookMapper对象
        BookMapper mapper02 = session02.getMapper(BookMapper.class);
        //删除图书信息
         mapper02.deleteByPrimaryKey(5);
        session02.commit();
        session02.close();
        //获取BookMapper对象
        BookMapper mapper03 = session03.getMapper(BookMapper.class);
        //查询图书信息
        Book book02 = mapper03.selectByPrimaryKey(1);
        System.out.println("id："+book02.getId()+"；name："+book02.getName()+"；price："+book02.getPrice());
    }
}