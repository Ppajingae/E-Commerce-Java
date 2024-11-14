package com.yoong.ecommercejava2.domain.coupon.repository;

import com.yoong.ecommercejava2.domain.coupon.entity.CouponToBuyer;

import java.util.List;
import java.util.Optional;

public interface CouponToBuyerRepository {

    List<CouponToBuyer> findAllByBuyerId(Long buyerId);

    boolean existsByCouponIdAndBuyerId(Long couponId, Long buyerId);

    CouponToBuyer save(CouponToBuyer couponToBuyer);

    Optional<CouponToBuyer> findByProductIdAndBuyerId(Long productId, Long buyerId);

    List<CouponToBuyer> findAllByCouponIdAndBuyerIdAndIsUsedFalse(List<Long> couponIdList, Long buyerId);

    void deleteAll(List<CouponToBuyer> couponToBuyerList);

    Optional<CouponToBuyer> findByCouponIdAndBuyerIdAndIsUsedFalse(Long couponId, Long buyerId);

    void saveAllByCouponIdAndBuyerIdAndIsUsedTrue(List<Long> coupons, Long buyerId);

    CouponToBuyer delete(CouponToBuyer couponToBuyer);

    void deleteAllByExpiredAt();
}
