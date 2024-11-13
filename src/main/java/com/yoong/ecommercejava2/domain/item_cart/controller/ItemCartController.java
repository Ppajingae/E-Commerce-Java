package com.yoong.ecommercejava2.domain.item_cart.controller;

import com.yoong.ecommercejava2.common.dto.DefaultResponse;
import com.yoong.ecommercejava2.domain.item_cart.dto.SelectProductQuantity;
import com.yoong.ecommercejava2.domain.item_cart.dto.response.CartResponse;
import com.yoong.ecommercejava2.domain.item_cart.service.ItemCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class ItemCartController {

    private final ItemCartService itemCartService;

    @PostMapping("/{productId}")
    public ResponseEntity<DefaultResponse> addItemIntoCart(
            @PathVariable Long productId,
            @RequestBody SelectProductQuantity selectProductQuantity
            ){

        return ResponseEntity.status(HttpStatus.OK).body(itemCartService.addItemIntoCart(productId, selectProductQuantity));
    }

    @GetMapping()
    public ResponseEntity<List<CartResponse>> getMyCart(){
        return ResponseEntity.status(HttpStatus.OK).body(itemCartService.getMyCart());
    }

    @PutMapping("/{productId}")
    public ResponseEntity<DefaultResponse> updateItemIntoCart(
            @PathVariable Long productId,
            @RequestBody SelectProductQuantity selectProductQuantity
    ){
        return ResponseEntity.status(HttpStatus.OK).body(itemCartService.updateItemIntoCart(productId, selectProductQuantity));

    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<DefaultResponse> deleteItemIntoCart(
            @PathVariable Long productId
    ){
        return ResponseEntity.status(HttpStatus.OK).body(itemCartService.deleteItemIntoCart(productId));
    }
}
