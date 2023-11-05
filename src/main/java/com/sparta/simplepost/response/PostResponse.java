package com.sparta.simplepost.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class PostResponse {

    private String title;
    private String author;
    private String content;
    private String createdDate;
}
