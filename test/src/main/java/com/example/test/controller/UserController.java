package com.example.test.controller;

import com.example.test.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.example.test.service.UserService;
import com.example.test.User;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getALlUsers(){
        return userService.getAllUsers();

    }
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable String id){
        return userService.getUser(id);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/users")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/users/{id}")
    public void deleteUser(@PathVariable String id){
        userService.deleteUser(id);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/users/{id}")
    public void  updateUser(@RequestBody User user, @PathVariable String id){
        userService.updateUser(user,id);
    }
}


