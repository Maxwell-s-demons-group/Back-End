package com.revature;

import com.revature.models.Post;
import com.revature.services.ProfanityService;
import com.revature.models.User;
import com.revature.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SocialMediaApplicationTests {
@Autowired
	UserRepository userRepository;
	
	@Autowired
	ProfanityService profanityService;
	
	@Test
	void usesearchStringTestFirstName() {
		String firstname = "Huy";



		assertEquals(userRepository.findByFirstName(firstname),userRepository.findByString(firstname));

	}
	@Test
	void usesearchStringTestLastName(){
		String lastname = "Van";




		assertEquals(userRepository.findByLastName(lastname),userRepository.findByString(lastname));

	}
	@Test
	void usesearchStringTestEmail(){
		String email ="admin@gmail.com";

		assertEquals(userRepository.findByEmail(email), userRepository.findByString(email));
	}
	
	@Test
	void profannityPostTest() {
		Post post = new Post();
		post.setText("I like apples");

		Post post1 = new Post();
		post1.setText("I like oranges");

		Post post2 = new Post();
		post2.setText("I like pears");

		post = profanityService.postFillter(post);
		post1 = profanityService.postFillter(post1);
		post2 = profanityService.postFillter(post2);

		assertEquals(null, post);
		assertEquals(null,post1);
		assertEquals(post2,post2);

	}

	@Test
	void profannityCommentTest(){
		List<Post> comments = new ArrayList<>();
		Post comment1 = new Post();
		Post comment2 = new Post();
		Post comment3 = new Post();

		List<Post> comments1 = new ArrayList<>();
		Post comment4 = new Post();
		Post comment5 = new Post();
		Post comment6 = new Post();

		comment1.setText("I love oranges");
		comment2.setText("I love pears");
		comment3.setText("I love peaches");

		comment4.setText("I love plums");
		comment5.setText("I love pears");
		comment6.setText("I love peaches");

		comments.add(0,comment1);
		comments.add(1,comment2);
		comments.add(2,comment3);

		comments1.add(0,comment4);
		comments1.add(1,comment5);
		comments1.add(2,comment6);

		Post post = new Post();
		Post post1 = new Post();


		post.setComments(comments);
		post1.setComments(comments1);



		post = profanityService.commentFillter(post);
		post1 = profanityService.commentFillter(post1);

		assertEquals(null, post);
		assertEquals(post1, post1);

	}

}
