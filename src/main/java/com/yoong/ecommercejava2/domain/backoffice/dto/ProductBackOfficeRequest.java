package com.yoong.ecommercejava2.domain.backoffice.dto;

public record ProductBackOfficeRequest(
        int quantity,
        int price
) {
}
