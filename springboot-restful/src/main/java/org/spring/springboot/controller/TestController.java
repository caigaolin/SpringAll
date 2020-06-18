package org.spring.springboot.controller;

import org.spring.springboot.config.AuthorSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author caigaolin
 * @version V1.0
 * @Package org.spring.springboot.controller
 * @date 2020/6/16 14:14
 * @Copyright © 2019-2020 河南拓普计算机网络工程有限公司
 */

@RestController
public class TestController {

    @Autowired
    private AuthorSettings authorSettings;

    @RequestMapping("/")
    public String index(){
        return "author name is "+authorSettings.getName()+" and author age is "+authorSettings.getAge();
    }

}
