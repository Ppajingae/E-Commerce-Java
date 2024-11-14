package com.yoong.ecommercejava2.domain.admin.controller;

import com.yoong.ecommercejava2.common.dto.DefaultResponse;
import com.yoong.ecommercejava2.domain.admin.dto.AdminBySellerResponse;
import com.yoong.ecommercejava2.domain.admin.dto.BlackListResponse;
import com.yoong.ecommercejava2.domain.admin.service.AdminService;
import com.yoong.ecommercejava2.domain.seller.dto.SellerResponse;
import com.yoong.ecommercejava2.infra.security.Jwt.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/sanctions/seller/{sellerId}")
    ResponseEntity<DefaultResponse> sanctionSeller(
            @PathVariable Long sellerId,
            @AuthenticationPrincipal UserPrincipal userPrincipal
            ){
        return ResponseEntity.status(HttpStatus.OK).body(adminService.sanctionSeller(sellerId, userPrincipal.getId()));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/sanctions/product/{productId}")
    ResponseEntity<DefaultResponse> sanctionProduct(
            @PathVariable Long productId,
            @AuthenticationPrincipal UserPrincipal userPrincipal
    ){
        return ResponseEntity.status(HttpStatus.OK).body(adminService.sanctionProduct(productId, userPrincipal.getId()));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/black-list")
    ResponseEntity<List<BlackListResponse>> getBlackLists(
            @AuthenticationPrincipal UserPrincipal userPrincipal
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(adminService.getBlackLists(userPrincipal.getId()));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/black-list/{blackListId}")
    ResponseEntity<BlackListResponse> getBlackList(
            @PathVariable Long blackListId,
            @AuthenticationPrincipal UserPrincipal userPrincipal
    ){
        return ResponseEntity.status(HttpStatus.OK).body(adminService.getBlackList(blackListId, userPrincipal.getId()));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/black-list/{blackListId}")
    ResponseEntity<DefaultResponse> deleteBlackList(
            @PathVariable Long blackListId,
            @AuthenticationPrincipal UserPrincipal userPrincipal
    ){
        return ResponseEntity.status(HttpStatus.OK).body(adminService.deleteBlackList(blackListId, userPrincipal.getId()));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/seller/resign/{sellerId}")
    ResponseEntity<DefaultResponse> approveSellerResignation(
            @PathVariable Long sellerId,
            @AuthenticationPrincipal UserPrincipal userPrincipal
    ){
        return ResponseEntity.status(HttpStatus.OK).body(adminService.approveSellerResignation(sellerId, userPrincipal.getId()));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/seller/approval/{sellerId}")
    ResponseEntity<DefaultResponse> promotePendingSeller(
            @PathVariable Long sellerId,
            @AuthenticationPrincipal UserPrincipal userPrincipal
    ){
        return ResponseEntity.status(HttpStatus.OK).body(adminService.promotePendingSeller(sellerId, userPrincipal.getId()));
    }

    @GetMapping("/sellers")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<SellerResponse>> getSellerLists() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(adminService.getSellerLists());
    }

    @GetMapping("/sellers/{sellerId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<AdminBySellerResponse> getSellerBySellerId(
            @PathVariable Long sellerId
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(adminService.getSellerBySellerId(sellerId));
    }



}
