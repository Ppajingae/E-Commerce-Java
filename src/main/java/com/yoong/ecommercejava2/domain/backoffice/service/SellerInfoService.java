package com.yoong.ecommercejava2.domain.backoffice.service;

import com.yoong.ecommercejava2.common.dto.DefaultResponse;
import com.yoong.ecommercejava2.domain.backoffice.dto.seller_info.UpdateImageRequest;
import com.yoong.ecommercejava2.domain.backoffice.dto.seller_info.UpdatePasswordRequest;
import com.yoong.ecommercejava2.domain.backoffice.dto.seller_info.UpdateSellerRequest;
import com.yoong.ecommercejava2.domain.backoffice.dto.seller_info.UpdateShopRequest;
import com.yoong.ecommercejava2.domain.seller.dto.SellerResponse;
import org.springframework.stereotype.Service;

@Service
public class SellerInfoService {

    public DefaultResponse updateShopInfo(UpdateShopRequest updateShopRequest) {
        return null;
    }

    public DefaultResponse changeShopImage(UpdateImageRequest updateImageRequest) {
        return null;
    }

    public DefaultResponse updateSellerInfo(UpdateSellerRequest updateSellerRequest) {
        return null;
    }

    public DefaultResponse changePassword(UpdatePasswordRequest updatePasswordRequest) {
        return null;
    }

    public DefaultResponse changeSellerImage(UpdateImageRequest updateImageRequest) {
        return null;
    }

    public SellerResponse getSellerInfo() {
        return null;
    }

    //ShopResponse
    public DefaultResponse getShopInfo() {
        return null;
    }

    //ShopAndSellerResponse
    public DefaultResponse getShopInfoByShopId(Long shopId) {
        return null;
    }
}
