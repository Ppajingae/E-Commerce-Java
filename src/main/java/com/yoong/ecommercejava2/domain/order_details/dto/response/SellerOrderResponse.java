package com.yoong.ecommercejava2.domain.order_details.dto.response;

import java.time.LocalDateTime;
import java.util.List;

public record SellerOrderResponse(
        Long orderMasterId,
        LocalDateTime registerDate,
        List<SellerComplainResponse> products
) {
}
