package com.yoong.ecommercejava2.domain.seller.shop.repository;

import com.yoong.ecommercejava2.domain.seller.shop.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Long> {

    boolean existsBySellerId(Long sellerId);
    Shop findBySellerId(Long sellerId);
}
