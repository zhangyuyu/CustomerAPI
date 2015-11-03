package com.zhangyu.advice;

import com.zhangyu.exception.NoCustomerFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class NoCustomerFoundExceptionHandle {

    @ResponseBody
    @ExceptionHandler(NoCustomerFoundException.class)
    public String handleException() {
        return "no customer was found";
    }
}
