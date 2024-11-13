package com.yoong.ecommercejava2.domain.item_cart.dto.response;

public record ItemResponse(
        Long cartId,
        Long productId,
        String productName,
        int productQuantity,
        int productPrice,
        String productImageUrl
) {
}
