package com.yoong.ecommercejava2.domain.backoffice.dto.sales_statics;

public record TotalSalesResponse(
        int totalQuantity,
        int totalPrice
) {
}
