package com.yoong.ecommercejava2.domain.auth.dto;

import com.yoong.ecommercejava2.domain.auth.enum_class.UserRole;

public record EmailAuthRequest(
        String email,
        UserRole role
){
}
