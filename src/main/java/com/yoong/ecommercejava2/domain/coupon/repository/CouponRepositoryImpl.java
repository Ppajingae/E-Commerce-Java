package com.yoong.ecommercejava2.domain.coupon.repository;

import com.yoong.ecommercejava2.domain.coupon.entity.Coupon;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CouponRepositoryImpl implements CouponRepository {

    private final CouponJpaRepository couponJpaRepository;

    @Override
    public Coupon save(Coupon coupon) {
        return null;
    }

    @Override
    public Optional<Coupon> findByIdOrNull(Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(Coupon coupon) {

    }

    @Override
    public List<Coupon> findAll() {
        return List.of();
    }

    @Override
    public List<Coupon> findAllCouponIdWithBuyer(List<Long> couponIdList) {
        return List.of();
    }

    @Override
    public boolean existsByProductId(Long productId) {
        return false;
    }

    @Override
    public Optional<Coupon> findByIdAndSellerId(Long couponId, Long sellerId) {
        return Optional.empty();
    }

    @Override
    public List<Coupon> findAllBySellerId(Long sellerId) {
        return List.of();
    }

    @Override
    public List<Long> findAllByProductId(List<Long> productIdList) {
        return List.of();
    }

    @Override
    public void flush() {

    }

    @Override
    public Coupon saveAndFlush(Coupon coupon) {
        return null;
    }

    @Override
    public Optional<Coupon> findByProductId(Long productId) {
        return Optional.empty();
    }

    @Override
    public void deleteAllByExpiredAt() {

    }

    @Override
    public List<Coupon> findAllByCouponId(List<Long> couponIdList) {
        return List.of();
    }
}
