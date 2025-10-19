package com.elira.pos.payload.adminAnalytics;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StoreStatusDistributionDTO {

    private Long active;
    private Long blocked;
    private Long pending;
}
