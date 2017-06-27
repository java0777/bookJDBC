package com.demo.book.jdbc.model.dao;

import com.demo.book.jdbc.model.entity.Book;

import java.util.List;

/**
 * Created by Administrator on 2017/6/27.
 */
public interface BookDao {

    List<Book> selectAll();
}
