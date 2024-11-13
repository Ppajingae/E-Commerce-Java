package com.yoong.ecommercejava2.domain.order_details.dto.response;

import com.yoong.ecommercejava2.domain.order_details.enum_class.ComplainStatus;
import com.yoong.ecommercejava2.domain.order_details.enum_class.OrderStatus;

public record BuyerOrderDetailProductResponse(
        Long orderDetailId,
        OrderStatus orderStatus,
        ComplainStatus complainStatus,
        String productName,
        int productPrice,
        int productQuantity,
        String productImageUrl
) {
}
