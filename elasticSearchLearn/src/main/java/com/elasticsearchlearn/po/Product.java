package com.elasticsearchlearn.po;/*
 * @Author: zeng
 * @Data: 2022/1/20 17:53
 * @Description: TODO
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Product {
    private String name;
    private long age;
}
