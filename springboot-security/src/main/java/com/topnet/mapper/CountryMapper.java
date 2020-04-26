package com.topnet.mapper;

import com.topnet.model.Country;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Author cgl
 * @ClassName CountryMapper
 * @Date Created in 11:43 2020/4/26
 */
public interface CountryMapper extends MySqlMapper<Country>, Mapper<Country> {
}
