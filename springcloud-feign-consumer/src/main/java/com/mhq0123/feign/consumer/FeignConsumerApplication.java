package com.mhq0123.feign.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.nio.charset.Charset;

/**
 * Created by mhq0123 on 2016/12/17.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients // 开启feign功能
public class FeignConsumerApplication {

    // TODO 添加编码过滤器
    @Bean
    public CharacterEncodingFilter characterEncodingFilter() {
        return new CharacterEncodingFilter("utf-8", true);
    }

    // TODO 修复服务返回乱码问题
    @Bean
    public StringHttpMessageConverter stringHttpMessageConverter() {
        return new StringHttpMessageConverter(Charset.forName("utf-8"));
    }

    public static void main(String[] args) {
        SpringApplication.run(FeignConsumerApplication.class, args);
    }
}
