package com.example.test.service;

import org.springframework.stereotype.Service;
import com.example.test.User;
import com.example.test.Location;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {
    User user1 = new User(
            "u1",
            "Kuromi",
            "Amara",
            new Location("l1", "Mayungone"),
            "Amara@gmai.com");
    User user2 = new User(
            "u2",
            "Yohan",
            "Ray",
            new Location("l2", "NorthDagon"),
            "Yohan@gmai.com");

    List<User> users =new ArrayList<>(Arrays.asList(user1,user2));
    public List<User> getAllUsers(){
        return users;
    }

    public User getUser(String id){
        User user = users.stream().filter(t->id.equals(t.getId())).findFirst().orElse(null);
        return user;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void deleteUser(String id) {
        users.removeIf(t->t.getId().equals(id));
    }

    public void updateUser(User user, String id) {
        for (int i = 0; i< users.size(); i++){
            User u = users.get(i);
            if (u.getId().equals(id)){
                users.set(i,user);
            }
        }
    }
}