package com.zhangyu.log;

import com.zhangyu.entity.Customer;
import org.apache.log4j.Logger;

import static java.lang.String.format;

public class LogCustomer {

    final Logger logger=Logger.getLogger(LogCustomer.class);

    public void logCustomer(Customer customer){
        logger.info(format("Create customer %s", customer.getFirstName()));
    }

    public void logMessage(String message){
        logger.info(message);
    }
}