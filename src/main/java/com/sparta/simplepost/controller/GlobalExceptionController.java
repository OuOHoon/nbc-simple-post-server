package com.sparta.simplepost.controller;

import com.sparta.simplepost.exception.PasswordNotValidException;
import com.sparta.simplepost.exception.PostNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(PasswordNotValidException.class)
    public ResponseEntity<String> handlePasswordNotValidException(PasswordNotValidException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<Void> handlePostNotFoundException(PostNotFoundException e) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleNotReadableException(Exception e) {
        return new ResponseEntity<>("입력 값이 적절하지 않습니다.", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingRequestHeaderException.class)
    public ResponseEntity<String> handleMissingRequestHeaderException(Exception e) {
        return new ResponseEntity<>("비밀번호를 입력해야 합니다.", HttpStatus.BAD_REQUEST);
    }
}
