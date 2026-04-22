package com.itheima.step02ywc;

import com.itheima.step01cjc.DealMySQL;

public class UserService {
//    private DealMySQL dealMySQL = new DealMySQL();
    public void deleteUser(String zhanghao,String mima) {
        DealMySQL dealMySQL1 = new DealMySQL();
        dealMySQL1.setMima(mima);
        dealMySQL1.setZhanghao(zhanghao);
        System.out.println(dealMySQL1);
    }
}
