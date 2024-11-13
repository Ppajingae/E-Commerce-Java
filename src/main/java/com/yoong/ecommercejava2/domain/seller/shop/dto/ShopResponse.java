package com.yoong.ecommercejava2.domain.seller.shop.dto;

public record ShopResponse(
        Long id,
        Long sellerId,
        String name,
        String description,
        String shopImage,
        float rate
) {
}
