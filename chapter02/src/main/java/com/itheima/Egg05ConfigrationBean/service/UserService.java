package com.itheima.Egg05ConfigrationBean.service;
import com.itheima.Egg05ConfigrationBean.bean.UserDao;
import org.springframework.stereotype.Service; // 这是一个被 @ComponentScan 扫描的组件

@Service // 相当于 @Component，标记为服务层
public class UserService {

    private UserDao userDao;

    // 构造器注入（推荐方式）
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void addUser() {
        System.out.println("UserService: 业务逻辑处理...");
        userDao.save();
    }
}
