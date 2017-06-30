import com.demo.book.jdbc.model.dao.BookDao;
import com.demo.book.jdbc.model.entity.Book;

import com.demo.book.jdbc.model.entity.BookCatalog;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;


/**
 * Created by Administrator on 2017/6/27.
 */
public class Test {

    public static void main(String[] args) {
        try {
            insertNewBook();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*@Autowired
    private BookDao bookDao;*/

    /**
     * 存储新书
     */

     static void insertNewBook() throws IOException {
        ClassPathXmlApplicationContext con = new ClassPathXmlApplicationContext("spring.xml");
        BookDao dao = con.getBean(BookDao.class);
        Book book=new Book();
        book.setBookName("魔界");
        book.setAuthor("李奶奶");
        int i = dao.insertBook(book);
        //写入文本
        //Connection connect = Jsoup.connect("http://www.17k.com/chapter/2477255/28942975.html");
         Connection connect = Jsoup.connect("http://www.17k.com/chapter/2477255/28542679.html");
        Document doc = connect.get();
        Elements content = doc.select("div#chapterContentWapper");
        String text = content.text();
        String[] s = text.split("\\s+?");
         String catalogName = s[0];
         String filePath="D:\\Game\\Test";
        String fileName="\\kk2.txt";
        String file=filePath+fileName;
        Writer filewriter = null;
            filewriter = new FileWriter(file, true);
            for (String ss : s) {

                filewriter.write(ss);
            }
            //写入文本文件
             filewriter.close();
            System.out.println("成功");
         BookCatalog bookCatalog=new BookCatalog();
         bookCatalog.setFileDir(filePath);
         bookCatalog.setBook(book);
        bookCatalog.setCatalogName(catalogName);
         dao.insertBookMenu(bookCatalog);

     }
}
