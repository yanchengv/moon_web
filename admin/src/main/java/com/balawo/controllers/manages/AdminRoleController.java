package com.balawo.controllers.manages;

import com.balawo.models.AdminRole;
import com.balawo.models.Role;
import com.balawo.services.manages.AdminRoleService;
import com.balawo.services.manages.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Controller
@RequestMapping("/adminRoles")
public class AdminRoleController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private AdminRoleService adminRoleService;

    @GetMapping("/index")
    public String index(Long adminId, Model model) {

        var breadMenu = new HashMap<String, String>();
        breadMenu.put("m1", "主页");
        breadMenu.put("m2", "用户管理");
        breadMenu.put("m2_url", "/crms/admins/index");
        breadMenu.put("m3", "用户权限列表");
        List<Role> allRoles = roleService.findAll();
        var adminRoles = adminRoleService.findAllRoleIdsByAdminId(adminId);
        model.addAttribute("allRoles", allRoles);
        model.addAttribute("adminId", adminId);
        model.addAttribute("adminRoles", adminRoles);
        model.addAttribute("breadMenu", breadMenu);
        return "/views/manages/admin_roles/index";
    }

    @PostMapping("/create")
    public String create(Long adminId, Long[] roleIds, RedirectAttributes redirectAttributes) {
        var newRoleIds = Arrays.asList(roleIds);
        var oldRoleIds = adminRoleService.findAllRoleIdsByAdminId(adminId);

        var deleteRoleIds = oldRoleIds.stream().filter(item -> !newRoleIds.contains(item)).collect(toList());
        var addRoleIds = newRoleIds.stream().filter(item -> !oldRoleIds.contains(item)).collect(toList());

        //保存新增角色
        for (Long roleId : addRoleIds) {
            AdminRole adminRole = new AdminRole();
            adminRole.setAdmin_id(adminId);
            adminRole.setRole_id(roleId);
            adminRoleService.create(adminRole);
        }
        //删除旧的角色
        for (Long roleId : deleteRoleIds) {
            adminRoleService.delete(adminId, roleId);
        }
        redirectAttributes.addFlashAttribute("flashMsg", "保存成功");
        return "redirect:/adminRoles/index?adminId=" + adminId;
    }
}
