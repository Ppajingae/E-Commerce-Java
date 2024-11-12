package com.yoong.ecommercejava2.domain.admin.service;

import com.yoong.ecommercejava2.common.dto.DefaultResponse;
import com.yoong.ecommercejava2.domain.admin.dto.BlackListResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    public DefaultResponse sanctionSeller(Long sellerId) {
        return null;
    }


    public DefaultResponse sanctionProduct(Long productId) {
        return null;
    }


    public List<BlackListResponse> getBlackLists() {
        return null;
    }


    public BlackListResponse getBlackList(Long blackListId) {
        return null;
    }


    public DefaultResponse deleteBlackList(Long blackListId) {
        return null;
    }


    public DefaultResponse approveSellerResignation(Long sellerId) {
        return null;
    }

    public DefaultResponse promotePendingSeller(Long sellerId) {
        return null;
    }
}
