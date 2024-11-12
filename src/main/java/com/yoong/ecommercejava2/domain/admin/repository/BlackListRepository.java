package com.yoong.ecommercejava2.domain.admin.repository;

import com.yoong.ecommercejava2.domain.admin.entity.BlackList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlackListRepository extends JpaRepository<BlackList, Long> {

    boolean existsByEmail(String email);
    BlackList findByEmail(String email);
}
