package com.yoong.ecommercejava2.domain.admin.repository;

import com.yoong.ecommercejava2.domain.admin.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    Admin findByEmail(String email);
}
