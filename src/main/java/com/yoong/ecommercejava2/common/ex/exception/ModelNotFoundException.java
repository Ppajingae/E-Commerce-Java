package com.yoong.ecommercejava2.common.ex.exception;

import lombok.Getter;

@Getter
public class ModelNotFoundException extends RuntimeException {
    int errorCode;
    String message;

    public ModelNotFoundException(int errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }
}
