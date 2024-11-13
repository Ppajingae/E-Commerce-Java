package com.yoong.ecommercejava2.domain.item_cart.repository;

import com.yoong.ecommercejava2.domain.item_cart.entity.ItemCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemCartJpaRepository extends JpaRepository<ItemCart, Long> {

    @Modifying(clearAutomatically = true)
    @Query("delete from ItemCart c where c.product.id = :productId and c.buyer.id = :buyerId")
    void deleteByProductIdAndBuyerId(Long productId, Long buyerId);

    @Modifying(clearAutomatically = true)
    @Query("update ItemCart ic set ic.quantity = :quantity where ic.product.id = :productId and ic.buyer.id = :buyerId")
    void updateQuantityByProductIdAndBuyerId(Long productId, Long buyerId, int quantity);

    List<ItemCart> findAllByBuyerId(Long buyerId);
}
