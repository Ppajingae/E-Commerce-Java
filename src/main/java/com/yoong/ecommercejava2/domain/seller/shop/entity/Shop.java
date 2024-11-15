package com.yoong.ecommercejava2.domain.seller.shop.entity;

import com.yoong.ecommercejava2.domain.seller.shop.dto.CreateShopRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table
@NoArgsConstructor
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
    private float rate = 0.0f;

    @Column(name = "seller_id")
    private Long sellerId;

    public Shop(CreateShopRequest createShopRequest) {
        this.description = createShopRequest.description();
        this.shopImage = createShopRequest.shopImage();
        this.name = createShopRequest.name();
    }
}
