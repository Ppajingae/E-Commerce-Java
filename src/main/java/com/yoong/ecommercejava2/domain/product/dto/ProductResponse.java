package com.yoong.ecommercejava2.domain.product.dto;

import com.yoong.ecommercejava2.domain.product.entity.Product;

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

    public static ProductResponse from(Product product){
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getProductBackOffice().getPrice(),
                0,
                product.getCreatedAt(),
                product.getUpdatedAt(),
                product.isSoldOut(),
                product.getShop().getId(),
                product.getCategoryId()
        );
    }
}