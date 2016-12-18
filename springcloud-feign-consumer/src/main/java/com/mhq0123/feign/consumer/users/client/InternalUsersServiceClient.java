package com.mhq0123.feign.consumer.users.client;

import com.mhq0123.feign.consumer.users.hystrix.InternalUsersServiceClientHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by mhq0123 on 2016/12/17.
 * 定义接口 并用注解FeignClient 去注册中心查找服务实现
 *
 * 实际开发中可以在服务boot用中创建xxx-service-client 模块，外部调用直接引入即可
 *
 * feign 自动集成hystrix ，在FeignClient注解里声明回调对应的类，并且此类实现此接口即可
 */
@FeignClient(value = "springcloud-service-internal-users", fallback = InternalUsersServiceClientHystrix.class)
public interface InternalUsersServiceClient {

    /**
     * 根据用户编号查询用户
     * @param userId
     * @return
     */
    @RequestMapping(value = "/selectUserByUserId", method = RequestMethod.GET)
    String selectUserByUserId(@RequestParam("userId") String userId);
}
