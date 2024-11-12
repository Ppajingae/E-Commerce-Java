package com.yoong.ecommercejava2.domain.backoffice.repository;

import com.yoong.ecommercejava2.domain.backoffice.entity.ProductBackOffice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductBackOfficeJpaRepository extends JpaRepository<ProductBackOffice, Long> {
}
