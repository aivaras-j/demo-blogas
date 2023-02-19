package com.example.demoblogas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BlogController {

    @Autowired
    BlogsService service;

    @GetMapping("/blogs/page/{pageNumber}")
    public String page(@PathVariable("pageNumber") int currentPage, Model model){
        Page<Blog> page = service.page(currentPage);

        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalBlogs", page.getTotalElements());
        model.addAttribute("blogs", page.getContent());

        return "blogs";
    }

    @GetMapping("/blogs")
    public String pages(Model model) {
        return page(1, model);
    }
    @RequestMapping("/blogs/{id}")
    public String blogs(@PathVariable int id, Model model) {
        model.addAttribute("blog", service.getBlogById(id));

        return "blog";
    }


}
