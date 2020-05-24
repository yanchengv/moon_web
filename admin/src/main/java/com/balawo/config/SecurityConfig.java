package com.balawo.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configurable
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Override
//    public void configure(WebSecurity webSecurity){
//        //不拦截静态资源,所有用户均可访问的资源
//        webSecurity.ignoring().antMatchers(
//                "/static/**",
//                "/webjars/**",
//                "/bootstrap/**"
//        );
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable(); //解决 in a frame because it set 'X-Frame-Options' to 'DENY' 问题
        http.authorizeRequests()
                .antMatchers( "/coreui/**", "/webjars/**","/bootstrap/**","/login","/register")//不拦截登录相关方法
                .permitAll()
//                .antMatchers("/user/**").hasAnyRole("USER") // 需要具有ROLE_USER角色才能访问
//                .antMatchers("/admin/**").hasAnyRole("ADMIN") // 需要具有ROLE_ADMIN角色才能访问
                .anyRequest().authenticated()
                .and()
                .cors().and()
                .formLogin()
                .loginPage("/login") // 设置登录页面
                .loginProcessingUrl("/authentication/form")
                .defaultSuccessUrl("/user/index") // 设置默认登录成功后跳转的页面
        ;
    }

    /**
     * 自定义获取用户信息接口
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    }
}
