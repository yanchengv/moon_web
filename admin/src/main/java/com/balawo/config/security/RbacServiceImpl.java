package com.balawo.config.security;

import com.balawo.services.manages.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;


/**
 * 用户权限验证，查看用户用户使用拥有当前访问界面的权限
 */
@Component("rbacService")
public class RbacServiceImpl implements RbacService {
    @Autowired
    private AuthorityService authorityService;

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        Object principal = authentication.getPrincipal();
        boolean hasPermission = false;
        if (principal instanceof UserDetails) { //首先判断先当前用户是否是我们UserDetails对象。
            String userName = ((UserDetails) principal).getUsername();
            Set<String> urls = new HashSet<>(); // 数据库读取 //读取用户所拥有权限的所有URL
            //获取系统所有的权限
            var allAuthorities = authorityService.getAllAuthorities();
            urls.add("/crms/");
            urls.add("/crms/admins/index");
            urls.add("/crms/admins/new");
            urls.add("/crms/admins/create");
            urls.add("/crms/roles/index");
            urls.add("/crms/roles/new");
            urls.add("/crms/roles/create");
            urls.add("/crms/authorites/index");

            System.out.println("查看用户用户使用拥有当前访问界面的权限");
            var requestURI = request.getRequestURI();
            System.out.println(requestURI);

            //如果系统所有权限不包含当前访问的uri,则不需要校验，直接可以访问
            if (!allAuthorities.contains(requestURI)) {
                return true;
            }
            // 注意这里不能用equal来判断，因为有些URL是有参数的，所以要用AntPathMatcher来比较
            for (String url : urls) {
                if (antPathMatcher.match(url, requestURI)) {
                    hasPermission = true;
                    break;
                }
            }
        }
        return hasPermission;
    }
}
