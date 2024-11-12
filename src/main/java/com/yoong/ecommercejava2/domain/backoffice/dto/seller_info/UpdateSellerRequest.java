package com.yoong.ecommercejava2.domain.backoffice.dto.seller_info;

public record UpdateSellerRequest(
    String nickname,
    String phoneNumber,
    String address
){
}
