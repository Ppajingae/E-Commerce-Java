package com.yoong.ecommercejava2.domain.item_cart.repository;

import com.yoong.ecommercejava2.domain.item_cart.entity.ItemCart;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemCartRepositoryImpl implements ItemCartRepository {

    private final ItemCartJpaRepository itemCartJpaRepository;

    @Override
    public List<ItemCart> findByBuyerId(Long buyerId) {
        return List.of();
    }

    @Override
    public ItemCart findByProductIdAndBuyerId(Long productId, Long buyerId) {
        return null;
    }

    @Override
    public List<ItemCart> findAllByIdAndBuyerId(List<Long> id, Long buyerId) {
        return List.of();
    }

    @Override
    public void deleteAll(List<Long> cartIdList) {

    }
}
