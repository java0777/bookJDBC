import com.demo.book.jdbc.model.dao.BookDao;
import com.demo.book.jdbc.model.entity.Book;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Administrator on 2017/6/27.
 */
public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext con= new ClassPathXmlApplicationContext("spring.xml");
        BookDao dao = con.getBean(BookDao.class);
        List<Book> books = dao.selectAll();
        System.out.println(books);
    }
}
