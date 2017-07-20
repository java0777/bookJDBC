import com.demo.book.jdbc.model.service.IBookService;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * Created by Administrator on 2017/7/17.
 */
public class K17BookServiceTest extends BaseTest {
    @Resource
    IBookService service;

    @Test
    public void getTitleContentTest() throws IOException {
/*        String content = service.getTitleContent(3, 1467);
        Assert.assertTrue("获取章节内容出错",content.length()>0);*/
    }
}

