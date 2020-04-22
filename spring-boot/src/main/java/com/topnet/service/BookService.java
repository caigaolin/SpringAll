package com.topnet.service;

import com.alibaba.fastjson.JSONObject;
import com.topnet.model.Book;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @Author cgl
 * @ClassName UserService
 * @Date Created in 18:05 2020/4/11
 */
@Service
public interface BookService {
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
    Book findOne(@RequestParam int id);

    /**
     * 修改
     * @param param
     * @return
     */
    Map<String, Object> updateBook(JSONObject param);

    /**
     * 添加
     * @param param
     * @return
     */
    Map<String,Object> insertBook(JSONObject param);
}
