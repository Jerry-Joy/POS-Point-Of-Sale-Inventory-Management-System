package com.elira.pos.controller;

import com.elira.pos.payload.adminAnalytics.DashboardSummaryDTO;
import com.elira.pos.payload.adminAnalytics.StoreRegistrationStateDTO;
import com.elira.pos.payload.adminAnalytics.StoreStatusDistributionDTO;
import com.elira.pos.service.AdminDashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/super-admin")
public class AdminDashboardController {

    private final AdminDashboardService adminDashboardService;

    @GetMapping("/dashboard/summary")
    public ResponseEntity<DashboardSummaryDTO> getDashboardSummary(){
        return ResponseEntity.ok(adminDashboardService.getDashboardSummary());
    }

    @GetMapping("/dashboard/store-registration")
    public ResponseEntity<List<StoreRegistrationStateDTO>> getLast7DayRegistrationStats(){
        return ResponseEntity.ok(adminDashboardService.getLast7DayRegistrationStats());
    }

    @GetMapping("/dashboard/store-status-distribution")
    public ResponseEntity<StoreStatusDistributionDTO> getStoreStatusDistribution(){
        return ResponseEntity.ok(adminDashboardService.getStoreStatusDistribution());
    }
}
