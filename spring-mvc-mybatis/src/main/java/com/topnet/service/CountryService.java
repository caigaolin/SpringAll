package com.topnet.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topnet.mapper.CountryMapper;
import com.topnet.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author cgl
 * @ClassName CountryService
 * @Date Created in 16:42 2020/4/17
 */
@Service
public class CountryService {

    @Autowired
    private CountryMapper countryMapper;

    public List<Country> findAll() {
        return countryMapper.selectAll();
    }

    /**
     * 分页查询
     * @param pageNum 当前页
     * @param pageSize 每页显示条数
     * @return
     */
    public PageInfo<Country> findPage(int pageNum,int pageSize) {
        //分页开始
        PageHelper.startPage(pageNum, pageSize);
        List<Country> list = countryMapper.selectAll();
        PageInfo<Country> info = new PageInfo<>(list);
        return info;
    }

    /**
     * 模糊匹配
     * @param countryname
     * @return
     */
    public List<Country> selectLike(String countryname) {
        return countryMapper.selectLike(countryname);
    }
}
