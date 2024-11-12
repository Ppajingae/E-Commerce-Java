package com.yoong.ecommercejava2.domain.buyer.dto.request;

public record UpdateBuyerPasswordRequest(
        String password,
        String retryPassword
) {
}
