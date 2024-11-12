package com.yoong.ecommercejava2.domain.product.dto;

public record ProductSummaryDto(
        Long id,
        String image,
        String name,
        int price
) {
}