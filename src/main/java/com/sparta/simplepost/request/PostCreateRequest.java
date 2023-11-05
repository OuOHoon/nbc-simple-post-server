package com.sparta.simplepost.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostCreateRequest {

    private String title;
    private String author;
    private String password;
    private String content;
    // 2007-12-03 형식
    private String createdDate;
}
