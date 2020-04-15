package com.dxc.community;

import com.dxc.community.dao.ContentsMapper;
import com.dxc.community.pojo.Contents;
import com.dxc.community.pojo.ContentsExample;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.List;
import java.util.Properties;

@SpringBootTest
class DemoApplicationTests {


    @Test
    void contextLoads() {
System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        String properties = System.getProperty("user.dir");
        System.out.println(properties);



//        UserDomain userDomain = new UserDomain();
//        userDomain.setUsername("admin");
//        userDomain.setPassword("123456");
//        userDomain = userService.getUser(userDomain);

//        System.out.println(userDomain);


    }

}
