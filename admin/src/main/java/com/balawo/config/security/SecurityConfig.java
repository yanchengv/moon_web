package com.balawo.config.security;


import com.balawo.config.security.MyAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configurable
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) //配置后会拦截注解了@PreAuthrize注解的方法  @PreAuthorize("hasAnyRole('admin')")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyAuthenticationProvider myAuthenticationProvider;


    /**
     * 自定义获取用户信息接口
     *
     * @param
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(myAuthenticationProvider);
//        auth.inMemoryAuthentication()
//                .passwordEncoder(new BCryptPasswordEncoder())
//                .withUser("admin")
//                .password(new BCryptPasswordEncoder().encode("123"))
//                .roles("admin");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable(); //解决 in a frame because it set 'X-Frame-Options' to 'DENY' 问题
        http.authorizeRequests()
                .antMatchers("/coreui/**", "/webjars/**", "/bootstrap/**", "/login", "/register", "/crms/admin_login")//不拦截登录相关方法
                .permitAll()
                //.antMatchers("/user/**").hasAnyRole("USER") // 需要具有ROLE_USER角色才能访问
                //.antMatchers("/admins/**").hasAnyRole("ADMIN") // 需要具有ROLE_ADMIN角色才能访问
                //.anyRequest().authenticated() 				// 任何请求,登录后可以访问 必须经过认证以后才能访问
                .anyRequest().access("@rbacService.hasPermission(request,authentication)")    //必须经过认证以后才能访问
                .and()
                .exceptionHandling().accessDeniedHandler(new CustomAccessDeniedHandler())
                .and()
                .formLogin()
                .loginPage("/login") // 设置登录页面
                .usernameParameter("username")
                .passwordParameter("password")
                .loginProcessingUrl("/crms/admin_login") // 自定义的登录接口
                .defaultSuccessUrl("/admins/index") //成功登陆后跳转页面
                .failureUrl("/login?error=error")
                .permitAll() //permitAll()表示这个不需要验证 登录页面，登录失败页面
                .and().csrf().disable();                    // 关闭csrf防护
        ;
    }


}
