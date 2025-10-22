package com.elira.pos.payload.branchAnalytics;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductPerformanceDTO {
    private String productName;
    private Long quantitySold;
    private double percentage;
}
