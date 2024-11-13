package com.yoong.ecommercejava2.domain.order_details.dto.response;

import java.time.LocalDateTime;
import java.util.List;

public record BuyerOrderResponse(
        Long orderMasterId,
        LocalDateTime orderRegisterDate,
        List<BuyerOrderShopResponse> orderShopDetails
) {
}