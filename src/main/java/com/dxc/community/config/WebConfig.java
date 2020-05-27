package com.dxc.community.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

/**
 * description: WebConfig <br>
 * date: 2020/3/16 13:46 <br>
 * author: duxuecheng <br>
 * version: 1.0 <br>
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private MyInterception myInterception;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(myInterception).addPathPatterns("/**")
                .excludePathPatterns("/login", "/LoginTo"
                        , "/css/**", "/img/**"
                        , "/js/**", "/static/**"
                        , "/fonts/**"
                        , "/comments/**");
    }


    /*
     * description: 创建简单异常对象处理类  <br>
     *缺点：只能实现异常类与错误页面的映射 ，而不能让错误页面显示具体的错误
     * version: 1.0 <br>
     * date: 2020/5/6 18:20 <br>
     * author: duxuecheng <br>
     *
     * @param
     * @return org.springframework.web.servlet.handler.SimpleMappingExceptionResolver
     */
    @Bean
    public SimpleMappingExceptionResolver getSimpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
        Properties properties = new Properties();
       // properties.put("java.io.IOException","error"); //key：具体的异常类，value:报错页面
        resolver.setExceptionMappings(properties);
        return resolver;
    }
}
