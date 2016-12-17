package com.mhq0123.service.internal.users;

import com.mhq0123.service.internal.users.bean.User;
import com.mhq0123.service.internal.users.service.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mhq0123 on 2016/12/17.
 */
@RestController
public class InternalUsersController {

    private final static Logger logger = LoggerFactory.getLogger(InternalUsersController.class);

    @Autowired
    private UsersService usersService;

    /**
     * 根据编号查询用户
     * @param userId
     * @return
     */
    @RequestMapping(value = "/selectUserByUserId", method = RequestMethod.GET)
    public User selectUserByUserId(String userId) {
        logger.info(">>>>>>>>>>>>---{}----<<<<<<<<<<", userId);
        return usersService.selectUserByUserId(userId);
    }
}
