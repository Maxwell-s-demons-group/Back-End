package com.revature.services;

import com.revature.models.Post;
import com.revature.models.Profanity;
import com.revature.repositories.ProfanityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfanityService {

    @Autowired
    ProfanityRepository profanityRepository;

    public Post postFillter(Post post){
        System.out.println(post);
        List<Profanity> profanities = profanityRepository.findAll();
        for(int i = 0; i < profanities.size(); i++){
            if(post.getText().toLowerCase().contains(profanities.get(i).getWord())){
                return null;
            }

        }
        return post;
    }

    public Post commentFillter(Post post){
        System.out.println(post);
        List<Profanity> profanities = profanityRepository.findAll();
        for(int i = 0; i < profanities.size(); i++){
            if(post.getComments().toString().toLowerCase().contains(profanities.get(i).getWord())){
                //post.setComments(null);
                return null;
            }

        }
        return post;
    }

}
