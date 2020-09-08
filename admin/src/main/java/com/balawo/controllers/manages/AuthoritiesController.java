package com.balawo.controllers.manages;

import com.balawo.repository.manages.AuthorityRepository;
import com.balawo.services.manages.AuthorityService;
import com.balawo.services.manages.RoleAuthorityService;
import com.balawo.services.manages.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
@RequestMapping("/authorites")
public class AuthoritiesController {

    @Autowired
    private AuthorityService authorityService;
    @Autowired
    private RoleService roleService;

    @GetMapping("/index")
    public String index(@RequestParam(value = "1", defaultValue = "1") Integer page, String roleId, Model model) {
        var breadMenu = new HashMap<String, String>();
        breadMenu.put("m1", "系统管理");
        breadMenu.put("m2", "角色管理");
        breadMenu.put("m2_url", "/crms/roles/index");
        breadMenu.put("m3", "权限列表");
        var authMap = authorityService.getAllAuthoritiesGroupByType();
        var AuthIdsOfRole = roleService.findAllAuthIds(Long.parseLong(roleId));
        System.out.println(AuthIdsOfRole);
        model.addAttribute("authorities", authMap);
        model.addAttribute("roleId", roleId);
        model.addAttribute("AuthIdsOfRole", AuthIdsOfRole);
        model.addAttribute("breadMenu", breadMenu);
        return "/views/manages/authorities/index";
    }
}
