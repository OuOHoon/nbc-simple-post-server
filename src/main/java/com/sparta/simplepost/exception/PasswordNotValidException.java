package com.sparta.simplepost.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class PasswordNotValidException extends RuntimeException {

    public PasswordNotValidException() {
        super("비밀번호가 일치하지 않습니다.");
    }
}
