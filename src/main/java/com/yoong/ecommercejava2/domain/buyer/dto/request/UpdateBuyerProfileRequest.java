package com.yoong.ecommercejava2.domain.buyer.dto.request;

public record UpdateBuyerProfileRequest(
        String nickname,
        String phoneNumber,
        String address
) {
}
