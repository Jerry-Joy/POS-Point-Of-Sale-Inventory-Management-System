package com.elira.pos.payload.storeAnalytics;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TimeSeriesPointDTO {
    private LocalDateTime date;
    private Double totalAmount;
}
