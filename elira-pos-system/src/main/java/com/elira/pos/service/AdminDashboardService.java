package com.elira.pos.service;

import com.elira.pos.payload.adminAnalytics.DashboardSummaryDTO;
import com.elira.pos.payload.adminAnalytics.StoreRegistrationStateDTO;
import com.elira.pos.payload.adminAnalytics.StoreStatusDistributionDTO;

import java.util.List;

public interface AdminDashboardService {

    DashboardSummaryDTO getDashboardSummary();
    List<StoreRegistrationStateDTO> getLast7DayRegistrationStats();
    StoreStatusDistributionDTO getStoreStatusDistribution();
}
