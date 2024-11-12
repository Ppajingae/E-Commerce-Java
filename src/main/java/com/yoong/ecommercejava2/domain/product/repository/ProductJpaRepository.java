package com.yoong.ecommercejava2.domain.product.repository;

import com.yoong.ecommercejava2.domain.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<Product, Long> {

    boolean existsByNameAndShopId(String name, Long shopId);
}
