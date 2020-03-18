package com.dxc.community;

import com.dxc.community.pojo.UserDomain;
import com.dxc.community.service.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        UserDomain userDomain = new UserDomain();
        userDomain.setUsername("admin");
        userDomain.setPassword("123456");
        userDomain = userService.getUser(userDomain);

        System.out.println(userDomain);
    }

}
