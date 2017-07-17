import com.demo.book.jdbc.model.config.ServiceConfig;
import com.demo.book.jdbc.model.dao.BookDao;
import com.demo.book.jdbc.model.entity.Book;
import com.demo.book.jdbc.model.entity.BookCatalog;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/7/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath*:spring.xml")
@Transactional
public class BaseTest {
    @Resource
    private BookDao dao;

    @Test
    public void insertTest(){
        Book book = new Book();
        book.setAuthor("江南");
        book.setBookName("亵渎");
        book.setInfo("胖子传奇");
        dao.insert(book);
        Integer id = book.getId();
        Assert.assertTrue("保存出错了",id!=null);
    }
@Test
    public void selectBookByNameAndAuthorTest(){
    Book book = dao.selectBookByNameAndAuthor("罪恶之城", null);
    Assert.assertNotNull("查询书籍出错",book);
    List<BookCatalog> catalogList = book.getBookCatalogList();
    Assert.assertTrue("章节查询出错了",catalogList!=null&&catalogList.size()>0);
}
}
