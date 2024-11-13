package com.yoong.ecommercejava2.domain.item_cart.repository;

import com.yoong.ecommercejava2.domain.item_cart.entity.ItemCart;

import java.util.List;

public interface ItemCartRepository {

    List<ItemCart> findByBuyerId(Long buyerId);

    ItemCart findByProductIdAndBuyerId(Long productId, Long buyerId);

    List<ItemCart> findAllByIdAndBuyerId(List<Long> id, Long buyerId);

    void deleteAll(List<Long> cartIdList);
}
