package com.dxc.community.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * description: WebConfig <br>
 * date: 2020/3/16 13:46 <br>
 * author: duxuecheng <br>
 * version: 1.0 <br>
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private  MyInterception myInterception;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(myInterception).addPathPatterns("/**")
               .excludePathPatterns("/login","/LoginTo","/static/**");
    }
}
