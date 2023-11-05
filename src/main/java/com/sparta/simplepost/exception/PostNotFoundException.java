package com.sparta.simplepost.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class PostNotFoundException extends RuntimeException {

    public PostNotFoundException() {
        super("게시글을 찾을 수 없습니다.");
    }
}
