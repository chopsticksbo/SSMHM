package com.itheima.dao;

import com.itheima.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Repository
public class AccountDaoImpl implements AccountDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    //添加单个账户消息
    public void addAccount(Account account) {
        // 定义SQL
        String sql = "INSERT INTO account(username,balance) VALUES(?,?)";
        // 定义数组来存放SQL语句中的参数
        Object[] obj = new Object[]{
                account.getUsername(),
                account.getBalance()
        };
        // 执行添加操作
        this.jdbcTemplate.update(sql, obj);
    }
    //批量添加账户信息
    public void addAccountList(List<Account> acclist) {
        // 定义SQL
        String sql = "INSERT INTO account(username,balance) VALUES(?,?)";
        // 定义批量插入到SQL语句中的参数
        List<Object[]> batchArgs = new ArrayList<>();
        for (int i = 0; i < acclist.size(); i++) {
            batchArgs.add(new Object[]{
                    acclist.get(i).getUsername(),
                    acclist.get(i).getBalance()});
        }
        // 执行批量添加操作
        this.jdbcTemplate.batchUpdate(sql, batchArgs);
    }
    //根据Id查找账户消息
    public Account queryAccountById(int id) {
        String sql="SELECT id,username,balance FROM account WHERE id = ?";
        // 创建一个新的BeanPropertyRowMapper对象
        RowMapper<Account> rowMapper =
                new BeanPropertyRowMapper<Account>(Account.class);
        //执行查询操作
        Account account= jdbcTemplate.queryForObject(sql, rowMapper,id);
        return account;
    }
    //查询账户消息，并将返回结果封装在Map中
    public Map<String,Object> queryAccountForMap(int id) {
        String sql="SELECT * FROM account WHERE id = ?";
        Map<String,Object> map = jdbcTemplate.queryForMap(sql,id);
        return map;
    }
    //查询账户消息，并将返回结果封装在List中
    public List<Account> queryAccountList() {
        String sql="SELECT * FROM account";
        List<Account> list = jdbcTemplate.query(
                sql,BeanPropertyRowMapper.newInstance(Account.class));
        return list;
    }
    //修改账户信息
    public void editAccount(Account acc) {
        // 定义SQL
        String sql = "UPDATE account SET username=?,balance=? WHERE id = ?";
        // 定义数组来存放SQL语句中的参数
        Object[] obj = new Object[]{
                acc.getUsername(),
                acc.getBalance(),
                acc.getId()
        };

        // 执行修改操作
        this.jdbcTemplate.update(sql, obj);
    }
    //删除账户信息
    public void delAccount(int id) {
        // 定义SQL
        String sql = "DELETE  FROM account WHERE id = ?";
        // 执行删除操作
        this.jdbcTemplate.update(sql, id);
    }
    /**
     *  转账
     *  inUser：收款人
     *  outUser：汇款人
     *  money：收款金额
     */
    @Transactional
    public void transfer(String outUser, String inUser, Double money) {
        // 汇款时，汇款用户的余额=现有余额-所汇金额
        this.jdbcTemplate.update("UPDATE account SET balance = balance-? "
                + "WHERE username = ?",money, outUser);
        // 模拟系统运行时的突发性问题
        int i = 1/0;
        // 收款时，收款用户的余额=现有余额+所汇金额
        this.jdbcTemplate.update("UPDATE account SET balance = balance +? "
                + "WHERE username = ?",money, inUser);
    }
}

