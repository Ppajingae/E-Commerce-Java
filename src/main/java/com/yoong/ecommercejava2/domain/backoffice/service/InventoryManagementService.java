package com.yoong.ecommercejava2.domain.backoffice.service;

import com.yoong.ecommercejava2.domain.backoffice.dto.product_backoffice.PriceRequest;
import com.yoong.ecommercejava2.domain.backoffice.dto.product_backoffice.ProductBackOfficeResponse;
import com.yoong.ecommercejava2.domain.backoffice.dto.product_backoffice.QuantityRequest;
import com.yoong.ecommercejava2.domain.backoffice.dto.product_backoffice.SellersProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class InventoryManagementService {

    public ProductBackOfficeResponse changeQuantity(Long productId, QuantityRequest quantityRequest) {
        return null;
    }

    public ProductBackOfficeResponse changePrice(Long productId, PriceRequest priceRequest) {
        return null;
    }

    public Page<SellersProductResponse> getSellerProducts(Pageable pageable) {
        return null;
    }
}
