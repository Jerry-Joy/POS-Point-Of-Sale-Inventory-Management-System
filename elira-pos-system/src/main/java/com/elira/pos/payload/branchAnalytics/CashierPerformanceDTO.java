package com.elira.pos.payload.branchAnalytics;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CashierPerformanceDTO {
    private Long cashierId;
    private String cashierName;
    private Long totalOrders;
    private Double totalRevenue;
}
