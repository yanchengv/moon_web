package com.balawo.services;

import com.balawo.models.Role;
import com.balawo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Page<Role> findAll(Integer page){
        page -= 1;
        Pageable pageable = PageRequest.of(page, 10, Sort.by("id").ascending());
        Page<Role> roles =   roleRepository.findAll(pageable);
        return roles;
    }

    public void createRole(Role role){
        roleRepository.save(role);
    }
}
