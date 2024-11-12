package com.yoong.ecommercejava2.domain.product.controller;

import com.yoong.ecommercejava2.common.dto.DefaultResponse;
import com.yoong.ecommercejava2.domain.product.dto.CreateRequest;
import com.yoong.ecommercejava2.domain.product.dto.ProductResponse;
import com.yoong.ecommercejava2.domain.product.dto.UpdateProductRequest;
import com.yoong.ecommercejava2.domain.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<DefaultResponse> createProduct(
            @RequestBody CreateRequest createRequest
    ){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(
                createRequest.createProductRequest(),
                createRequest.productBackOfficeRequest()
        ));
    }

    @PatchMapping("/{productId}")
    ResponseEntity<DefaultResponse> updateProduct(
            @PathVariable Long productId,
            @RequestBody UpdateProductRequest updateProductRequest
            ){

        return ResponseEntity.status(HttpStatus.OK).body(productService.updateProduct(
                productId,
                updateProductRequest
        ));
    }

    @DeleteMapping("/{productId}")
    ResponseEntity<DefaultResponse> deleteProduct(
            @PathVariable Long productId
    ){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(productService.deleteProduct(
                productId
        ));
    }

    @GetMapping("/{productId}")
    ResponseEntity<ProductResponse> getProductById(
            @PathVariable Long productId
    ){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProductById(productId));
    }

    @GetMapping("/category")
    ResponseEntity<ProductResponse> getProductsByCategory(
            Long categoryId,
            @PageableDefault(size = 10, page = 0) Pageable pageable
    ){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProductsByCategory(categoryId, pageable));
    }
}
