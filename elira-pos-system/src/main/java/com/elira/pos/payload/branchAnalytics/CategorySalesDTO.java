package com.elira.pos.payload.branchAnalytics;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategorySalesDTO {
    private String categoryName;
    private Long totalSales;
    private Long quantitySold;
}
