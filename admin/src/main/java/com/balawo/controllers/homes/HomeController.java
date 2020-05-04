package com.balawo.controllers.homes;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;

@Controller
public class HomeController {

    //管理系统主页
    @GetMapping("/")
    public String index(Model model){
        var breadMenu = new HashMap<String,String>();
        breadMenu.put("m1","管理系统");
        breadMenu.put("m2","首页");
        breadMenu.put("m2Url","/crms");
        breadMenu.put("m3","首页");
        model.addAttribute("breadMenu",breadMenu);
        return "views/homes/home/index";
    }
}
