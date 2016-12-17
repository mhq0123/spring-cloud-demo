package com.mhq0123.feign.consumer.users.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by mhq0123 on 2016/12/17.
 */
@FeignClient("springcloud-service-internal-users")
public interface InternalUsersServiceClient {

    /**
     * 根据用户编号查询用户
     * @param userId
     * @return
     */
    @RequestMapping(value = "/selectUserByUserId", method = RequestMethod.GET)
    String selectUserByUserId(@RequestParam("userId") String userId);
}
