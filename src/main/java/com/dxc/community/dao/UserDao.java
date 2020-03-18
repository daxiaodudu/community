package com.dxc.community.dao;

import com.dxc.community.pojo.UserDomain;
import org.apache.ibatis.annotations.Mapper;


/**
 * description: UserDao <br>
 * date: 2020/3/12 13:52 <br>
 * author: duxuecheng <br>
 * version: 1.0 <br>
 */
@Mapper
public interface UserDao {

    UserDomain getUser(UserDomain userDomain);

}
