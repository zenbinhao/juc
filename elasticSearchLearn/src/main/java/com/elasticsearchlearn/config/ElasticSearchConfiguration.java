package com.elasticsearchlearn.config;/*
 * @Author: zeng
 * @Data: 2022/1/20 16:49
 * @Description: TODO
 */


import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticSearchConfiguration {


    @Bean
    public ElasticsearchClient getElasticsearchClient(){
        RestClientBuilder httpClientBuilder = RestClient.builder(
                new HttpHost("192.168.92.128", 9200)
        );

// Create the HLRC
        RestHighLevelClient hlrc = new RestHighLevelClient(httpClientBuilder);

// Create the new Java Client with the same low level client
        ElasticsearchTransport transport = new RestClientTransport(
                hlrc.getLowLevelClient(),
                new JacksonJsonpMapper()
        );

        ElasticsearchClient client = new ElasticsearchClient(transport);

        return client;
    }

}
