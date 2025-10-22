package com.elira.pos.service;

import com.elira.pos.modal.PaymentSummary;
import com.elira.pos.payload.branchAnalytics.*;

import java.time.LocalDate;
import java.util.List;

public interface BranchAnalyticsService {

    List<DailySalesDTO> getDailySalesChart(Long branchId, Integer days);
    List<ProductPerformanceDTO> getTopProductsByQuantityWithPercentage(Long branchId);
    List<CashierPerformanceDTO> getTopCashierPerformanceByOrders(Long branchId);
    List<CategorySalesDTO> getCategoryWiseSalesBreakdown(Long branchId, LocalDate date);
    BranchDashboardOverviewDTO getBranchOverview(Long branchId);
    List<PaymentSummary> getPaymentMethodBreakdown(Long branchId, LocalDate date);
}
