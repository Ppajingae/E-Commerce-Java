package com.yoong.ecommercejava2.domain.backoffice.dto.sales_statics;

public record ProductSalesResponse(
        String productName,
        String productQuantity,
        String productPrice
) {
}
