import com.baomidou.mybatisplus.core.MybatisSqlSessionFactoryBuilder;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.itheima.entity.Book;
import com.itheima.mapper.BookMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.util.List;

public class MyBatisPlusTest {
    private SqlSession createSqlSession() {
        try {
            //读取mybatis-config.xml文件内容到Reader对象中
            Reader reader =
                    Resources.getResourceAsReader("mybatis-config.xml");
            //创建SqlSessionFactory类的实例
            SqlSessionFactory sqlMapper =
                    new MybatisSqlSessionFactoryBuilder().build(reader);
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
        SqlSession sqlSession = this.createSqlSession();
        // 通过SqlSession获取Mapper
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        // 使用Mapper进行操作
        Book book = bookMapper.selectById(1);
        System.out.println("----------查询单条图书信息------------");
        System.out.println(book);
        System.out.println("----------查询所有图书信息------------");
        List<Book> bookList = bookMapper.selectList(null);
        System.out.println(bookList);
        //创建条件构造器对象
        LambdaQueryWrapper<Book> queryWrapper = new LambdaQueryWrapper<>();
        //设置查询条件
        queryWrapper.gt(Book::getPrice, 60)
                .like(Book::getName, "记");
        List<Book> books = bookMapper.selectList(queryWrapper);
        System.out.println("----------查询指定条件的图书信息------------");
        System.out.println(books);
    }
    @Test
    public void insertTest() {
        SqlSession sqlSession = this.createSqlSession();
        // 通过SqlSession获取Mapper
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        Book book = new Book();
        book.setName("史记");
        book.setPrice(new BigDecimal(88.88));
        //插入Book对象的数据
        bookMapper.insert(book);
        sqlSession.commit();
        System.out.println("----------查询所有图书信息------------");
        List<Book> bookList = bookMapper.selectList(null);
        System.out.println(bookList);
    }
    @Test
    public void updateTest() {
        SqlSession sqlSession = this.createSqlSession();
        // 通过SqlSession获取Mapper
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        // 创建条件构造器
        LambdaUpdateWrapper<Book> updateWrapper = new LambdaUpdateWrapper<>();
        //设置查询条件
        updateWrapper.eq(Book::getName,"史记");
        updateWrapper.set(Book::getPrice,66.88);
        //更新图书信息
        bookMapper.update(updateWrapper);
        sqlSession.commit();
        System.out.println("----------查询所有图书信息------------");
        List<Book> bookList = bookMapper.selectList(null);
        System.out.println(bookList);
    }
    @Test
    public void deleteTest() {
        SqlSession sqlSession = this.createSqlSession();
        // 通过SqlSession获取Mapper
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        // 创建条件构造器
        LambdaQueryWrapper<Book> queryWrapper = new LambdaQueryWrapper<>();
        //设置条件
        queryWrapper.eq(Book::getName,"史记");
        //删除图书信息
        bookMapper.delete(queryWrapper);
        sqlSession.commit();
        System.out.println("----------查询所有图书信息------------");
        List<Book> bookList = bookMapper.selectList(null);
        System.out.println(bookList);
    }
}
