package com.yoong.ecommercejava2.common.ex.exception;

import lombok.Getter;

@Getter
public class ConflictException extends RuntimeException {
    int errorCode;
    String message;

    public ConflictException(int errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }
}
