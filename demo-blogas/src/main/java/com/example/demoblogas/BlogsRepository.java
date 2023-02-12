package com.example.demoblogas;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BlogsRepository {
    private final List<Blog> blogs;

    BlogsRepository(){
        this.blogs = List.of(
                new Blog(1, "Pirmas straipsnis",  "image 1", "The sports industry is a massive moneymaker both in the United States and around the world. Dedicated fans of football, soccer, baseball, basketball, and other games are eager and hungry for content that will satisfy their sports cravings."),
                new Blog(2, "Antras straipsnis",  "image 2", "The sports industry is a massive moneymaker both in the United States and around the world. Dedicated fans of football, soccer, baseball, basketball, and other games are eager and hungry for content that will satisfy their sports cravings."),
                new Blog(3, "Trecias straipsnis",  "image 3", "The sports industry is a massive moneymaker both in the United States and around the world. Dedicated fans of football, soccer, baseball, basketball, and other games are eager and hungry for content that will satisfy their sports cravings.")
        );
    }
    public List<Blog> findAll(){
        return blogs;
    }
    public Blog findBytId(int id) {
        return blogs
                .stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .get();
    }
}
