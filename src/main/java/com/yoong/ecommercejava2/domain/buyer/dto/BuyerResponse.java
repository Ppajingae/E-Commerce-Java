package com.yoong.ecommercejava2.domain.buyer.dto;

import com.yoong.ecommercejava2.domain.buyer.entity.Buyer;

public record BuyerResponse(

        Long id,
        String email,
        String nickname,
        String profileImage,
        String phoneNumber,
        String address
) {

    public static BuyerResponse from(Buyer buyer) {
        return new BuyerResponse(
                buyer.getId(),
                buyer.getEmail(),
                buyer.getNickname(),
                buyer.getProfileImage(),
                buyer.getPhoneNumber(),
                buyer.getAddress()
        );
    }
}
