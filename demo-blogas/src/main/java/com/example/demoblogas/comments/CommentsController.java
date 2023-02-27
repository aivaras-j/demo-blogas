package com.example.demoblogas.comments;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/com/example/demoblogas/blog/comments")
    public String getComments(Model model) {

        var comments = repository.findAll();
        model.addAttribute("comments", comments);
        model.addAttribute("comment", new Comment());
        return "/pages/index";
    }


    @PostMapping("/comments")
    public String createNewComment(@Valid Comment comment, BindingResult errors, Model model) {

        logger.info("New comment: {}", comment);

        if (errors.hasErrors())
            return "/com/example/demoblogas/blog/blog";

        Comment created = service.createComment(comment);
        model.addAttribute("comment", created);

        return  "redirect:/blogs/" + created.getId();

    }


}
