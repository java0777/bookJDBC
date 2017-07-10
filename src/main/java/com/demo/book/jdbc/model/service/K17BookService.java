package com.demo.book.jdbc.model.service;

import com.demo.book.jdbc.model.dao.BookDao;
import com.demo.book.jdbc.model.entity.Book;
import com.demo.port.IBookUtil;
import com.demo.port.ICatchThread;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/10.
 */
@Service
public class K17BookService implements IBookService {
    @Resource
    private IBookUtil bookUtil;
    @Resource
    private ICatchThread r;
    @Resource
    private BookDao dao;
    @Override
    public Book queryBook(String BookName, String author) {
        return null;
    }

    @Override
    public Book catchBook(String bookName, String author) {
        return null;
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext con=new ClassPathXmlApplicationContext("spring.xml");
        IBookUtil util = con.getBean(IBookUtil.class);
        ICatchThread r = con.getBean(ICatchThread.class);
        Map book = util.queryBook("罪恶之城", null);
        if (book==null){
            System.out.println("没有该书");
            return;
        }
        Book bookData = new Book();
        bookData.setAuthor(book.get("author_name").toString());
        List<Map<String, Object>> bookTitles = util.getBookTitles(book, r);
    }
}
