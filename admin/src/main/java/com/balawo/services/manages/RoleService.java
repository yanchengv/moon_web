package com.balawo.services.manages;

import com.balawo.models.AdminRole;
import com.balawo.models.Role;
import com.balawo.repository.manages.RoleAuthorityRepository;
import com.balawo.repository.manages.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleAuthorityRepository roleAuthorityRepository;

    public List<Role> findAll() {
        List<Role> roles = roleRepository.findAll();
        return roles;
    }

    public Page<Role> findAll(Integer page) {
        page -= 1;
        Pageable pageable = PageRequest.of(page, 10, Sort.by("id").ascending());
        Page<Role> roles = roleRepository.findAll(pageable);
        return roles;
    }


    public void createRole(Role role) {
        roleRepository.save(role);
    }

    public List<Long> findAllAuthIds(Long roleId) {
        var authIds = roleAuthorityRepository.findAllAuthIdByRoleId(roleId);
        return authIds;
    }
}
