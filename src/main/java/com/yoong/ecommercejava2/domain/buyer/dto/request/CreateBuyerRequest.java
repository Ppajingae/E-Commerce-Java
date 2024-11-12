package com.yoong.ecommercejava2.domain.buyer.dto.request;

public record CreateBuyerRequest(
        Long id,
        String nickname,
        String password,
        String email,
        String profileImage,
        String phoneNumber,
        String address
) {
}


