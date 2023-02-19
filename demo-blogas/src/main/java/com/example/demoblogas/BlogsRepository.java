package com.example.demoblogas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface BlogsRepository extends JpaRepository<Blog, Integer> {

    @Query("SELECT p FROM Blog p WHERE p.type = ?1")
    List<Blog> getByType(String type);

}
