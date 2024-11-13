package com.yoong.ecommercejava2.domain.order_details.controller;

import com.yoong.ecommercejava2.common.dto.DefaultResponse;
import com.yoong.ecommercejava2.domain.order_details.dto.request.BuyerOrderStatusRequest;
import com.yoong.ecommercejava2.domain.order_details.dto.request.SellerOrderStatusRequest;
import com.yoong.ecommercejava2.domain.order_details.dto.request.UpdateDeliveryStatusRequest;
import com.yoong.ecommercejava2.domain.order_details.dto.response.BuyerOrderResponse;
import com.yoong.ecommercejava2.domain.order_details.dto.response.OrderStatusResponse;
import com.yoong.ecommercejava2.domain.order_details.dto.response.SellerOrderResponse;
import com.yoong.ecommercejava2.domain.order_details.enum_class.OrderStatus;
import com.yoong.ecommercejava2.domain.order_details.service.OrderDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class OrderDetailsController {

    private final OrderDetailsService orderDetailsService;

    @PatchMapping("/buyer/complain/{shopId}/{orderId}")
    public ResponseEntity<OrderStatusResponse> buyerRequestComplain(
            @PathVariable("shopId")  Long shopId,
            @PathVariable("orderId") Long orderId,
            @RequestBody BuyerOrderStatusRequest buyerOrderStatusRequest
            ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(orderDetailsService.buyerRequestComplain(buyerOrderStatusRequest, shopId, orderId));
    }

    @GetMapping("/buyer/order-details")
    public ResponseEntity<List<BuyerOrderResponse>> getBuyerOrders() {
       return ResponseEntity.status(HttpStatus.OK).body(orderDetailsService.getBuyerOrders());
    }

    @GetMapping("/buyer/order-details/{orderId}")
    public ResponseEntity<BuyerOrderResponse> getBuyerOrderDetails(
            @PathVariable("orderId") Long orderId
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(orderDetailsService.getBuyerOrderDetails(orderId));
    }

    @PatchMapping("/seller/complain/{shopId}/{orderId}")
    public ResponseEntity<OrderStatusResponse> requestComplainReject(
            @PathVariable("shopId") Long shopId,
            @PathVariable("orderId") Long orderId,
            @RequestBody SellerOrderStatusRequest sellerOrderStatusRequest
            ){
        return ResponseEntity.status(HttpStatus.OK)
            .body(orderDetailsService.requestComplainReject(sellerOrderStatusRequest, shopId, orderId));
    }

    @GetMapping("/shop/order-details/{shopId}")
    public ResponseEntity<List<SellerOrderResponse>> getSellerOrderDetailsAll(
            @PathVariable("shopId") Long shopId,
            @RequestParam OrderStatus orderStatus
            ) {

       return ResponseEntity.status(HttpStatus.OK)
                .body(orderDetailsService.getSellerOrderDetailsAll(shopId, orderStatus));
    }

    @GetMapping("/shop/order-details/{shopId}/{orderId}")
    public ResponseEntity<SellerOrderResponse> getSellerOrderDetailsBuyer(
            @PathVariable("shopId") Long shopId,
            @PathVariable("orderId") Long orderId
            ){
        return ResponseEntity.status(HttpStatus.OK)
            .body(orderDetailsService.getSellerOrderDetailsBuyer(shopId, orderId));
    }

    @PatchMapping("/shop/complain/{shopId}/{orderId}/accept")
    public ResponseEntity<OrderStatusResponse> requestComplainAccept(
            @PathVariable("shopId") Long shopId,
            @PathVariable("orderId") Long orderId,
            @RequestBody SellerOrderStatusRequest sellerOrderStatusRequest
    ) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(orderDetailsService.requestComplainAccept(shopId, orderId, sellerOrderStatusRequest));
    }

    @PatchMapping("/{order-master-id}/{shop-id}")
    public ResponseEntity<DefaultResponse> updateProductsDelivery(
            @PathVariable("order-master-id") Long orderMasterId,
            @PathVariable("shop-id") Long shopId,
            @RequestBody UpdateDeliveryStatusRequest updateDeliveryStatusRequest
            ){
        return ResponseEntity.status(HttpStatus.OK)
                .body(orderDetailsService.updateProductsDelivery(orderMasterId, shopId, updateDeliveryStatusRequest));
    }

    @PatchMapping("delivery-status")
    public ResponseEntity<DefaultResponse> updateDeliveryStatus(){

        return ResponseEntity.status(HttpStatus.OK).body(orderDetailsService.updateDelivery());
    }

}
