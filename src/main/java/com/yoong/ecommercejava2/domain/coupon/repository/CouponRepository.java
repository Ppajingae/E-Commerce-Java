package com.yoong.ecommercejava2.domain.coupon.repository;

import com.yoong.ecommercejava2.domain.coupon.entity.Coupon;

import java.util.List;
import java.util.Optional;

public interface CouponRepository {
    Coupon save(Coupon coupon);

    Optional<Coupon> findByIdOrNull(Long id);

    void delete(Coupon coupon);

    List<Coupon> findAll();

    List<Coupon> findAllCouponIdWithBuyer(List<Long> couponIdList);

    boolean existsByProductId(Long productId);

    Optional<Coupon> findByIdAndSellerId(Long couponId, Long sellerId);

    List<Coupon> findAllBySellerId(Long sellerId);

    List<Long> findAllByProductId(List<Long> productIdList);

    void flush();

    Coupon saveAndFlush(Coupon coupon);

    Optional<Coupon> findByProductId(Long productId);

    void deleteAllByExpiredAt();

    List<Coupon> findAllByCouponId(List<Long> couponIdList);
}
