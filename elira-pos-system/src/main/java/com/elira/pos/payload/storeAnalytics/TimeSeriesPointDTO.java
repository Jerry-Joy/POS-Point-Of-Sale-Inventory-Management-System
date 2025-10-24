package com.elira.pos.payload.storeAnalytics;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TimeSeriesPointDTO {
    private LocalDateTime date;
    private Double totalAmount;
}
