package com.yoong.ecommercejava2.domain.product.service;

import com.yoong.ecommercejava2.common.dto.DefaultResponse;
import com.yoong.ecommercejava2.domain.backoffice.dto.ProductBackOfficeRequest;
import com.yoong.ecommercejava2.domain.product.dto.CreateProductRequest;
import com.yoong.ecommercejava2.domain.product.dto.ProductResponse;
import com.yoong.ecommercejava2.domain.product.dto.UpdateProductRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    public DefaultResponse createProduct(CreateProductRequest productRequest, ProductBackOfficeRequest productBackOfficeRequest) {
        return null;
    }

    public DefaultResponse updateProduct(Long productId, UpdateProductRequest updateProductRequest) {
        return null;
    }

    public DefaultResponse deleteProduct(Long productId) {
        return null;
    }

    public ProductResponse getProductById(Long productId) {
        return null;
    }

    public ProductResponse getProductsByCategory(Long categoryId, Pageable pageable) {
        return null;
    }
}
