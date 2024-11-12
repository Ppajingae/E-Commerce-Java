package com.yoong.ecommercejava2.domain.product.dto;

import java.time.LocalDateTime;

public record ProductResponse(
        Long id,
        String name,
        String description,
        int price,
        int likes,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        boolean isSoldOut,
        Long shopId,
        Long categoryId
) {
}