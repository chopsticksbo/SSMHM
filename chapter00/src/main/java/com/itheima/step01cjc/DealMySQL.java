package com.itheima.step01cjc;

public class DealMySQL {
    private String zhanghao;
    private String mima;

    public void setZhanghao(String zhanghao) {
        this.zhanghao = zhanghao;
    }

    public void setMima(String mima) {
        this.mima = mima;
    }

    @Override
    public String toString() {
        return "准备存入数据库，DealMySQL{" +
                "zhanghao='" + zhanghao + '\'' +
                ", mima='" + mima + '\'' +
                '}';
    }
}
