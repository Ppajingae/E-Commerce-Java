package com.yoong.ecommercejava2.domain.order_master.controller;

import com.yoong.ecommercejava2.common.dto.DefaultResponse;
import com.yoong.ecommercejava2.domain.order_master.dto.PaymentRequest;
import com.yoong.ecommercejava2.domain.order_master.service.OrderMasterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class OrderMasterController {

    private final OrderMasterService orderMasterService;

    @PostMapping("/payments")
    public ResponseEntity<DefaultResponse> requestPayment(
            @RequestBody PaymentRequest paymentRequest
    ){
        return ResponseEntity.status(HttpStatus.OK).body(orderMasterService.requestPayment(paymentRequest));
    }

}
