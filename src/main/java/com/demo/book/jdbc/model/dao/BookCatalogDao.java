package com.demo.book.jdbc.model.dao;

import com.demo.book.jdbc.model.entity.BookCatalog;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/7/11.
 */
@Repository
public interface BookCatalogDao extends BaseDao<BookCatalog, Integer> {

    List<BookCatalog> selectByBookId(Integer id);
}
