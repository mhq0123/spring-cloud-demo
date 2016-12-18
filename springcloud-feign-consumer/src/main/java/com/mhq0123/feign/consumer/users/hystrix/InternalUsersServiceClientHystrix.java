package com.mhq0123.feign.consumer.users.hystrix;

import com.mhq0123.feign.consumer.users.client.InternalUsersServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by mhq0123 on 2016/12/18.
 *
 * feign 自动集成hystrix 断路器回调类
 */
@Component // 容器管理
public class InternalUsersServiceClientHystrix implements InternalUsersServiceClient{

    private final static Logger logger = LoggerFactory.getLogger(InternalUsersServiceClientHystrix.class);

    @Override
    public String selectUserByUserId(@RequestParam("userId") String userId) {
        logger.info(this.getClass() + " is error, hold on...");
        return this.getClass() + " is error, hold on...";
    }
}
