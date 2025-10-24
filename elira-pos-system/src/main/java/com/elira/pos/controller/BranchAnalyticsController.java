package com.elira.pos.controller;


import com.elira.pos.modal.PaymentSummary;
import com.elira.pos.payload.branchAnalytics.*;
import com.elira.pos.service.BranchAnalyticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/branch-analytics")
public class BranchAnalyticsController {

    private final BranchAnalyticsService branchAnalyticsService;

    @GetMapping("/daily-sales")
    public ResponseEntity<List<DailySalesDTO>> getDailySalesChart(
            @RequestParam Long branchId,
            @RequestParam (defaultValue = "7") int days
    ) {
        return ResponseEntity.ok(
                branchAnalyticsService.getDailySalesChart(branchId, days));
    }

    @GetMapping("/top-products")
    public ResponseEntity<List<ProductPerformanceDTO>> getTopProductByQuantity(
            @RequestParam Long branchId
    ) {
        return ResponseEntity.ok(
                branchAnalyticsService.getTopProductsByQuantityWithPercentage(branchId));
    }

    @GetMapping("/top-cashiers")
    public ResponseEntity<List<CashierPerformanceDTO>> topCashiers(
            @RequestParam Long branchId
    ) {
        return ResponseEntity.ok(
                branchAnalyticsService.getTopCashierPerformanceByOrders(branchId));
    }

    @GetMapping("/category-sales")
    public ResponseEntity<List<CategorySalesDTO>> getCategoryWiseSalesBreakdown(
            @RequestParam Long branchId,
            @RequestParam @DateTimeFormat(
                    iso=DateTimeFormat.ISO.DATE_TIME) LocalDate date

    ) {
        return ResponseEntity.ok(
                branchAnalyticsService.getCategoryWiseSalesBreakdown(branchId, date));
    }

    @GetMapping("/today-overview")
    public ResponseEntity<BranchDashboardOverviewDTO> getTodayOverview(
            @RequestParam Long branchId

    ) {
        return ResponseEntity.ok(
                branchAnalyticsService.getBranchOverview(branchId));
    }

    @GetMapping("/payment-breakdown")
    public ResponseEntity<List<PaymentSummary>> getPaymentBreakdown(
            @RequestParam Long branchId,
            @RequestParam @DateTimeFormat(
                    iso=DateTimeFormat.ISO.DATE_TIME) LocalDate date

    ) {
        return ResponseEntity.ok(
                branchAnalyticsService.getPaymentMethodBreakdown(branchId, date));
    }


}
