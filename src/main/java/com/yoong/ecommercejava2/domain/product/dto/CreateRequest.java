package com.yoong.ecommercejava2.domain.product.dto;

import com.yoong.ecommercejava2.domain.backoffice.dto.product_backoffice.ProductBackOfficeRequest;

public record CreateRequest(
        CreateProductRequest createProductRequest,
        ProductBackOfficeRequest productBackOfficeRequest
) {
}
