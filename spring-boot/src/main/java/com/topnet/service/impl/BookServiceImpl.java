package com.topnet.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.topnet.mapper.BookMapper;
import com.topnet.model.Book;
import com.topnet.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author cgl
 * @ClassName BookServiceImpl
 * @Date Created in 18:37 2020/4/11
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> findAll() {
        return bookMapper.findAll();
    }

    @Override
    public Book findOne(int id) {
        return bookMapper.findOne(id);
    }

    @Override
    public Map<String, Object> updateBook(JSONObject param) {
        Integer id = param.getInteger("id");
        String name = param.getString("name");
        Integer number = param.getInteger("number");
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("name", name);
        map.put("number", number);
        int numb = bookMapper.updateBook(map);
        if (numb > 0) {
            return map;
        }else {

            return null;
        }
    }

    @Override
    public Map<String, Object> insertBook(JSONObject param) {
        HashMap<String, Object> map = new HashMap<>();
        String name = param.getString("name");
        Integer number = param.getInteger("number");
        map.put("name", name);
        map.put("number", number);
        int numb = bookMapper.insertBook(map);
        if (numb > 0) {
            return map;
        } else {
            return null;
        }
    }
}
