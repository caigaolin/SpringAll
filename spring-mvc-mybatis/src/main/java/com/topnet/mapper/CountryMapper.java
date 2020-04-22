package com.topnet.mapper;

import com.topnet.model.Country;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

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
     * @param countryname
     * @return
     */
    List<Country> selectLike(String countryname);
}
