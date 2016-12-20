package com.mhq0123.feign.consumer.users;

import com.mhq0123.feign.consumer.users.client.ExternalUsersServiceClient;
import com.mhq0123.feign.consumer.users.client.InternalUsersServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    private ExternalUsersServiceClient externalUsersServiceClient;
    @Autowired
    private InternalUsersServiceClient internalUsersServiceClient;

    /**
     * 根据用户类型、用户编号查询用户
     * @param userType
     * @param userId
     * @return
     */
    // TODO 效果一样
    // @RequestMapping(value = "/selectUserByUserId", method = RequestMethod.GET)
    @GetMapping("/selectUserByUserId")
    public String selectUserByUserId(@RequestParam("userType") String userType, @RequestParam("userId") String userId) {

        logger.info(">>>>>>>>>>>>---userType:{},userId:{}----<<<<<<<<<<", userType, userId);

        if("external".equals(userType)) {
            return externalUsersServiceClient.selectUserByUserId(userId);
        } else if("internal".equals(userType)) {
            return internalUsersServiceClient.selectUserByUserId(userId);
        }
        throw new IllegalArgumentException("暂不支持的用户类型" + userType);
    }
}
