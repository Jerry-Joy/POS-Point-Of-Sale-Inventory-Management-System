package com.elira.pos.mapper;

import com.elira.pos.modal.Order;
import com.elira.pos.modal.Product;
import com.elira.pos.modal.Refund;
import com.elira.pos.modal.ShiftReport;
import com.elira.pos.payload.dto.OrderDTO;
import com.elira.pos.payload.dto.ProductDTO;
import com.elira.pos.payload.dto.RefundDTO;
import com.elira.pos.payload.dto.ShiftReportDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ShiftReportMapper {

    public static ShiftReportDTO toDTO(ShiftReport entity) {
        return ShiftReportDTO.builder()
                .id(entity.getId())
                .shiftEnd(entity.getShiftEnd())
                .shiftStart(entity.getShiftStart())
                .totalSales(entity.getTotalSales())
                .totalOrders(entity.getTotalOrders())
                .totalRefund(entity.getTotalRefunds())
                .netSale(entity.getNetSale())
                .totalOrders(entity.getTotalOrders())
                .cashier(entity.getCashier() != null ? UserMapper.toDTO(entity.getCashier()) : null)
                .cashierId(entity.getCashier() != null ? entity.getCashier().getId() : null)
                .branchId(entity.getBranch() != null ? entity.getBranch().getId() : null)
                .recentOrders(mapOrders(entity.getRecentOrders()))
                .topSellingProducts(mapProducts(entity.getTopSellingProducts()))
                .refunds(mapRefunds(entity.getRefunds()))
                .paymentSummaries(entity.getPaymentSummaries())
                .build();
    }

    private static List<RefundDTO> mapRefunds(List<Refund> refunds) {
        if (refunds == null || refunds.isEmpty()) {
            return null;
        }
        return refunds.stream()
                .map(RefundMapper::toDTO)
                .collect(Collectors.toList());
    }

    private static List<ProductDTO> mapProducts(List<Product> topSellingProducts) {
        if (topSellingProducts == null || topSellingProducts.isEmpty()) {
            return null;
        }
        return topSellingProducts.stream()
                .map(ProductMapper::toDTO)
                .collect(Collectors.toList());
    }

    private static List<OrderDTO> mapOrders(List<Order> recentOrders) {
        if (recentOrders == null || recentOrders.isEmpty()) {
            return null;
        }
        return recentOrders.stream()
                .map(OrderMapper::toDTO)
                .collect(Collectors.toList());
    }
}
