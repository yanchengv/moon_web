package com.balawo.config.security;


import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 无访问权限的处理器
 */
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {

        //json格式返回
//        response.setContentType("application/json;charset=UTF-8");
//        response.getWriter().append(
//                new ObjectMapper().createObjectNode()
//                        .put("status", 401)
//                        .put("msg", "无访问权限")
//                        .toString());
        // System.out.println("Referer: " + request.getHeader("Referer"));
        response.sendRedirect(request.getHeader("Referer"));
    }
}
