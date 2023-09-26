package com.mehmetberkan.SpringInterceptor.config;

import com.mehmetberkan.SpringInterceptor.interceptor.SessionInterceptor;
import com.mehmetberkan.SpringInterceptor.interceptor.UserInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserInterceptor()).addPathPatterns("/users");
        registry.addInterceptor(new SessionInterceptor()).addPathPatterns("/users");
    }
}
