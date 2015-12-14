package com.zhangyu.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EntryPoint extends BasicAuthenticationEntryPoint {

    public EntryPoint() {
        super();
    }

    public EntryPoint(String realm) {
        setRealmName(realm);
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            response.setHeader("Access-Control-Allow-Origin", getOrigin(request));
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Access-Control-Allow-Headers", "Authorization, x-requested-with, Origin");
        } else {
            super.commence(request, response, authException);
        }
    }

    private String getOrigin(HttpServletRequest request) {
        String origin = request.getHeader("origin");

        if (origin == null || origin.length() == 0) {
            return "*";
        }
        return origin;
    }
}
