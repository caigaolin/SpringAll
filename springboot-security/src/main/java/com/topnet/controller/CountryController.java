package com.topnet.controller;

import com.topnet.model.Country;
import com.topnet.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author cgl
 * @ClassName CountryController
 * @Date Created in 13:19 2020/4/26
 */
@RestController
@RequestMapping("/country")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @PostMapping("/saveOne")
    public void saveOne(@RequestBody Country country){
        try {
            countryService.saveOne(country);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
