package com.yoong.ecommercejava2.domain.order_details.service;

import com.yoong.ecommercejava2.common.dto.DefaultResponse;
import com.yoong.ecommercejava2.domain.order_details.dto.request.BuyerOrderStatusRequest;
import com.yoong.ecommercejava2.domain.order_details.dto.request.SellerOrderStatusRequest;
import com.yoong.ecommercejava2.domain.order_details.dto.request.UpdateDeliveryStatusRequest;
import com.yoong.ecommercejava2.domain.order_details.dto.response.BuyerOrderResponse;
import com.yoong.ecommercejava2.domain.order_details.dto.response.OrderStatusResponse;
import com.yoong.ecommercejava2.domain.order_details.dto.response.SellerOrderResponse;
import com.yoong.ecommercejava2.domain.order_details.enum_class.OrderStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsService {

    public OrderStatusResponse buyerRequestComplain(BuyerOrderStatusRequest buyerOrderStatusRequest, Long shopId, Long orderId) {
        return null;
    }

    public List<BuyerOrderResponse> getBuyerOrders() {
        return null;
    }

    public BuyerOrderResponse getBuyerOrderDetails(Long orderId) {
        return null;
    }

    public OrderStatusResponse requestComplainReject(SellerOrderStatusRequest sellerOrderStatusRequest, Long shopId, Long orderId) {
        return null;
    }

    public List<SellerOrderResponse> getSellerOrderDetailsAll(Long shopId, OrderStatus orderStatus) {
        return null;
    }

    public SellerOrderResponse getSellerOrderDetailsBuyer(Long shopId, Long orderId) {
        return null;
    }

    public OrderStatusResponse requestComplainAccept(Long shopId, Long orderId, SellerOrderStatusRequest sellerOrderStatusRequest) {
        return null;
    }

    public DefaultResponse updateProductsDelivery(Long orderMasterId, Long shopId, UpdateDeliveryStatusRequest updateDeliveryStatusRequest) {
        return null;
    }

    public DefaultResponse updateDelivery() {
        return null;
    }
}
