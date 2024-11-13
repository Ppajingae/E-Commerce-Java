package com.yoong.ecommercejava2.domain.seller.controller;

import com.yoong.ecommercejava2.domain.seller.dto.CreateSellerRequest;
import com.yoong.ecommercejava2.domain.seller.dto.SellerResponse;
import com.yoong.ecommercejava2.domain.seller.service.SellerService;
import com.yoong.ecommercejava2.domain.seller.shop.dto.CreateShopRequest;
import com.yoong.ecommercejava2.domain.seller.shop.dto.ShopResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/seller")
@RequiredArgsConstructor
public class SellerController {

    private final SellerService sellerService;

    @PostMapping("/user_signup")
    public ResponseEntity<SellerResponse> signUp(
            @RequestBody CreateSellerRequest createSellerRequest
            ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(sellerService.signUp(createSellerRequest));
    }

    @PostMapping("/shop")
    public ResponseEntity<ShopResponse> createShop(
            @RequestBody CreateShopRequest createShopRequest
            ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(sellerService.createShop(createShopRequest));
    }
}
