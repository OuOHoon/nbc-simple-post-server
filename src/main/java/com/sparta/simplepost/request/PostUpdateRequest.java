package com.sparta.simplepost.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PostUpdateRequest {
    private String title;
    private String author;
    private String content;
    private String password;
}
