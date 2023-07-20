package com.example.minStudy.config;

import com.example.minStudy.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    MemberService userService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests((requests) -> requests
                                .requestMatchers("/", "/Member/**", "/item/**", "/images/**").permitAll()
                                .requestMatchers("/css/**", "/js/**", "/img/**").permitAll()
                                .requestMatchers("/account/**").permitAll()
//                    .requestMatchers("/admin/**").hasRole("ADMIN")
//                    .requestMatchers("/user/**").hasRole("USER")
                                .anyRequest().authenticated()
                )
                .formLogin(
                        (form) -> form
//                    .loginPage("/account/login")
//                        .defaultSuccessUrl("/")
//                        .failureUrl("/account/login?error")
                                .permitAll()
                )
                .logout(  (logout) -> logout.permitAll()  );
        return http.build();
    }


}