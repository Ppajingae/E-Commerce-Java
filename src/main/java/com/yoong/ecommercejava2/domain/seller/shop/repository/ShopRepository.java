package com.yoong.ecommercejava2.domain.seller.shop.repository;

import com.yoong.ecommercejava2.domain.seller.shop.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShopRepository extends JpaRepository<Shop, Long> {

    boolean existsBySellerId(Long sellerId);
    Optional<Shop> findBySellerId(Long sellerId);
}
