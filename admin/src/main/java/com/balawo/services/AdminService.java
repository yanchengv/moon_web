package com.balawo.services;

import com.alibaba.fastjson.JSONObject;
import com.balawo.models.Admin;
import com.balawo.models.Authority;
import com.balawo.repository.AdminRepository;
import com.sun.xml.bind.v2.runtime.reflect.Lister;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;


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


    public Admin findById(Long id) {
        var admin = adminRepository.findById(id).get();
        return admin;
    }

    public Admin findByEmail(String email) {
        var admin = adminRepository.findByEmail(email);
        return admin;
    }

    public Admin updateAdmin(Admin admin) {
        var a = adminRepository.save(admin);
        return a;
    }

    public void createAdmin(Admin admin) {
        var a = adminRepository.save(admin);
    }

    //查询管理员拥有的所有权限的url
    public List findAdminAuthUrl(Long adminId) {
        var allAuths = adminRepository.findAllAuthorities(adminId);
        List<String> list = new ArrayList<String>();
        for (Object[] auth : allAuths) {
            list.add(String.valueOf(auth[2]));
        }
        return list;
    }

    //比较管理员是否拥有权限子菜单
    public static Boolean compareMyUrlAndSonUrl(List myAuths, List sonAuths) {
        var flag = false;
        for (var auth : sonAuths) {
            HashMap<String, String> authMap = JSONObject.parseObject(auth.toString(), HashMap.class);
            var url = authMap.get("url");
            //校验管理员拥有的权限是否包含父菜单下面的子连接,如果包含则显示父菜单名称
            if (myAuths.contains(url)) {
                flag = true;
                break;
            }
            ;
        }
        ;
        return flag;
    }


    /**
     * 密码验证是否正确
     * DigestUtils.sha1Hex 等同于ruby的Digest::SHA1.hexdigest方法
     *
     * @param admin
     * @param password
     * @return
     */
    public Boolean password_validate(Admin admin, String password) {
        var user_password = admin.getPassword();
        var p1 = DigestUtils.sha1Hex(password + admin.getSalt());
        if (user_password.equals(p1)) {
            return true;
        }
        return false;
    }

    public HashMap encrypt_password(String password) {
        var hashMap = new HashMap<String, String>();
        var salt = UUID.randomUUID().toString().replace("-", "");
        var pwd = DigestUtils.sha1Hex(password + salt);
        hashMap.put("pwd", pwd);
        hashMap.put("salt", salt);
        return hashMap;
    }

    public String getUuid() {
        var salt = UUID.randomUUID().toString().replace("-", "");
        return salt;
    }

}
