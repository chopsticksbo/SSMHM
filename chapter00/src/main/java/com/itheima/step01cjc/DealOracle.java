package com.itheima.step01cjc;

public class DealOracle {
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
        return "准备存入数据库，DealOracle{" +
                "zhanghao='" + zhanghao + '\'' +
                ", mima='" + mima + '\'' +
                '}';
    }
}
