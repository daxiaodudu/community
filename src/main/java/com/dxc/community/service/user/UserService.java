package com.dxc.community.service.user;

import com.dxc.community.pojo.UserDomain;

/**
 * description: UserService <br>
 * date: 2020/3/12 13:53 <br>
 * author: duxuecheng <br>
 * version: 1.0 <br>
 */
public interface UserService {
    UserDomain getUser(UserDomain userDomain);

    UserDomain getUserByid(Integer uid);
}
