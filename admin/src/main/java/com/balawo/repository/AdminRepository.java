package com.balawo.repository;

import com.balawo.models.Admin;
import com.balawo.models.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {

     /**
      * 根据邮箱查找管理员
      * @param email
      * @return
      */
     @Query("select a from Admin a where a.email = ?1")
     Admin findByEmail(String email);

     /**
      * 查询管理员拥有的所有权限
      * @param adminId
      * @return
      */
     @Query(value = "select distinct  authorities.id,authorities.name,authorities.action from authorities " +
             "inner join role_authorities as ra on ra.authority_id = authorities.id " +
             "inner join admin_roles as ar on ar.role_id = ra.role_id " +
             "where ar.admin_id = ?1",nativeQuery = true)
     List<Object[]> findAllAuthorities(Long adminId);

}
