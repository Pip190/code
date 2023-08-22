package com.wo.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wo.utils.Result;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;

@Component
@Slf4j
public class AppAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Resource
    private ObjectMapper mapper;
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        Result<Object> result = Result.builder()
                .code(401)
                .message("登录失败")
                .build();
        String responseJson = mapper.writeValueAsString(result);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.print(responseJson);
        writer.flush();
    }
}
