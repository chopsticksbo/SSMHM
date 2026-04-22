package com.itheima.Egg01.config;

//import com.alibaba.druid.pool.DruidDataSource;
import com.itheima.bean.MyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;

@Configuration
@ComponentScan({"com.itheima.Egg01.config", "com.itheima.Egg01.dao"})
@PropertySource("classpath:/application.properties")
public class DataSourceConfig1 {
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.driver}")
    private String driverClassName;
    // 自定义数据源配置
    @Bean
    public DataSource dataSource() {
        MyDataSource dataSource = new MyDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriver(driverClassName);
        return dataSource;
    }
    // 注入数据源创建JdbcTemplate Bean，
    @Bean
    public JdbcTemplate jdbcTemplate(@Autowired DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}