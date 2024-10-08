package com.example.todo_api_lecture.service;

import com.example.todo_api_lecture.entity.Post;
import com.example.todo_api_lecture.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public Post updatePost(Long id, Post postDetails) {
        Post post = postRepository.findById(id).orElseThrow( () -> new RuntimeException("Post no found"));
        post.setTitle(postDetails.getTitle());
        post.setCompleted(postDetails.getCompleted());
        return postRepository.save(post);
    }

    public void deletePost(Long id) {
        Post post = postRepository.findById(id).orElseThrow( () -> new RuntimeException("Post no found"));
        postRepository.delete(post);
    }



}
