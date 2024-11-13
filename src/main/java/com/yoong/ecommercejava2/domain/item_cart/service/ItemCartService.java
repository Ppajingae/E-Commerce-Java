package com.yoong.ecommercejava2.domain.item_cart.service;

import com.yoong.ecommercejava2.common.dto.DefaultResponse;
import com.yoong.ecommercejava2.domain.item_cart.dto.SelectProductQuantity;
import com.yoong.ecommercejava2.domain.item_cart.dto.response.CartResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemCartService {

    public DefaultResponse addItemIntoCart(Long productId, SelectProductQuantity selectProductQuantity) {
        return null;
    }

    public List<CartResponse> getMyCart() {
        return null;
    }

    public DefaultResponse updateItemIntoCart(Long productId, SelectProductQuantity selectProductQuantity) {
        return null;
    }

    public DefaultResponse deleteItemIntoCart(Long productId) {
        return null;
    }
}
