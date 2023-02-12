package com.example.demoblogas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BlogController {

    @Autowired
    private BlogsRepository blogsRepository;

    @GetMapping("/blogs")
    public String blogs(@RequestParam(required = false) String name, Model model) {
        model.addAttribute("blogs", blogsRepository.findAll());

        return "blogs";
    }
    @GetMapping("blogs/{id}")
    public String blog(@PathVariable("id") int id, Model model){
        model.addAttribute("blog", blogsRepository.findBytId(id));
        return "blog";
    }

}
