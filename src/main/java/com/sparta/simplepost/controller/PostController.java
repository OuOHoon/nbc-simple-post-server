package com.sparta.simplepost.controller;

import com.sparta.simplepost.request.PostCreateRequest;
import com.sparta.simplepost.request.PostUpdateRequest;
import com.sparta.simplepost.response.PostResponse;
import com.sparta.simplepost.servcie.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/posts")
@RestController
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostResponse> create(@RequestBody PostCreateRequest postCreateRequest) {
        return ResponseEntity.ok(postService.create(postCreateRequest));
    }

    @PutMapping("/{postId}")
    public ResponseEntity<PostResponse> update(@PathVariable Long postId, @RequestBody PostUpdateRequest postUpdateRequest) {
        return ResponseEntity.ok(postService.updateById(postId, postUpdateRequest));
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostResponse> findOne(@PathVariable Long postId) {
        return ResponseEntity.ok(postService.findById(postId));
    }

    @GetMapping
    public ResponseEntity<List<PostResponse>> findAll() {
        return ResponseEntity.ok(postService.findAll());
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> delete(@PathVariable Long postId, @RequestHeader String password) {
        postService.deleteById(postId, password);
        return ResponseEntity.noContent().build();
    }
}
