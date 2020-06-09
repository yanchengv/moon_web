package com.balawo.services;

import com.balawo.models.AdminInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyAdminDetailsService implements UserDetailsService {


    private AdminService adminService;

    @Autowired
    public MyAdminDetailsService(AdminService adminService){
        this.adminService = adminService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //这里可以可以通过username（登录时输入的用户名）然后到数据库中找到对应的用户信息，并构建成我们自己的UserInfo来返回。
        //这里可以通过数据库来查找到实际的用户信息，这里我们先模拟下,后续我们用数据库来实现
        System.out.println(username);
        var admin = adminService.findByEmail(username);

        if(admin != null) {
            //假设返回的用户信息如下;
            AdminInfo userInfo=new AdminInfo();
            userInfo.setName(admin.getName());
            userInfo.setPassword(admin.getPassword());
            userInfo.setNickname(admin.getNickname());
            userInfo.setPhone(admin.getPhone());
            userInfo.setEmail(admin.getEmail());
            return userInfo;
        }
        return null;
    }
}
