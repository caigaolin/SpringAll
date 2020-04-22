package com.topnet.mapper;

import com.topnet.model.Book;

import java.util.List;
import java.util.Map;

/**
 * @Author cgl
 * @ClassName BookMapper
 * @Date Created in 18:26 2020/4/11
 */

public interface BookMapper {
    /**
     * 查询所有
     * @return
     */
    List<Book> findAll();

    /**
     * 查询一个
     * @param id
     * @return
     */
    Book findOne(int id);

    /**
     * 修改
     * @param map
     * @return
     */
    int updateBook(Map<String, Object> map);

    /**
     * 添加
     * @param map
     * @return
     */
    int insertBook(Map<String, Object> map);




}
