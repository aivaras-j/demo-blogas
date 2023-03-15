package com.example.demoblogas.comments;

import com.example.demoblogas.blog.Blog;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class CommentsController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CommentsService commentsService;


    @Autowired
    CommentsRepository commentsRepository;

    @Autowired
    public CommentsController(@Autowired CommentsRepository repository) {
        this.commentsRepository = repository;
    }

    @GetMapping("/blogs/blog")
    public String getComments(Model model) {

        var comments = commentsRepository.findAll();
        model.addAttribute("comments", comments);
        model.addAttribute("comment", new Comment());
        return "/blog/blog";


    }

    @GetMapping("/blogs/{id}/comment")
    public String showCommentBlog(Model model) {

        model.addAttribute("comment", new Comment());

        logger.info("Comment blog");

        return "comments/comment";
    }


    @PostMapping("/comments")
    public String createNewComment(@Valid @ModelAttribute("comment") Comment comment, BindingResult errors, Model model) {

        if (errors.hasErrors())
            return "comments/comment";

       commentsRepository.save(comment);
//        Comment created = commentsService.createComment(comment);
//        model.addAttribute("comment", created);
        logger.info("New comment: {}", comment);

        return  "redirect:blogs/";
    }
//    @DeleteMapping("/comments/{id}")
//    public String createComment(@PathVariable Integer id) {
//        System.out.println(id);
//        repository.deleteById(id);
//        return "redirect:/blog/blogs";
//    }




}
