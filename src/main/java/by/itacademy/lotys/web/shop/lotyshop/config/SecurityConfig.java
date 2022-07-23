package by.itacademy.lotys.web.shop.lotyshop.config;


import by.itacademy.lotys.web.shop.lotyshop.entities.enums.UserRole;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain userFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable();
        httpSecurity.cors().disable();
        httpSecurity.authorizeRequests()
                .antMatchers("/admin").hasRole(UserRole.ADMIN.name())
                .antMatchers("/users/").hasRole(UserRole.USER.name())
                .antMatchers("/","/users/create","/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .logout()
                .permitAll();
        return httpSecurity.build();
    }

}