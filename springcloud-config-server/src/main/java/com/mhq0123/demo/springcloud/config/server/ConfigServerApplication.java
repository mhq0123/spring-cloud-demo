package com.mhq0123.demo.springcloud.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Created by mahq on 2016/12/15.
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {
    /**
     * 配置服务
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
