package com.yoong.ecommercejava2.domain.seller.controller;

import com.yoong.ecommercejava2.common.dto.DefaultResponse;
import com.yoong.ecommercejava2.domain.seller.dto.CreateSellerRequest;
import com.yoong.ecommercejava2.domain.seller.dto.SellerResponse;
import com.yoong.ecommercejava2.domain.seller.service.SellerService;
import com.yoong.ecommercejava2.domain.seller.shop.dto.CreateShopRequest;
import com.yoong.ecommercejava2.domain.seller.shop.dto.ShopResponse;
import com.yoong.ecommercejava2.infra.security.Jwt.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    public ResponseEntity<DefaultResponse> signUp(
            @RequestBody CreateSellerRequest createSellerRequest
            ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(sellerService.signUp(createSellerRequest));
    }

    @PreAuthorize("hasRole('SELLER')")
    @PostMapping("/shop")
    public ResponseEntity<DefaultResponse> createShop(
            @RequestBody CreateShopRequest createShopRequest,
            @AuthenticationPrincipal UserPrincipal userPrincipal
            ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(sellerService.createShop(userPrincipal.getId(), createShopRequest));
    }
}
