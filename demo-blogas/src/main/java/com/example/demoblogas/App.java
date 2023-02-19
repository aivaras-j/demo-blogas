package com.example.demoblogas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	BlogsService blogsService;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("Add Blog1: {}", blogsService.createBlog(new Blog("Sporto naujienos", "Sport" )));
		logger.info("Add Blog2: {}", blogsService.createBlog(new Blog("Sokiu naujienos", "Dance" )));
		logger.info("Add Blog1: {}", blogsService.createBlog(new Blog("Sporto naujienos2", "Sport2" )));
		logger.info("Add Blog2: {}", blogsService.createBlog(new Blog("Sokiu naujienos2", "Dance2" )));
		logger.info("All Blogs: {}", blogsService.getAllBlogs());

	}
}
