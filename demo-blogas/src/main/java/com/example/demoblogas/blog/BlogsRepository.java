package com.example.demoblogas.blog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface BlogsRepository extends JpaRepository<Blog, Integer> {
    Blog findById(Long id);


    void deleteById(Long id);
}
