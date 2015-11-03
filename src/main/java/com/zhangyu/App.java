package com.zhangyu;

import com.zhangyu.listener.CustomerListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(App.class);
        springApplication.addListeners(new CustomerListener());
        springApplication.run(args);
    }
}
