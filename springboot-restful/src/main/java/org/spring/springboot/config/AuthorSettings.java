package org.spring.springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author caigaolin
 * @version V1.0
 * @Package org.spring.springboot.config
 * @date 2020/6/16 14:07
 * @Copyright © 2019-2020 河南拓普计算机网络工程有限公司
 */
@Component
@ConfigurationProperties(prefix = "author")
public class AuthorSettings {

    private String  name;
    private Long age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public AuthorSettings(String name, Long age) {
        this.name = name;
        this.age = age;
    }

    public AuthorSettings() {
    }
}
