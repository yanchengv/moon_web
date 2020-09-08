package com.balawo.repository.manages;


import com.balawo.models.RoleAuthority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RoleAuthorityRepository extends JpaRepository<RoleAuthority, Long> {

    //根据角色和权限ID获取列表
    @Query(value = "select * from role_authorities where authority_id = ?1 and role_id = ?2", nativeQuery = true)
    List<RoleAuthority> findByAuthIdAndRoleId(Long authorityId, Long roleId);

    //根据角色ID获取对应的所有权限Id
    @Query(value = "select authority_id from role_authorities where role_id = ?1 ", nativeQuery = true)
    List<Long> findAllAuthIdByRoleId(Long roleId);

    @Modifying
    @Transactional
    @Query(value = "delete from role_authorities where authority_id = ?1 and role_id = ?2", nativeQuery = true)
    void deleteByAuthorityIdAndRoleId(Long authorityId, Long roleId);
}
