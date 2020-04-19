package com.balawo.controllers;

import com.balawo.models.Admin;
import com.balawo.repository.AdminRepository;
import com.balawo.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/index")
    public String index(@RequestParam(value = "page",defaultValue = "1") Integer page, Model model) {
        var admins = adminService.findAll(page);
        model.addAttribute("admins", admins);
        return "views/homes/index";
    }

}
