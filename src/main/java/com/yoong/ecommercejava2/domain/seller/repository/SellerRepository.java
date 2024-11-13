package com.yoong.ecommercejava2.domain.seller.repository;

import com.yoong.ecommercejava2.domain.seller.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SellerRepository extends JpaRepository<Seller, Long> {
    Optional<Seller> findByEmail(String email);
    boolean existsByEmail(String email);
}
