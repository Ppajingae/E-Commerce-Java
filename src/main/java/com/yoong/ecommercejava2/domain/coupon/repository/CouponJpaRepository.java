package com.yoong.ecommercejava2.domain.coupon.repository;

import com.yoong.ecommercejava2.domain.coupon.entity.Coupon;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CouponJpaRepository extends JpaRepository<Coupon, Long> {

    boolean existsByProductId(Long productId);

    Optional<Coupon> findByIdAndSellerId(Long id, Long sellerId);


    List<Coupon> findAllBySellerId(Long sellerId);

    @Query("SELECT c.id FROM Coupon c WHERE c.product.id in :productIdList ")
    List<Long> findAllByProductIdList(List<Long> productIdList);

    Optional<Coupon> findByProductId(Long productId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Coupon c WHERE c.expiredAt <= CURRENT_TIMESTAMP")
    void deleteAllByExpiredAt();
}

