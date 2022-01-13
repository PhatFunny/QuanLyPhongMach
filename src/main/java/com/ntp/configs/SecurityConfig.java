/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ntp.configs.handlers.LoginSuccessHandler;
import com.ntp.configs.handlers.LogoutHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author Admin
 */
//  extends WebSecurityConfigurerAdapter 
@Configuration
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.ntp.repository",
    "com.ntp.service"
})
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    private AuthenticationSuccessHandler loginSuccessHandler;
    
    @Autowired
    private LogoutSuccessHandler logoutHandler;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public AuthenticationSuccessHandler loginSuccessHandler(){
        return new LoginSuccessHandler();
    }
    
    @Bean
    public LogoutSuccessHandler logoutHandler(){
        return new LogoutHandler();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/").failureUrl("/login?error");      
        http.formLogin().successHandler(this.loginSuccessHandler);

//        http.logout().logoutSuccessUrl("/login");
        http.logout().logoutSuccessHandler(this.logoutHandler);
        
        http.exceptionHandling().accessDeniedPage("/login?accessDenied");
        
        http.authorizeRequests().antMatchers("/").permitAll()
//user admin
                .antMatchers("/**/medicine")
                .access("hasAnyRole('ROLE_ADMIN' ,'ROLE_BACSY')")
                .antMatchers("/phieukhambenh")
                .access("hasAnyRole('ROLE_ADMIN' ,'ROLE_BACSY')")
                .antMatchers("/toathuoc")
                .access("hasAnyRole('ROLE_ADMIN' ,'ROLE_BACSY')")
                .antMatchers("/hosobenhnhan/**")
                .access("hasRole('ROLE_USER')")
                .antMatchers("/lichkhamcanhan/**")
                .access("hasRole('ROLE_USER')")
                .antMatchers("/admin/**")
                .access("hasRole('ROLE_ADMIN')")
                .antMatchers("/lichkhambenhnhan/**")
                .access("hasRole('ROLE_YTA')");

        http.csrf().disable();
    }
    
    @Bean
    public Cloudinary cloudinary(){
        Cloudinary c = new Cloudinary(ObjectUtils.asMap(
               "cloud_name", "djfijumdi",
                "api_key", "764917583376422",
                "api_secret", "dRHvIQK9qZnTUbhFXPh3FFjh794",
                "secure", true
        ));
        return c;
    }

}
