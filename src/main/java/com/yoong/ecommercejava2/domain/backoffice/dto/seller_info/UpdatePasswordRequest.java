package com.yoong.ecommercejava2.domain.backoffice.dto.seller_info;

public record UpdatePasswordRequest(
    String currentPassword,
    String newPassword,
    String confirmPassword
){
}
