package com.zhangyu.advice;

import com.zhangyu.exception.NoCustomerFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class CustomerControllerAdvice {

    @ResponseBody
    @ExceptionHandler(NoCustomerFoundException.class)
    public String handleNoCustomerFoundException(HttpServletResponse response) {
        response.setStatus(404);
        return "no customer was found";
    }
}
