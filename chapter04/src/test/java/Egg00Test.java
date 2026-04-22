import com.itheima.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Egg00Test {
//  测试德鲁伊连接池
    @Test
    public void testDruid() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Egg02Druid.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean(JdbcTemplate.class);
        String sql = "insert into t_user(real_name,age) values(?,?)";
        Object[] p1 = {"王二", 18};
        Object[] p2 = {"tom", 19};
        List<Object[]> person = new ArrayList<>();
        person.add(p1);
        person.add(p2);
        int[] count = jdbcTemplate.batchUpdate(sql, person);
//        System.out.println(count);
        System.out.println(Arrays.toString(count));
    }

//    回调函数
    @Test
    public void testCallback() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("chapter04.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean(JdbcTemplate.class);
        String sql = "select * from t_user where real_name=?";
//        注册回调函数
        User user = jdbcTemplate.execute(sql, new PreparedStatementCallback<User>() {
            @Override
            public User doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                User user = null;
                ps.setString(1, "梨花");
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    int id = rs.getInt("id");
                    String realName = rs.getString("real_name");
                    int age = rs.getInt("age");
                    user = new User(id, realName, age);
                }
                return user;
            }
        });
        System.out.println(user);
    }


//    批量删除数据
    @Test
    public void testBatchDelete() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("chapter04.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean(JdbcTemplate.class);
        String sql = "delete from t_user where real_name=?";
        Object[] p1 = {"王二"};
        Object[] p2 = {"tom"};
        List<Object[]> person = new ArrayList<>();
        person.add(p1);
        person.add(p2);
        int[] count = jdbcTemplate.batchUpdate(sql, person);
//        System.out.println(count);
        System.out.println(Arrays.toString(count));
    }

//    批量更新数据
    @Test
    public void testBatchUpdate() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("chapter04.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean(JdbcTemplate.class);
        String sql = "update t_user set age=? where real_name=?";
        Object[] p1 = {20, "王二"};
        Object[] p2 = {21, "tom"};
        List<Object[]> person = new ArrayList<>();
        person.add(p1);
        person.add(p2);
        int[] count = jdbcTemplate.batchUpdate(sql, person);
//        System.out.println(count);
        System.out.println(Arrays.toString(count));
    }

//    批量添加数据
    @Test
    public void testBatchAdd() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("chapter04.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean(JdbcTemplate.class);
        String sql = "insert into t_user(real_name,age) values(?,?)";
        Object[] p1 = {"王二", 18};
        Object[] p2 = {"tom", 19};
        List<Object[]> person = new ArrayList<>();
        person.add(p1);
        person.add(p2);
        int[] count = jdbcTemplate.batchUpdate(sql, person);
//        System.out.println(count);
        System.out.println(Arrays.toString(count));
    }

//    查询一个值，比如记录条数
    @Test
    public void testQueryCount(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("chapter04.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean(JdbcTemplate.class);
        String sql = "select count(*) from t_user";
        int count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(count);
    }

//    查询数据
    @Test
    public void query(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("chapter04.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean(JdbcTemplate.class);
//        查询所有数据
        String sql = "select * from t_user";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        users.forEach(System.out::println);
        System.out.println(users.size());

//        查询单条数据
        String sql2 = "select * from t_user where real_name=?";
        User user = jdbcTemplate.queryForObject(sql2, new BeanPropertyRowMapper<>(User.class),"张三");
        System.out.println(user);
    }
//    删除数据
    @Test
    public void testDelete()  {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("chapter04.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean(JdbcTemplate.class);
        String sql = "delete from t_user where real_name='王二'";
        int count = jdbcTemplate.update(sql);
        System.out.println(count);
    }

//    修改数据
    @Test
    public void testUpdate()  {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("chapter04.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean(JdbcTemplate.class);
//        String sql = "update t_user set age=60 where real_name='王二'";
        String sql = "update t_user set age=? where real_name=?";
        Object[] p1 = {60, "王二"};
//        int count = jdbcTemplate.update(sql,p1);
        int count = jdbcTemplate.update(sql,p1);
        System.out.println(count);
    }

//    新增数据
    @Test
    public void testAdd()  {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("chapter04.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean(JdbcTemplate.class);
//        jdbcTemplate.execute("insert into t_user(real_name,age) values('王二',18)");
        String sql = "insert into t_user(real_name,age) values(?,?)";
//        name = '牛三';
//        age = 18;
        int count = jdbcTemplate.update(sql,"牛三",18);
//        count 为1，说明新增成功，否则失败
//        count 为大于1，说明新增成功，但是新增的记录数大于1
        System.out.println(count);
    }

//    测试代码连接输出
    @Test
    public void testConnection()  {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("chapter04.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean(JdbcTemplate.class);
        System.out.println(jdbcTemplate);

    }
}
