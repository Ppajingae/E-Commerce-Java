package com.yoong.ecommercejava2.domain.backoffice.controller;

import com.yoong.ecommercejava2.domain.backoffice.dto.sales_statics.ProductSalesResponse;
import com.yoong.ecommercejava2.domain.backoffice.dto.sales_statics.TotalSalesResponse;
import com.yoong.ecommercejava2.domain.backoffice.service.SalesStatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/seller")
@RequiredArgsConstructor
public class SalesStatisticsController {

    private final SalesStatisticsService salesStatisticsService;

    //전체 상품 판매량 + 금액
    @GetMapping("/total-sales")
    public ResponseEntity<TotalSalesResponse> getTotalSales(){
        return ResponseEntity.status(HttpStatus.OK).body(salesStatisticsService.getTotalSales());
    }

    //상품 판매 수량 및 금액
    @GetMapping("/sales")
    ResponseEntity<List<ProductSalesResponse>> getProductSales(){
        return ResponseEntity.status(HttpStatus.OK).body(salesStatisticsService.getProductSales());
    }
}


