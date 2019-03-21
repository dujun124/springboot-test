package com.ablf.controller;

import com.ablf.dao.UserRepository;
import com.ablf.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Created by du on 2019/2/20.
 */
@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/{id}")
    public Optional<User> getUserById(@PathVariable("id") Integer id){
        Optional<User> user = userRepository.findById(id);
        return user;
    }

    @GetMapping("/user")
    public User insertUser(User user){
        return userRepository.save(user);
    }

    @GetMapping("/user/{id}/{lastName}")
    public User updateUser(@PathVariable("id") Integer id, @PathVariable("lastName") String lastName){
        Optional<User> userOptional = userRepository.findById(id);
        User user = userOptional.get();
        user.setLastName(lastName);
        return userRepository.save(user);
    }

    @GetMapping("/user/del/{id}")
    public String deleteUser(@PathVariable("id") Integer id){

        userRepository.deleteById(id);

        return "success";

    }

}
