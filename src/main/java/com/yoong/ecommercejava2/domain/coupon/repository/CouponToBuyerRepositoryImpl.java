package com.yoong.ecommercejava2.domain.coupon.repository;

import com.yoong.ecommercejava2.domain.coupon.entity.CouponToBuyer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CouponToBuyerRepositoryImpl implements CouponToBuyerRepository {

    private final CouponToBuyerJpaRepository couponToBuyerJpaRepository;

    @Override
    public List<CouponToBuyer> findAllByBuyerId(Long buyerId) {
        return List.of();
    }

    @Override
    public boolean existsByCouponIdAndBuyerId(Long couponId, Long buyerId) {
        return false;
    }

    @Override
    public CouponToBuyer save(CouponToBuyer couponToBuyer) {
        return null;
    }

    @Override
    public Optional<CouponToBuyer> findByProductIdAndBuyerId(Long productId, Long buyerId) {
        return Optional.empty();
    }

    @Override
    public List<CouponToBuyer> findAllByCouponIdAndBuyerIdAndIsUsedFalse(List<Long> couponIdList, Long buyerId) {
        return List.of();
    }

    @Override
    public void deleteAll(List<CouponToBuyer> couponToBuyerList) {

    }

    @Override
    public Optional<CouponToBuyer> findByCouponIdAndBuyerIdAndIsUsedFalse(Long couponId, Long buyerId) {
        return Optional.empty();
    }

    @Override
    public void saveAllByCouponIdAndBuyerIdAndIsUsedTrue(List<Long> coupons, Long buyerId) {

    }

    @Override
    public CouponToBuyer delete(CouponToBuyer couponToBuyer) {
        return null;
    }

    @Override
    public void deleteAllByExpiredAt() {

    }
}
