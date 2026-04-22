package com.itheima.Egg03.service.impl;

import com.itheima.Egg03.pojo.Account;
import com.itheima.Egg03.service.AccountService;

import com.itheima.Egg03.dao.AccountDao;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
//@Transactional
public class AccountServiceImpl implements AccountService {
    @Resource(name = "accountDao")
    private AccountDao accountDao;

    @Override
    @Transactional
    public void transfer(String fromActno, String toActno, double money) {
//        1. 开启事务
//        2.核心业务逻辑

        Account fromAccount = accountDao.selectByActno(fromActno);
        if (fromAccount.getBalance() < money) {
            throw new IllegalArgumentException("余额不足");
        }

        Account toAccount = accountDao.selectByActno(toActno);
//        余额充足
        fromAccount.setBalance(fromAccount.getBalance() - money);
        toAccount.setBalance(toAccount.getBalance() + money);

        int count = accountDao.update(fromAccount);
//        这个地方加上一个空指针异常,转出正常,转入异常
//        String s = null;
//        s.toString();

        count += accountDao.update(toAccount);
        if (count != 2) {
            throw new RuntimeException("转账失败");
        }
    }
}
