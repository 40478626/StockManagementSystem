package com.example.test.service;

import org.springframework.stereotype.Service;
import com.example.test.User;
import com.example.test.Location;
import com.example.test.Post;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PostService {
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

    Post post1 = new Post(
            "p1",
            "01-Jan-22",
            user1,
            "Hii!!!!");



    Post post2 = new Post(
            "p2",
            "02-Feb-22",
            user2,
            "Hello Guys");

    List<Post> posts = new ArrayList<>(Arrays.asList(post1,post2));
    public List<Post> getAllPost(){
        return posts;
    }

    public Post getPost(String id){
        Post post = posts.stream().filter(t->id.equals(t.getId())).findFirst().orElse(null);

        return post;
    }

    public void addPost(Post post) {
        posts.add(post);
    }

    public void deletePost(String id) {
        posts.removeIf(t-> t.getId().equals(id));
    }


    public void updatePost(String id,Post post) {
        for (int i = 0; i< posts.size();i++){
            Post p;
            p = posts.get(i);
            if (p.getId().equals(id)){
                posts.set (i,post);
            }
        }
    }
}

