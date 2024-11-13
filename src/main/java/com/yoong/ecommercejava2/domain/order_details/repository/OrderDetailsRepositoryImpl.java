package com.yoong.ecommercejava2.domain.order_details.repository;

import com.yoong.ecommercejava2.domain.backoffice.dto.sales_statics.TotalSalesResponse;
import com.yoong.ecommercejava2.domain.order_details.entity.OrderDetails;
import com.yoong.ecommercejava2.domain.order_details.enum_class.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class OrderDetailsRepositoryImpl implements OrderDetailsRepository {

    private final OrderDetailsJpaRepository orderDetailsJpaRepository;

    @Override
    public OrderDetails save(OrderDetails orderStatus) {
        return null;
    }

    @Override
    public List<OrderDetails> saveAll(List<OrderDetails> orderStatuses) {
        return List.of();
    }

    @Override
    public List<OrderDetails> findAllByShopId(Long shopId) {
        return List.of();
    }

    @Override
    public List<OrderDetails> findAllByShopIdOrderStatus(Long shopId, OrderStatus orderStatus) {
        return List.of();
    }

    @Override
    public Optional<OrderDetails> findByIdAndShopId(Long orderStatusId, Long shopId) {
        return Optional.empty();
    }

    @Override
    public List<OrderDetails> findAllByShopIdAndOrderMasterId(Long shopId, Long orderMasterId) {
        return List.of();
    }

    @Override
    public List<OrderDetails> findAllByShopIdAndBuyerId(Long shopId, Long buyerId) {
        return List.of();
    }

    @Override
    public List<OrderDetails> findAllByBuyerId(Long buyerId) {
        return List.of();
    }

    @Override
    public List<OrderDetails> findAllByBuyerIdAndOrderMasterId(Long buyerId, Long orderId) {
        return List.of();
    }

    @Override
    public void updateDeliveryStatus(OrderStatus changeStatus, OrderStatus whereStatus) {

    }

    @Override
    public TotalSalesResponse totalSalesStatisticsByShop(Long shopId) {
        return null;
    }
}
