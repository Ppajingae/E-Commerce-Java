package com.yoong.ecommercejava2.domain.buyer.controller;

import com.yoong.ecommercejava2.common.dto.DefaultResponse;
import com.yoong.ecommercejava2.domain.buyer.dto.request.CreateBuyerRequest;
import com.yoong.ecommercejava2.domain.buyer.dto.BuyerResponse;
import com.yoong.ecommercejava2.domain.buyer.dto.request.UpdateBuyerImageRequest;
import com.yoong.ecommercejava2.domain.buyer.dto.request.UpdateBuyerPasswordRequest;
import com.yoong.ecommercejava2.domain.buyer.dto.request.UpdateBuyerProfileRequest;
import com.yoong.ecommercejava2.domain.buyer.service.BuyerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name="구매자 관련 API")
@RestController
@RequestMapping("/api/v1/buyer")
@RequiredArgsConstructor
public class BuyerController {

    private final BuyerService buyerService;

    @PostMapping("/signup")
    public ResponseEntity<DefaultResponse> signUp(
            @RequestBody CreateBuyerRequest createBuyerRequest
    ){
        return ResponseEntity.status(HttpStatus.CREATED).body(buyerService.signUp(createBuyerRequest));
    }

    @GetMapping("/profile")
    public ResponseEntity<BuyerResponse> getMyProfile() {
        return ResponseEntity.status(HttpStatus.OK).body(buyerService.getMyProfile());
    }

    @PatchMapping("/profile/pw")
    public ResponseEntity<DefaultResponse> changePassword(
            @RequestBody UpdateBuyerPasswordRequest updateBuyerPasswordRequest
            ) {
        return ResponseEntity.status(HttpStatus.OK).body(buyerService.changePassword(updateBuyerPasswordRequest));
    }


    @PatchMapping("/profile/image")
    public ResponseEntity<DefaultResponse> changeImage(
            @RequestBody UpdateBuyerImageRequest updateBuyerImageRequest
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(buyerService.changeImage(updateBuyerImageRequest));
    }

    @PatchMapping("/profile")
    public ResponseEntity<DefaultResponse> changeProfile(
            @RequestBody UpdateBuyerProfileRequest updateBuyerProfileRequest
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(buyerService.changeProfile(updateBuyerProfileRequest));
    }


}