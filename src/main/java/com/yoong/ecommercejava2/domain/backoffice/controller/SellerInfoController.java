package com.yoong.ecommercejava2.domain.backoffice.controller;

import com.yoong.ecommercejava2.common.dto.DefaultResponse;
import com.yoong.ecommercejava2.domain.backoffice.dto.seller_info.UpdateImageRequest;
import com.yoong.ecommercejava2.domain.backoffice.dto.seller_info.UpdatePasswordRequest;
import com.yoong.ecommercejava2.domain.backoffice.dto.seller_info.UpdateSellerRequest;
import com.yoong.ecommercejava2.domain.backoffice.dto.seller_info.UpdateShopRequest;
import com.yoong.ecommercejava2.domain.backoffice.service.SellerInfoService;
import com.yoong.ecommercejava2.domain.seller.dto.SellerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sellerInfo")
@RequiredArgsConstructor
public class SellerInfoController {

    private final SellerInfoService sellerInfoService;

    @PatchMapping("/myShopInfo")
    public ResponseEntity<DefaultResponse> updateShopInfo(
            @RequestBody UpdateShopRequest updateShopRequest
            ){
        return ResponseEntity.status(HttpStatus.OK).body(sellerInfoService.updateShopInfo(updateShopRequest));
    }

    @PatchMapping("/myShopInfo/image")
    public ResponseEntity<DefaultResponse> changeShopImage(
            @RequestBody UpdateImageRequest updateImageRequest
            ){
        return ResponseEntity.status(HttpStatus.OK).body(sellerInfoService.changeShopImage(updateImageRequest));
    }

    @PatchMapping("/myInfo")
    public ResponseEntity<DefaultResponse> updateSellerInfo(
            @RequestBody UpdateSellerRequest updateSellerRequest
    ){
        return ResponseEntity.status(HttpStatus.OK).body(sellerInfoService.updateSellerInfo(updateSellerRequest));
    }

    @PatchMapping("/myInfo/changePassword")
    public ResponseEntity<DefaultResponse> changePassword(
            @RequestBody UpdatePasswordRequest updatePasswordRequest
    ){
        return ResponseEntity.status(HttpStatus.OK).body(sellerInfoService.changePassword(updatePasswordRequest));
    }

    @PatchMapping("/myInfo/image")
    public ResponseEntity<DefaultResponse> changeSellerImage(
            @RequestBody UpdateImageRequest updateImageRequest

    ){
        return ResponseEntity.status(HttpStatus.OK).body(sellerInfoService.changeSellerImage(updateImageRequest));
    }

    @GetMapping("/myInfo/image")
    public ResponseEntity<SellerResponse> getSellerInfo(){
        return ResponseEntity.status(HttpStatus.OK).body(sellerInfoService.getSellerInfo());
    }

    //ShopResponse
    @GetMapping("/myShopInfo")
    public ResponseEntity<DefaultResponse> getShopInfo(){
        return ResponseEntity.status(HttpStatus.OK).body(sellerInfoService.getShopInfo());
    }

    //ShopAndSellerResponse
    @GetMapping("/shopInfo/{shopId}")
    public ResponseEntity<DefaultResponse> getShopInfoByShopId(
            @PathVariable Long shopId
    ){
        return ResponseEntity.status(HttpStatus.OK).body(sellerInfoService.getShopInfoByShopId(shopId));
    }
}


