package com.yoong.ecommercejava2.domain.coupon.dto;

import java.time.LocalDateTime;

public record BuyerCouponResponse(
        Long couponId,
        Long productId,
        String discountPolicy,
        int discount,
        LocalDateTime expiredAt,
        String couponName,
        boolean isUsed
        ) {
}
