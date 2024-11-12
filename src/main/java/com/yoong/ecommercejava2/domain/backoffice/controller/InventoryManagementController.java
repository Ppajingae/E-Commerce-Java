package com.yoong.ecommercejava2.domain.backoffice.controller;

import com.yoong.ecommercejava2.domain.backoffice.dto.product_backoffice.PriceRequest;
import com.yoong.ecommercejava2.domain.backoffice.dto.product_backoffice.ProductBackOfficeResponse;
import com.yoong.ecommercejava2.domain.backoffice.dto.product_backoffice.QuantityRequest;
import com.yoong.ecommercejava2.domain.backoffice.dto.product_backoffice.SellersProductResponse;
import com.yoong.ecommercejava2.domain.backoffice.service.InventoryManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/seller")
@RequiredArgsConstructor
public class InventoryManagementController {

    private final InventoryManagementService inventoryManagementService;

    @PatchMapping("/{productId}/quantity")
    public ResponseEntity<ProductBackOfficeResponse> changeQuantity(
            @PathVariable Long productId,
            @RequestBody QuantityRequest quantityRequest
    ){
        return ResponseEntity.status(HttpStatus.OK).body(inventoryManagementService.changeQuantity(productId, quantityRequest));
    }

    @PatchMapping("/{productId}/price")
    public ResponseEntity<ProductBackOfficeResponse> changePrice(
            @PathVariable Long productId,
            @RequestBody PriceRequest priceRequest
    ){
        return ResponseEntity.status(HttpStatus.OK).body(inventoryManagementService.changePrice(productId, priceRequest));

    }

    @GetMapping("/products")
    public ResponseEntity<Page<SellersProductResponse>> getSellerProducts(
            @PageableDefault(size = 10, page = 0) Pageable pageable
    ){
        return ResponseEntity.status(HttpStatus.OK).body(inventoryManagementService.getSellerProducts(pageable));
    }

}
