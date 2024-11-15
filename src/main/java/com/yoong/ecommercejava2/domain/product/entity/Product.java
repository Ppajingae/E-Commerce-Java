package com.yoong.ecommercejava2.domain.product.entity;

import com.yoong.ecommercejava2.domain.backoffice.entity.ProductBackOffice;
import com.yoong.ecommercejava2.domain.product.dto.CreateProductRequest;
import com.yoong.ecommercejava2.domain.product.dto.UpdateProductRequest;
import com.yoong.ecommercejava2.domain.seller.shop.entity.Shop;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name="product")
@SQLRestriction("is_deleted=false")
@NoArgsConstructor
@Getter
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="shop_id")
    private Shop shop;

    @Column(name="category_id")
    private Long categoryId;

    @OneToOne(mappedBy = "product", optional = false)
    private ProductBackOffice productBackOffice;

    public Product(CreateProductRequest createProductRequest, Shop shop) {

        this.name = createProductRequest.name();
        this.description = createProductRequest.description();
        this.categoryId = createProductRequest.categoryId();
        this.productImage = createProductRequest.imageUrl();
        this.shop = shop;
    }

    public void savedProductBackOffice(ProductBackOffice productBackOffice) {
        this.productBackOffice = productBackOffice;
    }

    public void updateProduct(UpdateProductRequest updateProductRequest) {
        this.name = updateProductRequest.name();
        this.description = updateProductRequest.description();
        this.categoryId = updateProductRequest.categoryId();
        this.isSoldOut = updateProductRequest.isSoldOut();
        this.updatedAt = LocalDateTime.now();
    }

    public void delete(){
        this.isDeleted = true;
        this.deletedAt = LocalDateTime.now();
    }
}
