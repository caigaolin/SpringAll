package org.spring.springboot.config;

import lombok.Data;

import java.io.Serializable;

/**
 * @author caigaolin
 * @version V1.0
 * @Package org.spring.springboot.config
 * @date 2020/6/16 16:41
 * @Copyright © 2019-2020 河南拓普计算机网络工程有限公司
 */
@Data
public class WiselyResponse implements Serializable {
    private String responseMessage;

    //有参构造
    public WiselyResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }
    //空参构造
    public WiselyResponse() {
    }

    public String getResponseMessage() {
        return responseMessage;
    }
}
