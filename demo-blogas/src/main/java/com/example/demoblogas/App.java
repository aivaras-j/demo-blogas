package com.example.demoblogas;

import com.example.demoblogas.blog.Blog;
import com.example.demoblogas.blog.BlogsRepository;
import com.example.demoblogas.blog.BlogsService;
import com.example.demoblogas.blogSecurity.Role;
import com.example.demoblogas.blogSecurity.User.User;
import com.example.demoblogas.blogSecurity.User.UserRepository;
import com.example.demoblogas.comments.Comment;
import com.example.demoblogas.comments.CommentsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class App implements CommandLineRunner {

	@Autowired
	PasswordEncoder passwordEncoder;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	BlogsService blogsService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	BlogsRepository blogsRepository;

	@Autowired
	CommentsRepository commentsRepository;


	public static void main(String[] args) {

		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		userRepository.saveAll(
				List.of(
						new User("min", passwordEncoder.encode("min"), Role.USER),
						new User("ss", passwordEncoder.encode("ss"), Role.ADMIN)
//		        new User("min", "min", Role.USER),
//				new User("ss", "ss", Role.ADMIN)

				)
		);



		Blog blogas1 = new Blog("VSports Health Benefits of Vitamin D", "Context: Vitamin D is a potent secosteroid hormone " +
				"that provides many skeletal and extraskeletal health benefits. Musculoskeletal injury prevention and recovery are " +
				"potentially affected by sufficient circulating levels of the storage form of vitamin D: 25-hydroxyvitamin D3, or" +
				"25(OH)D. Vitamin D deficiency can exist among young, active, and healthy people, which may put them at increased" +
				" risk for injuryand prolonged recovery. Evidence Aquisition: PubMed was searched using vitamin D and skeletal muscle, " +
				"vitamin D and athletic performance,and vitamin D review articles. Studies from the 1930s to 2012 were used for the review." +
				"Results:There is strong correlation between vitamin D sufficiency and optimal muscle function. Increasing levels of vitamin D" +
				" reduce inflammation, pain, and myopathy while increasing muscle protein synthesis, ATP concentration, strength, jump height, " +
				"jump velocity, jump power, exercise capacity, and physical performance. 25(OH)D levels above 40 ng/mL are required for fracture " +
				"prevention, including stress fractures. Optimal sculoskeletal benefits occur at 25(OH)D levels above the current definition of " +
				"sufficiency (> 30 ng/mL) with no reported sports health benefitsabove 50 ng/mL. Conclusions: Vitamin D deficiency is common in " +
				"athletes. For athletes presenting with stress fractures, musculoskeletal pain, and frequent illness, one should have a heightened " +
				"awareness of the additional likely diagnosis of vitamin D deficiency. Correction of this deficiency is completed by standardized" +
				"and supervised oral supplementation protocols producing significant musculoskeletal sports health benefits.",
				"https://media.istockphoto.com/id/1141191007/vector/sports-set-of-athletes-of-various-sports-disciplines-isolated-vector-silhouettes-run-soccer.jpg?s=612x612&w=0&k=20&c=SEabW4SHZ7blMHJPxZNSTl_anOMHO3whQI7HIMxFpSg=");
		Blog blogas2 = new Blog("VSports Health Benefits of Vitamin D", "Context: Vitamin D is a potent secosteroid hormone " +
				"that provides many skeletal and extraskeletal health benefits. Musculoskeletal injury prevention and recovery are " +
				"potentially affected by sufficient circulating levels of the storage form of vitamin D: 25-hydroxyvitamin D3, or" +
				"25(OH)D. Vitamin D deficiency can exist among young, active, and healthy people, which may put them at increased" +
				" risk for injuryand prolonged recovery. Evidence Aquisition: PubMed was searched using vitamin D and skeletal muscle, " +
				"vitamin D and athletic performance,and vitamin D review articles. Studies from the 1930s to 2012 were used for the review." +
				"Results:There is strong correlation between vitamin D sufficiency and optimal muscle function. Increasing levels of vitamin D" +
				" reduce inflammation, pain, and myopathy while increasing muscle protein synthesis, ATP concentration, strength, jump height, " +
				"jump velocity, jump power, exercise capacity, and physical performance. 25(OH)D levels above 40 ng/mL are required for fracture " +
				"prevention, including stress fractures. Optimal sculoskeletal benefits occur at 25(OH)D levels above the current definition of " +
				"sufficiency (> 30 ng/mL) with no reported sports health benefitsabove 50 ng/mL. Conclusions: Vitamin D deficiency is common in " +
				"athletes. For athletes presenting with stress fractures, musculoskeletal pain, and frequent illness, one should have a heightened " +
				"awareness of the additional likely diagnosis of vitamin D deficiency. Correction of this deficiency is completed by standardized" +
				"and supervised oral supplementation protocols producing significant musculoskeletal sports health benefits.",
				"https://media.istockphoto.com/id/1141191007/vector/sports-set-of-athletes-of-various-sports-disciplines-isolated-vector-silhouettes-run-soccer.jpg?s=612x612&w=0&k=20&c=SEabW4SHZ7blMHJPxZNSTl_anOMHO3whQI7HIMxFpSg=");
		Blog blogas3 = new Blog("VSports Health Benefits of Vitamin D", "Context: Vitamin D is a potent secosteroid hormone " +
				"that provides many skeletal and extraskeletal health benefits. Musculoskeletal injury prevention and recovery are " +
				"potentially affected by sufficient circulating levels of the storage form of vitamin D: 25-hydroxyvitamin D3, or" +
				"25(OH)D. Vitamin D deficiency can exist among young, active, and healthy people, which may put them at increased" +
				" risk for injuryand prolonged recovery. Evidence Aquisition: PubMed was searched using vitamin D and skeletal muscle, " +
				"vitamin D and athletic performance,and vitamin D review articles. Studies from the 1930s to 2012 were used for the review." +
				"Results:There is strong correlation between vitamin D sufficiency and optimal muscle function. Increasing levels of vitamin D" +
				" reduce inflammation, pain, and myopathy while increasing muscle protein synthesis, ATP concentration, strength, jump height, " +
				"jump velocity, jump power, exercise capacity, and physical performance. 25(OH)D levels above 40 ng/mL are required for fracture " +
				"prevention, including stress fractures. Optimal sculoskeletal benefits occur at 25(OH)D levels above the current definition of " +
				"sufficiency (> 30 ng/mL) with no reported sports health benefitsabove 50 ng/mL. Conclusions: Vitamin D deficiency is common in " +
				"athletes. For athletes presenting with stress fractures, musculoskeletal pain, and frequent illness, one should have a heightened " +
				"awareness of the additional likely diagnosis of vitamin D deficiency. Correction of this deficiency is completed by standardized" +
				"and supervised oral supplementation protocols producing significant musculoskeletal sports health benefits.",
				"https://media.istockphoto.com/id/1141191007/vector/sports-set-of-athletes-of-various-sports-disciplines-isolated-vector-silhouettes-run-soccer.jpg?s=612x612&w=0&k=20&c=SEabW4SHZ7blMHJPxZNSTl_anOMHO3whQI7HIMxFpSg=");
		Blog blogas4 = new Blog("VSports Health Benefits of Vitamin D", "Context: Vitamin D is a potent secosteroid hormone " +
				"that provides many skeletal and extraskeletal health benefits. Musculoskeletal injury prevention and recovery are " +
				"potentially affected by sufficient circulating levels of the storage form of vitamin D: 25-hydroxyvitamin D3, or" +
				"25(OH)D. Vitamin D deficiency can exist among young, active, and healthy people, which may put them at increased" +
				" risk for injuryand prolonged recovery. Evidence Aquisition: PubMed was searched using vitamin D and skeletal muscle, " +
				"vitamin D and athletic performance,and vitamin D review articles. Studies from the 1930s to 2012 were used for the review." +
				"Results:There is strong correlation between vitamin D sufficiency and optimal muscle function. Increasing levels of vitamin D" +
				" reduce inflammation, pain, and myopathy while increasing muscle protein synthesis, ATP concentration, strength, jump height, " +
				"jump velocity, jump power, exercise capacity, and physical performance. 25(OH)D levels above 40 ng/mL are required for fracture " +
				"prevention, including stress fractures. Optimal sculoskeletal benefits occur at 25(OH)D levels above the current definition of " +
				"sufficiency (> 30 ng/mL) with no reported sports health benefitsabove 50 ng/mL. Conclusions: Vitamin D deficiency is common in " +
				"athletes. For athletes presenting with stress fractures, musculoskeletal pain, and frequent illness, one should have a heightened " +
				"awareness of the additional likely diagnosis of vitamin D deficiency. Correction of this deficiency is completed by standardized" +
				"and supervised oral supplementation protocols producing significant musculoskeletal sports health benefits.",
				"https://media.istockphoto.com/id/1141191007/vector/sports-set-of-athletes-of-various-sports-disciplines-isolated-vector-silhouettes-run-soccer.jpg?s=612x612&w=0&k=20&c=SEabW4SHZ7blMHJPxZNSTl_anOMHO3whQI7HIMxFpSg=");
		Blog blogas5 = new Blog("VSports Health Benefits of Vitamin D", "Context: Vitamin D is a potent secosteroid hormone " +
				"that provides many skeletal and extraskeletal health benefits. Musculoskeletal injury prevention and recovery are " +
				"potentially affected by sufficient circulating levels of the storage form of vitamin D: 25-hydroxyvitamin D3, or" +
				"25(OH)D. Vitamin D deficiency can exist among young, active, and healthy people, which may put them at increased" +
				" risk for injuryand prolonged recovery. Evidence Aquisition: PubMed was searched using vitamin D and skeletal muscle, " +
				"vitamin D and athletic performance,and vitamin D review articles. Studies from the 1930s to 2012 were used for the review." +
				"Results:There is strong correlation between vitamin D sufficiency and optimal muscle function. Increasing levels of vitamin D" +
				" reduce inflammation, pain, and myopathy while increasing muscle protein synthesis, ATP concentration, strength, jump height, " +
				"jump velocity, jump power, exercise capacity, and physical performance. 25(OH)D levels above 40 ng/mL are required for fracture " +
				"prevention, including stress fractures. Optimal sculoskeletal benefits occur at 25(OH)D levels above the current definition of " +
				"sufficiency (> 30 ng/mL) with no reported sports health benefitsabove 50 ng/mL. Conclusions: Vitamin D deficiency is common in " +
				"athletes. For athletes presenting with stress fractures, musculoskeletal pain, and frequent illness, one should have a heightened " +
				"awareness of the additional likely diagnosis of vitamin D deficiency. Correction of this deficiency is completed by standardized" +
				"and supervised oral supplementation protocols producing significant musculoskeletal sports health benefits.",
				"https://media.istockphoto.com/id/1141191007/vector/sports-set-of-athletes-of-various-sports-disciplines-isolated-vector-silhouettes-run-soccer.jpg?s=612x612&w=0&k=20&c=SEabW4SHZ7blMHJPxZNSTl_anOMHO3whQI7HIMxFpSg=");

//		blogsRepository.save(blogas1);
//		blogsRepository.save(blogas2);
		blogsRepository.saveAll(List.of(blogas1, blogas2, blogas3, blogas4, blogas5));


		Comment komentaras1 = new Comment("Pirmas", "Nice blog post");
		Comment komentaras2 = new Comment("antras", "Nice blog post");
		Comment komentaras3 = new Comment("trecias", "Nice blog post");
		Comment komentaras4 = new Comment("ketvirtas", "Nice blog post");
		Comment komentaras5 = new Comment("penktas", "Nice blog post");

		blogas1.addComment(komentaras1);
		blogas1.addComment(komentaras5);
		blogas2.addComment(komentaras2);
		blogas3.addComment(komentaras3);
		blogas4.addComment(komentaras4);


//		commentsRepository.save(komentaras1);
//		commentsRepository.save(komentaras2);


	commentsRepository.saveAll(List.of(komentaras1, komentaras2, komentaras3, komentaras4, komentaras5));


		logger.info(" Blogas1: {}", blogas1);
		logger.info("Blogas2: {}", blogas2);




//		logger.info("All Blogs: {}", blogsService.getAllBlogs());



//		logger.info("Add Blog1: {}", blogsService.createAndEditBlog(new Blog("VSports Health Benefits of Vitamin D", "Context:\n" +
//				"Vitamin D is a potent secosteroid hormone that provides many skeletal and extraskeletal health benefits. Musculoskeletal injury " +
//				"prevention and recovery are potentially affected by sufficient circulating levels of the storage form of vitamin D: 25-hydroxyvitamin " +
//				"D3, or 25(OH)D. Vitamin D deficiency can exist among young, active, and healthy people, which may put them at increased risk for injury " +
//				"and prolonged recovery. Evidence Aquisition: PubMed was searched using vitamin D and skeletal muscle, vitamin D and athletic performance, " +
//				"and vitamin D review articles. Studies from the 1930s to 2012 were used for the review." +
//				"Results:\n" +
//				"There is strong correlation between vitamin D sufficiency and optimal muscle function. Increasing levels of vitamin D reduce inflammation, " +
//				"pain, and myopathy while increasing muscle protein synthesis, ATP concentration, strength, jump height, jump velocity, jump power, exercise " +
//				"capacity, and physical performance. 25(OH)D levels above 40 ng/mL are required for fracture prevention, including stress fractures. Optimal " +
//				"musculoskeletal benefits occur at 25(OH)D levels above the current definition of sufficiency (> 30 ng/mL) with no reported sports health benefits " +
//				"above 50 ng/mL.\n" +
//				"Conclusions:\n" +
//				"Vitamin D deficiency is common in athletes. For athletes presenting with stress fractures, musculoskeletal pain, and frequent illness, one should " +
//				"have a heightened awareness of the additional likely diagnosis of vitamin D deficiency. Correction of this deficiency is completed by standardized " +
//				"and supervised oral supplementation protocols producing significant musculoskeletal sports health benefits.",
//				"https://media.istockphoto.com/id/1141191007/vector/sports-set-of-athletes-of-various-sports-disciplines-isolated-vector-silhouettes-run-soccer.jpg?s=612x612&w=0&k=20&c=SEabW4SHZ7blMHJPxZNSTl_anOMHO3whQI7HIMxFpSg=" )));
//
//		logger.info("Add Blog2: {}", blogsService.createAndEditBlog(new Blog("UK: Who is the GOAT men’s footballer?", "Lionel Messi’s triumph at the 2022 FIFA\n" +
//				" World Cup in Qatar and the recent death of Pelé have both reignited the debate around who is the greatest men’s football player of all time. So who do fans think is the GOAT of football?\n" +
//				"We ran a poll on YouGov Surveys to find out.\n" +
//				"\n" +
//				"We asked British football followers to choose the greatest of all time from FourFourTwo Magazine’s top 25 players. Our data shows that Pelé is considered\n" +
//				" the “Greatest Of All Time” (GOAT) by almost a third (31%) of British fans. Lionel Messi gained a massive leg up in the Messi vs Ronaldo debate, with the\n" +
//				" Argentine coming in second place (27%). Three players came in a rather distant third: George Best – who Pelé himself once described as the best player\n" +
//				" in the world – won 5% of the vote, as did Diego Maradona and Messi’s long-time rival Cristiano Ronaldo. Bobby Charlton ranked fourth (3%), Zinedine Zidane\n" +
//				" ranked fifth (2%), and no other player got more than 1% of the vote.\n" +
//				"\n" +
//				"We also gave fans the opportunity to nominate footballers outside of the 25 options we offered. Among the write-in candidates were Bobby Moore, Alan Shearer,\n" +
//				" Matt Le Tissier, Steven Gerrard, and Nicklas “Lord” Bendtner.", "https://sport.yougov.com/wp-content/uploads/2023/03/Blog-GOAT.png")));
//
//		logger.info("Add Blog3: {}", blogsService.createAndEditBlog(new Blog("Brundle on Verstappen: \"I'm sure they had the motor turned right down\"", "For Red Bull Racing,\n" +
//				" it was the first since Abu Dhabi 2013 that two of its own cars started from the front row of the grid and actually scored a one-two. It is one of the examples that show\n" +
//				" Red Bull has started the season dominantly. Martin Brundle fears a monotonous season.\n" +
//				"\n" +
//				"It was not a trouble-free weekend for the Austrian racing stable. Max Verstappen complained about his RB19 during the first two free practice sessions and was quite dissatisfied.\n" +
//				" In the end, the 25-year-old driver did capture the position. After qualifying, Verstappen and Sergio Perez needed new oil intake pipes fitted and during the race there were some\n" +
//				" minor issues with downshifting.", "https://cdn.racingnews365.com/2023/Verstappen/_1125x633_crop_center-center_85_none/9077247/SI202303040357.webp?v=1678002348" )));
//
//		logger.info("Add Blog3: {}", blogsService.createAndEditBlog(new Blog("Brundle on Verstappen: \"I'm sure they had the motor turned right down\"", "For Red Bull Racing,\n" +
//				" it was the first since Abu Dhabi 2013 that two of its own cars started from the front row of the grid and actually scored a one-two. It is one of the examples that show\n" +
//				" Red Bull has started the season dominantly. Martin Brundle fears a monotonous season.\n" +
//				"\n" +
//				"It was not a trouble-free weekend for the Austrian racing stable. Max Verstappen complained about his RB19 during the first two free practice sessions and was quite dissatisfied.\n" +
//				" In the end, the 25-year-old driver did capture the position. After qualifying, Verstappen and Sergio Perez needed new oil intake pipes fitted and during the race there were some\n" +
//				" minor issues with downshifting.", "https://cdn.racingnews365.com/2023/Verstappen/_1125x633_crop_center-center_85_none/9077247/SI202303040357.webp?v=1678002348" )));
//		logger.info("Add Blog3: {}", blogsService.createAndEditBlog(new Blog("Brundle on Verstappen: \"I'm sure they had the motor turned right down\"", "For Red Bull Racing,\n" +
//				" it was the first since Abu Dhabi 2013 that two of its own cars started from the front row of the grid and actually scored a one-two. It is one of the examples that show\n" +
//				" Red Bull has started the season dominantly. Martin Brundle fears a monotonous season.\n" +
//				"\n" +
//				"It was not a trouble-free weekend for the Austrian racing stable. Max Verstappen complained about his RB19 during the first two free practice sessions and was quite dissatisfied.\n" +
//				" In the end, the 25-year-old driver did capture the position. After qualifying, Verstappen and Sergio Perez needed new oil intake pipes fitted and during the race there were some\n" +
//				" minor issues with downshifting.", "https://cdn.racingnews365.com/2023/Verstappen/_1125x633_crop_center-center_85_none/9077247/SI202303040357.webp?v=1678002348" )));
//
//
//		logger.info("Add Blog4: {}", blogsService.createAndEditBlog(new Blog("WHAT IS OVERTRAINING? ", "The figure above is from research focusing on illnesses like common colds that we’re more likely to pick up", "https://media.istockphoto.com/id/1141191007/vector/sports-set-of-athletes-of-various-sports-disciplines-isolated-vector-silhouettes-run-soccer.jpg?s=612x612&w=0&k=20&c=SEabW4SHZ7blMHJPxZNSTl_anOMHO3whQI7HIMxFpSg=" )));
//
//		logger.info("All Blogs: {}", blogsService.getAllBlogs());


////	@Override
//	public void run(String... args) throws Exception {
//		repository.saveAll(
//				List.of(
//						new User("min", "min", Role.USER),
//						new User("ss", "maain", Role.ADMIN),
//						new User("missn", "a", Role.USER)
//				)
//		);
}
}
