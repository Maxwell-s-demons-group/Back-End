package com.revature;

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

}
