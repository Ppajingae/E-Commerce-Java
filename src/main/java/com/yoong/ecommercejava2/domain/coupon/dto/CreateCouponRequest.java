package com.yoong.ecommercejava2.domain.coupon.dto;

import com.yoong.ecommercejava2.domain.coupon.enum_class.Policy;

public record CreateCouponRequest(
        Long productId,
        Policy policy,
        int discount,
        int quantity,
        String couponName
) {
}