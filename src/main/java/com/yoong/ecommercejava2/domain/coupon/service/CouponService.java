package com.yoong.ecommercejava2.domain.coupon.service;

import com.yoong.ecommercejava2.common.dto.DefaultResponse;
import com.yoong.ecommercejava2.domain.coupon.dto.BuyerCouponResponse;
import com.yoong.ecommercejava2.domain.coupon.dto.CreateCouponRequest;
import com.yoong.ecommercejava2.domain.coupon.dto.SellerCouponResponse;
import com.yoong.ecommercejava2.domain.coupon.dto.UpdateCouponRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponService {

    public DefaultResponse createCoupon(CreateCouponRequest createCouponRequest) {
        return null;
    }

    public DefaultResponse updateCoupon(Long couponId, UpdateCouponRequest updateCouponRequest) {
        return null;
    }


    public SellerCouponResponse getSellerCouponById(Long couponId) {
        return null;
    }

    public List<SellerCouponResponse> getSellerCouponList() {
        return null;
    }

    public SellerCouponResponse getDetailCoupon(Long productId) {
        return null;
    }

    public BuyerCouponResponse getBuyerCouponById(Long productId) {
        return null;
    }

    public List<BuyerCouponResponse> getBuyerCouponList() {
        return null;
    }

    public DefaultResponse issuedCoupon(Long couponId) {
        return null;
    }

    public DefaultResponse deleteBuyerCoupon(Long couponId) {
        return null;
    }
}
