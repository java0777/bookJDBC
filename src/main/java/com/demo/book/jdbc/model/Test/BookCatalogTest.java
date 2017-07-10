package com.demo.book.jdbc.model.Test;

import com.demo.book.jdbc.model.dao.BookDao;
import com.demo.book.jdbc.model.entity.Book;
import com.demo.book.jdbc.model.entity.BookCatalog;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Tiramisu on 2017/7/7.
 */
public class BookCatalogTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext con = new ClassPathXmlApplicationContext("spring.xml");
        BookDao dao = con.getBean(BookDao.class);
        BookCatalog bookCatalog = new BookCatalog();
        bookCatalog.setCatalogName("第一章节");
        bookCatalog.setFileDir("D:\\mmmmm");
        bookCatalog.setFileName("mmmmm");
        Book book1 = new Book();
        book1.setId(2);
        bookCatalog.setBook(book1);
        dao.insertBookMenu(bookCatalog);
    }
}

