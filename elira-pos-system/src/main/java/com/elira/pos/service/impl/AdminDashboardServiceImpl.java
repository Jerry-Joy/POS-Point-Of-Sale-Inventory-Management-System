package com.elira.pos.service.impl;

import com.elira.pos.domain.StoreStatus;
import com.elira.pos.payload.adminAnalytics.DashboardSummaryDTO;
import com.elira.pos.payload.adminAnalytics.StoreRegistrationStateDTO;
import com.elira.pos.payload.adminAnalytics.StoreStatusDistributionDTO;
import com.elira.pos.repository.StoreRepository;
import com.elira.pos.service.AdminDashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AdminDashboardServiceImpl implements AdminDashboardService {

    private final StoreRepository storeRepository;

    @Override
    public DashboardSummaryDTO getDashboardSummary() {
        Long total = storeRepository.count();
        Long active = storeRepository.countByStatus(StoreStatus.ACTIVE);
        Long pending = storeRepository.countByStatus(StoreStatus.PENDING);
        Long blocked = storeRepository.countByStatus(StoreStatus.BLOCKED);

        return DashboardSummaryDTO.builder()
                .totalStore(total)
                .activeStore(active)
                .pendingStore(pending)
                .blockedStore(blocked)
                .build();
    }

    @Override
    public List<StoreRegistrationStateDTO> getLast7DayRegistrationStats() {
        LocalDate today = LocalDate.now();
        LocalDate sevenDaysAgo = today.minusDays(6);
        LocalDateTime startDateTime = sevenDaysAgo.atStartOfDay();

        List<Object[]> rawStats = storeRepository.getStoreRegistrationStats(startDateTime);

        Map<String, Long> dataMap = new LinkedHashMap<>();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        for (int i=0; i<7; i++){
            LocalDate date = sevenDaysAgo.plusDays(i);
            dataMap.put(date.format(dateTimeFormatter), 0L);
        }
        for (Object[] row : rawStats) {
            LocalDate date = ((LocalDate) row[0]);
            Long count = (Long) row[1];
            dataMap.put(date.format(dateTimeFormatter), count);
        }

        List<StoreRegistrationStateDTO> result = new ArrayList<>();
        dataMap.forEach((date, count) -> result.add(
                StoreRegistrationStateDTO.builder().date(date).count(count).build()
        ));
        return result;
    }

    @Override
    public StoreStatusDistributionDTO getStoreStatusDistribution() {

        Long active = storeRepository.countByStatus(StoreStatus.ACTIVE);
        Long pending = storeRepository.countByStatus(StoreStatus.PENDING);
        Long blocked = storeRepository.countByStatus(StoreStatus.BLOCKED);

        return StoreStatusDistributionDTO.builder()
                .active(active)
                .pending(pending)
                .blocked(blocked)
                .build();
    }
}
