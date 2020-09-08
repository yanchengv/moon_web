package com.balawo.controllers.manages;

import com.balawo.models.Role;
import com.balawo.services.manages.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
@RequestMapping("/roles")
public class RolesController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/index")
    public String index(@RequestParam(value = "1", defaultValue = "1") Integer page, Model model) {
        var breadMenu = new HashMap<String, String>();
        breadMenu.put("m1", "系统管理");
        breadMenu.put("m2", "角色管理");
        breadMenu.put("m2_url", "/crms/roles/index");
        breadMenu.put("m3", "角色列表");

        var roles = roleService.findAll(page);
        model.addAttribute("roles", roles);
        model.addAttribute("breadMenu", breadMenu);
        return "views/manages/roles/index";
    }

    @GetMapping("/new")
    public String newOne(Model model) {
        var breadMenu = new HashMap<String, String>();
        breadMenu.put("m1", "系统管理");
        breadMenu.put("m2", "角色管理");
        breadMenu.put("m2_url", "/crms/roles/index");
        breadMenu.put("m3", "新增角色");
        model.addAttribute("breadMenu", breadMenu);
        return "views/manages/roles/new";
    }

    @PostMapping("/create")
    public String create(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        var role = new Role();
        role.setName(request.getParameter("name"));
        role.setBrief(request.getParameter("brief"));
        redirectAttributes.addFlashAttribute("flashMsg", "创建成功");
        roleService.createRole(role);
        return "redirect:/roles/new";
    }
}
