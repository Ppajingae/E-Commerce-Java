package com.yoong.ecommercejava2.domain.admin.controller;

import com.yoong.ecommercejava2.common.dto.DefaultResponse;
import com.yoong.ecommercejava2.domain.admin.dto.BlackListResponse;
import com.yoong.ecommercejava2.domain.admin.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/sanctions/seller/{sellerId}")
    ResponseEntity<DefaultResponse> sanctionSeller(
            @PathVariable Long sellerId
    ){
        return ResponseEntity.status(HttpStatus.OK).body(adminService.sanctionSeller(sellerId));
    }

    @PostMapping("/sanctions/product/{productId}")
    ResponseEntity<DefaultResponse> sanctionProduct(
            @PathVariable Long productId
    ){
        return ResponseEntity.status(HttpStatus.OK).body(adminService.sanctionProduct(productId));
    }

    @GetMapping("/black-list")
    ResponseEntity<List<BlackListResponse>> getBlackLists() {
        return ResponseEntity.status(HttpStatus.OK).body(adminService.getBlackLists());
    }

    @GetMapping("/black-list/{blackListId}")
    ResponseEntity<BlackListResponse> getBlackList(
            @PathVariable Long blackListId
    ){
        return ResponseEntity.status(HttpStatus.OK).body(adminService.getBlackList(blackListId));
    }

    @DeleteMapping("/black-list/{blackListId}")
    ResponseEntity<DefaultResponse> deleteBlackList(
            @PathVariable Long blackListId
    ){
        return ResponseEntity.status(HttpStatus.OK).body(adminService.deleteBlackList(blackListId));
    }

    @DeleteMapping("/seller/resign/{sellerId}")
    ResponseEntity<DefaultResponse> approveSellerResignation(
            @PathVariable Long sellerId
    ){
        return ResponseEntity.status(HttpStatus.OK).body(adminService.approveSellerResignation(sellerId));
    }

    @PatchMapping("/seller/approval/{sellerId}")
    ResponseEntity<DefaultResponse> promotePendingSeller(
            @PathVariable Long sellerId
    ){
        return ResponseEntity.status(HttpStatus.OK).body(adminService.promotePendingSeller(sellerId));
    }


}


//// 판매자 전체 조회
//@GetMapping("/sellers")
//@PreAuthorize("hasRole('ADMIN')")
//fun getSellerLists(): ResponseEntity<List<SellerResponse>> =
//        ResponseEntity
//        .status(HttpStatus.OK)
//            .body(adminService.getSellerLists())
//
//// 판매자 상세 조회
//@GetMapping("/sellers/{sellerId}")
//@PreAuthorize("hasRole('ADMIN')")
//fun getSellerBySellerId(
//        @PathVariable sellerId: Long
//): ResponseEntity<AdminBySellerResponse> =
//        ResponseEntity
//        .status(HttpStatus.OK)
//           .body(adminService.getSellerBySellerId(sellerId))