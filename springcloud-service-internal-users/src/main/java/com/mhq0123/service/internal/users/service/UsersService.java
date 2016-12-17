package com.mhq0123.service.internal.users.service;

import com.mhq0123.service.internal.users.bean.User;
import org.springframework.stereotype.Service;

/**
 * Created by mhq0123 on 2016/12/17.
 */
@Service
public class UsersService {

    /**
     * 根据用户编号查询用户
     * @param userId
     * @return
     */
    public User selectUserByUserId(String userId) {
        User user = new User();
        user.setUserId(userId);
        user.setUserName("internal-user");

        return user;
    }
}
