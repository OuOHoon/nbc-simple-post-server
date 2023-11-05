package com.sparta.simplepost.repository;

import com.sparta.simplepost.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
