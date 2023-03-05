package com.example.demoblogas.blogSecurity;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/blogs").setViewName("/blog/blogs");
        registry.addViewController("/").setViewName("/blog/blogs");
       // registry.addViewController("/login/blog1").setViewName("/login/blog1");
        registry.addViewController("/login").setViewName("/blog/login");

    }
}
