package com.yoong.ecommercejava2.domain.order_details.dto.response;

import com.yoong.ecommercejava2.domain.order_details.enum_class.ComplainStatus;
import com.yoong.ecommercejava2.domain.order_details.enum_class.OrderStatus;

import java.time.LocalDateTime;

public record SellerComplainResponse(
        Long orderDetailId,
        String productName,
        String productImage,
        OrderStatus statusCode,
        ComplainStatus complainStatus,
        String complainBuyerName,
        String buyerComplainReason,
        LocalDateTime buyerComplainDate,
        String sellerComplainRejectReason,
        LocalDateTime sellerComplainDate
) {
}
