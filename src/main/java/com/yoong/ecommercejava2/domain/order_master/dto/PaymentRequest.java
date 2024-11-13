package com.yoong.ecommercejava2.domain.order_master.dto;

import java.util.List;

public record PaymentRequest(
        List<Long> cartIdList,
        List<Long> couponIdList
) {
}
