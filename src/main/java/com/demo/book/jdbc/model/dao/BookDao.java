package com.demo.book.jdbc.model.dao;

import com.demo.book.jdbc.model.entity.Book;
import com.demo.book.jdbc.model.entity.BookCatalog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
 * Created by Administrator on 2017/6/27.
 */
public interface BookDao {
    /**
     * 书名作者名模糊查询
     * @param bookName
     * @param author
     * @return
     */
    Book selectBookByNameAndAuthor(@Param("bookName")String bookName, @Param("author") String author);

    /**
     * 查询全部书本信息
     * @return
     */
    List<Book> selectAll();

    /**
     * 添加新书
     * @param book
     * @return
     */

    int insertBook(Book book);

    /**
     * 存储书本章节目录信息
     * @param bookCatalog
     * @return
     */
    int insertBookMenu(BookCatalog bookCatalog);
    /**
     * 删除书本
     * @param id
     * @return
     */
    int deleteBook(Integer id);
}
