package com.yoong.ecommercejava2.domain.product.dto;

public record CreateProductRequest(
        String name,
        String description,
        Long categoryId,
        String imageUrl
) {
}