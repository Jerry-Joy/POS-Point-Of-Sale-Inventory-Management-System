package com.elira.pos.payload.dto;

import com.elira.pos.domain.PaymentType;
import com.elira.pos.modal.Branch;
import com.elira.pos.modal.Order;
import com.elira.pos.modal.ShiftReport;
import com.elira.pos.modal.User;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class RefundDTO {

    private Long id;

    private OrderDTO order;

    private Long orderId;

    private String reason;

    private Double amount;

    //private ShiftReport shiftReport;
    private Long shiftReportId;

    private UserDto cashier;
    private String cashierName;

    private BranchDTO branch;
    private Long branchId;

    private PaymentType paymentType;

    private LocalDateTime createdAt;
}
