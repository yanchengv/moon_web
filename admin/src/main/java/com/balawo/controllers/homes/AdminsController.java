package com.balawo.controllers.homes;

import com.balawo.models.Admin;
import com.balawo.models.AdminInfo;
import com.balawo.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.HashMap;

@Controller
@RequestMapping("/admins")
public class AdminsController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/index")
    public String index(@RequestParam(value = "page", defaultValue = "1") Integer page, Model model,Authentication authentication) {
        //Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AdminInfo current_user = (AdminInfo)authentication.getPrincipal();
        var breadMenu = new HashMap<String, String>();
        breadMenu.put("m1", "主页");
        breadMenu.put("m2", "管理员");
        breadMenu.put("m2_url", "/crms/admins/index");
        breadMenu.put("m3", "管理员列表");
        var admins = adminService.findAll(page);
        model.addAttribute("admins", admins);
        model.addAttribute("current_page", page);
        model.addAttribute("adminStatus", Admin.Status);
        model.addAttribute("breadMenu", breadMenu);
        System.out.println("ID: "+current_user.getId() +"；Name:" + current_user.getName() + "；Phone:" + current_user.getPhone()+"；权限：" + current_user.getAuthorities());
        return "views/homes/admins/index";
    }

    //新增管理页面
    @GetMapping("/new")
    public String newOne(HttpServletRequest request, Model model) {
        var breadMenu = new HashMap<String, String>();
        breadMenu.put("m1", "主页");
        breadMenu.put("m2", "管理员");
        breadMenu.put("m2_url", "/crms/admins/index");
        breadMenu.put("m3", "新增管理员");
        model.addAttribute("breadMenu", breadMenu);
        return "views/homes/admins/new";
    }

    //创建管理员界面
    @PostMapping("/create")
    public String create(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        var nickname = request.getParameter("nickname");
        var name = request.getParameter("name");
        var email = request.getParameter("email");
        var phone = request.getParameter("phone");
        var password = request.getParameter("password");
        var salt = adminService.getUuid();
        var admin = new Admin();
        admin.setNickname(nickname);
        admin.setName(name);
        admin.setEmail(email);
        admin.setPhone(phone);
        admin.setSalt(salt);
        admin.setPassword(password);
        adminService.createAdmin(admin);
        redirectAttributes.addFlashAttribute("flashMsg", "创建成功");
        return "redirect:/admins/new";
    }

    @PostMapping("/update")
    public String update(HttpServletRequest request) {
        var admin = adminService.findById(Long.parseLong(request.getParameter("adminId")));
        admin.setNickname(request.getParameter("nickname"));
        admin.setName(request.getParameter("name"));
        admin.setPhone(request.getParameter("phone"));
        admin.setEmail(request.getParameter("email"));
        adminService.updateAdmin(admin);
        return "redirect:/admins/index";
    }

    @PostMapping("/set_admin_status")
    public String set_admin_status(HttpServletRequest request) {
        var admin = adminService.findById(Long.parseLong(request.getParameter("adminId")));
        admin.setStatus(Integer.parseInt(request.getParameter("status")));
        adminService.updateAdmin(admin);
        //return "redirect:/admins/index";
        return "redirect:" + request.getHeader("Referer");

    }


}
