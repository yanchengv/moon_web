package com.balawo.repository.manages;

import com.balawo.models.AdminRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface AdminRoleRepository extends JpaRepository<AdminRole, Long> {

    //根据管理员ID查询所有的角色ID
    @Query(value = "select role_id from admin_roles where admin_id = ?1", nativeQuery = true)
    List<Long> findAllRoleIdsByAdminId(Long adminId);

    @Modifying
    @Transactional
    @Query(value = "delete from admin_roles where admin_id = ?1 and role_id=?2 ", nativeQuery = true)
    void deleteAdminRoleByRoleIdAndAdminId(Long adminId, Long roleId);
}
