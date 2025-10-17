package com.elira.pos.service.impl;

import com.elira.pos.domain.PaymentType;
import com.elira.pos.mapper.ShiftReportMapper;
import com.elira.pos.modal.*;
import com.elira.pos.payload.dto.ShiftReportDTO;
import com.elira.pos.repository.OrderRepository;
import com.elira.pos.repository.RefundRepository;
import com.elira.pos.repository.ShiftReportRepository;
import com.elira.pos.repository.UserRepository;
import com.elira.pos.service.ShiftReportService;
import com.elira.pos.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShiftReportServiceImpl implements ShiftReportService {

    private final ShiftReportRepository shiftReportRepository;
    private final UserService userService;
    private final RefundRepository refundRepository;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    @Override
    public ShiftReportDTO startShift(Long cashierId,
                                     Long branchId,
                                     LocalDateTime shiftStart) throws Exception {

        User currentUser = userService.getCurrentUser();
        shiftStart = LocalDateTime.now();
        LocalDateTime startOfDay = shiftStart.withHour(0).withMinute(0).withSecond(0);

        LocalDateTime endOfDay = shiftStart.withHour(23).withMinute(59).withSecond(59);

        Optional<ShiftReport> existing = shiftReportRepository.findByCashierAndShiftStartBetween(
                currentUser, startOfDay, endOfDay
        );

        if (existing.isPresent()) {
            throw new Exception("You have already started a shift today");
        }

        Branch branch = currentUser.getBranch();

        ShiftReport shiftReport = ShiftReport.builder()
                .cashier(currentUser)
                .shiftStart(shiftStart)
                .build();

        ShiftReport savedReport = shiftReportRepository.save(shiftReport);
        return ShiftReportMapper.toDTO(savedReport);
    }

    @Override
    public ShiftReportDTO endShift(Long shiftReportId,
                                   LocalDateTime shiftEnd) throws Exception {
        User currentUser = userService.getCurrentUser();

        ShiftReport shiftReport = shiftReportRepository
                .findTopByCashierAndShiftEndIsNullOrderByShiftStartDesc(currentUser)
                .orElseThrow(() -> new Exception("No shift found for the current user"));

        shiftReport.setShiftEnd(shiftEnd);
//here
        List<Refund> refunds = refundRepository.findByCashierIdAndCreatedAtBetween(
                currentUser.getId(),
                shiftReport.getShiftStart(),
                shiftReport.getShiftEnd()
        );

        double totalRefunds = refunds.stream()
                .mapToDouble( refund -> refund.getAmount() != null ?
                        refund.getAmount() : 0.0)
                .sum();

        List<Order> orders = orderRepository.findByCashierAndCreatedAtBetween(
                currentUser,
                shiftReport.getShiftStart(),
                shiftReport.getShiftEnd()
        );

        double totalSales = orders.stream()
                .mapToDouble(Order::getTotalAmount)
                .sum();

        int totalOrders = orders.size();

        double netSales = totalSales - totalRefunds;

        shiftReport.setTotalRefunds(totalRefunds);
        shiftReport.setTotalSales(totalSales);
        shiftReport.setTotalOrders(totalOrders);
        shiftReport.setNetSale(netSales);
        shiftReport.setRecentOrders(getRecentOrders(orders));
        shiftReport.setTopSellingProducts(getTopSellingProducts(orders));
        shiftReport.setPaymentSummaries(getPaymentSummaries(orders, totalSales));
        shiftReport.setRefunds(refunds);

        ShiftReport savedReport = shiftReportRepository.save(shiftReport);

        return ShiftReportMapper.toDTO(savedReport);
    }


    @Override
    public ShiftReportDTO getShiftReportById(Long id) {
        return shiftReportRepository.findById(id)
                .map(ShiftReportMapper::toDTO)
                .orElseThrow(
                ()-> new RuntimeException("Shift report not found with given id" + id)
        );
    }

    @Override
    public List<ShiftReportDTO> getAllShiftReports() {
        List<ShiftReport> reports = shiftReportRepository.findAll();
        return reports.stream().map(
                ShiftReportMapper::toDTO
        ).collect(Collectors.toList());
    }

    @Override
    public List<ShiftReportDTO> getShiftReportsByBranchId(Long branchId) {
        List<ShiftReport> reports = shiftReportRepository.findByBranchId(branchId);
        return reports.stream().map(
                ShiftReportMapper::toDTO
        ).collect(Collectors.toList());
    }

    @Override
    public List<ShiftReportDTO> getShiftReportsByCashierId(Long cashierId) {
        List<ShiftReport> reports = shiftReportRepository.findByCashierId(cashierId);
        return reports.stream().map(
                ShiftReportMapper::toDTO
        ).collect(Collectors.toList());
    }

    @Override
    public ShiftReportDTO getCurrentShiftProgress(Long cashierId) throws Exception {

        User user = userService.getCurrentUser();

        ShiftReport shiftReport = shiftReportRepository
                .findTopByCashierAndShiftEndIsNullOrderByShiftStartDesc(user)
                .orElseThrow(() -> new Exception("No shift found for the current user"));

        LocalDateTime now = LocalDateTime.now();
        List<Order> orders = orderRepository.findByCashierAndCreatedAtBetween(
                user,
                shiftReport.getShiftStart(),
                now
        );

        List<Refund> refunds = refundRepository.findByCashierIdAndCreatedAtBetween(
                user.getId(),
                shiftReport.getShiftStart(),
                shiftReport.getShiftEnd()
        );

        double totalRefunds = refunds.stream()
                .mapToDouble( refund -> refund.getAmount() != null ?
                        refund.getAmount() : 0.0)
                .sum();



        double totalSales = orders.stream()
                .mapToDouble(Order::getTotalAmount)
                .sum();

        int totalOrders = orders.size();

        double netSales = totalSales - totalRefunds;

        shiftReport.setTotalRefunds(totalRefunds);
        shiftReport.setTotalSales(totalSales);
        shiftReport.setTotalOrders(totalOrders);
        shiftReport.setNetSale(netSales);
        shiftReport.setRecentOrders(getRecentOrders(orders));
        shiftReport.setTopSellingProducts(getTopSellingProducts(orders));
        shiftReport.setPaymentSummaries(getPaymentSummaries(orders, totalSales));
        shiftReport.setRefunds(refunds);

        ShiftReport savedReport = shiftReportRepository.save(shiftReport);

        return ShiftReportMapper.toDTO(savedReport);
    }

    @Override
    public ShiftReportDTO getShiftByCashierAndDate(Long cashierId,
                                                   LocalDateTime date) throws Exception {
        User cashier = userRepository.findById(cashierId)
                .orElseThrow(() -> new Exception("Cashier not found width given id" +cashierId)
                );

        LocalDateTime start = date.withHour(0).withMinute(0).withSecond(0);
        LocalDateTime end = date.withHour(23).withMinute(59).withSecond(59);

        ShiftReport report = shiftReportRepository.findByCashierAndShiftStartBetween(
                cashier, start, end
        ).orElseThrow(() -> new Exception("Shift report not found for cashier"));

        return ShiftReportMapper.toDTO(report);
    }

    //------------------------------Helper Methods-----------------------//

    private List<PaymentSummary> getPaymentSummaries(List<Order> orders,
                                                     double totalSales) {

        Map<PaymentType, List<Order>> grouped = orders.stream()
                .collect(Collectors.groupingBy(order->order.getPaymentType() != null?
                        order.getPaymentType(): PaymentType.CASH));

        List<PaymentSummary> summaries = new ArrayList<>();
        for (Map.Entry<PaymentType, List<Order>> entry : grouped.entrySet()) {
            double amount = entry.getValue().stream()
                    .mapToDouble(Order::getTotalAmount).sum();
            int transactions = entry.getValue().size();
            double percent = (amount / totalSales) * 100;

            PaymentSummary ps = new PaymentSummary();
            ps.setType(entry.getKey());
            ps.setTotalAmount(amount);
            ps.setTransactionCount(transactions);
            ps.setPercentage(percent);
            summaries.add(ps);
        }
        return summaries;
    }

    private List<Product> getTopSellingProducts(List<Order> orders) {
        Map<Product, Integer> productSalesMap = new HashMap<>();

        for (Order order : orders) {
            for (OrderItem item : order.getItems()) {
                Product product = item.getProduct();
                productSalesMap.put(product, productSalesMap.getOrDefault(product, 0) + item.getQuantity());
            }
        }

        return productSalesMap.entrySet().stream()
                .sorted((a,b)->b.getValue().compareTo(a.getValue()))
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private List<Order> getRecentOrders(List<Order> orders) {
        return orders.stream()
                .sorted(Comparator.comparing(Order::getCreatedAt).reversed())
                .limit(5)
                .collect(Collectors.toList());
    }
}
