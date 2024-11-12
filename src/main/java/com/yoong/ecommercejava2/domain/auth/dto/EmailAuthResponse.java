package com.yoong.ecommercejava2.domain.auth.dto;

import com.yoong.ecommercejava2.domain.auth.enum_class.UserRole;

public record EmailAuthResponse(
        Long id,
        boolean isApproved,
        UserRole role
) {
}
