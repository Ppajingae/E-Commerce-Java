package com.yoong.ecommercejava2.domain.admin.service;

import com.yoong.ecommercejava2.common.dto.DefaultResponse;
import com.yoong.ecommercejava2.domain.admin.dto.AdminBySellerResponse;
import com.yoong.ecommercejava2.domain.admin.dto.BlackListResponse;
import com.yoong.ecommercejava2.domain.seller.dto.SellerResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    public DefaultResponse sanctionSeller(Long sellerId, Long id) {
        return null;
    }


    public DefaultResponse sanctionProduct(Long productId, Long id) {
        return null;
    }


    public List<BlackListResponse> getBlackLists(Long id) {
        return null;
    }


    public BlackListResponse getBlackList(Long blackListId, Long id) {
        return null;
    }


    public DefaultResponse deleteBlackList(Long blackListId, Long id) {
        return null;
    }


    public DefaultResponse approveSellerResignation(Long sellerId, Long id) {
        return null;
    }

    public DefaultResponse promotePendingSeller(Long sellerId, Long id) {
        return null;
    }

    public List<SellerResponse> getSellerLists() {
        return null;
    }

    public AdminBySellerResponse getSellerBySellerId(Long sellerId) {
        return null;
    }
}
