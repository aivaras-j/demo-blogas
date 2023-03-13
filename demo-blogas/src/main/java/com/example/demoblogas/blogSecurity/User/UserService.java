package com.example.demoblogas.blogSecurity.User;

import com.example.demoblogas.blog.Blog;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public User createUser(User user) {

        return userRepository.save(user);
    }
    public User getUser(int id) {

        return userRepository.findById(id).get();
    }
    public User getUsergById(Integer id) {

        return userRepository.findById(id).get();
    }
}

