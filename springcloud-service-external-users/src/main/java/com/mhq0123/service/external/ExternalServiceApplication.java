package com.mhq0123.service.external;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by mhq0123 on 2016/12/17.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ExternalServiceApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ExternalServiceApplication.class).web(true).run(args);
    }
}
