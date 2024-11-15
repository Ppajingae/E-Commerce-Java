package com.yoong.ecommercejava2.domain.product.repository;

import com.yoong.ecommercejava2.domain.product.dto.ProductSummaryDto;
import com.yoong.ecommercejava2.domain.product.dto.ReviewProductDto;
import com.yoong.ecommercejava2.domain.product.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository{

    private final ProductJpaRepository productJpaRepository;

    @Override
    public Page<ProductSummaryDto> findAllPaginated(Pageable pageable) {
        return null;
    }

    @Override
    public Page<ProductSummaryDto> findByCategoryPaginated(Long categoryId, Pageable pageable) {
        return null;
    }

    @Override
    public Page<ProductSummaryDto> searchByKeywordPaginated(String keyword, Pageable pageable) {
        return null;
    }

    @Override
    public List<ProductSummaryDto> findAllById(Collection<Long> productIds) {
        return List.of();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productJpaRepository.findById(id);
    }

    @Override
    public List<Product> findAllByShopId(Long shopId) {
        return List.of();
    }

    @Override
    public Page<Product> findPaginatedByShopId(Long shopId, Pageable pageable) {
        return null;
    }

    @Override
    public List<ReviewProductDto> findAllByProductId(List<Long> productIdList) {
        return List.of();
    }

    @Override
    public Product saveAndFlush(Product product) {
        return productJpaRepository.saveAndFlush(product);
    }

    @Override
    public void delete(Product product) {
        productJpaRepository.delete(product);
    }
}
