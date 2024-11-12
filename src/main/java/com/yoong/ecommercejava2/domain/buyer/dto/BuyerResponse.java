package com.yoong.ecommercejava2.domain.buyer.dto;

public record BuyerResponse(

        Long id,
        String email,
        String nickname,
        String profileImage,
        String phoneNumber,
        String address
) {
}
