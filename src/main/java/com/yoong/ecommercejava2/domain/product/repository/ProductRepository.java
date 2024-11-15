package com.yoong.ecommercejava2.domain.product.repository;

import com.yoong.ecommercejava2.domain.product.dto.ProductSummaryDto;
import com.yoong.ecommercejava2.domain.product.dto.ReviewProductDto;
import com.yoong.ecommercejava2.domain.product.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    Page<ProductSummaryDto> findAllPaginated(Pageable pageable);
    Page<ProductSummaryDto> findByCategoryPaginated(Long categoryId, Pageable pageable);
    Page<ProductSummaryDto> searchByKeywordPaginated(String keyword, Pageable pageable);
    List<ProductSummaryDto> findAllById(Collection<Long> productIds);
    Optional<Product> findById(Long id);
    List<Product> findAllByShopId(Long shopId);
    Page<Product> findPaginatedByShopId(Long shopId, Pageable pageable);
    List<ReviewProductDto> findAllByProductId(List<Long> productIdList);
    Product saveAndFlush(Product product);
    void delete(Product product);
}
