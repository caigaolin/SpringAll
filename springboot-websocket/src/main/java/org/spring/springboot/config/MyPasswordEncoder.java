package org.spring.springboot.config;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author caigaolin
 * @version V1.0
 * @Package org.spring.springboot.config
 * @date 2020/6/17 14:32
 * @Copyright © 2019-2020 河南拓普计算机网络工程有限公司
 */
public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}
