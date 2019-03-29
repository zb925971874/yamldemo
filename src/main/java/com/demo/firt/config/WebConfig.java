package com.demo.firt.config;

import com.demo.firt.web.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Configuration 拦截器的注册
 */
@Configuration
public class WebConfig  implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //设置拦截哪些路径
        //excludePathPatterns 此方法是设置不需要拦截的路径
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/login.html","/userlist.html","/updateuser.html");
    }
}
