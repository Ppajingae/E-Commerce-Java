package com.yoong.ecommercejava2.domain.favorite.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "favorite")
public class Favorite {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "buyer_id")
    private Long buyerId;
}
