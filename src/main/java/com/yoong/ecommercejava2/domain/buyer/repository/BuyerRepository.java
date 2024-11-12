package com.yoong.ecommercejava2.domain.buyer.repository;

import com.yoong.ecommercejava2.domain.buyer.entity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

interface BuyerRepository extends JpaRepository<Buyer, Long> {

    Buyer findByEmail(String email);
    Buyer findByProviderNameAndProviderId(String providerName, String providerId);
    boolean existsByEmail(String email);
}