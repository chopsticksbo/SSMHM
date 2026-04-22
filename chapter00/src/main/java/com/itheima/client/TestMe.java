package com.itheima.client;
import com.itheima.step01cjc.DealMySQL;
import com.itheima.step02ywc.UserService;
import com.itheima.step03bxc.UserAction;

public class TestMe {
//    1. 测试持久层
//    public static void main(String[] args) {
//        DealMySQL dealMySQL = new DealMySQL();
//        dealMySQL.deal();
//    }
//    2. 测试业务层
//    public static void main(String[] args) {
//        UserService userService = new UserService();
//        userService.deleteUser();
//    }
//    3. 测试表现层
    public static void main(String[] args) {
        UserAction userAction = new UserAction();
        userAction.deleteUser("123456","123456");
    }

}
