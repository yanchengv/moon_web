package com.balawo;

import com.balawo.config.QiqiuProperties;

import com.balawo.models.User;
import com.balawo.repository.UserRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

//spring jpa测试会默认使用内置数据库代替项目中的，如果不希望替换则使用AutoConfigureTestDatabase注解明确指定
@AutoConfigureTestDatabase(replace = NONE)
@RunWith(SpringRunner.class)
@DataJpaTest
class AdminApplicationTests {
    @Autowired
    private UserRepository userRepository;


    @Test
    void contextLoads() {
    }

    @Test
    public void test() {
//       var user = userRepository.findById(1);
//        System.out.println(user);
        var users = userRepository.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    //测试sha1密码加密，等同于ruby的密码加密Digest::SHA1.hexdigest()方法
    @Test
    public void sha1() {
        System.out.println(11212312);
        System.out.println(DigestUtils.sha1Hex("123"));
    }

}
