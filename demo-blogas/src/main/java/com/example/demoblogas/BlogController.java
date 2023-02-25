package com.example.demoblogas.blog;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
public class BlogController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    com.example.demoblogas.blog.BlogsService service;

    @GetMapping("/blogs/page/{pageNumber}")
    public String page(@PathVariable("pageNumber") int currentPage, Model model){
        Page<com.example.demoblogas.blog.Blog> page = service.page(currentPage);

        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalBlogs", page.getTotalElements());
        model.addAttribute("blogs", page.getContent());

        return "/blog/blogs";
    }

    @GetMapping("/blogs")
    public String pages(Model model) {

        return page(1, model);
    }



    @PostMapping("/blogs")
    public String createNewBlog(@Valid com.example.demoblogas.blog.Blog blog, BindingResult errors, Model model) {
        logger.info("New blog: {}", blog);

        if (errors.hasErrors())
            return "/blog/new";

        com.example.demoblogas.blog.Blog created = service.createBlog(blog);
        model.addAttribute("blog", created);

        return  "redirect:blogs/" + created.getId();
    }

    @GetMapping("blogs/new")
    public String showForm(Model model) {
        model.addAttribute("blog", new com.example.demoblogas.blog.Blog());
        return "/blog/new";
    }

    @RequestMapping("/blogs/{id}")
    public String blog(@PathVariable int id, Model model) {

        model.addAttribute("blog", service.getBlogById(id));
        return "/blog/blog";
    }

}
