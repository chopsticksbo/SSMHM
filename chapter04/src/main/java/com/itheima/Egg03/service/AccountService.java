package com.itheima.Egg03.service;

import com.itheima.Egg03.pojo.Account;

public interface AccountService {
    /**
     * 转账
     * @param fromActno 转账账号
     * @param toActno 收款账号
     * @param money 转账金额
     */
    void transfer(String fromActno, String toActno, double money);

}
