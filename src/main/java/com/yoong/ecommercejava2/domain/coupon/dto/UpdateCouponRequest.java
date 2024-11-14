package com.yoong.ecommercejava2.domain.coupon.dto;

import com.yoong.ecommercejava2.domain.coupon.enum_class.Policy;

import java.time.LocalDateTime;

public record UpdateCouponRequest(
        LocalDateTime expiredAt,
        Policy policy,
        int discount,
        int quantity
) {
}