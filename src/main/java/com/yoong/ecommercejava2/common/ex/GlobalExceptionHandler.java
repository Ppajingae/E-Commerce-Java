package com.yoong.ecommercejava2.common.ex;

import com.yoong.ecommercejava2.common.dto.ErrorResponse;
import com.yoong.ecommercejava2.common.ex.exception.ModelNotFoundException;
import com.yoong.ecommercejava2.common.ex.exception.PasswordException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ModelNotFoundException.class)
    public ResponseEntity<ErrorResponse> modelNotFoundException(ModelNotFoundException e){

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(e.getErrorCode(), e.getMessage()));
    }

    @ExceptionHandler(PasswordException.class)
    public ResponseEntity<ErrorResponse> passwordException(PasswordException e){

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponse(e.getErrorCode(), e.getMessage()));
    }
}
