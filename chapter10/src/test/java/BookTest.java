import itheima.entity.Book;
import itheima.mapper.BookMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

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
// 测试插入数据
    @Test
    public void MapperTest() {
        SqlSession sqlSession = createSqlSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        Book b = new Book();
        b.setId(7);
        b.setName("QQ");
        b.setPrice(100.0);
        bookMapper.insertBook(b);
        sqlSession.commit();
        sqlSession.close();
    }
//    测试查询数据
    @Test
    public void selectAll(){
        SqlSession sqlSession = createSqlSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        Book b = new Book();
        b.setId(7);
        b.setName("QQ");
        Book book = bookMapper.queryByIdAndName(b);
        System.out.println(book);
        sqlSession.close();
    }
//    测试修改数据
    @Test
    public void updateBook(){
        SqlSession sqlSession = createSqlSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        Book b = new Book();
        b.setId(1);
//        b.setName("java se");
        b.setPrice(23.2);
        int rows = bookMapper.updateBook(b);
        System.out.println(rows);
        if(rows > 0){
            System.out.println("修改成功");
            sqlSession.commit();
        }else{
            System.out.println("修改失败");
            sqlSession.rollback();
        }
        sqlSession.close();
    }
}