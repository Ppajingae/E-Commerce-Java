package com.yoong.ecommercejava2.domain.order_details.repository;

import com.yoong.ecommercejava2.domain.backoffice.dto.sales_statics.TotalSalesResponse;
import com.yoong.ecommercejava2.domain.order_details.entity.OrderDetails;
import com.yoong.ecommercejava2.domain.order_details.enum_class.OrderStatus;

import java.util.List;
import java.util.Optional;

public interface OrderDetailsRepository {

    OrderDetails save(OrderDetails orderStatus);

    List<OrderDetails> saveAll(List<OrderDetails> orderStatuses);

    List<OrderDetails> findAllByShopId(Long shopId);

    List<OrderDetails> findAllByShopIdOrderStatus(Long shopId, OrderStatus orderStatus);

    Optional<OrderDetails> findByIdAndShopId(Long orderStatusId, Long shopId);

    List<OrderDetails> findAllByShopIdAndOrderMasterId(Long shopId, Long orderMasterId);

    List<OrderDetails> findAllByShopIdAndBuyerId(Long shopId, Long buyerId);

    List<OrderDetails> findAllByBuyerId(Long buyerId);

    List<OrderDetails> findAllByBuyerIdAndOrderMasterId(Long buyerId, Long orderId);

    void updateDeliveryStatus(OrderStatus changeStatus, OrderStatus whereStatus);

    TotalSalesResponse totalSalesStatisticsByShop(Long shopId);
}
