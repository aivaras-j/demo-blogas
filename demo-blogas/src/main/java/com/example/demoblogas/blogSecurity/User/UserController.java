package com.example.demoblogas.blogSecurity.User;
import com.example.demoblogas.blogSecurity.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/register")
    public String newUser(User user, Model model) {
           user.setRole(Role.USER);

        logger.info("New user: {}", userService.createUser(user));

        return "redirect:/user/login";
    }

    @GetMapping("/register")
    public String showUser(Model model) {
        model.addAttribute("user", new User());
        return "/user/register";
    }

    @GetMapping("/user/{id}/profile")
    public String profile(@PathVariable int id, Model model) {

        model.addAttribute("user", userRepository.findById(id).get());

        return "/user/profile";
    }

//    @GetMapping("/blogs/user")
//    public String userPage(Model model) {
//
//        return "/blog/blogs";
//    }
//
//    @GetMapping("/user/login/success")
//    public String showBlogPage(Model model) {
//        return "blog/blog";
//    }

//    @GetMapping("/blogs/user/{id}")
//    public String getUserById(@PathVariable int id, Model model) {
//        User user = userRepository.findById(id).get();
//        model.addAttribute("user", user);
//        return "/blog/blogs";
//    }

//    @RequestMapping("/user/{id}")
//    public String userId(@PathVariable Integer id, Model model) {
//
//        model.addAttribute("user", userService.getUsergById(id));
//        return "/blog/blogs";
//    }
}
