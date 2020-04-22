package com.topnet.controller;

import com.alibaba.fastjson.JSONObject;
import com.topnet.model.Book;
import com.topnet.service.BookService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author cgl
 * @ClassName BookController
 * @Date Created in 18:38 2020/4/11
 */
@RestController
@RequestMapping("/book")
public class BookController {



    @Autowired
    private BookService bookService;

    @GetMapping("/findAll")
    public List<Book> findAll(){
        return bookService.findAll();
    }

    @GetMapping("/findOne")
    public Book findOne(@RequestParam int id){
        return bookService.findOne(id);
    }

    @PostMapping("/updateBook")
    public Map<String,Object>updateBook(@ApiParam(name = "param",value = "{\"id\":\"1\", \"name\":\"121212\" ,\"number\":\"1\"}",required = true) @RequestBody JSONObject param){
        Map<String, Object> result = bookService.updateBook(param);
        return result;
    }

    @PostMapping("/insertBook")
    public Map<String,Object>insertBook(@ApiParam(name = "param",value = "{\"name\":\"测试\" , \"number\":\"123\"}", required = true) @RequestBody JSONObject param){
        Map<String, Object> result = bookService.insertBook(param);
        return result;
    }
}
