package com.yoong.ecommercejava2.domain.seller.shop.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Shop {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "shop_image")
    private String shopImage;

    @Column(name = "rate")
    private float rate;

    @Column(name = "seller_id")
    private Long sellerId;
}
