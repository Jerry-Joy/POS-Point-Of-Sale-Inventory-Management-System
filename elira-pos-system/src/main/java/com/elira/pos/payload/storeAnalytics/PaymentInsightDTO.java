package com.elira.pos.payload.storeAnalytics;

import com.elira.pos.domain.PaymentType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentInsightDTO {
    private PaymentType paymentType;
    private Double totalAmount;
}
