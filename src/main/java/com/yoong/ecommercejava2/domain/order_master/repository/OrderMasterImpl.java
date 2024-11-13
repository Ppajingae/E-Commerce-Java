package com.yoong.ecommercejava2.domain.order_master.repository;

import com.yoong.ecommercejava2.domain.coupon_to_buyer.entity.CouponToBuyer;
import com.yoong.ecommercejava2.domain.order_master.entity.OrderMaster;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
@RequiredArgsConstructor
public class OrderMasterImpl implements OrderMasterRepository {


    private final OrderMasterJpaRepository orderMasterJpaRepository;

    @Override
    public OrderMaster saveAndFlush(OrderMaster orderMaster) {
        return null;
    }

    @Override
    public OrderMaster findByIdOrNull(Long id) {
        return null;
    }

    @Override
    public OrderMaster save(OrderMaster orderMaster) {
        return null;
    }

    @Override
    public List<OrderMaster> findByIdIn(List<Long> ids) {
        return List.of();
    }

    @Override
    public List<OrderMaster> findByIdInOrderByIdDesc(Set<Long> ids) {
        return List.of();
    }

    @Override
    public Map<Long, Integer> discountTotalPriceList(Long buyerId, List<CouponToBuyer> couponIdList) {
        return Map.of();
    }
}
