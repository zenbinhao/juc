package com.elasticsearchlearn.po;/*
 * @Author: zeng
 * @Data: 2022/1/21 19:39
 * @Description: TODO
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


@Document(indexName = "jd_goods")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Goods {

    @Id
    private String id;
    @Field(type = FieldType.Text)
    private String name;
    @Field(type = FieldType.Auto)
    private String price;
    @Field(type = FieldType.Auto)
    private String images;
}
