package com.balawo.config;

import com.balawo.models.AdminInfo;
import com.balawo.services.MyAdminDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;


@Component
public class MyAuthenticationProvider implements AuthenticationProvider {
    /**
     * 注入我们自己定义的用户信息获取对象
     */

    private MyAdminDetailsService userDetailService;
    @Autowired
    public MyAuthenticationProvider(MyAdminDetailsService userDetailService){
        this.userDetailService = userDetailService;
    }



    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();// 这个获取表单输入中返回的用户名;
        String password = (String) authentication.getCredentials();// 这个是表单中输入的密码；
        System.out.println(userName);
        // 这里构建来判断用户是否存在和密码是否正确
        System.out.println(userDetailService);
        AdminInfo adminInfo = (AdminInfo) userDetailService.loadUserByUsername(userName); // 这里调用我们的自己写的获取用户的方法；
        System.out.println(adminInfo.getName());
        if (adminInfo == null){
            throw new BadCredentialsException("用户名不存在");
        }
        if (!adminInfo.getPassword().equals(password)){
            throw new BadCredentialsException("密码不正确");
        }
        return new UsernamePasswordAuthenticationToken(adminInfo,password);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
