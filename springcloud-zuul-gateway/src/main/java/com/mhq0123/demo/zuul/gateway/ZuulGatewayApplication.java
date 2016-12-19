package com.mhq0123.demo.zuul.gateway;

import com.mhq0123.demo.zuul.gateway.filter.AccessTokenFilter;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * Created by mhq0123 on 2016/12/19.
 */
@EnableZuulProxy // TODO 开启zuul
@SpringCloudApplication //整合了@SpringBootApplication、@EnableDiscoveryClient、@EnableCircuitBreaker
public class ZuulGatewayApplication {

    /**
     * 开启过滤
     * @return
     */
    @Bean
    public AccessTokenFilter accessTokenFilter() {
        return new AccessTokenFilter();
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(ZuulGatewayApplication.class).web(true).run(args);
    }
}
