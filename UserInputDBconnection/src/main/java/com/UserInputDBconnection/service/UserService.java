package com.UserInputDBconnection.service;


import com.UserInputDBconnection.model.User;
import com.UserInputDBconnection.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {



    // to save the data
   @Autowired
    private UserRepository userRepository;


    public User saveUserData(User user){
        return userRepository.save(user);

    }
//// to getting or show data
//
//    public User getUserData(){
//
//    }



}
