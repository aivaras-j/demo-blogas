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
    BlogsService service;

    @GetMapping("/blogs/page/{pageNumber}")
    public String page(@PathVariable("pageNumber") int currentPage, Model model){
        Page<Blog> page = service.page(currentPage);

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
    public String createNewBlog(@Valid  Blog blog, BindingResult errors, Model model) {


        if (errors.hasErrors())
            return "/blog/new";

        Blog created = service.createAndEditBlog(blog);
        model.addAttribute("blog", created);

        logger.info("New blog: {}", blog);

        return  "redirect:blogs/" + created.getId();
    }

    @GetMapping("blogs/new")
    public String showForm(Model model) {
        model.addAttribute("blog", new Blog());
        return "/blog/new";
    }

    @GetMapping("/blogs/{id}")
    public String blog(@PathVariable(value = "id") Integer id, Model model) {
        model.addAttribute("blog", service.getBlogById(id));
        return "/blog/blog";
    }

    @DeleteMapping("/blogs/{id}")
    public String deleteBlog(@PathVariable Integer id) {
        System.out.println(id);
        service.deleteBlogById(id);
        return "redirect:/blogs";
    }

    @GetMapping("/blogs/{id}/blogEdit")
    public String showEditBlog(@PathVariable Integer id, Model model) {

        model.addAttribute("blog", service.getBlogById(id));

        logger.info("Edit blog");

        return "blog/blogEdit";
    }

    @PostMapping("/blogEdit/{id}")
    public String editedBlog(@PathVariable Long id, @Valid Blog blog, BindingResult errors, Model model) {

        logger.info("Edited blog: {}", blog);

        if (errors.hasErrors()) {
            return "blog/blogEdit";
        }

        Blog updated = service.createAndEditBlog(blog);
        model.addAttribute("blog", updated);

        return "redirect:/blogs";
    }

    @GetMapping("/contact")
    public String aboutPage(Model model) {

        return "/blog/contact";
    }
//    @GetMapping("/login")
//    public String loginPage(Model model) {
//
//        return "/blog/login/login";
//    }



}
