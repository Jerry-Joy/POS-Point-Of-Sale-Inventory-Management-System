package com.elira.pos.payload.dto;

import com.elira.pos.domain.PaymentType;
import com.elira.pos.modal.Customer;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class OrderDTO {

    private Long id;

    private Double totalAmount;

    private LocalDateTime CreatedAt;

    private Long branchId;
    private Long customerId;

    private BranchDTO branch;

    private UserDto cashier;

    private Customer customer;

    private PaymentType paymentType;

    private List<OrderItemDTO> items;
}
