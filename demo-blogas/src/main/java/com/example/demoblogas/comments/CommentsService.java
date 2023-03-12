package com.example.demoblogas.comments;

import com.example.demoblogas.blog.Blog;
import com.example.demoblogas.blog.BlogsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsService {

    private CommentsRepository repository;

    public CommentsService(CommentsRepository repository) {

        this.repository = repository;
    }
    public Comment createComment(Comment comment) {

        return repository.save(comment);
    }
    public Comment getCommentById(Long id) {

        return repository.findById((Long) id).get();
    }
    public List<Comment> getAllComments() {

        return repository.findAll();
    }
    public void deleteComment(Long id) {
        repository.deleteById(id);
    }


}




