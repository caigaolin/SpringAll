package com.topnet.service;

import com.topnet.mapper.CountryMapper;
import com.topnet.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author cgl
 * @ClassName CountryService
 * @Date Created in 11:43 2020/4/26
 */
@Service
public class CountryService {

    @Autowired
    private CountryMapper countryMapper;

    @Transactional(rollbackFor = {RuntimeException.class,Error.class})
    public void saveOne(Country country){
//        int i = 1/0;
        countryMapper.insert(country);
    }
}
