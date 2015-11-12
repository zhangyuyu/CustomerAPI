package com.zhangyu.advice;

import com.zhangyu.exception.NoCustomerFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class CustomerControllerAdvice {

    @ExceptionHandler(NoCustomerFoundException.class)
    @ResponseStatus(value= BAD_REQUEST)
    @ResponseBody
    public String handleNoCustomerFoundException(HttpServletRequest request,NoCustomerFoundException exception) {
        Map<String, Object> errorMap = new HashMap<String, Object>();
        errorMap.put("status", BAD_REQUEST );
        errorMap.put("Request", request.getRequestURL());
        errorMap.put("messge", exception.getMessage());
        return errorMap.toString();
    }
}
