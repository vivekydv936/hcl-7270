package com.hcld2.jwtdemo.controller;

import com.hcld2.jwtdemo.entity.Post;
import com.hcld2.jwtdemo.repository.PostRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/post")
public class PostController {

    private final PostRepository postRepository;


    @GetMapping
    public List<Post> allposts() {
        return postRepository.findAll();
    }

    @PostMapping
    public Post createPost(@Valid @RequestBody Post post , Authentication auth) {

        return postRepository.save(new Post( post.getTitle(),post.getContent(),auth.getName()));
    }


}
