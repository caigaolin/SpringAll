package com.topnet.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;

/**
 * @Author cgl
 * @ClassName Country
 * @Date Created in 10:47 2020/4/26
 */
@Data
@ToString
public class Country {
    private Integer id;
    @Column(name = "countryname")
    private String countryName;
    @Column(name = "countrycode")
    private String countryCode;
}
