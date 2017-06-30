package com.demo.book.jdbc.model.service;

import com.demo.book.jdbc.model.entity.Book;
import com.demo.book.jdbc.model.entity.BookCatalog;

import java.util.List;

/**
 * 书籍相关业务类
 */
public interface IBookService {
    //章节文件存储地址
    String fileDir = "D:\\book\\titles\\";


    /**
     * 根据作者名称查询书籍列表
     *
     * @param author 作者名称
     * @return 数据库中符合要求的书籍集合
     */
    List<Book> queryByAuthor(String author);

    /**
     * 根据书籍名称查询书籍列表
     *
     * @param name 书籍名称
     * @return 数据库中符合要求的书籍集合
     */
    List<Book> queryByBookName(String name);

    /**
     * 根据作者，书名查询唯一书籍，若出现重复 保存业务出错
     *
     * @param author 作者名称
     * @param name   书籍名称
     * @return 唯一的书籍，若没有返回 null
     */
    Book queryByAuthorAndBookName(String author, String name);

    /**
     * 将符合条件的数据内容从17k或起点拿到
     * 并生成数据库对应记录book，bookCatalog，相关txt
     * 流程：传参书名，作者到抓取组件，若没有返回false 结束
     * 若有返回章节相关map
     * 将map转成bookCatalog对象，生成相对应的txt
     * 保存入数据库
     * @param book
     * @return false 没有该书籍保存失败，true保存书籍成功
     */
    boolean saveBook(Book book);

}
