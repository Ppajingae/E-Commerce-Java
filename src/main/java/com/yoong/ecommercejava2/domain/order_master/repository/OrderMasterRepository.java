package com.yoong.ecommercejava2.domain.order_master.repository;

import com.yoong.ecommercejava2.domain.coupon.entity.CouponToBuyer;
import com.yoong.ecommercejava2.domain.order_master.entity.OrderMaster;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface OrderMasterRepository {

    OrderMaster saveAndFlush(OrderMaster orderMaster);

    OrderMaster findByIdOrNull(Long id);

    OrderMaster save(OrderMaster orderMaster);

    List<OrderMaster> findByIdIn(List<Long> ids);

    List<OrderMaster> findByIdInOrderByIdDesc(Set<Long> ids);

    Map<Long, Integer> discountTotalPriceList(Long buyerId, List<CouponToBuyer> couponIdList);
}
