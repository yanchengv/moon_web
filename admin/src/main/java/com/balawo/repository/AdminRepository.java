package com.balawo.repository;

import com.balawo.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {

     @Query("select a from Admin a where a.email = ?1")
     Admin findByEmail(String email);


}
