package com.topnet.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author cgl
 * @ClassName Country
 * @Date Created in 15:45 2020/4/17
 */
@Table(name = "country")
@Data
@ToString
public class Country implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "countryname")
    private String countryName;
    @Column(name = "countrycode")
    private String countryCode;
}
