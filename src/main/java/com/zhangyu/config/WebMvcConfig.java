package com.zhangyu.config;

import com.zhangyu.interceptor.CustomerInterceptor;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

@Configuration
public class WebMvcConfig extends WebMvcAutoConfigurationAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CustomerInterceptor()).addPathPatterns("/customers/**");
    }
}
