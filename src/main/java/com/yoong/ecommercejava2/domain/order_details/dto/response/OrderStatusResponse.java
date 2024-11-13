package com.yoong.ecommercejava2.domain.order_details.dto.response;

import com.yoong.ecommercejava2.domain.order_details.enum_class.ComplainType;

public record OrderStatusResponse(
        String msg
) {

    public static OrderStatusResponse from(ComplainType complainType, String str){

        String message = "";
                switch (complainType){
                    case ComplainType.EXCHANGE -> message = "교환 " + str;
                    case ComplainType.REFUND -> message = "환불 " + str;
                    default -> throw new RuntimeException();
                }

                return new OrderStatusResponse(message);
    }
}

