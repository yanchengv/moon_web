package com.balawo.services;

import com.balawo.models.Admin;
import com.balawo.repository.AdminRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {


    @Autowired
    private AdminRepository adminRepository;


    public Page<Admin> findAll(Integer page) {
        page -= 1;
        Pageable pageable = PageRequest.of(page, 10, Sort.by("id").ascending());
        Page<Admin> admins = adminRepository.findAll(pageable);
        return admins;
    }


    public Admin findByEmail(String email) {
        var admin = adminRepository.findByEmail(email);
        return admin;
    }

    /**
     * 密码验证是否正确
     * DigestUtils.sha1Hex 等同于ruby的Digest::SHA1.hexdigest方法
     * @param admin
     * @param password
     * @return
     */
    public Boolean password_validate(Admin admin, String password) {
        var user_password = admin.getPassword();
        var p1 = DigestUtils.sha1Hex(password + admin.getSalt());
        if(user_password.equals(p1)){
            return true;
        }
        return false;
    }
}
