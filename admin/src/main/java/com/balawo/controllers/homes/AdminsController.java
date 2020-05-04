package com.balawo.controllers.homes;

import com.balawo.models.Admin;
import com.balawo.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
@RequestMapping("/admins")
public class AdminsController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/index")
    public String index(@RequestParam(value = "page",defaultValue = "1") Integer page, Model model) {
        //    @bread_menu = {m1: '订单管理', m2: '取消订单', m2_url: '/crms/minsus/orders/cancel_order', m3: '订单列表', s: "minsu_cancel_order_search"}

        var breadMenu = new HashMap<String,String>();
        breadMenu.put("m1","主页");
        breadMenu.put("m2","管理员");
        breadMenu.put("m2_url","/crms/admins/index");
        breadMenu.put("m3","管理员列表");
        var admins = adminService.findAll(page);
        model.addAttribute("admins", admins);
        model.addAttribute("current_page",page);
        model.addAttribute("adminStatus",Admin.Status);
        model.addAttribute("breadMenu",breadMenu);
        return "views/homes/admins/index";
    }

    @PostMapping("/update")
    public String update(HttpServletRequest request){
        var admin = adminService.findById(Long.parseLong(request.getParameter("adminId")));
        admin.setNickname(request.getParameter("nickname"));
        admin.setName(request.getParameter("name"));
        admin.setPhone(request.getParameter("phone"));
        admin.setEmail(request.getParameter("email"));
        adminService.updateAdmin(admin);
        return "redirect:/admins/index";
    }

    @PostMapping("/set_admin_status")
    public String set_admin_status(HttpServletRequest request){
        var admin = adminService.findById(Long.parseLong(request.getParameter("adminId")));
        admin.setStatus(Integer.parseInt(request.getParameter("status")));
        adminService.updateAdmin(admin);
        //return "redirect:/admins/index";
        return "redirect:" + request.getHeader("Referer");

    }

}
