package com.demo.book.jdbc.model.dao;

import java.util.List;

/**
 * Created by Administrator on 2017/7/17.
 */

public interface BaseDao<E, I> {

    /**
     * 将对象数据存入数据库
     * @param entity 待存储对象
     * @return
     */
    boolean insert(E entity);

    /**
     * 根据主键删除记录
     * @param id  主键值
     * @return
     */
    boolean deleteById(I id);

    /**
     * 查询该表所有数据
     * @return
     */
    List<E> selectAll();

    /**
     * 根据主键查询数据，无：null，有：转换成对象返回
     * @param id  主键值
     * @return
     */
    E selectById(I id);
}
