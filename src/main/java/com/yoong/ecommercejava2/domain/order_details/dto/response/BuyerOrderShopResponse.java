package com.yoong.ecommercejava2.domain.order_details.dto.response;

import java.util.List;

public record BuyerOrderShopResponse(
        Long shopId,
        String shopName,
        List<BuyerOrderDetailProductResponse> productsOrders
) {
}
