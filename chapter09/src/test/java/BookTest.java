import com.itheima.entity.Book;
import com.itheima.mapper.BookMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class BookTest {
    private SqlSession createSqlSession() {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            return sqlSession;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test
    public void testQueryByIdAndName() {
        SqlSession sqlSession = this.createSqlSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        Book b = new Book();
        b.setId(1);
        b.setName("Java");
        b.setPrice(100.0);
        Book book = bookMapper.queryByIdAndName(b);
        System.out.println(book);
    }
}
