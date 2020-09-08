package com.balawo.controllers;

import com.balawo.models.Admin;
import com.balawo.models.User;
import com.balawo.services.AdminService;
import com.balawo.services.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;

@Controller
public class SessionController {
    private static final Logger log = LoggerFactory.getLogger(SessionController.class);

    @Autowired
    private AdminService adminService;

    /**
     * 登录界面
     *
     * @return
     */
    @RequestMapping("/login")
    public String loginIndex(@RequestParam(name = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("login_error", "用户名或者密码不正确！");
        }
        return "views/sessions/login";
    }

    @PostMapping(path = "/admin_login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        var admin = adminService.findByEmail(email);
        if (admin == null) {
            log.warn("用户不存在");
            model.addAttribute("login_error", "用户名或者密码不正确！");
            return "views/sessions/login";
        }
        if (adminService.password_validate(admin, password)) {
            log.warn("密码不正确");
            model.addAttribute("login_error", "用户名或者密码不正确！");
            return "views/sessions/login";
        }
        log.info("登录成功");
        return "redirect:/admins/index";
    }
}
