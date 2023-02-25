package com.example.demoblogas;

import com.example.demoblogas.blog.Blog;
import com.example.demoblogas.blog.BlogsService;
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

		logger.info("Add Blog1: {}", blogsService.createBlog(new Blog("VITAMIN D: THE ‘SUNSHINE VITAMIN’ AND MUSCLE HEALTH", "An afternoon lunch outside, a day at the beach, or simply getting some fresh air", "https://media.istockphoto.com/id/1141191007/vector/sports-set-of-athletes-of-various-sports-disciplines-isolated-vector-silhouettes-run-soccer.jpg?s=612x612&w=0&k=20&c=SEabW4SHZ7blMHJPxZNSTl_anOMHO3whQI7HIMxFpSg=" )));

		logger.info("Add Blog2: {}", blogsService.createBlog(new Blog("OVERTRAINING MYTH: DON’T BELIEVE THE HYPE", "Often, as a keen sportsperson or when aspiring towards kickstarting your routine, you might", "https://media.istockphoto.com/id/1141191007/vector/sports-set-of-athletes-of-various-sports-disciplines-isolated-vector-silhouettes-run-soccer.jpg?s=612x612&w=0&k=20&c=SEabW4SHZ7blMHJPxZNSTl_anOMHO3whQI7HIMxFpSg=")));

		logger.info("Add Blog3: {}", blogsService.createBlog(new Blog("TYPES OF VITAMIN D IN OUR FOOD", "Two types of vitamin D are found in our food and supplements – D2 and D3. The only difference is the", "https://media.istockphoto.com/id/1141191007/vector/sports-set-of-athletes-of-various-sports-disciplines-isolated-vector-silhouettes-run-soccer.jpg?s=612x612&w=0&k=20&c=SEabW4SHZ7blMHJPxZNSTl_anOMHO3whQI7HIMxFpSg=" )));

		logger.info("Add Blog4: {}", blogsService.createBlog(new Blog("WHAT IS OVERTRAINING? ", "The figure above is from research focusing on illnesses like common colds that we’re more likely to pick up", "https://media.istockphoto.com/id/1141191007/vector/sports-set-of-athletes-of-various-sports-disciplines-isolated-vector-silhouettes-run-soccer.jpg?s=612x612&w=0&k=20&c=SEabW4SHZ7blMHJPxZNSTl_anOMHO3whQI7HIMxFpSg=" )));

		logger.info("All Blogs: {}", blogsService.getAllBlogs());

	}
}
