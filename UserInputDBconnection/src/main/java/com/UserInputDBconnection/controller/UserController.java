package com.UserInputDBconnection.controller;


import com.UserInputDBconnection.model.User;
import com.UserInputDBconnection.repository.UserRepository;
import com.UserInputDBconnection.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {


    // to call service method
    @Autowired
    private UserService userService;


    // to getting data or show data
    @Autowired
    private UserRepository userRepository;



    // to store data
    @PostMapping("/store")
    public ResponseEntity<User> storeData(@RequestBody User user){ // RequestBody is for get data from user
        System.out.println("this is user"+user);
        userService.saveUserData(user);
        return ResponseEntity.ok(user);

    }



//    // to show the data
    @GetMapping("/getData")
    public ResponseEntity<List<User>> getData(){
       List<User> user= userRepository.findAll();
        return ResponseEntity.ok(user);

    }

// to show data with the help of id
    @GetMapping("/getDataById")
    public Optional<User> getData(@RequestParam("id") int id){ // @RequestParam is use for getting data with the help of id
        Optional<User> user= userRepository.findById(id);
        return user;
    }


// to update data
    @PutMapping("/update")
    public User updateData(@RequestBody User user){ // User user is for id validation

        User userData=userRepository.findById(user.getUserId()).orElseThrow(); // find by id is for check the data existing or not

        userData.setUserId(user.getUserId());
        userData.setUserPassword(user.getUserPassword());
        userData.setUserName(user.getUserName());


        userRepository.save(userData);
        return user;


    }



    // for delete data
    @DeleteMapping("/delete")
    public void deleteData(@RequestParam("id") int id){
        userRepository.deleteById(id);
    }


}


