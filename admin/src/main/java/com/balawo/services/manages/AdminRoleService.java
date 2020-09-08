package com.balawo.services.manages;


import com.balawo.models.AdminRole;
import com.balawo.repository.manages.AdminRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdminRoleService {

    @Autowired
    private AdminRoleRepository adminRoleRepository;


    //根据管理员ID查询所有角色ID
    public List<Long> findAllRoleIdsByAdminId(Long adminId) {
        var allRoleIds = adminRoleRepository.findAllRoleIdsByAdminId(adminId);
        return allRoleIds;
    }


    public void create(AdminRole adminRole) {
        adminRoleRepository.save(adminRole);
    }

    public void delete(Long adminId, Long roleId) {
        adminRoleRepository.deleteAdminRoleByRoleIdAndAdminId(adminId, roleId);
    }


}
