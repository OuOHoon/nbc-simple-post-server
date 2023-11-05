package com.sparta.simplepost.domain;

import com.sparta.simplepost.request.PostCreateRequest;
import com.sparta.simplepost.response.PostResponse;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id @GeneratedValue
    private Long id;

    private String title;
    private String author;
    private String password;
    private String content;
    @CreatedDate
    private LocalDate createdDate;

    public Post updateTitle(String title) {
        if (title == null) return this;
        this.title = title;
        return this;
    }

    public Post updateAuthor(String author) {
        if (author == null) return this;
        this.author = author;
        return this;
    }

    public Post updateContent(String content) {
        if (content == null) return this;
        this.content = content;
        return this;
    }

    public static Post toEntity(PostCreateRequest postCreateRequest) {
        return Post.builder()
                .title(postCreateRequest.getTitle())
                .author(postCreateRequest.getAuthor())
                .password(postCreateRequest.getPassword())
                .content(postCreateRequest.getContent())
                .createdDate(LocalDate.parse(postCreateRequest.getCreatedDate()))
                .build();
    }

    public PostResponse toResponse() {
        return PostResponse.builder()
                .title(this.title)
                .author(this.author)
                .content(this.content)
                .createdDate(this.createdDate.toString())
                .build();
    }
}
