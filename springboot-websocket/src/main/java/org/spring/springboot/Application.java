package org.spring.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author caigaolin
 * @version V1.0
 * @Package org.spring.springboot
 * @date 2020/6/18 9:04
 * @Copyright © 2019-2020 河南拓普计算机网络工程有限公司
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        //程序入口
        SpringApplication.run(Application.class, args);
    }
}
