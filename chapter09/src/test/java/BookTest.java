import com.itheima.entity.Book;
import com.itheima.mapper.BookMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookTest {
    private SqlSession createSqlSession() {
        // 设置系统属性，允许XML解析器访问外部DTD和文件
        System.setProperty("javax.xml.accessExternalDTD", "all");
        System.setProperty("javax.xml.accessExternalSchema", "all");
        System.setProperty("javax.xml.parsers.SAXParserFactory", "com.sun.org.apache.xerces.internal.jaxp.SAXParserFactoryImpl");
        System.setProperty("javax.xml.parsers.DocumentBuilderFactory", "com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl");
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
        SqlSession sqlSession = createSqlSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        Book b = new Book();
        b.setId(1);
        b.setName("Java");
        b.setPrice(100.0);
        Book book = bookMapper.queryByIdAndName(b);
        System.out.println(book);
    }

    @Test
    public void testQueryByIdAndName2() {
        try {
//            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = builder.build(reader);
            SqlSession sqlSession = sqlSessionFactory.openSession();

            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            Book b = new Book();
            b.setName("java");
            Book book = bookMapper.queryByIdAndName(b);
            System.out.println(book);
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindBooksWithSort() {
        SqlSession sqlSession = createSqlSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        String sortType = "name";
        List<Book> books = bookMapper.findBooksWithSort(sortType);
        books.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testFindBooksByIds() {
        SqlSession sqlSession = createSqlSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        Integer[] arr = {1, 2,3};
        List<Book> books = bookMapper.findBooksByIds(arr);
        for(Book book : books) {
            System.out.println(book);
        }
        sqlSession.close();
    }
}