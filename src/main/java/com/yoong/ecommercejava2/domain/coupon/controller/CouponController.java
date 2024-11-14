package com.yoong.ecommercejava2.domain.coupon.controller;

import com.yoong.ecommercejava2.common.dto.DefaultResponse;
import com.yoong.ecommercejava2.domain.coupon.dto.BuyerCouponResponse;
import com.yoong.ecommercejava2.domain.coupon.dto.CreateCouponRequest;
import com.yoong.ecommercejava2.domain.coupon.dto.SellerCouponResponse;
import com.yoong.ecommercejava2.domain.coupon.dto.UpdateCouponRequest;
import com.yoong.ecommercejava2.domain.coupon.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CouponController {

    private final CouponService couponService;

    @PostMapping("/seller/coupon")
    public ResponseEntity<DefaultResponse> createCoupon(
            @RequestBody CreateCouponRequest createCouponRequest
            ){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(couponService.createCoupon(createCouponRequest));
    }

    @PutMapping("/seller/coupon/{couponId}")
    public ResponseEntity<DefaultResponse>  updateCoupon(
            @PathVariable("couponId") Long couponId,
            @RequestBody UpdateCouponRequest updateCouponRequest
            ){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(couponService.updateCoupon(couponId, updateCouponRequest));
    }

    @GetMapping("/seller/coupon/{couponId}")
    public ResponseEntity<SellerCouponResponse> getSellerCouponById(
            @PathVariable("couponId") Long couponId
    ){
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(couponService.getSellerCouponById(couponId));
    }


    @GetMapping("/seller/coupon")
    public ResponseEntity<List<SellerCouponResponse>> getSellerCouponList(
    ){
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(couponService.getSellerCouponList());
    }

    @GetMapping("/coupon/{productId}")
    public ResponseEntity<SellerCouponResponse> getDetailCoupon(
            @PathVariable("productId") Long productId
            ){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(couponService.getDetailCoupon(productId));
    }

    @GetMapping("/buyer/coupon/{productId}")
    public ResponseEntity<BuyerCouponResponse> getBuyerCouponById(
            @PathVariable("productId") Long productId
    ){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(couponService.getBuyerCouponById(productId));
    }

    @GetMapping("/buyer/coupon")
    public ResponseEntity<List<BuyerCouponResponse>> getBuyerCouponList(
    ){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(couponService.getBuyerCouponList());
    }

    @PatchMapping("/buyer/coupon/{couponId}")
    public ResponseEntity<DefaultResponse> issuedCoupon(
            @PathVariable Long couponId
    ){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(couponService.issuedCoupon(couponId));
    }

    @DeleteMapping("/buyer/coupon/{couponId}")
    public ResponseEntity<DefaultResponse> deleteBuyerCoupon(
            @PathVariable Long couponId
    ) {
       return ResponseEntity.status(HttpStatus.OK).body(couponService.deleteBuyerCoupon(couponId));
    }
}
