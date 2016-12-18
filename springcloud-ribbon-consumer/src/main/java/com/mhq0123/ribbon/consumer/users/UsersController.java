package com.mhq0123.ribbon.consumer.users;

import com.mhq0123.ribbon.consumer.users.service.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mhq0123 on 2016/12/17.
 */
@RestController
public class UsersController {

    private final static Logger logger = LoggerFactory.getLogger(UsersController.class);

    @Autowired
    private UsersService usersService;

    /**
     * 根据用户类型、用户编号查询用户
     * @param userType
     * @param userId
     * @return
     */
    @RequestMapping(value = "/selectUserByUserId", method = RequestMethod.GET)
    public String selectUserByUserId(@RequestParam("userType") String userType, @RequestParam("userId") String userId) {

        logger.info(">>>>>>>>>>>>---userType:{},userId:{}----<<<<<<<<<<", userType, userId);

        return usersService.selectUserByUserId(userType, userId);
    }
}
