package com.yoong.ecommercejava2.domain.buyer.service;

import com.yoong.ecommercejava2.common.dto.DefaultResponse;
import com.yoong.ecommercejava2.domain.buyer.dto.BuyerResponse;
import com.yoong.ecommercejava2.domain.buyer.dto.request.CreateBuyerRequest;
import com.yoong.ecommercejava2.domain.buyer.dto.request.UpdateBuyerImageRequest;
import com.yoong.ecommercejava2.domain.buyer.dto.request.UpdateBuyerPasswordRequest;
import com.yoong.ecommercejava2.domain.buyer.dto.request.UpdateBuyerProfileRequest;
import org.springframework.stereotype.Service;

@Service
public class BuyerService {

    public DefaultResponse signUp(CreateBuyerRequest createBuyerRequest) {
        return null;
    }

    public BuyerResponse getMyProfile() {
        return null;
    }

    public DefaultResponse changePassword(UpdateBuyerPasswordRequest updateBuyerPasswordRequest) {
        return null;
    }

    public DefaultResponse changeImage(UpdateBuyerImageRequest updateBuyerImageRequest) {
        return null;
    }

    public DefaultResponse changeProfile(UpdateBuyerProfileRequest updateBuyerProfileRequest) {
        return null;
    }
}
