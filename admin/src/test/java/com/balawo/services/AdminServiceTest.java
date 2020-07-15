package com.balawo.services;

import com.balawo.models.Authority;
import com.balawo.repository.AdminRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import java.util.List;

import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@SpringBootTest
@AutoConfigureTestDatabase(replace = NONE)
@RunWith(SpringRunner.class)
//@DataJpaTest
public class AdminServiceTest {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private AdminService adminService;

    @Test
    public void findAllAuthorities(){
       List<Object[]> auths =  adminRepository.findAllAuthorities(1L);
        System.out.println(auths);
        System.out.println("1111111");
        for (Object[] auth:auths) {
            System.out.println("ID="+auth[0]+";name="+auth[1]+";action="+auth[2]);
        }
    }

    @Test
    public void findAdminAuthUrl(){
        var list = adminService.findAdminAuthUrl(1L);
        System.out.println(list);
    }
}
