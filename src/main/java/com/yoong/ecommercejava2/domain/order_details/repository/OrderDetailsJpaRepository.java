package com.yoong.ecommercejava2.domain.order_details.repository;

import com.yoong.ecommercejava2.domain.order_details.entity.OrderDetails;
import com.yoong.ecommercejava2.domain.order_details.enum_class.OrderStatus;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OrderDetailsJpaRepository extends JpaRepository<OrderDetails, Long> {

    Optional<OrderDetails> findByIdAndBuyerId(Long id, Long shopId);

    List<OrderDetails> findAllByBuyerId(Long buyerId);

    List<OrderDetails> findAllByShopIdAndBuyerId(Long shopId, Long buyerId);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE OrderDetails od SET od.orderStatus = :changeStatus WHERE od.orderStatus = :whereStatus")
    void updateDeliveryStatus(@Param("changeStatus") OrderStatus changeStatus, @Param("whereStatus") OrderStatus whereStatus);
}
