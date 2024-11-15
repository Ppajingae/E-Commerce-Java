package com.yoong.ecommercejava2.domain.product.service;

import com.yoong.ecommercejava2.common.dto.DefaultResponse;
import com.yoong.ecommercejava2.common.ex.exception.ModelNotFoundException;
import com.yoong.ecommercejava2.domain.backoffice.dto.product_backoffice.ProductBackOfficeRequest;
import com.yoong.ecommercejava2.domain.backoffice.entity.ProductBackOffice;
import com.yoong.ecommercejava2.domain.backoffice.repository.ProductBackOfficeRepository;
import com.yoong.ecommercejava2.domain.product.dto.CreateProductRequest;
import com.yoong.ecommercejava2.domain.product.dto.ProductResponse;
import com.yoong.ecommercejava2.domain.product.dto.UpdateProductRequest;
import com.yoong.ecommercejava2.domain.product.entity.Product;
import com.yoong.ecommercejava2.domain.product.repository.ProductRepository;
import com.yoong.ecommercejava2.domain.seller.repository.SellerRepository;
import com.yoong.ecommercejava2.domain.seller.shop.entity.Shop;
import com.yoong.ecommercejava2.domain.seller.shop.repository.ShopRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ShopRepository shopRepository;
    private final SellerRepository sellerRepository;
    private final ProductBackOfficeRepository productBackOfficeRepository;

    @Transactional
    public DefaultResponse createProduct(CreateProductRequest productRequest, ProductBackOfficeRequest productBackOfficeRequest, Long sellerId) {

        Shop shop = shopRepository.findBySellerId(sellerId).orElseThrow(()->
                new ModelNotFoundException(404, "상점 정보가 존재하지 않습니다"));

        Product product = productRepository.saveAndFlush(new Product(productRequest, shop));

        ProductBackOffice productBackOffice = productBackOfficeRepository.save(new ProductBackOffice(productBackOfficeRequest, product));

        product.savedProductBackOffice(productBackOffice);

        return new DefaultResponse("상품 생성이 완료 되었습니다");
    }

    @Transactional
    public DefaultResponse updateProduct(Long productId, UpdateProductRequest updateProductRequest) {

        Product product = productRepository.findById(productId).orElseThrow(
                () -> new ModelNotFoundException(404, "상품이 존재하지 않습니다")
        );

        product.updateProduct(updateProductRequest);

        return new DefaultResponse("상품 정보 수정이 완료 되었습니다");
    }

    @Transactional
    public DefaultResponse deleteProduct(Long productId) {

        Product product = productRepository.findById(productId).orElseThrow(
                () -> new ModelNotFoundException(404, "상품이 존재하지 않습니다")
        );

        product.delete();

        return new DefaultResponse("상품 삭제가 완료 되었습니다");
    }

    public ProductResponse getProductById(Long productId) {

        Product product = productRepository.findById(productId).orElseThrow(
                () -> new ModelNotFoundException(404, "상품이 존재하지 않습니다")
        );

        return ProductResponse.from(product);
    }

    public ProductResponse getProductsByCategory(Long categoryId, Pageable pageable) {
        return null;
    }
}
