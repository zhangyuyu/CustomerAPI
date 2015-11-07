package com.zhangyu.filter;


import javax.servlet.*;
import java.io.IOException;

public class CustomerFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("*********************************************");
    }

    @Override
    public void destroy() {

    }

}
