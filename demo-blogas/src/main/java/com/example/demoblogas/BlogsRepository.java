package com.example.demoblogas.blog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface BlogsRepository extends JpaRepository<com.example.demoblogas.blog.Blog, Integer> {

    @Query("SELECT p FROM Blog p WHERE p.text = ?1")
    List<com.example.demoblogas.blog.Blog> getByType(String type);

}
