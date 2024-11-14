package com.yoong.ecommercejava2.common.dto;

import lombok.RequiredArgsConstructor;

public record ErrorResponse(
        int errorCode,
        String message
){

}
