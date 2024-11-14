package com.yoong.ecommercejava2.domain.coupon.dto;

import java.time.LocalDateTime;

public record SellerCouponResponse(
        Long couponId,
        String discountPolicy,
        int discount,
        Long productId,
        LocalDateTime expiredAt,
        int quantity,
        String couponName
) {
}
