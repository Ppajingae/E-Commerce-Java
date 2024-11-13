package com.yoong.ecommercejava2.domain.order_details.dto.request;

import com.yoong.ecommercejava2.domain.order_details.enum_class.OrderStatus;

public record UpdateDeliveryStatusRequest(
        OrderStatus deliveryStatus
) {
}
