package com.revature.controllers;

import java.util.List;

import com.revature.models.User;
import com.revature.services.ProfanityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.annotations.Authorized;
import com.revature.models.Post;
import com.revature.services.PostService;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/post")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
//@CrossOrigin(origins = "*")
public class PostController {

	private final PostService postService;
    @Autowired
    ProfanityService profanityService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
    
    @Authorized
    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
    	return ResponseEntity.ok(this.postService.getAll());
    }
    
    @Authorized
    @PutMapping
    public ResponseEntity<Post> upsertPost(@RequestBody Post post) {
//        Post post1 = new Post();
//        post1 = post;

        // fillters out posts for bad language
        post = profanityService.postFillter(post);

        post = profanityService.commentFillter(post);


//        return ResponseEntity.ok(this.postService.upsert(post));
        //if the post text is without bad language the post will be saved to the database
        if(post!=null){
            if(post.getComments()!=null){
                postService.upsert(post);
            }
        }
        //returns post as a response
        return ResponseEntity.ok(post);

    }
}
