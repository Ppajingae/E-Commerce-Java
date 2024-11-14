package com.yoong.ecommercejava2.domain.coupon.entity;

import jakarta.persistence.*;

@Entity
@Table(name="coupon_to_buyer")
public class CouponToBuyer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="coupon_id")
    private Coupon coupon;

    @Column(name = "buyer_id")
    private Long buyerId;

    @Column(name="is_used")
    private Boolean isUsed = false;
}
