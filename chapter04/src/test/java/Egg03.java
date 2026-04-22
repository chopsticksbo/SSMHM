import com.itheima.Egg03.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Egg03 {
    @Test
    public void testTransfer() {
        ApplicationContext context = new ClassPathXmlApplicationContext("Egg03.xml");
        AccountService accountService = context.getBean("accountService", AccountService.class);
        try {
            accountService.transfer("act-001", "act-002", 100);
            System.out.println("转账成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("转账失败");
        }
    }
}
