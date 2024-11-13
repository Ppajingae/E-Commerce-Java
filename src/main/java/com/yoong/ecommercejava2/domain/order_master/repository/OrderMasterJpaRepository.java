package com.yoong.ecommercejava2.domain.order_master.repository;

import com.yoong.ecommercejava2.domain.order_master.entity.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface OrderMasterJpaRepository extends JpaRepository<OrderMaster, Long> {

    List<OrderMaster> findByIdIn(List<Long> ids);
    List<OrderMaster> findByIdInOrderByIdDesc(Set<Long> ids);
}
