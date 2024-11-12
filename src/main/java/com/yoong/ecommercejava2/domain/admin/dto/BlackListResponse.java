package com.yoong.ecommercejava2.domain.admin.dto;

public record BlackListResponse(
        Long id,
        String nickname,
        String email,
        int sanctionsCount,
        boolean isSanctioned
) {
}
