package com.demo.book.jdbc.model.dao;

import com.demo.book.jdbc.model.entity.Book;
import com.demo.book.jdbc.model.entity.BookCatalog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Created by Administrator on 2017/6/27.
 */
@Repository
public interface BookDao extends BaseDao<Book,Integer> {
    /**
     * 书名作者名模糊查询
     * @param bookName
     * @param author
     * @return
     */
    Book selectBookByNameAndAuthor(@Param("bookName")String bookName, @Param("author") String author);

}
