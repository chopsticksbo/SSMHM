package com.itheima.client;

public class OneDev {
//    持久层
    public static void dealSQL(String zhanghao,String mima) {
         String zhanghao1 = zhanghao;
         String mima1 = mima;
        System.out.println("准备存入数据库，DealOracle{"+zhanghao1+"-"+mima1+"}");
    }
//    业务层
    public static void deleteUser(String zhanghao,String mima) {
        dealSQL(zhanghao,mima);
    }
//表现层
    public static void main(String[] args) {
        deleteUser("123456","123456");
//        System.out.println("准备存入数据库，DealOracle{"+zhanghao1+"-"+mima1+"}");
    }
}