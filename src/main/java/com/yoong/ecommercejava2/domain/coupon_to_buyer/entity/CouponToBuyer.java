package com.yoong.ecommercejava2.domain.coupon_to_buyer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CouponToBuyer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
