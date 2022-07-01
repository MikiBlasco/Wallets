package com.example.wallets.controllers;

import com.example.wallets.models.User;
import com.example.wallets.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/all-users")
    @CrossOrigin
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    @CrossOrigin
    public User getUser(@PathVariable long id, @AuthenticationPrincipal UserDetails userDetails){
        return userService.getUserById(id, userDetails);
    }

    @PostMapping("/create-user")
    @CrossOrigin
    public void createUser(@RequestBody User user, @AuthenticationPrincipal UserDetails userDetails){ userService.createUser(user, userDetails); }

    @PatchMapping("/update-user/{id}")
    @CrossOrigin
    public void updateUser(@RequestBody User user, @PathVariable long id, @AuthenticationPrincipal UserDetails userDetails){ userService.updateUser(user, id, userDetails); }

    @PostMapping ("/delete-user/{id}")
    @CrossOrigin
    public void deleteUser(@PathVariable long id, @AuthenticationPrincipal UserDetails userDetails){ userService.deleteUser(id, userDetails); }

}
