package com.yoong.ecommercejava2.domain.coupon.entity;

import com.yoong.ecommercejava2.domain.coupon.enum_class.Policy;
import com.yoong.ecommercejava2.domain.product.entity.Product;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="coupon")
public class Coupon {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Enumerated(EnumType.STRING)
    @Column(name = "discount_policy", nullable = false)
    private Policy discountPolicy;

    @Column(name = "discount", nullable = true)
    private int discount;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "expired_at", nullable = false)
    private LocalDateTime expiredAt;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "seller_id", nullable = false)
    private Long sellerId;

    @Column(name = "coupon_name", nullable = false)
    private String couponName;
}
