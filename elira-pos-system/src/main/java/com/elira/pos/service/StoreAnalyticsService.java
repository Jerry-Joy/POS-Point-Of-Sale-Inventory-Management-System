package com.elira.pos.service;

import com.elira.pos.payload.branchAnalytics.CategorySalesDTO;
import com.elira.pos.payload.storeAnalytics.*;

import java.util.List;

public interface StoreAnalyticsService {

    StoreOverviewDTO getStoreOverview(Long storeAdminId);
    TimeSeriesDataDTO getSalesTrends(Long storeAdminId, String period);

    List<TimeSeriesPointDTO> getMonthlySalesGraph(Long storeAdminId);

    List<TimeSeriesPointDTO> getDailySalesGraph(Long storeAdminId);

    //List<CategorySalesDTO> getSalesByCategory(Long storeAdminId);

    List<PaymentInsightDTO> getSalesByPaymentMethod(Long storeAdminId);

    List<BranchSalesDTO> getSalesByBranch(Long storeAdminId);

    List<PaymentInsightDTO> getPaymentBreakdown(Long storeAdminId);

    BranchPerformanceDTO getBranchPerformance(Long storeAdminId);

    StoreAlertDTO getStoreAlerts(Long storeAdminId);
}
