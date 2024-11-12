package com.yoong.ecommercejava2.domain.product.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name="product")
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "product_image")
    private String productImage;

    @Column(name = "is_sold_out")
    private boolean isSoldOut = false;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt = null;

    @Column(name = "is_deleted")
    private boolean isDeleted = false;

    @Column(name="created_at")
    @CreationTimestamp
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name="updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt = LocalDateTime.now();

    @Column(name="shop_id")
    private Long shopId;

    @Column(name="category_id")
    private Long categoryId;
}
