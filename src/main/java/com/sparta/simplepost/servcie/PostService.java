package com.sparta.simplepost.servcie;

import com.sparta.simplepost.domain.Post;
import com.sparta.simplepost.exception.PasswordNotValidException;
import com.sparta.simplepost.exception.PostNotFoundException;
import com.sparta.simplepost.repository.PostRepository;
import com.sparta.simplepost.request.PostCreateRequest;
import com.sparta.simplepost.request.PostUpdateRequest;
import com.sparta.simplepost.response.PostResponse;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Transactional
    public PostResponse create(PostCreateRequest postCreateRequest) {
        Post post = Post.toEntity(postCreateRequest);
        postRepository.save(post);
        return post.toResponse();
    }

    public List<PostResponse> findAll() {
        List<Post> posts = postRepository.findAll(Sort.by(Sort.Direction.DESC, "createdDate"));
        return posts.stream().map(Post::toResponse).toList();
    }

    public PostResponse findById(Long id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isEmpty()) {
            throw new PostNotFoundException();
        }
        return optionalPost.get().toResponse();
    }

    @Transactional
    public PostResponse updateById(Long id, PostUpdateRequest postUpdateRequest) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isEmpty()) {
            throw new PostNotFoundException();
        }
        Post post = optionalPost.get();
        if (!post.getPassword().equals(postUpdateRequest.getPassword()))
            throw new PasswordNotValidException();

        return postRepository.save(post.updateTitle(postUpdateRequest.getTitle())
                .updateContent(postUpdateRequest.getContent())
                .updateAuthor(postUpdateRequest.getAuthor())).toResponse();
    }

    @Transactional
    public void deleteById(Long id, String password) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isEmpty()) {
            throw new PostNotFoundException();
        }
        Post post = optionalPost.get();
        if (!password.equals(post.getPassword()))
            throw new PasswordNotValidException();
        postRepository.deleteById(id);
    }
}
