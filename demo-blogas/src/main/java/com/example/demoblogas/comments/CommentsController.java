package com.example.demoblogas.comments;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentsController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CommentsService service;



    private CommentsRepository repository;

    @Autowired
    public CommentsController(@Autowired CommentsRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/blogs/blog")
    public String getComments(Model model) {

        var comments = repository.findAll();
        model.addAttribute("comments", comments);
        model.addAttribute("comment", new Comment());
        return "/blog/blog";


    }


    @PostMapping("/comments")
    public String createNewComment(@Valid Comment comment, BindingResult errors, Model model) {

        logger.info("New comment: {}", comment);

        if (errors.hasErrors())
            return "/blog/blogs";

        Comment created = service.createComment(comment);
        model.addAttribute("comment", created);

        return  "redirect:/blogs/" + created.getId();

    }
    @DeleteMapping("/comments/{id}")
    public String createComment(@PathVariable Long id) {
        System.out.println(id);
        repository.deleteById(id);
        return "redirect:/blog/blogs";
    }




}
