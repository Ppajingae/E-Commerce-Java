package com.yoong.ecommercejava2.common.dto;

public record LoginRequest(
        String email,
        String password
) {
}
