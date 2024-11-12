package com.yoong.ecommercejava2.domain.backoffice.dto.product_backoffice;

import java.time.LocalDateTime;

public record SellersProductResponse(

        Long id,
        String name,
        int quantity,
        int price,
        LocalDateTime createdAt,
        String productImage,
        String description
) {
}