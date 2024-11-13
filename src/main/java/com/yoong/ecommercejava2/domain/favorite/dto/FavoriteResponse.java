package com.yoong.ecommercejava2.domain.favorite.dto;

public record FavoriteResponse(
        Long productId,
        String productName,
        int productPrice,
        String productImage
) {
}
