package com.itheima.dao;

import com.itheima.pojo.Account;
import java.util.List;
import java.util.Map;
public interface AccountDao {
    //添加单个账户消息
    public void addAccount(Account account);
    //根据Id查找账户消息
    public Account queryAccountById(int id);
    //批量添加账户信息
    public void addAccountList(List<Account> acclist);
    //查询账户消息，并将返回结果封装在Map中
    public Map<String,Object> queryAccountForMap(int id);
    //查询账户消息，并将返回结果封装在List中
    public List<Account> queryAccountList();
    //修改账户信息
    public void editAccount(Account acc);
    //删除账户信息
    public void delAccount(int id);
    // 转账
    public void transfer(String outUser,String inUser,Double money);
}
