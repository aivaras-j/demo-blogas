package com.example.demoblogas.blogSecurity;


import com.example.demoblogas.blogSecurity.User.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class CustomSecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
  //      return new BCryptPasswordEncoder();
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authenticationProvider(authenticationProvider());

        return http.csrf().disable()
                .authorizeHttpRequests().requestMatchers("/", "/blogs", "/blogs/{id}", "/style/**", "/resources/**", "/webjars/**", "/error", "/register",
                        "/blogs/page/**", "/h2-console/**").permitAll()
                .and()
                .authorizeHttpRequests().requestMatchers("/user/**").hasAuthority("USER")
                .and()
                .authorizeHttpRequests().requestMatchers("/admin/**").hasAuthority("ADMIN")
           //     .and()
          //      .authorizeHttpRequests().requestMatchers("/blogs/**").hasAnyAuthority("ADMIN, USER")
                .anyRequest()
                .authenticated()
                .and()
                  .formLogin()
                  .loginPage("/user/login")
                  .loginProcessingUrl("/user/login")
                  .usernameParameter("username")
                  .defaultSuccessUrl("/blogs", true)
                  .permitAll()
                .and()
//                 .formLogin()
//                 .loginPage("/admin/admin/login")
//                 .usernameParameter("username")
//                 .loginProcessingUrl("/admin/admin/login")
//                . defaultSuccessUrl("/blogs")
//                 .permitAll()
//                .and()
                .logout()
                .logoutUrl("/user/logout")
                .logoutSuccessUrl("/blogs")
                .permitAll()
                .and()
//                  .logout()
//                  .logoutUrl("/admin/logout")
//                  .logoutSuccessUrl("/blogs")
//                  .permitAll()
//                .and()
                .build();
    }
}