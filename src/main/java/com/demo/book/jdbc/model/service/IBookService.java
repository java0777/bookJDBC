package com.demo.book.jdbc.model.service;


import com.demo.book.jdbc.model.entity.Book;

/**
 * 书籍相关业务类
 */
public interface IBookService {
    /**
     * 流程：通过字段查询数据库中是否有符合的记录
     * 有：返回该书籍对象
     * 没有：返回null
     * 根据书名，作者查询书籍
     * @param BookName 书名 不能为null
     * @param author 作者
     * @return
     */
 Book queryBook(String BookName,String author );

    /**
     * 流程：通过书名，作者调用抓取接口
     * 有：执行抓章节 录入数据库(先书籍对象，然后是书籍章节)，写txt文件 并返回装配好的book对象
     * 没有：返回null
     * 通过抓取组件抓取书籍，并成相应的记录跟txt文件
     * @param bookName 书名
     * @param author  作者
     * @return
     */
 Book catchBook(String bookName,String author);
}
