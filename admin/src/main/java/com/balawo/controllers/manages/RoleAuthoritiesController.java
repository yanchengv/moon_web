package com.balawo.controllers.manages;

import com.balawo.models.RoleAuthority;
import com.balawo.services.manages.RoleAuthorityService;
import com.balawo.services.manages.RoleService;
import org.codehaus.groovy.transform.SourceURIASTTransformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Controller
@RequestMapping("/roleAuthorities")
public class RoleAuthoritiesController {

    @Autowired
    private RoleAuthorityService roleAuthorityService;
    @Autowired
    private RoleService roleService;

    @PostMapping("/create")
    public String create(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        RoleAuthority roleAuthority = new RoleAuthority();
        var roleId = request.getParameter("roleId");
        var roleIdL = Long.parseLong(roleId);

        String[] authIds = request.getParameterValues("authority_ids");
        var newAuthIds = new ArrayList<Long>();
        var oldAuthIds = roleService.findAllAuthIds(roleIdL);
        for (var authId : Arrays.asList(authIds)) {
            var authIdL = Long.parseLong(String.valueOf(authId));
            newAuthIds.add(authIdL);
        }

        //获取要新添加的权限ID
        var addAuthIds = newAuthIds.stream().filter(item -> !oldAuthIds.contains(item)).collect(toList());
        //获取要删除的权限ID
        var deleteAuthIds = oldAuthIds.stream().filter(item -> !newAuthIds.contains(item)).collect(toList());
        System.out.println("addAuthIds===" + addAuthIds);
        System.out.println("deleteAuthIds===" + deleteAuthIds);

        //保存新增的权限ID
        for (Long authId : addAuthIds) {
            var authRoleList = roleAuthorityService.findByAuthIdAndRoleId(authId, roleIdL);
            // 判断集合list是否为空,同时判断list为null，为空集合
            if (!CollectionUtils.isEmpty(authRoleList)) {
                //如果角色已存在此权限，则跳过不保存
                continue;
            }
            var roleAuth = new RoleAuthority();
            roleAuth.setRole_id(roleIdL);
            roleAuth.setAuthority_id(authId);
            roleAuthorityService.create(roleAuth);
        }

        //删除的权限ID
        for (Long authId : deleteAuthIds) {
            roleAuthorityService.delete(authId, roleIdL);
        }


        redirectAttributes.addFlashAttribute("flashMsg", "保存成功");
        return "redirect:/authorites/index?roleId=" + roleId;
    }
}
