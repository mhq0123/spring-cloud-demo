package com.mhq0123.ribbon.consumer.users.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by mhq0123 on 2016/12/18.
 */
@Service
public class UsersService {

    private final static Logger logger = LoggerFactory.getLogger(UsersService.class);

    /**
     * 自动注入负载均衡rest服务模板
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 根据用户类型、用户编号查询用户
     * @param userType
     * @param userId
     * @return
     */
    // TODO 开启断路器功能 失败直接回调函数
    @HystrixCommand(fallbackMethod = "serviceFallBack")
    public String selectUserByUserId(String userType, String userId) {

        logger.info(">>>>>>>>>>>>---userType:{},userId:{}----<<<<<<<<<<", userType, userId);

        String serviceUrl = null;
        if("external".equals(userType)) {
            serviceUrl = "http://springcloud-service-external-users/selectUserByUserId?userId=" + userId;
        } else if("internal".equals(userType)) {
            serviceUrl = "http://springcloud-service-internal-users/selectUserByUserId?userId=" + userId;
        } else {
            throw new IllegalArgumentException("暂不支持的用户类型" + userType);
        }
        return restTemplate.getForEntity(serviceUrl, String.class).getBody();
    }

    public String serviceFallBack(String userType, String userId) {
        logger.info(this.getClass() + " is error, hold on...");
        return this.getClass() + " is error, hold on...";
    }
}
