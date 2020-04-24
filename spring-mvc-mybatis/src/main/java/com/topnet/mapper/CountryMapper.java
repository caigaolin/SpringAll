package com.topnet.mapper;

import com.topnet.model.Country;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Author cgl
 * @ClassName CountryMapper
 * @Date Created in 16:00 2020/4/17
 */
//@Component
//@MapperScan
public interface CountryMapper extends Mapper<Country> {
    /**
     * 模糊匹配
     * @param countryName
     * @return
     */
    List<Map<String,Object>> selectLike(String countryName);
}
