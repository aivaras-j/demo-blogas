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

		logger.info("Add Blog1: {}", blogsService.createAndEditBlog(new Blog("VSports Health Benefits of Vitamin D", "Context:\n" +
				"Vitamin D is a potent secosteroid hormone that provides many skeletal and extraskeletal health benefits. Musculoskeletal injury " +
				"prevention and recovery are potentially affected by sufficient circulating levels of the storage form of vitamin D: 25-hydroxyvitamin " +
				"D3, or 25(OH)D. Vitamin D deficiency can exist among young, active, and healthy people, which may put them at increased risk for injury " +
				"and prolonged recovery. Evidence Aquisition: PubMed was searched using vitamin D and skeletal muscle, vitamin D and athletic performance, " +
				"and vitamin D review articles. Studies from the 1930s to 2012 were used for the review." +
				"Results:\n" +
				"There is strong correlation between vitamin D sufficiency and optimal muscle function. Increasing levels of vitamin D reduce inflammation, " +
				"pain, and myopathy while increasing muscle protein synthesis, ATP concentration, strength, jump height, jump velocity, jump power, exercise " +
				"capacity, and physical performance. 25(OH)D levels above 40 ng/mL are required for fracture prevention, including stress fractures. Optimal " +
				"musculoskeletal benefits occur at 25(OH)D levels above the current definition of sufficiency (> 30 ng/mL) with no reported sports health benefits " +
				"above 50 ng/mL.\n" +
				"Conclusions:\n" +
				"Vitamin D deficiency is common in athletes. For athletes presenting with stress fractures, musculoskeletal pain, and frequent illness, one should " +
				"have a heightened awareness of the additional likely diagnosis of vitamin D deficiency. Correction of this deficiency is completed by standardized " +
				"and supervised oral supplementation protocols producing significant musculoskeletal sports health benefits.",
				"https://media.istockphoto.com/id/1141191007/vector/sports-set-of-athletes-of-various-sports-disciplines-isolated-vector-silhouettes-run-soccer.jpg?s=612x612&w=0&k=20&c=SEabW4SHZ7blMHJPxZNSTl_anOMHO3whQI7HIMxFpSg=" )));

		logger.info("Add Blog2: {}", blogsService.createAndEditBlog(new Blog("OVERTRAINING MYTH: DON’T BELIEVE THE HYPE", "Often, as a keen sportsperson or when aspiring towards kickstarting your routine, you might", "https://media.istockphoto.com/id/1141191007/vector/sports-set-of-athletes-of-various-sports-disciplines-isolated-vector-silhouettes-run-soccer.jpg?s=612x612&w=0&k=20&c=SEabW4SHZ7blMHJPxZNSTl_anOMHO3whQI7HIMxFpSg=")));

		logger.info("Add Blog3: {}", blogsService.createAndEditBlog(new Blog("TYPES OF VITAMIN D IN OUR FOOD", "Two types of vitamin D are found in our food and supplements – D2 and D3. The only difference is the", "https://media.istockphoto.com/id/1141191007/vector/sports-set-of-athletes-of-various-sports-disciplines-isolated-vector-silhouettes-run-soccer.jpg?s=612x612&w=0&k=20&c=SEabW4SHZ7blMHJPxZNSTl_anOMHO3whQI7HIMxFpSg=" )));

		logger.info("Add Blog4: {}", blogsService.createAndEditBlog(new Blog("WHAT IS OVERTRAINING? ", "The figure above is from research focusing on illnesses like common colds that we’re more likely to pick up", "https://media.istockphoto.com/id/1141191007/vector/sports-set-of-athletes-of-various-sports-disciplines-isolated-vector-silhouettes-run-soccer.jpg?s=612x612&w=0&k=20&c=SEabW4SHZ7blMHJPxZNSTl_anOMHO3whQI7HIMxFpSg=" )));

		logger.info("All Blogs: {}", blogsService.getAllBlogs());

	}
}
