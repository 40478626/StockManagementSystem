package com.example.test.controller;

import com.example.test.Post;
import com.example.test.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
//        System.out.println("aaa");
    }

    @GetMapping("/posts")
    public List<Post> getAllPosts(){
        return postService.getAllPost();

    }

    @GetMapping("/posts/{id}")
    public Post getPost(@PathVariable String id){
        return postService.getPost(id);
    }


    @RequestMapping(method = RequestMethod.POST,value = "/posts")
    public void addPost(@RequestBody Post post){
        postService.addPost(post);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/posts/{id}")
    public void deletePost(@PathVariable String id) {
        postService.deletePost(id);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/posts/{id}")
    public void updatePost(@PathVariable String id,@RequestBody Post post){
        postService.updatePost(id, post);
    }
}