package com.stu212306105.helloserver.interceptor;

import com.stu212306105.helloserver.common.ResultCode;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        boolean isRegister = "POST".equalsIgnoreCase(request.getMethod()) && "/api/users".equals(uri);
        boolean isLogin = "POST".equalsIgnoreCase(request.getMethod()) && "/api/users/login".equals(uri);

        if (isRegister || isLogin) {
            return true;
        }

        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty()) {
            response.setContentType("application/json;charset=UTF-8");
            String errorJson = "{\"code\": " + ResultCode.TOKEN_INVALID.getCode() + ",\"msg\":\"" + ResultCode.TOKEN_INVALID.getMsg() + "\",\"data\": null}";
            response.getWriter().write(errorJson);
            return false;
        }

        return true;
    }
}