package com.topnet.service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topnet.mapper.CountryMapper;
import com.topnet.model.Country;
import com.topnet.util.Constant;
import com.topnet.util.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
     * @param countryName
     * @return
     */
    public JSONObject selectLike(String countryName) {
        List<Map<String, Object>> list = countryMapper.selectLike(countryName);
        System.out.println(list);
        if (list.isEmpty()){
            return DataUtil.returnData(Constant.CODE_ERROR, "", "列表为空");
        }
        return DataUtil.returnData(Constant.CODE_SUCCESS, list, "列表数据");
    }
}
