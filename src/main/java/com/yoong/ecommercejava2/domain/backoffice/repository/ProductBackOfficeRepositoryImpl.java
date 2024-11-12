package com.yoong.ecommercejava2.domain.backoffice.repository;

import com.yoong.ecommercejava2.domain.backoffice.dto.sales_statics.TotalSalesResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductBackOfficeRepositoryImpl implements ProductBackOfficeRepository {

    private final ProductBackOfficeJpaRepository productBackOfficeJpaRepository;

    @Override
    public TotalSalesResponse findTotalSalesStatisticsByProductIds(List<Long> productIds) {
        return null;
    }
}
