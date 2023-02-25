package com.example.demoblogas.blog;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogsService {

    private com.example.demoblogas.blog.BlogsRepository repository;

    public BlogsService(com.example.demoblogas.blog.BlogsRepository repository) {

        this.repository = repository;
    }

    public com.example.demoblogas.blog.Blog createBlog(com.example.demoblogas.blog.Blog blog) {

        return repository.save(blog);
    }

    public com.example.demoblogas.blog.Blog getBlogById(int id) {

        return repository.findById(id).get();
    }

    public List<com.example.demoblogas.blog.Blog> getAllBlogs() {

        return repository.findAll();
    }

    public Page<com.example.demoblogas.blog.Blog> page(int currentPage) {
        PageRequest pageRequest = PageRequest.of(currentPage - 1, 2);
        return repository.findAll(pageRequest);

    }

}

//    public List<Blog> getBlogByType(String name) {
//        return repository.getByType(name);
//    }

//    public void removeBlogFromList(Blog blog) {
//        repository.delete(blog);
//    }

//    public void removeAllBlogs(){
//        repository.deleteAll();
//    }


