package com.example.demoblogas.comments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentsRepository extends JpaRepository<Comment, Integer> {

    Optional<Comment> findById(Integer id);
}
