package com.dxc.community.service.user.impl;

import com.dxc.community.constant.ErrorConstant;
import com.dxc.community.dao.UserDao;
import com.dxc.community.exception.BusinessException;
import com.dxc.community.pojo.UserDomain;
import com.dxc.community.service.user.UserService;
import com.dxc.community.utils.DuDuUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * description: UserServiceImpl <br>
 * date: 2020/3/12 13:55 <br>
 * author: duxuecheng <br>
 * version: 1.0 <br>
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDomain getUser(UserDomain userDomain) {
        if (null == userDomain)
            throw new BusinessException(ErrorConstant.Common.PARAM_IS_EMPTY);
        if (null == userDomain.getUsername() || null == userDomain.getPassword())
            throw new BusinessException(ErrorConstant.Common.PARAM_IS_EMPTY);
        userDomain.setPassword(DuDuUtils.MD5encode(userDomain.getPassword()));
        return userDao.getUser(userDomain);

    }

    @Override
    public UserDomain getUserByid(Integer uid) {
        if (null == uid)
            throw new BusinessException(ErrorConstant.Common.PARAM_IS_EMPTY);

        UserDomain userDomain = new UserDomain();
        userDomain.setUid(uid);

        return userDao.getUser(userDomain);
    }
}
