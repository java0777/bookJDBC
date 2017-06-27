package com.demo.book.jdbc.model.entity;

import java.util.List;

/**
 * 书籍实体
 */
public class Book {
    private Integer id; //主键
    private String bookName;//书籍名
    private String author;//作者名
    private List<BookCatalog> bookCatalogList;//相关目录清单

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<BookCatalog> getBookCatalogList() {
        return bookCatalogList;
    }

    public void setBookCatalogList(List<BookCatalog> bookCatalogList) {
        this.bookCatalogList = bookCatalogList;
    }
}
