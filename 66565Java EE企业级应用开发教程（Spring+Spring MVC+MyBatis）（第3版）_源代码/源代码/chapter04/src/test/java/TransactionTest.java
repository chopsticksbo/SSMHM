
import com.itheima.dao.AccountDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
/*@SpringJUnitConfig(locations = "classpath:applicationContext.xml")*/
@SpringJUnitConfig(locations = "classpath:applicationContext-annotation.xml")
public class TransactionTest {
    @Autowired
    private AccountDao accountDao;
    @Test
    public void testTransfer() {
        //转账
        accountDao.transfer("lisi","wangwu",100.0);
    }
}
