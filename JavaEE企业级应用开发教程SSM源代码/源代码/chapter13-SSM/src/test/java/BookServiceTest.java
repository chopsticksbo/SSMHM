import com.itheima.entity.Book;
import com.itheima.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:application-service.xml",
"classpath:application-dao.xml"})
public class BookServiceTest {
    @Autowired
   private BookService bookService;
    @Test
    public void findAllBooks(){
        List<Book> allBooks = bookService.findAllBooks();
        System.out.println(allBooks);
    }
}