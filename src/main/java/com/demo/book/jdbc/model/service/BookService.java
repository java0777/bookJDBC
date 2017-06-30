package com.demo.book.jdbc.model.service;

import com.demo.book.jdbc.model.dao.BookDao;
import com.demo.book.jdbc.model.entity.Book;
import com.demo.book.jdbc.model.entity.BookCatalog;
import com.demo.k17.util.IBookUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Administrator on 2017/6/30.
 */
@Service
public class BookService implements IBookService {
    @Resource
    private IBookUtil util;
    @Resource
    private BookDao bookDao;

    public List<Book> queryByAuthor(String author) {
        return null;
    }

    public List<Book> queryByBookName(String name) {
        return null;
    }

    public Book queryByAuthorAndBookName(String author, String name) {
        return bookDao.selectBookByNameAndAuthor(name, author);
    }

    @Transactional
    public boolean saveBook(Book book) {
        if (book == null) {
            return false;
        }
        Map<String, StringBuilder> allTitles = util.getAllTitles(book.getAuthor(), book.getBookName());

        if (allTitles == null || allTitles.size() == 0) {
            return false;
        }

        bookDao.insertBook(book);
        String fileDir = IBookService.fileDir;
        byte[] temp = new byte[1024];
        for (Map.Entry<String, StringBuilder> entry : allTitles.entrySet()) {
            String title = entry.getKey();
            StringBuilder content = entry.getValue();
            String fileName = UUID.randomUUID().toString().replaceAll("-", "");
            InputStream input = new ByteArrayInputStream(content.toString().getBytes());
            FileOutputStream out = null;
            try {
                out = new FileOutputStream(fileDir + fileName + ".txt");
                for (int index = input.read(); index != -1; index = input.read()) {
                    out.write(temp, 0, index);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    input.close();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            BookCatalog bookCatalog = new BookCatalog();
            bookCatalog.setBook(book);
            bookCatalog.setCatalogName(title);
            bookCatalog.setFileDir(fileDir);
            bookCatalog.setFileName(fileName);
            bookDao.insertBookMenu(bookCatalog);
        }
        return true;
    }
}
