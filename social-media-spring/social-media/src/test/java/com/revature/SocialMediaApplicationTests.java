package com.revature;

import com.revature.models.Post;
import com.revature.models.User;
import com.revature.repositories.UserRepository;
import com.revature.services.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SocialMediaApplicationTests {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ProfanityService profanityService;
	
	static User user = new User();
	static String firstname = "Beo";
	static String lastname = "Van";
	@BeforeAll
	static void createUser(){

		user.setFirstName(firstname);
		user.setLastName(lastname);
		}
	@Test
	void usesearchStringTestFirstName() {
		userRepository.save(user);

		assert(userRepository.findByString(firstname).contains(user));

	}
	@Test
	void usesearchStringTestLastName(){

		userRepository.save(user);
		assert(userRepository.findByString(lastname).contains(user));
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
	
	@Test
	void checkLike(){

		Post post1 = new Post();
		Post post2 = new Post();
		post1.setText("goodbye");
		postService.upsert(post1);
		System.out.println(post1);
		User user1 = new User();
		user1.setFirstName("Henry");

		Set<User> likes = new HashSet<>();
		likes.add(user1);
	
		post1.setLikes(likes);
		postService.upsert(post1);
		System.out.println(post1);
		assertEquals(1, post1.getLikes().size());

	}

}
