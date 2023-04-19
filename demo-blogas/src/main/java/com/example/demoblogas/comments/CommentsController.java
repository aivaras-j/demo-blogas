package com.example.demoblogas.comments;

import com.example.demoblogas.blog.Blog;
import com.example.demoblogas.blog.BlogsService;
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
    BlogsService blogsService;


    @Autowired
    CommentsRepository commentsRepository;

    @Autowired
    public CommentsController(@Autowired CommentsRepository repository) {
        this.commentsRepository = repository;
    }

    @GetMapping("/blogs/blog/{id}/comment")
    public String blogCommentForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("blog", blogsService.getBlogById(id));
        var comments = commentsRepository.findAll();
        model.addAttribute("comments", comments);
        model.addAttribute("comment", new Comment());
        return "comments/comment";
    }


//    @GetMapping("/blogs/blog/{id}/comm")
//    public String showCommentBlog(@PathVariable ("id") int id, Model model) {
//        var comments = commentsRepository.findAll();
//        model.addAttribute("comments", comments);
//        model.addAttribute("comment", new Comment());
//
//        logger.info("Comment blog");
//
//        return "comments/comment";
//    }


    @PostMapping("/blogs/blog/{id}/comment")
    public String createNewComment(@PathVariable("id") Integer id, @Valid Comment comment, BindingResult errors) {

        logger.info("HEllo: {}", comment);
        if (errors.hasErrors()) {
            logger.info("Yep, I have error: {}", comment);
            errors.getAllErrors().forEach(System.out::println);
            return "comments/comment";
        }
        logger.info("Comment: {}", comment);
        Blog blog = blogsService.getBlogById(id);

        if(blog == null){
            return "redirect:/blogs";
        }
        //
        comment.setBlog(blog);
        commentsRepository.save(comment);

        blog.addComment(comment);
        blogsService.createAndEditBlog(blog);
        logger.info("Blog comment: {}", comment);
        logger.info("Blog comment: {}", blog);
        return  "redirect:/blogs/blog/{id}";
    }


}

