package com.yoong.ecommercejava2.domain.admin.dto;

import com.yoong.ecommercejava2.domain.seller.enum_class.ActiveStatus;
import com.yoong.ecommercejava2.domain.seller.shop.dto.ShopResponse;

public record AdminBySellerResponse(
        Long id,
        String email,
        String nickname,
        String profileImage,
        String phoneNumber,
        String address,
        ActiveStatus activeStatus,
        ShopResponse shop
) {
}
