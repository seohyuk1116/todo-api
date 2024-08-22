package com.example.todo_api_lecture.controller;

import com.example.todo_api_lecture.entity.Post;
import com.example.todo_api_lecture.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("")
@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getAllPosts(@PathVariable("id") Long id) {
        Post post = postService.getPostById(id).orElseThrow( () -> new RuntimeException("Post not found"));
        return ResponseEntity.ok(post);
    }

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        //log.info("createPost {}", post.toString());
        return postService.createPost(post);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable("id") Long id, @RequestBody Post postDetails) {
        Post updatePost = postService.updatePost(id, postDetails);
        return ResponseEntity.ok(updatePost);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable("id") Long id) {
        postService.deletePost(id);

        return ResponseEntity.ok().build();
    }



}
