package com.yoong.ecommercejava2.domain.item_cart.entity;

import com.yoong.ecommercejava2.domain.buyer.entity.Buyer;
import com.yoong.ecommercejava2.domain.product.entity.Product;
import jakarta.persistence.*;

@Entity
@Table(name = "cart")
public class ItemCart {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="buyer_id")
    private Buyer buyer;

    @Column(name="shop_id")
    private Long shopId;
}
