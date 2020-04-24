package com.topnet.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.topnet.model.Country;
import com.topnet.service.CountryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author cgl
 * @ClassName CountryController
 * @Date Created in 15:54 2020/4/17
 */
@Api(description = "spring-mvc-mybatis")
@RestController
@RequestMapping(value = "/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @ApiOperation(value = "查询所有")
    @GetMapping("/findAll")
    public List<Country> findAll() {
        return countryService.findAll();
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/findPage")
    public PageInfo<Country>findPage(@RequestParam int pageNum,@RequestParam int pageSize){
        PageInfo<Country> pageInfo = countryService.findPage(pageNum, pageSize);
        return pageInfo;
    }

    @ApiOperation(value = "模糊查询")
    @GetMapping("/selectLike")
    public JSONObject selectLike(@RequestParam String countryName){
        return countryService.selectLike(countryName);
    }
}
