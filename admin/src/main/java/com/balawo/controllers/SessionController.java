package com.balawo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SessionController {

    /**
     * 登陆界面
     * @return
     */
    @RequestMapping("/login")
    public String loginIndex(){
        return "views/sessions/login";
    }

    @RequestMapping(path = "/login",method = RequestMethod.POST)
    public void login(){

    }
}
