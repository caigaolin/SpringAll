package com.topnet.model;

import lombok.Data;
import lombok.ToString;

/**
 * @Author cgl
 * @ClassName Book
 * @Date Created in 18:21 2020/4/11
 */
@Data
@ToString
public class Book {
    private Integer id;
    private String name;
    private Integer number;
}
