import com.itheima.entity.Book;
import com.itheima.mapper.BookMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookTest {
    private SqlSession createSqlSession() {
        try {
            //读取mybatis-config.xml文件内容到Reader对象中
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            //创建SqlSessionFactory类的实例
            SqlSessionFactory sqlMapper = new
                    SqlSessionFactoryBuilder().build(reader);
            //创建SqlSession对象
            SqlSession session = sqlMapper.openSession();
            return session;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Test
    public void ifTest() {
        //获取SqlSession对象
        SqlSession session =this.createSqlSession();
        //获取BookMapper对象
        BookMapper mapper = session.getMapper(BookMapper.class);
        //创建Book对象
        Book b = new Book();
        /*b.setId(1);*/
        b.setName("西游记");
        //查询图书信息
        Book book = mapper.queryByIdAndName(b);
        System.out.println(book);
    }
    @Test
    public void chooseTest() {
        //获取SqlSession对象
        SqlSession session =this.createSqlSession();
        //获取BookMapper对象
        BookMapper mapper = session.getMapper(BookMapper.class);
         //查询图书信息
/*        List<Book> books = mapper.findBooksWithSort("name");*/
/*        List<Book> books = mapper.findBooksWithSort("price");*/
        List<Book> books = mapper.findBooksWithSort("");
        for (Book book:books) {
            System.out.println(book);
        }
    }
    @Test
    public void foreachByArrayTest() {
        //获取SqlSession对象
        SqlSession session =this.createSqlSession();
        //获取BookMapper对象
        BookMapper mapper = session.getMapper(BookMapper.class);
        //图书id
        Integer[] arr={1,3};
        //查询图书信息
        List<Book> books = mapper.findBooksByIds(arr);
        for (Book book:books) {
            System.out.println(book);
        }
    }
    @Test
    public void foreachByListTest() {
        //获取SqlSession对象
        SqlSession session =this.createSqlSession();
        //获取BookMapper对象
        BookMapper mapper = session.getMapper(BookMapper.class);
        //图书信息
        List<Book> books=new ArrayList<>();
        books.add(new Book(5,"黄帝内经",56.56));
        books.add(new Book(6,"伤寒杂病论",58.88));
        mapper.batchInsertBooks(books);
        session.commit();
        //查询最新的图书列表
        chooseTest();
    }
    @Test
    public void foreachByMapTest() {
        //获取SqlSession对象
        SqlSession session =this.createSqlSession();
        //获取BookMapper对象
        BookMapper mapper = session.getMapper(BookMapper.class);
        // 创建用于存放查询条件的Map
        Map<String, String> conditions = new HashMap<>();
        conditions.put("name", "三国演义");
        conditions.put("price","55.5");
        //查询图书
        List<Book> books = mapper.queryByConditions(conditions);
        for (Book book:books) {
            System.out.println(book);
        }
    }

    @Test
    public void setTest() {
        //获取SqlSession对象
        SqlSession session =this.createSqlSession();
        //获取BookMapper对象
        BookMapper mapper = session.getMapper(BookMapper.class);
        // 创建图书对象
        Book book = new Book(4, "石头记", 55.55);
        //更新图书
        mapper.updateBook(book);
        session.commit();
        //查询更新后的图书信息
        chooseTest();
    }
}