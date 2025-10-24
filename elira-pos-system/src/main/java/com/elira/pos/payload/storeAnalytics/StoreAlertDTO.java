package com.elira.pos.payload.storeAnalytics;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class StoreAlertDTO {

    private List<String> lowStockAlert;
    private List<String> noSalesToday;
    private List<String> refundSpikeAlerts;
    private List<String> inactiveCashiers;
}
