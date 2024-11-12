package com.yoong.ecommercejava2.domain.backoffice.entity;

import com.yoong.ecommercejava2.domain.product.entity.Product;
import jakarta.persistence.*;

@Entity
@Table(name="product_backoffice")
public class ProductBackOffice {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(name = "quantity")
    private int quantity;

    @Column(name="price")
    private int price;

    @Column(name = "sold_quantity")
    private Long soldQuantity;

    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;
}
