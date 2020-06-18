package org.spring.springboot.config;

import lombok.Data;

import java.io.Serializable;

/**
 * @author caigaolin
 * @version V1.0
 * @Package org.spring.springboot.config
 * @date 2020/6/16 16:39
 * @Copyright © 2019-2020 河南拓普计算机网络工程有限公司
 */
@Data
public class WiselyMessage implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WiselyMessage(String name) {
        this.name = name;
    }

    public WiselyMessage() {
    }
}
