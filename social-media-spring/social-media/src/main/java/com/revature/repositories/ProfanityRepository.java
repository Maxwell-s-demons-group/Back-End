package com.revature.repositories;

import com.revature.models.Post;
import com.revature.models.Profanity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfanityRepository extends JpaRepository<Profanity, Integer> {
}
