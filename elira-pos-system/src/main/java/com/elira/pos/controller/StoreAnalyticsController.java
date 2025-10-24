package com.elira.pos.controller;

import com.elira.pos.payload.branchAnalytics.CategorySalesDTO;
import com.elira.pos.payload.storeAnalytics.*;
import com.elira.pos.service.StoreAnalyticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/store/analytics")
public class StoreAnalyticsController {

    private final StoreAnalyticsService storeAnalyticsService;

    @GetMapping("/{storeAdminId}/overview")
    public ResponseEntity<StoreOverviewDTO> getStoreOverview(
            @PathVariable Long storeAdminId
    ){
        return ResponseEntity.ok(
                storeAnalyticsService.getStoreOverview(storeAdminId)
        );
    }

    @GetMapping("/{storeAdminId}/sales-trends")
    public ResponseEntity<TimeSeriesDataDTO> getSalesTrends(
            @PathVariable Long storeAdminId,
            @RequestParam String period
    ){
        return ResponseEntity.ok(
                storeAnalyticsService.getSalesTrends(storeAdminId, period));
    }

    @GetMapping("/{storeAdminId}/sales/monthly")
    public ResponseEntity<List<TimeSeriesPointDTO>> getMonthlySales(
            @PathVariable Long storeAdminId
    ){
        return ResponseEntity.ok(
                storeAnalyticsService.getMonthlySalesGraph(storeAdminId));
    }

    @GetMapping("/{storeAdminId}/sales/daily")
    public ResponseEntity<List<TimeSeriesPointDTO>> getDailySales(
            @PathVariable Long storeAdminId
    ){
        return ResponseEntity.ok(
                storeAnalyticsService.getDailySalesGraph(storeAdminId));
    }

//    @GetMapping("/{storeAdminId}/sales/category")
//    public ResponseEntity<List<CategorySalesDTO>> getSalesByCategory(
//            @PathVariable Long storeAdminId
//    ){
//        return ResponseEntity.ok(
//                storeAnalyticsService.getSalesByCategory);
//    }

    @GetMapping("/{storeAdminId}/sales/payment-method")
    public ResponseEntity<List<PaymentInsightDTO>> getSalesByPaymentMethod(
            @PathVariable Long storeAdminId
    ){
        return ResponseEntity.ok(
                storeAnalyticsService.getSalesByPaymentMethod(storeAdminId));
    }

    @GetMapping("/{storeAdminId}/sales/branch")
    public ResponseEntity<List<BranchSalesDTO>> getSalesByBranch(
            @PathVariable Long storeAdminId
    ){
        return ResponseEntity.ok(
                storeAnalyticsService.getSalesByBranch(storeAdminId));
    }

    @GetMapping("/{storeAdminId}/sales/payment")
    public ResponseEntity<List<PaymentInsightDTO>> getPaymentBreakdown(
            @PathVariable Long storeAdminId
    ){
        return ResponseEntity.ok(
                storeAnalyticsService.getSalesByPaymentMethod(storeAdminId));
    }

    @GetMapping("/{storeAdminId}/branch-performance")
    public ResponseEntity<BranchPerformanceDTO> getBranchPerformance(
            @PathVariable Long storeAdminId
    ){
        return ResponseEntity.ok(
                storeAnalyticsService.getBranchPerformance(storeAdminId));
    }

    @GetMapping("/{storeAdminId}/alert")
    public ResponseEntity<StoreAlertDTO> getStoreAlert(
            @PathVariable Long storeAdminId
    ){
        return ResponseEntity.ok(
                storeAnalyticsService.getStoreAlerts(storeAdminId));
    }
}
