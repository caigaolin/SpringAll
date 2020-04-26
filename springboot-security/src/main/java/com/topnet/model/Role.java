package com.topnet.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author cgl
 * @ClassName Role
 * @Date Created in 16:03 2020/4/26
 */
@Data
@ToString
public class Role implements Serializable {
    private Integer id;
    private String name;
    private String nameZh;
}
