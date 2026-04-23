import com.itheima.config.DataSourceConfig;
import com.itheima.dao.AccountDao;
import com.itheima.pojo.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@SpringJUnitConfig(DataSourceConfig.class)
public class JDBCTest {
    @Autowired
    private AccountDao accountDao;
    @Test
    public void testAddAccount() {
        Account account = new Account();
        account.setUsername("zhangsan");
        account.setBalance(200.0);
        //添加账户信息
        accountDao.addAccount(account);
        //查询Id为1的账户信息
        Account acc = accountDao.queryAccountById(1);
        System.out.println(acc);
    }
    @Test
    public void testQueryAccountMap() {
        //查询Id为1的账户信息
        Map<String, Object> map = accountDao.queryAccountForMap(1);
        System.out.println(map);
    }
    @Test
    public void testQueryAccountList() {
        //查询所有的账户信息
        List<Account> accounts = accountDao.queryAccountList();
        System.out.println(accounts);

    }
    @Test
    public void testAddAccountList() {
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(new Account(null,"lisi",200.0));
        accounts.add(new Account(null,"wangwu",200.0));
        //批量添加账户信息
        accountDao.addAccountList(accounts);
        this.testQueryAccountList();
    }

    @Test
    public void testEditAccount() {
        //修改Id为1的账户信息
        accountDao.editAccount(new Account(1,"lilaosi",500.0));
        this.testQueryAccountList();
    }
    @Test
    public void testDelAccount() {
        //删除Id为1的账户信息
        accountDao.delAccount(1);
        this.testQueryAccountList();
    }
}
