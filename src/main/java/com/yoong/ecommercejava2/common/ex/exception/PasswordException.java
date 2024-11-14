package com.yoong.ecommercejava2.common.ex.exception;

import lombok.Getter;

@Getter
public class PasswordException extends RuntimeException {

    int errorCode;
    String message;

    public PasswordException(int errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }
}
