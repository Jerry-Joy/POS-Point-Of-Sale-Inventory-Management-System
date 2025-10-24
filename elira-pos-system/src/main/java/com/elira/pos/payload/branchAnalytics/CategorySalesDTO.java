package com.elira.pos.payload.branchAnalytics;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategorySalesDTO {
    private String categoryName;
    private BigDecimal totalSales;
    private Long quantitySold;
}
