package com.balawo.controllers.my_advices;

import com.balawo.models.AdminInfo;
import com.balawo.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

//@ControllerAdvice ，很多初学者可能都没有听说过这个注解，实际上，这是一个非常有用的注解，顾名思义，这是一个增强的 Controller。使用这个 Controller ，可以实现三个方面的功能：
//    全局异常处理
//    全局数据绑定
//    全局数据预处理

@ControllerAdvice
public class MyGlobalExceptionHandlerController {

    @Autowired
    private AdminService adminService;

    //html页面全局获取当前用户的数据绑定
    @ModelAttribute
    public void currentUser(Model model, Authentication authentication) {
        System.out.println("currentUser*********");
        if (authentication != null) {
            AdminInfo currentUser = (AdminInfo) authentication.getPrincipal();
            if (currentUser != null) {
                model.addAttribute("currentUser", currentUser);
            }
        }

    }

    @ModelAttribute
    public void myAuthorities(Model model, Authentication authentication) {
        System.out.println("myAuthorities**********");
        if (authentication != null) {
            AdminInfo currentUser = (AdminInfo) authentication.getPrincipal();
            if (currentUser != null) {
                var authUrls = adminService.findAdminAuthUrl(1L);
                model.addAttribute("myAuths", authUrls);
            }
        }


    }
}
