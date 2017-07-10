package com.demo.book.jdbc.model.Test;


import com.demo.book.jdbc.model.dao.BookDao;
import com.demo.book.jdbc.model.entity.Book;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Tiramisu on 2017/7/5.
 */
public class BookDaoTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext con = new ClassPathXmlApplicationContext("spring.xml");
        BookDao dao = con.getBean(BookDao.class);
        Book book = new Book();
        book.setBookName("卡卡卡");
        book.setAuthor("金坷垃");
        book.setInfo("收到货结构化好久好久安徽科技海军");
        dao.insertBook(book);
        System.out.println(dao.selectAll());
    }
}