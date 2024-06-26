package com.yunsheng.yunsheng_springboot_back.generator.Common;


import com.yunsheng.yunsheng_springboot_back.generator.Interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration


public class InterceptorConfig implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .excludePathPatterns("/login")
                .excludePathPatterns("/register")
                .excludePathPatterns("/error");
    }
}
