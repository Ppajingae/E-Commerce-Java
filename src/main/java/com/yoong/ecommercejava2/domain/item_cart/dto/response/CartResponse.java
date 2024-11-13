package com.yoong.ecommercejava2.domain.item_cart.dto.response;

import java.util.List;

public record CartResponse(
        Long shopId,
        String shopName,
        List<ItemResponse> items
) {
}

