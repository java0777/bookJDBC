package com.demo.book.jdbc.model.service;

import com.demo.book.jdbc.model.dao.BookCatalogDao;
import com.demo.book.jdbc.model.dao.BookDao;
import com.demo.book.jdbc.model.entity.Book;
import com.demo.book.jdbc.model.entity.BookCatalog;
import com.demo.port.IBookUtil;
import com.demo.port.ICatchThread;
import com.demo.util.BookWriterUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
    private BookDao bookDao;

    @Resource
    private BookCatalogDao catalogDao;

    @Override
    public Book queryBook(String bookName, String author) {
        return bookDao.selectBookByNameAndAuthor(bookName, author);
    }

    @Override
    @Transactional
    public Book catchBook(String bookName, String author) throws IOException {
        Map book = bookUtil.queryBook(bookName, author);
        if (book == null) {
            System.out.println("没有该书");
            return null;
        }
        Book bookData = new Book();
        bookData.setAuthor(book.get("author_name").toString());
        bookData.setBookName(book.get("book_name").toString());
        bookData.setInfo(book.get("intro").toString());
        bookDao.insert(bookData);
        List<BookCatalog> catalogList = new ArrayList<>();
        bookData.setBookCatalogList(catalogList);
        List<Map<String, Object>> bookTitles = bookUtil.getBookTitles(book, r);
        String fileDir = "D:\\allTitle\\";
        File dir = new File(fileDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        for (Map item : bookTitles) {
            String name = item.get("name").toString();
            String content = item.get("content").toString();
            String fileName = UUID.randomUUID().toString().replaceAll("-", "");
            BookCatalog catalog = new BookCatalog();
            catalog.setBookId(bookData.getId());
            catalog.setCatalogName(name);
            catalog.setFileDir(fileDir);
            catalog.setFileName(fileName);
            String fileStr = fileDir + fileName + ".txt";
            BufferedWriter writer = BookWriterUtil.getWriter(fileStr);
            String[] split = content.split(" ");
            for (String line : split) {
                writer.newLine();
                writer.write(line);
            }
            writer.close();
            catalogDao.insert(catalog);
            catalogList.add(catalog);
        }
        return bookData;
    }

    @Override
    public String getTitleContent(Integer bookId, Integer titleId) throws IOException {
        BookCatalog catalog = catalogDao.getCatalogByBookIdAndTitleId(bookId, titleId);
        String fileDir = catalog.getFileDir();
        String fileName = catalog.getFileName();
        StringBuilder content = new StringBuilder();
        BufferedReader reader = BookWriterUtil.getReader(fileDir + fileName + ".txt");
        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            content.append(line);
        }
        return content.toString();
    }

}
