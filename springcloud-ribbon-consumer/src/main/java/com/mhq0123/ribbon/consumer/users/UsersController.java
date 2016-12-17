package com.mhq0123.ribbon.consumer.users;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by mhq0123 on 2016/12/17.
 */
@RestController
public class UsersController {

    private final static Logger logger = LoggerFactory.getLogger(UsersController.class);

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
    @RequestMapping(value = "/selectUserByUserId", method = RequestMethod.GET)
    public String selectUserByUserId(@RequestParam("userType") String userType, @RequestParam("userId") String userId) {

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
}
