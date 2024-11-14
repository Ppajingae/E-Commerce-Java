package com.yoong.ecommercejava2.domain.coupon.repository;

import com.yoong.ecommercejava2.domain.coupon.entity.CouponToBuyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CouponToBuyerJpaRepository extends JpaRepository<CouponToBuyer, Long> {

    boolean existsByCouponIdAndBuyerId(Long couponId, Long buyerId);


    @Query("select cb from CouponToBuyer cb where cb.coupon.id in :couponId and cb.buyerId = :buyerId and cb.isUsed = false")
    List<CouponToBuyer> findAllByCouponIdAndBuyerIdAndIsUsedFalse(List<Long> couponId, Long buyerId);

    Optional<CouponToBuyer> findByCouponIdAndBuyerIdAndIsUsedFalse(Long couponId, Long buyerId);
}
