package com.balawo.services.manages;

import com.balawo.models.Role;
import com.balawo.models.RoleAuthority;
import com.balawo.repository.manages.RoleAuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleAuthorityService {

    @Autowired
    private RoleAuthorityRepository roleAuthorityRepository;

    public void create(RoleAuthority roleAuthority){
        roleAuthorityRepository.save(roleAuthority);
    }

    public List<RoleAuthority> findByAuthIdAndRoleId(Long authorityId,Long roleId){
        var roleAuthList = roleAuthorityRepository.findByAuthIdAndRoleId(authorityId,roleId);
        return roleAuthList;
    }

    // 删除角色权限记录
    public void delete(Long authorityId,Long roleId){
       roleAuthorityRepository.deleteByAuthorityIdAndRoleId(authorityId,roleId);

    }

}
