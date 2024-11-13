package com.yoong.ecommercejava2.domain.seller.shop.dto;

public record CreateShopRequest(
        String name,
        String description,
        String shopImage
) {
}
