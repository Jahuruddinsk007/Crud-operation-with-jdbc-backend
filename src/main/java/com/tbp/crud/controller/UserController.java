package com.tbp.crud.controller;

import com.tbp.crud.dao.UserRepository;
import com.tbp.crud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/add")
    public User addUser(@RequestBody User user) {

        return userRepository.saveUser(user);

    }

    @PutMapping("/update/{id}")
    public User updateUser(@RequestBody User user) {

        return userRepository.updateUser(user);

    }

    @GetMapping("/fetch/{id}")
    public User getUser(@PathVariable("id") int id) {
        return userRepository.getById(id);
    }

    @GetMapping("/fetchall")
    public List<User> getUsers() {
        return userRepository.allUsers();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id){
        return userRepository.deleteById(id);
    }

}
