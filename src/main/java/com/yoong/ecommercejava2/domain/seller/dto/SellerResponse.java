package com.yoong.ecommercejava2.domain.seller.dto;

import com.yoong.ecommercejava2.domain.seller.enum_class.ActiveStatus;

public record SellerResponse(
    Long id,
    String email,
    String nickname,
    String profileImage,
    String phoneNumber,
    String address,
    ActiveStatus activeStatus
) {
}
