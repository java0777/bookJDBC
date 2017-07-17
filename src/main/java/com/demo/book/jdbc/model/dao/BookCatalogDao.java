package com.demo.book.jdbc.model.dao;

import com.demo.book.jdbc.model.entity.BookCatalog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/7/11.
 */
@Repository
public interface BookCatalogDao extends BaseDao<BookCatalog, Integer> {

    /**
     * 根据书籍编号，查询其下所以章节记录
     * @param bookId 书籍编号
     * @return
     */
    List<BookCatalog> selectByBookId(Integer bookId);

    /**
     * 根据书籍编号，章节编号查询匹配的完整得章节记录
     * @param bookId 书籍编号
     * @param catalogId  章节编号
     * @return
     */
    BookCatalog getCatalogByBookIdAndTitleId(@Param("bookId") Integer bookId,@Param("catalogId") Integer catalogId);
}
