package com.yoong.ecommercejava2.domain.order_details.entity;

import com.yoong.ecommercejava2.domain.buyer.entity.Buyer;
import com.yoong.ecommercejava2.domain.order_details.enum_class.ComplainStatus;
import com.yoong.ecommercejava2.domain.order_details.enum_class.OrderStatus;
import com.yoong.ecommercejava2.domain.product.entity.Product;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="order_details")
public class OrderDetails {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status", nullable = false)
    private OrderStatus orderStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "complain_status", nullable = false)
    private ComplainStatus complainStatus;

    @Column(name = "buyer_req_dt", nullable = true)
    private LocalDateTime buyerDateTime = null;

    @Column(name = "buyer_req_desc", nullable = true)
    private String buyerDescription = null;

    @Column(name = "seller_rej_dt", nullable = true)
    private LocalDateTime sellerDateTime = null;

    @Column(name = "seller_rej_desc", nullable = true)
    private String sellerDescription = null;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "order_master_id", nullable = false)
    private Long orderMasterId;

    @Column(name = "product_quantity", nullable = false)
    private int productQuantity;

    @Column(name = "shop_id")
    private Long shopId;

    @Column(name = "total_price", nullable = false)
    private int totalPrice;
}
