package com.zhangyu;

import com.zhangyu.filter.RequestLoggingFilter;
import com.zhangyu.interceptor.CustomerInterceptor;
import com.zhangyu.listener.CustomerListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(App.class);
        springApplication.addListeners(new CustomerListener());
        springApplication.run(args);
    }

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CustomerInterceptor())
                .addPathPatterns("/customers/**");
    }

    @Bean
    public FilterRegistrationBean requestLoggingFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new RequestLoggingFilter());
        return registrationBean;
    }
}
