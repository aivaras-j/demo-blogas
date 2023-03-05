//package com.example.demoblogas.blogSecurity;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .authorizeHttpRequests((requests) -> requests
//                        .requestMatchers("/", "/blogs", "/style/**", "/resources/**", "/webjars/**").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .formLogin((form) -> form
//                        .loginPage("/login")
//                        .defaultSuccessUrl("/blogs", true)
//                        .permitAll()
//                )
//                .logout((logout) -> logout
//                        .permitAll()
//                )
//                .build();
//    }
//}