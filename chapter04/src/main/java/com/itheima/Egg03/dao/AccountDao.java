package com.itheima.Egg03.dao;

import com.itheima.Egg03.pojo.Account;

public interface AccountDao {
    Account selectByActno(String actno);

    int update(Account account);
}
