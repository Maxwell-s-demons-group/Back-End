package com.revature.services;

import com.revature.dtos.UserInfor;
import com.revature.models.User;
import com.revature.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findByCredentials(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

//    public List<User> findByFirstNameAndLastNameAndEmail(UserInfor userInfor) {
//        userInfor.setFirstname(userInfor.getFirstname());
//        userInfor.setLastname(userInfor.getLastname());
//        userInfor.setEmail(userInfor.getEmail());
//
//
//        System.out.println(userInfor.getLastname());
//        System.out.println(userInfor.getFirstname());
//        System.out.println(userInfor.getEmail());
//
//
//
//        if (userInfor.getFirstname() == "" && userInfor.getEmail() == "") {
//            System.out.println(userRepository.findByLastName(userInfor.getLastname()));
//            return userRepository.findByLastName(userInfor.getLastname());
//
//        } else if (userInfor.getFirstname() == "" && userInfor.getLastname() == "") {
//
//            return userRepository.findByEmail(userInfor.getEmail());
//
//        } else if (userInfor.getLastname() == "" && userInfor.getEmail() == "") {
//            System.out.println(userRepository.findByFirstName(userInfor.getFirstname()));
//            return userRepository.findByFirstName(userInfor.getFirstname());
//
//        }
//
//
//        return null;
//    }

    public  List<User> findByString(String word){
        return userRepository.findByString(word);

    }


}
