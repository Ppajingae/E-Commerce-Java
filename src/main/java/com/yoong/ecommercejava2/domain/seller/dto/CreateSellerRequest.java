package com.yoong.ecommercejava2.domain.seller.dto;

public record CreateSellerRequest(
        Long id,
        String nickname,
        String password,
        String email,
        String phoneNumber,
        String address
) {
}
