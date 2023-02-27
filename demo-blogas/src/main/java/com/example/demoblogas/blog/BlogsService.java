package com.example.demoblogas.blog;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogsService {

    private BlogsRepository repository;

    public BlogsService(BlogsRepository repository) {

        this.repository = repository;
    }

    public Blog createAndEditBlog(Blog blog) {

        return repository.save(blog);
    }

    public Blog getBlogById(int id) {

        return repository.findById(id).get();
    }

    public List<Blog> getAllBlogs() {

        return repository.findAll();
    }

    public Page<Blog> page(int currentPage) {
        PageRequest pageRequest = PageRequest.of(currentPage - 1, 2);
        return repository.findAll(pageRequest);

    }
    public void deleteBlogById(int id) {
        repository.deleteById(id);
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


