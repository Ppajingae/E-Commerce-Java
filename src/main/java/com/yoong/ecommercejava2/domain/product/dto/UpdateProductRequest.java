package com.yoong.ecommercejava2.domain.product.dto;

public record UpdateProductRequest(
        String name,
        String description,
        boolean isSoldOut,
        Long categoryId
) {
}
