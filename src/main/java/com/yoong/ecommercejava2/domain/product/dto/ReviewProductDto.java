package com.yoong.ecommercejava2.domain.product.dto;

public record ReviewProductDto(
        Long productId,
        String productName,
        String productImage
) {
}
