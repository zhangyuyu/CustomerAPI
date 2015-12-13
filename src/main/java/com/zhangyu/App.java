package com.zhangyu;

import com.zhangyu.filter.RequestLoggingFilter;
import com.zhangyu.listener.CustomerListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(App.class);
        springApplication.addListeners(new CustomerListener());
        springApplication.run(args);
    }

    @Bean
    public FilterRegistrationBean requestLoggingFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new RequestLoggingFilter());
        return registrationBean;
    }
}
