package com.john.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author John117
 * @date 2022/08/07  9:17
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode  // 去重
public class Author {
    private Long id;
    private String name;
    private Integer age;
    private  String intro;  // 简介
    private List<Book> books;
}
