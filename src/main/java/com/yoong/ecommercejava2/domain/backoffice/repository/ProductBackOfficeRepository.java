package com.yoong.ecommercejava2.domain.backoffice.repository;

import com.yoong.ecommercejava2.domain.backoffice.dto.sales_statics.TotalSalesResponse;

import java.util.List;

public interface ProductBackOfficeRepository {

    TotalSalesResponse findTotalSalesStatisticsByProductIds(List<Long> productIds);
}
